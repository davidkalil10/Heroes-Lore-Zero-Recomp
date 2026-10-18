# STATUS — Heroes Lore: Zero

_Última atualização: 2026-10-13_

## Ambiente
- Java 17/21, Python 3.13, Git: OK.
- Toolchain C++ (MSYS2 UCRT64: g++, CMake, Ninja, SDL2, SDL2_mixer): OK.
- Guia Mestre Arquitetural disponível em `docs/PORTING_GUIDE_BLUEPRINT.md`.

## Estado Atual
- [x] JAR original copiado: `reference/heroes_zero.jar` (1.232.363 bytes).
- [x] Extraído: `reference/extracted/` (141 classes, 938 arquivos de recursos).
- [x] Decompilado: `reference/decompiled_cfr/` (141 classes decompiladas com CFR).
- [x] Bytecode desmontado: `reference/javap/` (141 arquivos `.javap.txt`).
- [x] Identificação do MIDlet principal: `rpg.RPGHeroEx`.
- [x] Análise da resolução e controles: Nokia C6-00 (360x640), Canvas `f` com suporte a toque (`pointerPressed`, `pointerReleased`) e pad virtual (`vpad.png`).
- [x] Motor base C++17 copiado (`src/vm/`, `src/midp/`, `src/platform/`).
- [x] Assets de sistema integrados: fontes TrueType Inter (`assets/fonts/`), soundfont GM (`assets/soundfont/TimGM6mb.sf2`), botões translúcidos (`assets/ui/`).
- [x] Assets do jogo extraídos para `assets/` (mapas `.m`, `.mpm`, definições `.tdf`, fontes `.dat`, imagens `.png`, textos `en/`, áudio `snd/`).
- [x] Adaptar `main.cpp` para inicializar a resolução 360x640 e a classe `rpg.RPGHeroEx`.
- [x] Portar o Canvas `f`, contexto gráfico `cm` e máquina de estados `az` / `rpg.a`.
- [x] Implementar nativos Java/J2ME necessários (`Hashtable`, `Vector`, `String`, `LCDUI Graphics/Image`, `DataInputStream/OutputStream`).
- [x] Marco 0 (Milestone 1): Jogo abrindo no PC em 360x640 com tela de splash `bv`, áudio MIDI e menu `bs`!
- [x] Validação de jogabilidade no PC via Teclado e Gamepad (injeção e captura de eventos verificadas).
- [x] Ocultação do touchpad virtual (`vpad.png`) para apresentação limpa e pura no PC/consoles.
- [x] Resolução nativa original fiel 240x320 (3:4) sem distorção e sem gaps entre mapa e diálogos.
- [x] True Widescreen 16:9 (568x320) com expansão real de viewport horizontal e reposicionamento de HUD/câmera.
- [x] Modo Auto dinâmico adaptando proporção entre 16:9 widescreen e 3:4 original de acordo com a janela/tela.
- [x] Molduras temáticas (Bezels Soltia / Slate) nas abas laterais em modo 3:4.
- [x] Atalhos de controle de proporção: F7 (Ciclo Auto / 3:4 / 16:9), Alt+Enter / F11 (Tela Cheia).
- [x] Correção de travamento nas cutscenes iniciais (correção de GC dangling pointer em `Runtime.getRuntime`).
- [x] Resolução de lentidão/inanição de threads (GIL starvation) e calibração de `Thread_sleep` nativo.
- [x] Taxa de quadros calibrada para 30 FPS (Fluido / Padrão) e 15 FPS (Nostalgia J2ME original), com ciclo estrito via F6 e Menu de Opções.
- [x] Correção do NullPointerException e travamento ao redimensionar a tela ou alternar proporção durante cutscenes/diálogos (`df.var_cg_a`).
- [x] Transição do Menu Principal para o Mapa de Aventura (`do.java`) e cutscene do prólogo com áudio `/snd/b/10`.
- [x] Suporte ao opcode 196 (`wide` / 0xC4) na VM JVM (`src/vm/interp.cpp`), corrigindo crash fatal em `g.a()V` (`iinc_w 2, 256`) na transição para o Mapa 136.
- [x] Mapeamento ergonômico da tecla `#` (código 35) para pular cutscenes e diálogos instantaneamente (`di.var_boolean_f = false`): teclas H, N, P, ., ], /, # no Teclado, e botão `Select / Back` ou `RT` no Gamepad.
- [x] Entrada no Quarto do Protagonista (Mapa 136) com controle ativo do jogador liberado, HUD completo renderizado e trilha sonora `/snd/b/13` ativa!
- [x] Mapeamento ergonômico da tecla `*` (código 42) para a tecla `7` acima do WASD.
- [x] Confirmação intuitiva de menus via `Espaço`, `Enter` e botão `A` do controle (emulação inteligente de LSK `-6` quando `di.var_byte_d == 5`, eliminando o salto indesejado para a opção 5).
- [x] Correção da distorção/bagunça na barra de status ao alternar proporção de tela ou alternar tela cheia (eliminação do shearing com `img->pixels.assign` e invalidação imediata dos dirty flags `bs.c:Z` e `rpg/a.a:Z`).
- [x] Preenchimento contínuo e sem emendas das lacunas pretas na barra de status em True Widescreen (16:9), estendendo as molduras de pedra gótica modular (`rpg.e.var_cg_k`) pelas laterais do console de vida/mana.
- [x] Pipeline de CI Multiplataforma configurado no GitHub Actions (`.github/workflows/build.yml`) para compilação automatizada nas 4 plataformas: Windows (x64 ZIP), Linux (AppImage), Android (Universal & ARM64 APKs) e Nintendo Switch (.nro Homebrew com RomFS).
- [x] Mapeamento ergonômico de Gamepads físicos para Nintendo Switch (A=53 Ataque/Confirma, B=-7 Menu/Cancela, X=49 Skill 1, Y=51 Skill 2, L1/LB=55 Skill 3, R1/RB=57 Skill 4, ZL/LT=35 Poção MP/Skip diálogo, ZR/RT=48 Poção HP, SELECT=Minimapa 42 / Skip em cutscene) e PC/Xbox.
- [x] Otimização e ergonomia do layout de botões virtuais (Mobile e Switch portátil) em Retrato e Paisagem, elevando o viewport no topo para 100% de visão desobstruída do HUD e posicionando MENU e MAPA acima do D-Pad.
- [x] Detecção inteligente de dock no Nintendo Switch (`appletGetOperationMode() == AppletOperationMode_Console`), ocultando controles de toque na TV, centralizando o viewport em 1080p e exibindo notificação OSD de transição.
- [x] Correção de travamento no modo Retrato do Switch (TATE 90° / Flip Grip 270°), garantindo a renderização direta dos diálogos modais (`Updater`, `CloudSave`) no buffer intermediário `s_rotateTarget`.
- [ ] Validação de persistência de save games RMS (`ah`, `bh`, `rpg.b`).

