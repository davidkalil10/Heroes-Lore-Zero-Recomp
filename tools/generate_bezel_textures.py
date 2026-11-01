#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
tools/generate_bezel_textures.py
Gera texturas de molduras temáticas (Bezels) para telas panorâmicas (16:9 / 16:10 em modo 3:4)
especificamente customizadas para Heroes Lore: Zero.

- bezel_zero (e bezel_soltia para retrocompatibilidade):
    Moldura temática majestosa com a arquitetura gótica e medieval de Heroes Lore: Zero,
    medalhão heráldico com as Gunblades e Espadas cruzadas de Lucian, runas arcanas luminosas,
    o logotipo oficial de alta resolução do jogo, cartucho heráldico de preservação e créditos.
- bezel_slate:
    Moldura elegante e minimalista em ardósia vulcânica / metal escuro escovado.
- font_osd:
    Fonte matricial em alta resolução para notificações e HUD OSD em tela cheia.
"""

import os
import sys
import math
import struct
from PIL import Image, ImageDraw, ImageFont, ImageFilter

# Fontes do sistema
FONT_TITLE = "C:/Windows/Fonts/georgiab.ttf"
if not os.path.exists(FONT_TITLE):
    FONT_TITLE = "C:/Windows/Fonts/timesbd.ttf"
if not os.path.exists(FONT_TITLE):
    FONT_TITLE = "C:/Windows/Fonts/segoeuib.ttf"

FONT_RUNE = "C:/Windows/Fonts/segoeui.ttf"

def save_rgba(img, out_path):
    os.makedirs(os.path.dirname(out_path), exist_ok=True)
    w, h = img.size
    raw_data = img.tobytes("raw", "RGBA")
    with open(out_path, "wb") as f:
        # Header: uint32 width, uint32 height
        f.write(struct.pack("<II", w, h))
        f.write(raw_data)
    png_path = os.path.splitext(out_path)[0] + ".png"
    img.save(png_path)
    print(f"  [OK] Salvo: {out_path} ({w}x{h}) e {png_path}")

def draw_beveled_rect(draw, bbox, fill, light, dark, width=2):
    x0, y0, x1, y1 = bbox
    draw.rectangle(bbox, fill=fill)
    for i in range(width):
        # Top e Left = Luz
        draw.line([(x0 + i, y0 + i), (x1 - i, y0 + i)], fill=light)
        draw.line([(x0 + i, y0 + i), (x0 + i, y1 - i)], fill=light)
        # Bottom e Right = Sombra
        draw.line([(x0 + i, y1 - i), (x1 - i, y1 - i)], fill=dark)
        draw.line([(x1 - i, y0 + i), (x1 - i, y1 - i)], fill=dark)

def draw_rune(draw, rx, ry, r_type, sz=18):
    # Brilho de halo dourado/âmbar e azul-arcano
    for off in [(-2, 0), (2, 0), (0, -2), (0, 2), (-1, -1), (1, 1)]:
        ox, oy = rx + off[0], ry + off[1]
        c_glow = (255, 190, 70, 90)
        if r_type == 'algiz': # ᛉ
            draw.line([(ox, oy - sz), (ox, oy + sz)], fill=c_glow, width=4)
            draw.line([(ox, oy - sz//3), (ox - sz, oy - sz)], fill=c_glow, width=4)
            draw.line([(ox, oy - sz//3), (ox + sz, oy - sz)], fill=c_glow, width=4)
        elif r_type == 'tiwaz': # ᛏ
            draw.line([(ox, oy - sz), (ox, oy + sz)], fill=c_glow, width=4)
            draw.line([(ox, oy - sz), (ox - sz, oy - sz//2)], fill=c_glow, width=4)
            draw.line([(ox, oy - sz), (ox + sz, oy - sz//2)], fill=c_glow, width=4)
        elif r_type == 'fehu': # ᚠ
            draw.line([(ox - sz//2, oy - sz), (ox - sz//2, oy + sz)], fill=c_glow, width=4)
            draw.line([(ox - sz//2, oy - sz//2), (ox + sz//2, oy - sz)], fill=c_glow, width=4)
            draw.line([(ox - sz//2, oy), (ox + sz//2, oy - sz//2)], fill=c_glow, width=4)
        elif r_type == 'sowilo': # ᛋ
            draw.line([(ox + sz//2, oy - sz), (ox - sz//2, oy - sz//3)], fill=c_glow, width=4)
            draw.line([(ox - sz//2, oy - sz//3), (ox + sz//2, oy + sz//3)], fill=c_glow, width=4)
            draw.line([(ox + sz//2, oy + sz//3), (ox - sz//2, oy + sz)], fill=c_glow, width=4)
        elif r_type == 'gebo': # ᚷ
            draw.line([(ox - sz, oy - sz), (ox + sz, oy + sz)], fill=c_glow, width=4)
            draw.line([(ox + sz, oy - sz), (ox - sz, oy + sz)], fill=c_glow, width=4)
        elif r_type == 'othala': # ᛟ
            draw.line([(ox, oy - sz), (ox - sz, oy)], fill=c_glow, width=4)
            draw.line([(ox, oy - sz), (ox + sz, oy)], fill=c_glow, width=4)
            draw.line([(ox - sz, oy), (ox + sz, oy + sz)], fill=c_glow, width=4)
            draw.line([(ox + sz, oy), (ox - sz, oy + sz)], fill=c_glow, width=4)

    # Traço principal com ouro e luz
    c_core = (255, 240, 200, 250)
    if r_type == 'algiz':
        draw.line([(rx, ry - sz), (rx, ry + sz)], fill=c_core, width=2)
        draw.line([(rx, ry - sz//3), (rx - sz, ry - sz)], fill=c_core, width=2)
        draw.line([(rx, ry - sz//3), (rx + sz, ry - sz)], fill=c_core, width=2)
    elif r_type == 'tiwaz':
        draw.line([(rx, ry - sz), (rx, ry + sz)], fill=c_core, width=2)
        draw.line([(rx, ry - sz), (rx - sz, ry - sz//2)], fill=c_core, width=2)
        draw.line([(rx, ry - sz), (rx + sz, ry - sz//2)], fill=c_core, width=2)
    elif r_type == 'fehu':
        draw.line([(rx - sz//2, ry - sz), (rx - sz//2, ry + sz)], fill=c_core, width=2)
        draw.line([(rx - sz//2, ry - sz//2), (rx + sz//2, ry - sz)], fill=c_core, width=2)
        draw.line([(rx - sz//2, ry), (rx + sz//2, ry - sz//2)], fill=c_core, width=2)
    elif r_type == 'sowilo':
        draw.line([(rx + sz//2, ry - sz), (rx - sz//2, ry - sz//3)], fill=c_core, width=2)
        draw.line([(rx - sz//2, ry - sz//3), (rx + sz//2, ry + sz//3)], fill=c_core, width=2)
        draw.line([(rx + sz//2, ry + sz//3), (rx - sz//2, ry + sz)], fill=c_core, width=2)
    elif r_type == 'gebo':
        draw.line([(rx - sz, ry - sz), (rx + sz, ry + sz)], fill=c_core, width=2)
        draw.line([(rx + sz, ry - sz), (rx - sz, ry + sz)], fill=c_core, width=2)
    elif r_type == 'othala':
        draw.line([(rx, ry - sz), (rx - sz, ry)], fill=c_core, width=2)
        draw.line([(rx, ry - sz), (rx + sz, ry)], fill=c_core, width=2)
        draw.line([(rx - sz, oy if 'oy' in locals() else ry), (rx + sz, ry + sz)], fill=c_core, width=2)
        draw.line([(rx + sz, ry), (rx - sz, ry + sz)], fill=c_core, width=2)

def create_bezel_zero(width=1920, height=1080):
    # Proporção central 3:4 do jogo em 1080p:
    # Altura do jogo = 1080. Largura = 1080 * (240 / 320) = 810.
    # game_x0 = (1920 - 810) // 2 = 555
    # game_x1 = 555 + 810 = 1365
    game_w = int(height * 0.75)
    game_x0 = (width - game_w) // 2
    game_x1 = game_x0 + game_w

    img = Image.new('RGBA', (width, height), (0, 0, 0, 0))
    draw = ImageDraw.Draw(img)

    # 1. Base em ardósia e basalto nobre para as laterais
    for panel_x0, panel_x1, is_right in [(0, game_x0, False), (game_x1, width, True)]:
        panel_w = panel_x1 - panel_x0
        # Gradiente vertical suave do painel (mais escuro na borda externa, iluminado no pilar)
        for y in range(height):
            vy = math.sin((y / height) * math.pi)
            base_r = int(15 + vy * 5)
            base_g = int(17 + vy * 6)
            base_b = int(24 + vy * 8)
            draw.line([(panel_x0, y), (panel_x1, y)], fill=(base_r, base_g, base_b, 255))

        # Blocos de pedra rúnica (pedra talhada gótica ancestral)
        block_h = 54
        block_w = 111
        for row in range(height // block_h + 1):
            by = row * block_h
            offset = (row % 2) * (block_w // 2)
            for col in range((panel_w // block_w) + 2):
                bx = panel_x0 + col * block_w - offset
                if bx + block_w < panel_x0 or bx > panel_x1:
                    continue
                cx0 = max(panel_x0, bx)
                cx1 = min(panel_x1, bx + block_w)
                cy0 = max(0, by)
                cy1 = min(height, by + block_h)
                if cx1 > cx0 and cy1 > cy0:
                    draw_beveled_rect(draw, [cx0, cy0, cx1, cy1],
                                      fill=(20, 24, 32, 255),
                                      light=(42, 52, 70, 120),
                                      dark=(8, 10, 15, 200),
                                      width=1)

        # Pilar Central dentro de cada painel
        pillar_w = int(panel_w * 0.60)
        pillar_x0 = panel_x0 + (panel_w - pillar_w) // 2
        pillar_x1 = pillar_x0 + pillar_w

        # Sombra do pilar sobre a parede
        draw.rectangle([pillar_x0 - 15, 0, pillar_x1 + 15, height], fill=(6, 8, 12, 140))

        # Corpo do Pilar (Mármore Escuro / Basalto Estilizado)
        draw_beveled_rect(draw, [pillar_x0, 0, pillar_x1, height],
                          fill=(24, 28, 38, 255),
                          light=(65, 80, 105, 255),
                          dark=(10, 12, 18, 255),
                          width=4)

        # Canaletas verticais do pilar (estilo clássico nórdico / gótico)
        flute_count = 5
        flute_w = (pillar_w - 40) // flute_count
        for f in range(flute_count):
            fx0 = pillar_x0 + 20 + f * flute_w
            fx1 = fx0 + flute_w - 6
            draw_beveled_rect(draw, [fx0, 30, fx1, height - 30],
                              fill=(16, 19, 27, 255),
                              light=(10, 12, 16, 255),
                              dark=(50, 62, 85, 200),
                              width=2)

        # Capitéis ornamentados no topo e base do pilar
        for cap_y0, cap_y1 in [(0, 60), (height - 60, height)]:
            draw_beveled_rect(draw, [pillar_x0 - 8, cap_y0, pillar_x1 + 8, cap_y1],
                              fill=(36, 42, 56, 255),
                              light=(95, 115, 150, 255),
                              dark=(10, 12, 18, 255),
                              width=3)
            # Relevo dourado de bronze no capitel
            draw.rectangle([pillar_x0, cap_y0 + 20, pillar_x1, cap_y0 + 26],
                           fill=(195, 155, 60, 240))
            draw.line([(pillar_x0, cap_y0 + 20), (pillar_x1, cap_y0 + 20)], fill=(255, 225, 120, 255))
            draw.line([(pillar_x0, cap_y0 + 26), (pillar_x1, cap_y0 + 26)], fill=(110, 80, 25, 255))

        # Friso Dourado Ornamental na margem do jogo
        border_x = panel_x1 - 6 if not is_right else panel_x0
        draw.rectangle([border_x, 0, border_x + 6, height], fill=(160, 130, 50, 255))
        draw.line([(border_x, 0), (border_x, height)], fill=(225, 195, 95, 255))
        draw.line([(border_x + 5, 0), (border_x + 5, height)], fill=(75, 55, 15, 255))

    # 2. Painel Esquerdo: Medalhão Heráldico de HEROES LORE: ZERO
    left_cx = game_x0 // 2
    r_medallion = 74
    cy_medallion = height // 2 - 130

    # Halo místico dourado e rubi em torno do medalhão
    for r in range(r_medallion + 42, r_medallion, -3):
        alpha = int(95 * (1.0 - (r - r_medallion) / 42.0))
        draw.ellipse([left_cx - r, cy_medallion - r, left_cx + r, cy_medallion + r],
                     fill=(240, 180, 50, alpha))

    # Medalhão de Bronze e Aço
    draw.ellipse([left_cx - r_medallion, cy_medallion - r_medallion,
                  left_cx + r_medallion, cy_medallion + r_medallion],
                 fill=(28, 32, 44, 255), outline=(215, 175, 75, 255), width=4)
    draw.ellipse([left_cx - r_medallion + 8, cy_medallion - r_medallion + 8,
                  left_cx + r_medallion - 8, cy_medallion + r_medallion - 8],
                 outline=(90, 120, 170, 200), width=2)

    # Rebites de bronze ao redor do medalhão
    for angle_deg in range(0, 360, 45):
        rad = math.radians(angle_deg)
        riv_r = r_medallion - 4
        riv_x = int(left_cx + riv_r * math.cos(rad))
        riv_y = int(cy_medallion + riv_r * math.sin(rad))
        draw.ellipse([riv_x - 3, riv_y - 3, riv_x + 3, riv_y + 3],
                     fill=(225, 190, 85, 255), outline=(50, 40, 15, 255))

    # Asas Heráldicas Douradas e Prateadas no fundo do medalhão
    draw.polygon([(left_cx - 16, cy_medallion + 10), (left_cx - 46, cy_medallion - 16),
                  (left_cx - 30, cy_medallion + 8), (left_cx - 48, cy_medallion + 2),
                  (left_cx - 20, cy_medallion + 22)], fill=(210, 175, 75, 220))
    draw.polygon([(left_cx + 16, cy_medallion + 10), (left_cx + 46, cy_medallion - 16),
                  (left_cx + 30, cy_medallion + 8), (left_cx + 48, cy_medallion + 2),
                  (left_cx + 20, cy_medallion + 22)], fill=(210, 175, 75, 220))

    # As Armas Cruzadas de Lucian em Heroes Lore: Zero:
    # 1. Espada Larga (Diagonal Esquerda-Inferior para Direita-Superior)
    # 2. Gunblade / Pistola-Espada (Diagonal Direita-Inferior para Esquerda-Superior)
    # Lâmina 1: Espada Sagrada
    draw.polygon([(left_cx - 38, cy_medallion - 38), (left_cx - 33, cy_medallion - 43),
                  (left_cx + 38, cy_medallion + 38), (left_cx + 33, cy_medallion + 43)],
                 fill=(220, 240, 255, 255))
    draw.line([(left_cx - 38, cy_medallion - 38), (left_cx + 38, cy_medallion + 38)],
              fill=(120, 190, 240, 255), width=2)
    # Guarda da Espada 1
    draw.line([(left_cx + 26, cy_medallion + 40), (left_cx + 40, cy_medallion + 26)],
              fill=(230, 185, 75, 255), width=4)

    # Lâmina 2: Gunblade de Lucian
    draw.polygon([(left_cx + 38, cy_medallion - 38), (left_cx + 33, cy_medallion - 43),
                  (left_cx - 38, cy_medallion + 38), (left_cx - 33, cy_medallion + 43)],
                 fill=(245, 245, 250, 255))
    draw.line([(left_cx + 38, cy_medallion - 38), (left_cx - 38, cy_medallion + 38)],
              fill=(210, 160, 50, 255), width=2)
    # Mecanismo Gunblade (Tambor / Guarda)
    draw.line([(left_cx - 26, cy_medallion + 40), (left_cx - 40, cy_medallion + 26)],
              fill=(230, 185, 75, 255), width=4)
    draw.ellipse([left_cx - 32, cy_medallion + 28, left_cx - 24, cy_medallion + 36],
                 fill=(80, 95, 120, 255), outline=(210, 175, 75, 255))

    # Gema Rubi Central no ponto de cruzamento das armas
    draw.polygon([(left_cx, cy_medallion - 12),
                  (left_cx + 10, cy_medallion),
                  (left_cx, cy_medallion + 12),
                  (left_cx - 10, cy_medallion)],
                 fill=(230, 35, 45, 255))
    draw.polygon([(left_cx, cy_medallion - 8),
                  (left_cx + 6, cy_medallion),
                  (left_cx, cy_medallion + 8),
                  (left_cx - 6, cy_medallion)],
                 fill=(255, 95, 105, 255))
    # Ponto de brilho branco da gema
    draw.ellipse([left_cx - 2, cy_medallion - 4, left_cx + 2, cy_medallion], fill=(255, 255, 255, 255))

    # Fileira de Runas Arcanas na Coluna Esquerda
    left_rune_types = ['algiz', 'tiwaz', 'fehu', 'sowilo', 'gebo', 'othala']
    start_ry = cy_medallion + 105
    step_ry = 50
    for idx, r_type in enumerate(left_rune_types):
        draw_rune(draw, left_cx, start_ry + idx * step_ry, r_type, sz=15)

    # Inscrição mística HEROES LORE • ZERO na coluna esquerda
    try:
        font_hl_left = ImageFont.truetype(FONT_TITLE, 19)
        font_zero_left = ImageFont.truetype(FONT_TITLE, 21)
    except:
        font_hl_left = ImageFont.load_default()
        font_zero_left = font_hl_left

    txt_hl_l = "• HEROES LORE •"
    bbox_hl_l = draw.textbbox((0, 0), txt_hl_l, font=font_hl_left)
    w_hl_l = bbox_hl_l[2] - bbox_hl_l[0]
    draw.text((left_cx - w_hl_l // 2, start_ry + len(left_rune_types) * step_ry + 10),
              txt_hl_l, font=font_hl_left, fill=(230, 195, 95, 230))

    txt_z_l = "• ZERO •"
    bbox_z_l = draw.textbbox((0, 0), txt_z_l, font=font_zero_left)
    w_z_l = bbox_z_l[2] - bbox_z_l[0]
    draw.text((left_cx - w_z_l // 2, start_ry + len(left_rune_types) * step_ry + 36),
              txt_z_l, font=font_zero_left, fill=(255, 220, 110, 255))

    # 3. Painel Direito: Logotipo Oficial Gravado em Ouro e Prata
    right_cx = game_x1 + (width - game_x1) // 2

    try:
        font_hl = ImageFont.truetype(FONT_TITLE, 32)
        font_zero = ImageFont.truetype(FONT_TITLE, 26)
        font_tag = ImageFont.truetype(FONT_TITLE, 13)
        font_box_title = ImageFont.truetype(FONT_TITLE, 13)
        font_name_gold = ImageFont.truetype(FONT_TITLE, 18)
        font_name_plat = ImageFont.truetype(FONT_TITLE, 16)
        font_name_cyan = ImageFont.truetype(FONT_TITLE, 16)
        font_sub = ImageFont.truetype(FONT_TITLE, 11)
        font_stamp = ImageFont.truetype(FONT_TITLE, 13)
    except:
        font_hl = ImageFont.load_default()
        font_zero = font_hl
        font_tag = font_hl
        font_box_title = font_hl
        font_name_gold = font_hl
        font_name_plat = font_hl
        font_name_cyan = font_hl
        font_sub = font_hl
        font_stamp = font_hl

    # 1. Placa Superior Nobre de Heroes Lore: Zero (y = 200 até 400)
    plaque_w = 400
    plaque_h = 190
    logo_y = 205

    draw_beveled_rect(draw, [right_cx - plaque_w // 2, logo_y, right_cx + plaque_w // 2, logo_y + plaque_h],
                      fill=(18, 22, 32, 255),
                      light=(85, 105, 140, 240),
                      dark=(8, 10, 15, 255),
                      width=3)
    # Filete dourado duplo interno
    draw.rectangle([right_cx - plaque_w // 2 + 6, logo_y + 6, right_cx + plaque_w // 2 - 6, logo_y + plaque_h - 6],
                   outline=(180, 140, 50, 200), width=2)

    # Rebites de bronze nos cantos da placa
    for cx_c, cy_c in [
        (right_cx - plaque_w // 2 + 12, logo_y + 12),
        (right_cx + plaque_w // 2 - 12, logo_y + 12),
        (right_cx - plaque_w // 2 + 12, logo_y + plaque_h - 12),
        (right_cx + plaque_w // 2 - 12, logo_y + plaque_h - 12)
    ]:
        draw.ellipse([cx_c - 3, cy_c - 3, cx_c + 3, cy_c + 3], fill=(210, 170, 70, 230), outline=(40, 30, 10, 255))

    # Título Nobre Oficial: HEROES LORE
    txt_hl = "HEROES LORE"
    bbox_hl = draw.textbbox((0, 0), txt_hl, font=font_hl)
    w_hl = bbox_hl[2] - bbox_hl[0]
    draw.text((right_cx - w_hl // 2 + 2, logo_y + 24), txt_hl, font=font_hl, fill=(0, 0, 0, 255))
    draw.text((right_cx - w_hl // 2, logo_y + 22), txt_hl, font=font_hl, fill=(245, 205, 100, 255))

    # Subtítulo Imponente: ZERO
    txt_zero = "ZERO"
    bbox_zero = draw.textbbox((0, 0), txt_zero, font=font_zero)
    w_zero = bbox_zero[2] - bbox_zero[0]
    # Sombra profunda e cor rubi/dourada de Zero
    draw.text((right_cx - w_zero // 2 + 2, logo_y + 70), txt_zero, font=font_zero, fill=(0, 0, 0, 255))
    draw.text((right_cx - w_zero // 2, logo_y + 68), txt_zero, font=font_zero, fill=(240, 70, 75, 255))
    draw.text((right_cx - w_zero // 2, logo_y + 68), txt_zero, font=font_zero, fill=(255, 220, 120, 160))

    # Losangos heráldicos flanqueando ZERO
    draw.polygon([(right_cx - w_zero // 2 - 25, logo_y + 82),
                  (right_cx - w_zero // 2 - 19, logo_y + 88),
                  (right_cx - w_zero // 2 - 13, logo_y + 82),
                  (right_cx - w_zero // 2 - 19, logo_y + 76)], fill=(225, 185, 75, 240))
    draw.polygon([(right_cx + w_zero // 2 + 13, logo_y + 82),
                  (right_cx + w_zero // 2 + 19, logo_y + 88),
                  (right_cx + w_zero // 2 + 25, logo_y + 82),
                  (right_cx + w_zero // 2 + 19, logo_y + 76)], fill=(225, 185, 75, 240))

    # Divisor dourado com losango
    div_y = logo_y + 125
    draw.line([(right_cx - 110, div_y), (right_cx + 110, div_y)], fill=(160, 130, 50, 220), width=2)
    draw.polygon([(right_cx, div_y - 6), (right_cx + 6, div_y), (right_cx, div_y + 6), (right_cx - 6, div_y)],
                 fill=(255, 215, 90, 255))

    # Sub-rótulo Recompilação Nativa
    txt_sub = "EDICAO DEFINITIVA RECOMPILADA"
    bbox_sub = draw.textbbox((0, 0), txt_sub, font=font_tag)
    w_sub = bbox_sub[2] - bbox_sub[0]
    draw.text((right_cx - w_sub // 2, logo_y + 144), txt_sub, font=font_tag, fill=(140, 170, 210, 230))

    # 2. Cartucho Heráldico Inferior (y = 430 até 870)
    box_w = 400
    box_h = 440
    box_y = 430

    draw_beveled_rect(draw, [right_cx - box_w // 2, box_y, right_cx + box_w // 2, box_y + box_h],
                      fill=(15, 19, 27, 245),
                      light=(70, 90, 120, 200),
                      dark=(6, 8, 12, 255),
                      width=2)
    # Filete dourado interno refinado
    draw.rectangle([right_cx - box_w // 2 + 5, box_y + 5, right_cx + box_w // 2 - 5, box_y + box_h - 5],
                   outline=(150, 120, 45, 170), width=1)

    # Rebites de bronze nos cantos
    for cx_c, cy_c in [
        (right_cx - box_w // 2 + 10, box_y + 10),
        (right_cx + box_w // 2 - 10, box_y + 10),
        (right_cx - box_w // 2 + 10, box_y + box_h - 10),
        (right_cx + box_w // 2 - 10, box_y + box_h - 10)
    ]:
        draw.ellipse([cx_c - 3, cy_c - 3, cx_c + 3, cy_c + 3], fill=(190, 150, 60, 220), outline=(50, 40, 15, 255))

    # Título do Cartucho
    txt_hdr = "— ARQUIVO DE PRESERVACAO —"
    bbox_hdr = draw.textbbox((0, 0), txt_hdr, font=font_box_title)
    w_hdr = bbox_hdr[2] - bbox_hdr[0]
    draw.text((right_cx - w_hdr // 2, box_y + 22), txt_hdr, font=font_box_title, fill=(215, 180, 85, 230))

    # Divisor 1
    d1_y = box_y + 56
    draw.line([(right_cx - 120, d1_y), (right_cx + 120, d1_y)], fill=(130, 105, 45, 160), width=1)
    draw.polygon([(right_cx, d1_y - 4), (right_cx + 4, d1_y), (right_cx, d1_y + 4), (right_cx - 4, d1_y)],
                 fill=(220, 185, 80, 220))

    # Bloco 1: David Kalil Braga
    b1_y = box_y + 78
    txt_dk = "DAVID KALIL BRAGA"
    bbox_dk = draw.textbbox((0, 0), txt_dk, font=font_name_gold)
    w_dk = bbox_dk[2] - bbox_dk[0]
    draw.text((right_cx - w_dk // 2 + 1, b1_y + 1), txt_dk, font=font_name_gold, fill=(0, 0, 0, 240))
    draw.text((right_cx - w_dk // 2, b1_y), txt_dk, font=font_name_gold, fill=(250, 215, 110, 255))

    txt_dk_sub = "RECOMPILACAO C++17 • ENGENHARIA"
    bbox_dk_sub = draw.textbbox((0, 0), txt_dk_sub, font=font_sub)
    w_dk_sub = bbox_dk_sub[2] - bbox_dk_sub[0]
    draw.text((right_cx - w_dk_sub // 2, b1_y + 26), txt_dk_sub, font=font_sub, fill=(160, 180, 205, 210))

    # Divisor 2
    d2_y = box_y + 150
    draw.line([(right_cx - 120, d2_y), (right_cx + 120, d2_y)], fill=(130, 105, 45, 160), width=1)
    draw.polygon([(right_cx, d2_y - 4), (right_cx + 4, d2_y), (right_cx, d2_y + 4), (right_cx - 4, d2_y)],
                 fill=(220, 185, 80, 220))

    # Bloco 2: EA Mobile • Hands-On Mobile (2008)
    b2_y = box_y + 172
    txt_ea = "EA MOBILE • HANDS-ON MOBILE"
    bbox_ea = draw.textbbox((0, 0), txt_ea, font=font_name_plat)
    w_ea = bbox_ea[2] - bbox_ea[0]
    draw.text((right_cx - w_ea // 2 + 1, b2_y + 1), txt_ea, font=font_name_plat, fill=(0, 0, 0, 240))
    draw.text((right_cx - w_ea // 2, b2_y), txt_ea, font=font_name_plat, fill=(225, 240, 255, 255))

    txt_ea_sub = "DESENVOLVEDORES ORIGINAIS (2008)"
    bbox_ea_sub = draw.textbbox((0, 0), txt_ea_sub, font=font_sub)
    w_ea_sub = bbox_ea_sub[2] - bbox_ea_sub[0]
    draw.text((right_cx - w_ea_sub // 2, b2_y + 26), txt_ea_sub, font=font_sub, fill=(160, 180, 205, 210))

    # Divisor 3
    d3_y = box_y + 244
    draw.line([(right_cx - 120, d3_y), (right_cx + 120, d3_y)], fill=(130, 105, 45, 160), width=1)
    draw.polygon([(right_cx, d3_y - 4), (right_cx + 4, d3_y), (right_cx, d3_y + 4), (right_cx - 4, d3_y)],
                 fill=(220, 185, 80, 220))

    # Bloco 3: Fidelidade Técnica e Audiovisual
    b3_y = box_y + 266
    txt_fid = "PROPORCAO: 3:4 ORIGINAL"
    bbox_fid = draw.textbbox((0, 0), txt_fid, font=font_name_cyan)
    w_fid = bbox_fid[2] - bbox_fid[0]
    draw.text((right_cx - w_fid // 2 + 1, b3_y + 1), txt_fid, font=font_name_cyan, fill=(0, 0, 0, 240))
    draw.text((right_cx - w_fid // 2, b3_y), txt_fid, font=font_name_cyan, fill=(0, 225, 255, 245))

    txt_fid_sub = "TAXA FIEL 15/30 FPS • SOM MIDI SF2"
    bbox_fid_sub = draw.textbbox((0, 0), txt_fid_sub, font=font_sub)
    w_fid_sub = bbox_fid_sub[2] - bbox_fid_sub[0]
    draw.text((right_cx - w_fid_sub // 2, b3_y + 26), txt_fid_sub, font=font_sub, fill=(110, 205, 235, 220))

    # Divisor 4
    d4_y = box_y + 338
    draw.line([(right_cx - 120, d4_y), (right_cx + 120, d4_y)], fill=(130, 105, 45, 160), width=1)
    draw.polygon([(right_cx, d4_y - 4), (right_cx + 4, d4_y), (right_cx, d4_y + 4), (right_cx - 4, d4_y)],
                 fill=(220, 185, 80, 220))

    # Bloco 4: Carimbo de Fidelidade
    b4_y = box_y + 368
    txt_st = "• FIDELIDADE PIXEL-PERFECT •"
    bbox_st = draw.textbbox((0, 0), txt_st, font=font_stamp)
    w_st = bbox_st[2] - bbox_st[0]
    draw.text((right_cx - w_st // 2, b4_y), txt_st, font=font_stamp, fill=(235, 195, 95, 230))

    # 3. Selo Sagrado Inferior em y = 920
    txt_sfoot = "— ZERO CHRONICLES REBORN 2026 —"
    bbox_sf = draw.textbbox((0, 0), txt_sfoot, font=font_stamp)
    w_sf = bbox_sf[2] - bbox_sf[0]
    draw.text((right_cx - w_sf // 2, 922), txt_sfoot, font=font_stamp, fill=(245, 205, 100, 230))

    # 4. Chanfro de Profundidade e Sombra Suave na junção com o jogo (Inner Shadow)
    shadow_w = 28
    for i in range(shadow_w):
        alpha = int(220 * (1.0 - (i / shadow_w) ** 0.8))
        draw.line([(game_x0 - i, 0), (game_x0 - i, height)], fill=(0, 0, 0, alpha))
        draw.line([(game_x1 + i, 0), (game_x1 + i, height)], fill=(0, 0, 0, alpha))

    # Borda dourada brilhante de separação precisa
    draw.line([(game_x0 - 1, 0), (game_x0 - 1, height)], fill=(200, 160, 70, 255), width=2)
    draw.line([(game_x1, 0), (game_x1, height)], fill=(200, 160, 70, 255), width=2)

    return img

def create_bezel_slate(width=1920, height=1080):
    game_w = int(height * 0.75)
    game_x0 = (width - game_w) // 2
    game_x1 = game_x0 + game_w

    img = Image.new('RGBA', (width, height), (0, 0, 0, 0))
    draw = ImageDraw.Draw(img)

    # Ardósia vulcânica escura com textura sutil e micro-chanfros
    for panel_x0, panel_x1 in [(0, game_x0), (game_x1, width)]:
        for y in range(height):
            t = math.sin((y / height) * math.pi)
            v = int(14 + t * 6)
            draw.line([(panel_x0, y), (panel_x1, y)], fill=(v, v + 2, v + 4, 255))

        # Faixas de metal escovado verticais
        p_w = panel_x1 - panel_x0
        step = 60
        for x in range(panel_x0, panel_x1, step):
            draw_beveled_rect(draw, [x, 0, min(panel_x1, x + step), height],
                              fill=(16, 18, 22, 255),
                              light=(32, 36, 44, 180),
                              dark=(6, 8, 10, 220),
                              width=1)

    # Chanfro e sombra na borda do jogo
    shadow_w = 24
    for i in range(shadow_w):
        alpha = int(240 * (1.0 - i / shadow_w))
        draw.line([(game_x0 - i, 0), (game_x0 - i, height)], fill=(0, 0, 0, alpha))
        draw.line([(game_x1 + i, 0), (game_x1 + i, height)], fill=(0, 0, 0, alpha))

    # Linha de destaque em cinza titânio
    draw.line([(game_x0 - 1, 0), (game_x0 - 1, height)], fill=(70, 80, 95, 255), width=2)
    draw.line([(game_x1, 0), (game_x1, height)], fill=(70, 80, 95, 255), width=2)

    return img

def create_font_osd():
    # 96 caracteres ASCII: 32 (espaço) a 127 em células 44x72
    cell_w, cell_h = 44, 72
    cols, rows = 16, 6
    img = Image.new('RGBA', (cols * cell_w, rows * cell_h), (0, 0, 0, 0))

    font_path = "C:/Windows/Fonts/segoeuib.ttf"
    if not os.path.exists(font_path):
        font_path = "C:/Windows/Fonts/arialbd.ttf"
    try:
        font = ImageFont.truetype(font_path, 44)
    except:
        font = ImageFont.load_default()

    for idx in range(96):
        ascii_code = 32 + idx
        char = chr(ascii_code)
        col = idx % cols
        row = idx // cols

        cell_img = Image.new('RGBA', (cell_w, cell_h), (0, 0, 0, 0))
        d_cell = ImageDraw.Draw(cell_img)

        bbox = d_cell.textbbox((0, 0), char, font=font)
        tw = bbox[2] - bbox[0]
        th = bbox[3] - bbox[1]
        tx = (cell_w - tw) // 2
        ty = (cell_h - th) // 2 - 2

        # Sombra sutil escura
        for ox in [-2, 0, 2]:
            for oy in [-2, 0, 2]:
                if ox != 0 or oy != 0:
                    d_cell.text((tx + ox, ty + oy), char, font=font, fill=(5, 8, 14, 230))
        # Caractere branco brilhante
        d_cell.text((tx, ty), char, font=font, fill=(255, 255, 255, 255))

        img.paste(cell_img, (col * cell_w, row * cell_h))

    return img

def main():
    dest_dirs = [
        "assets/ui",
        "build/assets/ui",
        "android/app/src/main/assets/ui",
        "android/app/src/main/assets/assets/ui",
        "dist_windows/assets/ui",
        "romfs/assets/ui",
        "romfs/ui"
    ]
    for d in dest_dirs:
        os.makedirs(d, exist_ok=True)

    print("==================================================")
    print(" Gerando Molduras Temáticas (Bezels) para Zero")
    print("==================================================")

    print("\n1. Gerando Bezel Temático Oficial: Heroes Lore: Zero (1920x1080)...")
    img_zero = create_bezel_zero(1920, 1080)
    for d in dest_dirs:
        save_rgba(img_zero, os.path.join(d, "bezel_zero.rgba"))
        # Mantém também bezel_soltia para retrocompatibilidade total com saves/configs anteriores
        save_rgba(img_zero, os.path.join(d, "bezel_soltia.rgba"))

    print("\n2. Gerando Bezel Minimalista: Ardósia Escura (1920x1080)...")
    img_slate = create_bezel_slate(1920, 1080)
    for d in dest_dirs:
        save_rgba(img_slate, os.path.join(d, "bezel_slate.rgba"))

    print("\n3. Gerando Fonte OSD (704x432)...")
    img_font = create_font_osd()
    for d in dest_dirs:
        save_rgba(img_font, os.path.join(d, "font_osd.rgba"))

    print("\n[OK] Todas as texturas de bezel de Heroes Lore: Zero geradas com sucesso!")

if __name__ == "__main__":
    main()

