#!/usr/bin/env python3
"""
tools/translate_all_story.py — Tradução concorrente de alta performance para todas as cutscenes de Heroes Lore: Zero
"""

import json
import os
import re
import time
import unicodedata
import urllib.request
import urllib.parse
from concurrent.futures import ThreadPoolExecutor, as_completed

def clean_ascii(text):
    nfkd = unicodedata.normalize('NFKD', text)
    res = ''.join([c for c in nfkd if not unicodedata.combining(c)])
    res = res.replace('ç', 'c').replace('Ç', 'C')
    res = res.replace('«', '"').replace('»', '"').replace('“', '"').replace('”', '"')
    res = res.replace('‘', "'").replace('’', "'")
    return res

def translate_single_line(line):
    if not line or not line.strip():
        return line

    prefix = ''
    m = re.match(r'^([\^\|]\[[^\]]+\]&|\})(\s*)', line)
    if m:
        prefix = m.group(0)
        body = line[len(prefix):]
    else:
        body = line

    if not body.strip():
        return line

    tags = []
    def repl_tag(match):
        tags.append(match.group(0))
        return f'___TAG_{len(tags)-1}___'

    body_masked = re.sub(r'\{[^\}&]+&', repl_tag, body)

    url = 'https://translate.googleapis.com/translate_a/single?client=gtx&sl=en&tl=pt&dt=t&q=' + urllib.parse.quote(body_masked)
    req = urllib.request.Request(url, headers={'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)'})
    
    trans_text = body
    for _ in range(3):
        try:
            with urllib.request.urlopen(req, timeout=5) as resp:
                data = json.loads(resp.read().decode('utf-8'))
                trans_text = ''.join([p[0] for p in data[0] if p and p[0]])
                break
        except Exception:
            time.sleep(0.3)

    for i, tag in enumerate(tags):
        tag_clean = tag
        if tag == '{pact&': tag_clean = '{pacto&'
        elif tag == '{monsters&': tag_clean = '{monstros&'
        elif tag == '{culprit&': tag_clean = '{culpado&'
        elif tag == '{triangle&': tag_clean = '{triangulo&'
        elif tag == '{Return Point&': tag_clean = '{Ponto de Retorno&'
        trans_text = re.sub(rf'___\s*TAG_{i}\s*___', tag_clean, trans_text)

    clean_body = clean_ascii(trans_text)
    clean_body = clean_body.replace(' ,', ',').replace(' .', '.')
    return prefix + clean_body

def main():
    with open('lang/source_en/maps_dialogs.json', 'r', encoding='utf-8') as f:
        en_maps = json.load(f)
    with open('lang/pt_br/maps_dialogs.json', 'r', encoding='utf-8') as f:
        pt_maps = json.load(f)

    # Identifica todas as falas que precisam de tradução
    tasks = [] # list of (map_key, idx, text)
    for map_key in sorted(en_maps.keys()):
        en_data = en_maps[map_key]
        en_dialogs = en_data['dialogs'] if isinstance(en_data, dict) else en_data
        pt_data = pt_maps.get(map_key, {})
        pt_dialogs = pt_data.get('dialogs', []) if isinstance(pt_data, dict) else pt_data

        for i, (en_s, pt_s) in enumerate(zip(en_dialogs, pt_dialogs)):
            if en_s.strip() and en_s.strip() == pt_s.strip() and len(en_s.strip()) > 5:
                tasks.append((map_key, i, en_s))

    print(f'Total de falas a traduzir: {len(tasks)} em paralelo (16 workers)...', flush=True)

    results = {}
    completed = 0
    t0 = time.time()

    with ThreadPoolExecutor(max_workers=16) as executor:
        future_to_task = {
            executor.submit(translate_single_line, item[2]): item
            for item in tasks
        }
        for future in as_completed(future_to_task):
            map_key, idx, orig = future_to_task[future]
            try:
                trans = future.result()
            except Exception:
                trans = orig
            results[(map_key, idx)] = trans
            completed += 1
            if completed % 100 == 0 or completed == len(tasks):
                elapsed = time.time() - t0
                print(f'Progresso: {completed}/{len(tasks)} falas traduzidas ({completed/elapsed:.1f} falas/s)', flush=True)

    # Aplica os resultados traduzidos
    modified_maps = set()
    for (map_key, idx), trans in results.items():
        pt_data = pt_maps[map_key]
        if isinstance(pt_data, dict):
            pt_data['dialogs'][idx] = trans
        else:
            pt_data[idx] = trans
        modified_maps.add(map_key)

    with open('lang/pt_br/maps_dialogs.json', 'w', encoding='utf-8') as f:
        json.dump(pt_maps, f, ensure_ascii=False, indent=2)

    print(f'[SUCESSO] {len(tasks)} falas traduzidas em {len(modified_maps)} mapas e salvas com sucesso!', flush=True)

if __name__ == '__main__':
    main()
