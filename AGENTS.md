# AGENTS.md — Heroes Lore: Zero (recompilação nativa)

Leia este arquivo PRIMEIRO em toda sessão (Antigravity, Codex, etc.). Depois leia `docs/STATUS.md`.

## Objetivo
Portar o jogo J2ME `Heroes Lore: Zero` (Electronic Arts / Hands-On Mobile, MIDlet `rpg.RPGHeroEx`, versão Nokia C6-00 360x640) para C++17 + SDL2,
de forma **fiel e literal** (tradução do bytecode/decompilação, SEM reescrever lógica "no olhômetro"),
com camada de plataforma fina para futuros ports (PC, Android, Switch, Linux, Steam Deck).

## Regras
1. Nunca adivinhar o que uma classe faz: decompilar (CFR/javap), ler, documentar em `docs/CLASS_MAP.md`.
2. Portar método a método mantendo a estrutura original; nome ofuscado fica em comentário.
3. APIs J2ME ficam atrás de uma interface em `src/platform/` (Graphics, Canvas, RecordStore, Audio, Input).
4. Toda descoberta/erro/acerto vai para `docs/LEARNINGS.md`. Todo avanço atualiza `docs/STATUS.md`. Versionamento e releases em `docs/VERSIONING.md`.
5. Validar contra o original rodando em emulador J2ME quando possível.
6. Siga as orientações comprovadas de arquitetura em `docs/PORTING_GUIDE_BLUEPRINT.md`.

## Fontes
- JAR original: `reference/heroes_zero.jar` (cópia do JAR na raiz)
- Extraído: `reference/extracted/` (141 classes, 938 recursos)
- Decompilado: `reference/decompiled_cfr/` (CFR com `--renamedupmembers` e `--caseinsensitivefs`)
- Bytecode desmontado: `reference/javap/` (141 arquivos `.javap.txt`)
- MIDlet Principal: `rpg.RPGHeroEx`
- Resolução nativa original: 360x640 (Portrait alta resolução Symbian / Nokia C6-00)

## Layout do Projeto
```
AGENTS.md  docs/  reference/ (jar, decompilado, extraído, javap)  tools/  src/{vm,midp,platform}  assets/
```
