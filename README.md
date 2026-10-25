# ⚔️ Heroes Lore: Zero — Recompilação Nativa Multiplataforma (C++17 + SDL2)

[![Release](https://img.shields.io/github/v/release/davidkalil10/Heroes-Lore-Zero-Recomp?style=for-the-badge&color=blue)](https://github.com/davidkalil10/Heroes-Lore-Zero-Recomp/releases)
[![Plataformas](https://img.shields.io/badge/Plataformas-Windows%20%7C%20Linux%20%7C%20Android%20%7C%20Switch-success?style=for-the-badge)](https://github.com/davidkalil10/Heroes-Lore-Zero-Recomp/releases)
[![C++17](https://img.shields.io/badge/Padrão-C%2B%2B17-blue.svg?style=for-the-badge)](https://en.wikipedia.org/wiki/C%2B%2B17)
[![SDL2](https://img.shields.io/badge/Frontend-SDL2%20%2B%20SDL2__mixer-green.svg?style=for-the-badge)](https://www.libsdl.org/)
[![Licença](https://img.shields.io/badge/Finalidade-Preservação%20Histórica-orange.svg?style=for-the-badge)](#-licença-e-aviso-legal)

Port nativo e literal em **C++17** do clássico RPG J2ME **Heroes Lore: Zero** (*Electronic Arts / Hands-On Mobile Korea*), baseado na versão de alta definição para Nokia C6-00 (Symbian^3 / S60v5, MIDlet principal `rpg.RPGHeroEx`).

O projeto executa o **bytecode original diretamente no motor C++**, sem emulação pesada e sem reescrever a lógica de jogo no "olhômetro". Todas as fórmulas de combate, progressão de atributos, inteligência artificial de monstros, gráficos, animações e diálogos operam com fidelidade absoluta de 100% ao jogo original.

---

## 🌟 Recursos da Recompilação

- 🎮 **Controles Modernos & Gamepad Completo:**
  - Suporte nativo *plug-and-play* a controles de Xbox, PlayStation, Nintendo Switch Pro Controller e genéricos (D-Pad, analógicos com zona morta ajustada, botões de ação frontais e atalhos nos gatilhos).
  - Teclado com mapeamento ergonômico (`WASD` / Setas, `Espaço` / `Enter` para Ação, `Q`/`Tab` para Menu In-Game, `Esc`/`Backspace` para Voltar, `M` para Minimapa, `1`/`2`/`3`/`6` para Habilidades e `4`/`5` para Poções).
  - Emulação 1:1 fiel do teclado numérico do celular original via **NumPad** do PC.
- 📱 **Gamepad Virtual Ergonômico Touch (Mobile & Switch Portátil):**
  - Layout translúcido moderno reconstruído 1:1 baseado no aclamado design de *Heroes Lore 2*, com D-Pad analógico responsivo, pílulas de comando e botões de atalho dedicados para telas de toque em celulares Android e no Nintendo Switch em modo portátil.
- 🖥️ **True Widescreen (16:9) & Proporção de Tela Dinâmica:**
  - Alternância entre **Auto** (responsivo à orientação do dispositivo), **3:4 Original** (240x320) e **16:9 True Widescreen** (568x320 com expansão real da área visível do mapa e HUD rebalanceado).
  - **Menu In-Game Adaptativo:** O menu principal in-game (`ax.java`) se adapta dinamicamente à tela, expandindo-se para uma largura fluida de 558px em widescreen.
  - **Transição Thread-Safe:** Mudança instantânea de aspect ratio através do menu de configurações (`bd.class`) ou por atalho de controle/teclado sem congelamentos ou tela preta.
  - **Molduras Temáticas (Bezels):** Molduras exclusivas inspiradas na estética de Soltia (Soltia Dourada, Slate e Preto) para preenchimento de telas panorâmicas no modo 3:4.
- ⚡ **Limitador de Quadros (15 FPS / 30 FPS):**
  - **30 FPS:** Modo fluido moderno de alta taxa de resposta.
  - **15 FPS:** Taxa de quadros autêntica do hardware móvel J2ME original de 2008 (modo nostalgia).
- 🌐 **Localização Integral em Português do Brasil (PT-BR) & Sistema Multi-idiomas:**
  - Tradução completa para Português do Brasil de todos os menus de sistema, opções in-game, missões, itens, equipamentos, habilidades e todos os diálogos de mapas (Lucian, Clare, Silverleaf Village, Chelen Village, etc.).
  - **Hot-Reload em Tempo Real:** Alternância de idioma a quente pelo menu de opções (**Menu In-Game → System → Options → Idioma / Language**) ou tecla <kbd>F2</kbd>, atualizando textos e repintando a interface imediatamente sem reiniciar o jogo.
  - Exibição elegante do número da versão instalada (`v1.0.11`) centralizada logo abaixo do logotipo oficial no menu de título.
- ☁️ **Cloud Save Multiplataforma (Google Drive):**
  - Sincronização e backup de saves na nuvem via OAuth 2.0 Device Flow (RFC 8628), sem necessidade de digitação de senhas no jogo.
  - Pasta e arquivos de save totalmente dedicados e isolados para *Heroes Lore Zero* (`com.davidbraga.heroeslorezero`), permitindo continuar a mesma campanha entre PC, Android, Linux ou Nintendo Switch.
  - Recarregamento automático de metadados dos slots (`di.m()`) e retorno seguro ao título ao restaurar um save in-game.
- 🔄 **Atualizações OTA (Over-The-Air):**
  - Verificação e notificação automática de novas versões disponíveis diretamente pelo GitHub Releases (tecla <kbd>F9</kbd> ou menu Options).
  - No Android, conta com instalador de APK integrado com permissões seguras via `FileProvider`.
- 🎵 **Trilha Sonora MIDI Sintetizada em Tempo Real:**
  - Sintetizador de áudio embutido utilizando TinySoundFont (TSF) e TinyMidiLoader (TML), reproduzindo com fidelidade absoluta as 15 trilhas sonoras originais do jogo.

---

## 📱 Plataformas Suportadas

| Plataforma | Pacote / Binário | Formato | Status |
| :--- | :--- | :--- | :--- |
| 🪟 **Windows** | `heroes_lore_zero.exe` | Standalone ZIP (com DLLs e Assets) | ✅ Suportado |
| 🐧 **Linux & Steam Deck** | `heroes_lore_zero_linux_x86_64.AppImage` | AppImage portátil universal | ✅ Suportado |
| 🤖 **Android** | `heroes_lore_zero_android_universal.apk` / `arm64.apk` | APK nativo (ARM64-v8a + ARMeabi-v7a) | ✅ Suportado |
| 🕹️ **Nintendo Switch** | `heroes_lore_zero.nro` | Homebrew NRO com RomFS embutido | ✅ Suportado |

> **Nota de Isolamento:** Os identificadores de pacote (`com.davidbraga.heroeslorezero`), Title IDs do Switch (`0100484C5A000000`), pastas de armazenamento e arquivos de save na nuvem são 100% isolados de *Heroes Lore: Wind of Soltia* e *Heroes Lore 2*, permitindo que toda a trilogia coexista harmoniosamente no mesmo dispositivo sem qualquer conflito.

---

## 🎮 Mapeamento de Controles

### Ações de Jogo e Combate

| Ação no Jogo | Teclado (PC) | Gamepad (Xbox / Geral) | Nintendo Switch | Toque (Mobile / Switch) |
| :--- | :--- | :--- | :--- | :--- |
| **Movimento** | `WASD` / Setas / NumPad `2,4,6,8` | D-Pad / Analógico Esquerdo | D-Pad / Stick Esquerdo | D-Pad Virtual |
| **Ação / Atacar / Confirmar ('5')** | `Espaço` / `Enter` / NumPad `5` | Botão **A** | Botão **A** (Leste) | Botão **5** |
| **Menu In-Game (LSK = -6)** | `Q` / `Tab` / `L` | Botão **START** | Botão **+** (Plus) | Botão **MENU** |
| **Voltar / Cancelar / Menu (RSK = -7)** | `Esc` / `Backspace` / `E` / `R` | Botão **B** (ou START em menu) | Botão **B** (Sul) | Botão **BACK / X** |
| **Minimapa da Região ('*')** | `M` / `7` (topo) / `*` / NumPad `*` | Botão **SELECT / BACK** / `L3` | Botão **-** (Minus) / `L3` | Botão **MAPA** |
| **Poção HP ('0')** | `5` (topo) / `0` / NumPad `0` | Gatilho Direito (**RT / R2**) | Gatilho **ZR** | Botão **0 (HP)** |
| **Poção MP / Pular Diálogo ('#')** | `4` (topo) / `#` / `T` / `.` / NumPad `#` | Gatilho Esquerdo (**LT / L2**) / `R3` | Gatilho **ZL** / `R3` | Botão **# (MP / Pular)** |
| **Habilidade 1 ('1')** | `1` (topo) / NumPad `1` | Botão **X** | Botão **Y** (Oeste) | Botão **1** |
| **Habilidade 2 ('3')** | `2` (topo) / NumPad `3` | Botão **Y** | Botão **X** (Norte) | Botão **3** |
| **Habilidade 3 ('7')** | `3` (topo) / NumPad `7` | Botão de Ombro Esquerdo (**LB / L1**) | Botão **L** | Botão **7** |
| **Habilidade 4 ('9')** | `6` (topo) / `9` / `F` / NumPad `9` | Botão de Ombro Direito (**RB / R1**) | Botão **R** | Botão **9** |
| **Ciclar Poção Anterior** | `[` / `,` (vírgula) | Menu de Itens | Menu de Itens | Atalho de Menu |

### Atalhos Globais e Funções de Sistema

| Função de Sistema | Teclado (PC) | Gamepad (Atalho / Combo) |
| :--- | :--- | :--- |
| **Alternar Idioma (PT-BR / English)** | <kbd>F2</kbd> | Menu Options in-game |
| **Abrir Modal de Cloud Save (Google Drive)** | <kbd>F4</kbd> | Menu Options in-game |
| **Alternar Molduras (Soltia / Slate / Preto)** | <kbd>F5</kbd> | <kbd>SELECT</kbd> + <kbd>LB</kbd> |
| **Alternar FPS (30 FPS Fluido / 15 FPS Original)** | <kbd>F6</kbd> ou <kbd>F8</kbd> | <kbd>SELECT</kbd> + <kbd>RB</kbd> |
| **Alternar Aspect Ratio (Auto / 3:4 / 16:9 Wide)** | <kbd>F7</kbd> ou <kbd>F10</kbd> | <kbd>SELECT</kbd> + <kbd>START</kbd> ou Botão <kbd>Guide</kbd> |
| **Verificar Atualizações OTA** | <kbd>F9</kbd> | Menu Options in-game |
| **Alternar Tela Cheia (Fullscreen)** | <kbd>F11</kbd> ou <kbd>Alt</kbd> + <kbd>Enter</kbd> | — |
| **Alternar Rotação da Tela (Nintendo Switch)** | — | Botão <kbd>-</kbd> (Minus) no Switch |
| **Ocultar/Exibir Gamepad Virtual (Switch)** | — | Botão <kbd>L3</kbd> no Switch |

---

## 🏛️ Arquitetura do Projeto

O código-fonte foi estruturado de forma desacoplada em módulos nativos limpos e modernos:

```
heroes_lore_zero_recomp/
├── src/
│   ├── vm/                     # Motor de Execução JVM / CLDC 1.1 em C++17
│   │   ├── vm.h / vm.cpp       # Gerenciamento de classes, pool de constantes, GC com tracing de raízes
│   │   ├── interp.cpp          # Interpretador de bytecodes otimizado (instruções do jogo)
│   │   └── natives.cpp         # Implementação das APIs nativas de java/lang, java/io, java/util e hooks
│   ├── midp/                   # Emulação da camada J2ME MIDP 2.0
│   │   ├── midp.h / midp.cpp   # Displayable, Canvas, Graphics 2D, Image e RecordStore (RMS)
│   │   └── stb_image.h         # Decodificação de imagens PNG e texturas
│   ├── platform/               # Camada de Plataforma (Hardware Abstraction Layer)
│   │   ├── platform.h          # Interface de janela, loop de eventos e áudio
│   │   ├── platform_sdl.cpp    # Backend SDL2 com renderização acelerada, escala, touch e input
│   │   ├── midi_synth.h/cpp    # Sintetizador MIDI com TinySoundFont (TSF) + TinyMidiLoader (TML)
│   │   ├── cloud_save.h/cpp    # Cliente Cloud Save com Google Drive (Device Flow RFC 8628)
│   │   └── updater.h/cpp       # Verificador e instalador de atualizações OTA (GitHub Releases)
│   └── main.cpp                # Ponto de entrada, boot de rpg.RPGHeroEx e loop principal
├── reference/
│   ├── heroes_zero.jar         # Arquivo JAR original de referência (Nokia C6-00 360x640)
│   ├── extracted/              # 938 recursos extraídos (fontes, mapas /m/, sprites /a/, sons /snd/)
│   ├── decompiled_cfr/         # 141 classes originais decompiladas com CFR para auditoria técnica
│   └── javap/                  # Bytecode original desmontado com javap
├── assets/                     # Recursos convertidos e pacotes de idioma compilados (assets/lang/pt/)
├── lang/                       # Arquivos fonte de tradução (lang/source_en/ e lang/pt_br/)
├── dist_linux/                 # Metadados de desktop, ícones e AppRun para empacotamento Linux
├── switch/                     # Ícone oficial e assets específicos do Nintendo Switch
├── android/                    # Projeto Gradle + NDK para compilação dos APKs Android
├── tools/                      # Scripts de compilação de textos, RomFS, AppImage e assets
├── docs/                       # Documentação técnica detalhada, mapa de classes e learnings
└── CMakeLists.txt              # Configuração de build moderna para CMake e Ninja
```

---

## ⚙️ Como Compilar o Projeto

O projeto conta com um pipeline unificado no **GitHub Actions** que compila automaticamente todas as plataformas a cada tag ou push. Se preferir compilar localmente:

### 🪟 Windows (MSYS2 UCRT64 ou MinGW64)
```powershell
# Pré-requisitos: pacotes mingw-w64-ucrt-x86_64-gcc, cmake, ninja, SDL2 e SDL2_mixer
cmake -B build -G Ninja -DCMAKE_BUILD_TYPE=Release
cmake --build build
.\build\heroes_lore_zero.exe
```

### 🐧 Linux (Ubuntu / Debian / Arch / Fedora)
```bash
# Pré-requisitos: build-essential, cmake, ninja-build, libsdl2-dev, libsdl2-mixer-dev, libcurl4-openssl-dev, pkg-config
cmake -B build -G Ninja -DCMAKE_BUILD_TYPE=Release
cmake --build build
python3 tools/prepare_appimage.py
```

### 🕹️ Nintendo Switch (devkitPro / devkitA64 + libnx)
```bash
python3 tools/prepare_switch_romfs.py
make -f Makefile.switch -j$(nproc)
# Gera: heroes_lore_zero.nro
```

### 🤖 Android (Gradle + NDK)
```bash
cd android
./gradlew assembleRelease
# Gera os APKs em android/app/build/outputs/apk/release/
```

---

## 📖 Documentação do Projeto

- 📘 [`AGENTS.md`](AGENTS.md) — Diretrizes de arquitetura, padrões literais de port e layout.
- 🗺️ [`docs/CLASS_MAP.md`](docs/CLASS_MAP.md) — Auditoria e mapa de papéis das 141 classes J2ME decompiladas.
- 🧭 [`docs/PORTING_GUIDE_BLUEPRINT.md`](docs/PORTING_GUIDE_BLUEPRINT.md) — Guia mestre arquitetural passo a passo para ports J2ME.
- 📋 [`docs/STATUS.md`](docs/STATUS.md) — Estado atual de progresso, marcos alcançados e tarefas ativas.
- 🧠 [`docs/LEARNINGS.md`](docs/LEARNINGS.md) — Registro de aprendizados, descobertas do bytecode, armadilhas superadas e decisões técnicas.
- 🏷️ [`docs/VERSIONING.md`](docs/VERSIONING.md) — Políticas de versionamento semântico, CI/CD e lançamentos de releases.
- 🌐 [`docs/LOCALIZATION.md`](docs/LOCALIZATION.md) — Guia de internacionalização, compilação de assets de texto e adição de novos idiomas.

---

## 👥 Créditos & Agradecimentos

- **Port Nativo & Recompilação Multiplataforma (Windows, Linux, Android, Switch):** [David Kalil Braga](https://github.com/davidkalil10) (2026)
- **Desenvolvimento Original J2ME:** *Electronic Arts (EA Mobile)* & *Hands-On Mobile Korea*
- **Localização e Tradução PT-BR:** David Kalil Braga (2026) — baseada na rica nomenclatura e legado estabelecido pela trilogia Heroes Lore.
- **Engenharia Reversa & Ferramentas:** Comunidade de emulação e preservação de jogos J2ME / CFR Decompiler.

---

## ⚖️ Licença e Aviso Legal

Este projeto é uma obra de **preservação histórica de software** e engenharia reversa educacional. Todas as marcas registradas, títulos, gráficos, enredo e áudios originais de *Heroes Lore: Zero* pertencem à *Electronic Arts (EA Mobile)* e à *Hands-On Mobile Korea*.
