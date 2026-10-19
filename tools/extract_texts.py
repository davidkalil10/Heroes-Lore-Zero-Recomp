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

    # Lê nomes de área/região no cabeçalho
    area_name = ""
    region_name = ""
    n22 = 3 # pula var_byte_a, O[0], O[1]
    by8_0 = data[n22]; n22 += 1
    if by8_0 > 0:
        area_name = data[n22:n22+by8_0].decode('utf-8', errors='replace')
        n22 += by8_0
    by8_1 = data[n22]; n22 += 1
    if by8_1 > 0:
        region_name = data[n22:n22+by8_1].decode('utf-8', errors='replace')
        n22 += by8_1

    # Localiza a tabela de diálogos no final
    dialogs = []
    if data[-1] == 0:
        for n3 in range(1, 255):
            for off in range(len(data) - n3 - 2, 0, -1):
                if data[off] == n3:
                    lengths = data[off+1 : off+1+n3]
                    expected_end = off + 1 + n3 + sum(lengths) + n3
                    if expected_end == len(data):
                        cur = off + 1 + n3
                        valid = True
                        temp_strs = []
                        for l in lengths:
                            if cur + l >= len(data) or data[cur + l] != 0:
                                valid = False
                                break
                            s = data[cur : cur+l].decode('utf-8', errors='replace')
                            cur += l + 1
                            temp_strs.append(s)
                        if valid and len(temp_strs) == n3:
                            dialogs = temp_strs
                            break
            if dialogs:
                break

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
