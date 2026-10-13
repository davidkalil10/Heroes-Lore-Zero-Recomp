# ⚔️ Heroes Lore: Zero — Native Recompilation (C++17 + SDL2)

Recompilação nativa do clássico **Heroes Lore: Zero** (*Electronic Arts / Hands-On Mobile*), baseado na versão de alta definição para Nokia C6-00 (360x640 portrait).

Executa o **bytecode original decompilado em C++17** com uma camada fina sobre SDL2, preservando 100% das fórmulas, atributos, IA, gráficos e diálogos originais.

---

## 🛠️ Status do Projeto
- **Fase:** Marco 0 (Scaffolding, auditoria de classes, extração de assets e inicialização do MIDlet `rpg.RPGHeroEx`).
- **Resolução Nativa:** 360x640 (Portrait alta definição).
- **Blueprint Arquitetural:** Documentado em [`docs/PORTING_GUIDE_BLUEPRINT.md`](docs/PORTING_GUIDE_BLUEPRINT.md).

## ⚙️ Como Compilar no PC (Windows / Linux)
```bash
cmake -B build -G Ninja -DCMAKE_BUILD_TYPE=Release
cmake --build build
.\build\heroes_lore_zero.exe
```
