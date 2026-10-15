# 🚀 Prompt para Abrir a Nova Sessão de Heroes Lore: Zero

Copie e cole o texto abaixo na primeira mensagem da nova janela do Antigravity ao abrir a pasta `heroes_lore_zero_recomp`:

```markdown
Olá! Vamos iniciar o projeto de recompilação nativa de Heroes Lore: Zero (C++17 + SDL2).

Por favor:
1. Leia atentamente o arquivo `AGENTS.md` e `docs/STATUS.md`.
2. Consulte o guia de arquitetura comprovado em `docs/PORTING_GUIDE_BLUEPRINT.md` e o mapa de classes em `docs/CLASS_MAP.md`.
3. O JAR original já está extraído em `reference/extracted/` (141 classes e 938 recursos), decompilado com CFR em `reference/decompiled_cfr/` e com bytecode desmontado em `reference/javap/`.
4. Os recursos do jogo já foram organizados em `assets/` (mapas .m e .mpm, definições .tdf, fontes .dat, imagens .png, textos em inglês na pasta en/, áudio em snd/).
5. O MIDlet principal identificado é `rpg.RPGHeroEx` com resolução nativa de 360x640 (Nokia C6-00), gerenciado pelo Canvas `f` e controlador `rpg.c`.
6. Nosso objetivo imediato é o **Marco 0 (Milestone 1)**: adaptar o ponto de entrada em `src/main.cpp` e o motor C++ para carregar a classe `rpg.RPGHeroEx` em 360x640, renderizar a tela de apresentação `bv` / menu `bs` no PC via SDL2, tocar a música e permitir jogar com teclado e gamepad!
```