## Roadmap de Etapas (Seguindo o Blueprint)
- [x] **Passo 0:** Boot nativo no PC da classe `rpg.RPGHeroEx` e renderização do primeiro frame (240x320 / Widescreen).
- [x] **Passo 1:** Game loop estável (60 Hz com lógica original), Splash `bv`, Música MIDI (`/snd/b/0`) e Menu `bs`.
- [x] **Passo 2:** Suporte completo a teclado e gamepads com mapeamento ergonômico (incluindo atalhos `#` de skip e poções).
- [x] **Passo 3:** True Widescreen (16:9, 568x320), Modo Original (3:4, 240x320), Molduras Soltia (Bezels) e Modo Auto.
- [x] **Passo 4:** Jogabilidade do Prólogo e Abertura até o Quarto do Herói (Mapa 136) 100% funcional sem crashes.
- [x] **Passo 5:** Configuração e Scripts de Build Multiplataforma (Nintendo Switch Makefile, Linux AppDir/AppRun, Android Gradle/NDK, Windows MinGW).
- [ ] **Passo 6:** Validação e testes práticos dos binários compilados das 4 plataformas.
- [ ] **Passo 7:** Persistência de save games RMS (`rpg.b`, `ah`, `bh`) em disco.
- [ ] **Passo 8:** Auto-Updater OTA via GitHub Releases.
- [ ] **Passo 9:** Cloud Save Multiplataforma (Google Drive RFC 8628).
