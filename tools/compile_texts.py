#!/usr/bin/env python3
"""
tools/compile_texts.py — Heroes Lore: Zero
Compila arquivos de tradução (JSON em lang/<idioma>/) para a pasta de assets compilados
assets/lang/<idioma>/ (.tdf, .m, edf/ndf), prontos para uso pelo motor C++ em tempo de execução.

Uso:
    python tools/compile_texts.py pt
    python tools/compile_texts.py es
"""

import os
import sys
import glob
import json

def clean_ascii(s):
    """Garante que a string use apenas caracteres suportados pela fonte bitmap dotFontSmall.dat."""
    # Mapeamento para substituição de acentos
    trans = str.maketrans({
        'á': 'a', 'à': 'a', 'ã': 'a', 'â': 'a', 'ä': 'a',
        'é': 'e', 'è': 'e', 'ê': 'e', 'ë': 'e',
        'í': 'i', 'ì': 'i', 'î': 'i', 'ï': 'i',
        'ó': 'o', 'ò': 'o', 'õ': 'o', 'ô': 'o', 'ö': 'o',
        'ú': 'u', 'ù': 'u', 'û': 'u', 'ü': 'u',
        'ç': 'c', 'ñ': 'n',
        'Á': 'A', 'À': 'A', 'Ã': 'A', 'Â': 'A', 'Ä': 'A',
        'É': 'E', 'È': 'E', 'Ê': 'E', 'Ë': 'E',
        'Í': 'I', 'Ì': 'I', 'Î': 'I', 'Ï': 'I',
        'Ó': 'O', 'Ò': 'O', 'Õ': 'O', 'Ô': 'O', 'Ö': 'O',
        'Ú': 'U', 'Ù': 'U', 'Û': 'U', 'Ü': 'U',
        'Ç': 'C', 'Ñ': 'N',
        '“': '"', '”': '"', '‘': "'", '’': "'", '—': '-', '–': '-'
    })
    return s.translate(trans)

def compile_tdf(strings):
    out = bytearray()
    count = min(len(strings), 255)
    out.append(count)
    for s in strings[:count]:
        s_clean = clean_ascii(s)
        s_bytes = s_clean.encode('latin1', errors='replace')
        slen = len(s_bytes)
        out.append((slen >> 8) & 0xFF)
        out.append(slen & 0xFF)
        out.extend(s_bytes)
    return bytes(out)

def find_map_dialog_offset(data):
    if not data or data[-1] != 0:
        return None
    for n3 in range(1, 255):
        for off in range(len(data) - n3 - 2, 0, -1):
            if data[off] == n3:
                lengths = data[off+1 : off+1+n3]
                expected_end = off + 1 + n3 + sum(lengths) + n3
                if expected_end == len(data):
                    cur = off + 1 + n3
                    valid = True
                    for l in lengths:
                        if cur + l >= len(data) or data[cur + l] != 0:
                            valid = False
                            break
                        cur += l + 1
                    if valid:
                        return off
    return None

def compile_map(orig_path, trans_info):
    with open(orig_path, 'rb') as f:
        data = f.read()

    # Atualiza cabeçalho com nomes de área/região se fornecidos
    area_name = clean_ascii(trans_info.get("area_name", ""))
    region_name = clean_ascii(trans_info.get("region_name", ""))
    
    # Reconstrói os primeiros bytes se houver nomes
    n22 = 3
    by8_0 = data[n22]; n22 += 1
    orig_area = data[n22:n22+by8_0] if by8_0 > 0 else b""
    n22 += by8_0
    by8_1 = data[n22]; n22 += 1
    orig_reg = data[n22:n22+by8_1] if by8_1 > 0 else b""
    n22 += by8_1

    new_header = bytearray(data[:3])
    area_bytes = (area_name.encode('latin1', errors='replace') if area_name else orig_area)[:255]
    new_header.append(len(area_bytes))
    new_header.extend(area_bytes)

    reg_bytes = (region_name.encode('latin1', errors='replace') if region_name else orig_reg)[:255]
    new_header.append(len(reg_bytes))
    new_header.extend(reg_bytes)

    rest_start = n22
    dialog_off = find_map_dialog_offset(data)
    
    if dialog_off is None:
        # Mapa sem diálogos, só copia os bytes
        return bytes(new_header) + data[rest_start:]

    # Bytes do mapa entre cabeçalho de nomes e a tabela de diálogos
    map_body = data[rest_start:dialog_off]

    dialogs = trans_info.get("dialogs", [])
    if not dialogs:
        # Mantém diálogos originais
        return bytes(new_header) + map_body + data[dialog_off:]

    # Compila nova tabela de diálogos
    count = min(len(dialogs), 255)
    dialog_bytes_list = []
    lengths = bytearray()
    for d in dialogs[:count]:
        d_clean = clean_ascii(d)
        db = d_clean.encode('latin1', errors='replace')[:255]
        dialog_bytes_list.append(db)
        lengths.append(len(db))

    new_dialog_table = bytearray()
    new_dialog_table.append(count)
    new_dialog_table.extend(lengths)
    for db in dialog_bytes_list:
        new_dialog_table.extend(db)
        new_dialog_table.append(0) # delimitador nulo

    return bytes(new_header) + map_body + bytes(new_dialog_table)

