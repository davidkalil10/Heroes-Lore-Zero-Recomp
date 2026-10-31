#!/usr/bin/env python3
"""
tools/extract_texts.py — Heroes Lore: Zero
Extrai todos os textos do jogo original (UI, Menus, Itens, Habilidades, Diálogos de Mapas e Monstros)
para a pasta lang/source_en/ em formato JSON legível e estruturado.
"""

import os
import glob
import json

def parse_tdf(path):
    with open(path, 'rb') as f:
        data = f.read()
    if not data:
        return []
    count = data[0]
    idx = 1
    strings = []
    for _ in range(count):
        if idx + 2 > len(data): break
        slen = (data[idx] << 8) | data[idx+1]
        idx += 2
        sbytes = data[idx:idx+slen]
        idx += slen
        try:
            s = sbytes.decode('utf-8')
        except:
            s = sbytes.decode('latin1', errors='replace')
        strings.append(s)
    return strings

def parse_map(path):
    with open(path, 'rb') as f:
        data = f.read()
    if not data:
        return None

    pos = 0
    b0 = data[pos]; pos += 1
    o0 = data[pos]; pos += 1
    o1 = data[pos]; pos += 1

    area_name = ""
    region_name = ""
    by8_0 = data[pos]; pos += 1
    if by8_0 > 0:
        area_name = data[pos:pos+by8_0].decode('utf-8', errors='replace')
        pos += by8_0
    by8_1 = data[pos]; pos += 1
    if by8_1 > 0:
        region_name = data[pos:pos+by8_1].decode('utf-8', errors='replace')
        pos += by8_1

    by9 = data[pos]; pos += 1
    pos += by9
    w = data[pos]; h = data[pos+1]; pos += 2
    pos += w * h * 2
    n8 = data[pos]; pos += 1 + n8 * 5
    n3 = data[pos]; pos += 1 + n3 * 5
    n2 = data[pos]; pos += 1 + n2 * 5
    by6 = data[pos]; pos += 1 + by6
    by7 = data[pos]; pos += 1
    for i in range(by7):
        n4 = data[pos+1]
        pos += 4 if (n4 & 0x80) == 0x80 else 3
    by3 = data[pos]; pos += 1 + by3
    by2 = data[pos]; pos += 1
    for i in range(by2):
        n4 = data[pos+1]
        pos += 4 if (n4 & 0x80) == 0x80 else 3

    cnt1 = data[pos]; pos += 1
    lens1 = [data[pos+i] for i in range(cnt1)]
    pos += cnt1 + sum(lens1)
    cnt2 = data[pos]; pos += 1
    lens2 = [data[pos+2*i] | (data[pos+2*i+1] << 8) for i in range(cnt2)]
    pos += cnt2 * 2 + sum(lens2)

    dialog_count = data[pos]; pos += 1
    dialogs = []
    if dialog_count > 0:
        str_lens = [data[pos+i] for i in range(dialog_count)]
        pos += dialog_count
        for l in str_lens:
            s = data[pos:pos+l].decode('utf-8', errors='replace')
            dialogs.append(s)
            pos += l + 1

    return {
        "area_name": area_name,
        "region_name": region_name,
        "dialogs": dialogs
    }

def parse_enemies():
    # Extrai strings contíguas de tamanho >= 3 de assets/en/edf
    path = "assets/en/edf"
    if not os.path.exists(path):
        return []
    with open(path, 'rb') as f:
        data = f.read()
    cur = []
    strs = []
    for b in data:
        if 32 <= b <= 126:
            cur.append(chr(b))
        else:
            if len(cur) >= 3:
                s = ''.join(cur).strip()
                if s and not s.isdigit():
                    strs.append(s)
            cur = []
    if len(cur) >= 3:
        s = ''.join(cur).strip()
        if s and not s.isdigit():
            strs.append(s)
    # Remove duplicatas preservando ordem
    seen = set()
    unique = []
    for s in strs:
        if s not in seen:
            seen.add(s)
            unique.append(s)
    return unique

def main():
    os.makedirs("lang/source_en", exist_ok=True)

    print("Extraindo arquivos .tdf (UI, Menus, Itens, Skills)...")
    ui_data = {}
    for tdf in sorted(glob.glob("assets/t/*.tdf")):
        key = os.path.basename(tdf)
        ui_data[key] = parse_tdf(tdf)
    with open("lang/source_en/ui_strings.json", "w", encoding="utf-8") as f:
        json.dump(ui_data, f, ensure_ascii=False, indent=2)
    print(f"  -> {len(ui_data)} arquivos .tdf extraídos em lang/source_en/ui_strings.json")

    print("Extraindo arquivos de mapas .m (Diálogos, falas de NPCs, cutscenes)...")
    map_data = {}
    for m in sorted(glob.glob("assets/m/m/*.m") + glob.glob("assets/m/m2/*.m")):
        rel = os.path.relpath(m, "assets").replace("\\", "/")
        parsed = parse_map(m)
        if parsed:
            map_data[rel] = parsed
    with open("lang/source_en/maps_dialogs.json", "w", encoding="utf-8") as f:
        json.dump(map_data, f, ensure_ascii=False, indent=2)
    print(f"  -> {len(map_data)} mapas extraídos em lang/source_en/maps_dialogs.json")

    print("Extraindo nomes de monstros e NPCs (edf/ndf)...")
    enemies = parse_enemies()
    enemy_data = {
        "enemies": enemies
    }
    with open("lang/source_en/enemies_npcs.json", "w", encoding="utf-8") as f:
        json.dump(enemy_data, f, ensure_ascii=False, indent=2)
    print(f"  -> {len(enemies)} monstros extraídos em lang/source_en/enemies_npcs.json")

    print("\nExtração concluída com sucesso!")

if __name__ == "__main__":
    main()