def main():
    lang = sys.argv[1].lower() if len(sys.argv) > 1 else "pt"
    src_dir = f"lang/{lang}_br" if os.path.exists(f"lang/{lang}_br") else f"lang/{lang}"
    out_dir = f"assets/lang/{lang}"

    if not os.path.exists(src_dir):
        print(f"Erro: Diretório de tradução '{src_dir}' não encontrado!")
        sys.exit(1)

    print(f"=== Compilando Idioma [{lang}] de '{src_dir}' para '{out_dir}' ===")
    os.makedirs(f"{out_dir}/t", exist_ok=True)
    os.makedirs(f"{out_dir}/m/m", exist_ok=True)
    os.makedirs(f"{out_dir}/m/m2", exist_ok=True)
    os.makedirs(f"{out_dir}/en", exist_ok=True)

    # 1. Compila .tdf
    ui_path = os.path.join(src_dir, "ui_strings.json")
    if os.path.exists(ui_path):
        with open(ui_path, "r", encoding="utf-8") as f:
            ui_data = json.load(f)
        compiled_tdfs = 0
        for tdf_name, strs in ui_data.items():
            if not tdf_name.endswith('.tdf'):
                continue
            b = compile_tdf(strs)
            out_file = os.path.join(out_dir, "t", tdf_name)
            with open(out_file, "wb") as f_out:
                f_out.write(b)
            compiled_tdfs += 1
        print(f"[OK] {compiled_tdfs} arquivos .tdf compilados em {out_dir}/t/")

    # 2. Compila mapas .m
    maps_path = os.path.join(src_dir, "maps_dialogs.json")
    if os.path.exists(maps_path):
        with open(maps_path, "r", encoding="utf-8") as f:
            maps_data = json.load(f)
        compiled_maps = 0
        for rel_path, info in maps_data.items():
            orig_file = os.path.join("assets", rel_path)
            if not os.path.exists(orig_file):
                continue
            b = compile_map(orig_file, info)
            out_file = os.path.join(out_dir, rel_path)
            os.makedirs(os.path.dirname(out_file), exist_ok=True)
            with open(out_file, "wb") as f_out:
                f_out.write(b)
            compiled_maps += 1
        print(f"[OK] {compiled_maps} arquivos de mapas .m compilados em {out_dir}/m/")

    # 3. Compila monstros (edf) com integridade total de checksum
    enemies_path = os.path.join(src_dir, "enemies_npcs.json")
    if os.path.exists(enemies_path) and os.path.exists("assets/en/edf"):
        with open(enemies_path, "r", encoding="utf-8") as f:
            enemy_data = json.load(f)
        trans_dict = enemy_data.get("translations", {})
        
        orig_edf_path = "assets/en/edf"
        with open(orig_edf_path, "rb") as f_orig:
            orig_bytes = f_orig.read()

        new_edf = bytearray()
        off = 0
        monster_count = 0
        trans_count = 0
        while off < len(orig_bytes):
            s2 = (orig_bytes[off] << 8) | orig_bytes[off+1]
            rec = orig_bytes[off+2 : off+2+s2]
            off += 2 + s2

            name_len = rec[0]
            orig_name = rec[1 : 1 + name_len].decode('latin1', errors='replace')
            rest_data = rec[1 + name_len : -1] # Dados de atributos/drops excluindo checksum antiga

            if orig_name in trans_dict:
                t_name = clean_ascii(trans_dict[orig_name])
                t_bytes = t_name.encode('latin1', errors='replace')[:255]
                trans_count += 1
            else:
                t_bytes = rec[1 : 1 + name_len]

            new_rec = bytearray()
            new_rec.append(len(t_bytes))
            new_rec.extend(t_bytes)
            new_rec.extend(rest_data)
            # Recalcula o byte de checksum conforme rpg.e.boolean_a(byte[]): sum(bytes[:-1]) & 0xFF == bytes[-1]
            new_csum = sum(new_rec) & 0xFF
            new_rec.append(new_csum)

            new_s2 = len(new_rec)
            new_edf.append((new_s2 >> 8) & 0xFF)
            new_edf.append(new_s2 & 0xFF)
            new_edf.extend(new_rec)
            monster_count += 1

        edf_out = os.path.join(out_dir, "en", "edf")
        with open(edf_out, "wb") as f_out:
            f_out.write(new_edf)
        print(f"[OK] edf compilado em {edf_out}: {monster_count} monstros ({trans_count} traduzidos, checksum 100% integra)")

    print(f"=== Concluído! Idioma [{lang}] pronto para execução. ===")

if __name__ == "__main__":
    main()
