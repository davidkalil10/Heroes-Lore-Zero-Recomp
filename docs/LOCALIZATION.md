# Sistema de Localização e Internacionalização — Heroes Lore: Zero

Este documento detalha a arquitetura do sistema de tradução e suporte a múltiplos idiomas em *Heroes Lore: Zero*, o fluxo de funcionamento em tempo de execução (*hot-reload* sem reiniciar o jogo) e o guia passo a passo para adicionar novos idiomas no futuro.

---

## 1. Arquitetura do Sistema de Textos

No jogo J2ME original (Nokia C6-00 360x640), os textos não ficavam concentrados em um único arquivo, mas distribuídos em várias estruturas binárias proprietárias:

1. **Textos de Interface e Menus (`t/*.tdf`)**:
   - 31 arquivos binários contendo tabelas de strings (`com.tdf`, `gm.tdf`, `h.tdf`, `it.tdf`, `m.tdf`, `qs.tdf`, `qm.tdf`, etc.).
   - Estrutura: Cabeçalho com contagem `N` (16-bit big-endian) seguido por comprimentos `L_i` (16-bit big-endian) e o fluxo contínuo de caracteres codificados com offset de chave aritmética.
   - No bytecode, a classe `ch.java` gerencia o carregamento sob demanda (`byte[][]` em `a:[Ljava/lang/Object;`).
2. **Diálogos de Mapas e Quests (`m/m/*.m` e `m/m2/*.m`)**:
   - 139 arquivos de mapa. Cada arquivo `.m` possui dados de tileset/colisão e, nos bytes finais, uma tabela de diálogos e nomes de áreas/regiões no formato:
     `[N: short] [L_0: short, ..., L_{N-1}: short] [str_0\x00, ..., str_{N-1}\x00]`
   - No bytecode, a classe `db.java` carrega esses diálogos dinamicamente a partir do mapa do jogador ativo (`di.a:B`).
3. **Inimigos e NPCs (`en/edf`)**:
   - Tabela binária com nomes e atributos dos monstros e personagens de suporte.
4. **Fonte Gráfica Monospaçada (`dotFontSmall.dat`)**:
   - Fonte bitmap embutida para renderização dos caracteres e símbolos especiais.

---

## 2. Troca de Idioma a Quente (*Hot-Reload* Instantâneo)

A recompilação nativa suporta **troca de idioma em tempo de execução** através da opção 11 (12º item) do menu de configurações (`bd.class`), sem a necessidade de recarregar a partida, mudar de mapa ou reiniciar o aplicativo:

### Como funciona nos bastidores:
1. **Interceptação de Leitura de Assets (`Platform::readAsset`)**:
   - Quando um idioma diferente do padrão (`"en"`) está ativo (ex: `"pt"`), qualquer leitura de arquivos de texto (`t/*.tdf`, `m/m/*.m`, `en/edf`) verifica primeiramente se existe um override compilado em `assets/lang/<idioma>/...`.
   - Se existir, os dados traduzidos são lidos; caso contrário, é feito o fallback transparente para o arquivo original em inglês.
2. **Detecção e Registro de `ch.java` (`ch_init_native`)**:
   - O construtor `ch.<init>:(Ljava/lang/String;)V` é interceptado nativamente, registrando o ponteiro da instância em `s_chInstances`.
   - Ao trocar de idioma, `Platform::reloadLanguage(VM& vm)` redecodifica e atualiza instantaneamente o array interno de cada instância ativa de `ch`.
3. **Recarregamento de Arrays Estáticos (`rpg/e` e `ax`)**:
   - Os campos estáticos `rpg/e.a` até `rpg/e.k` e `ax.a` até `ax.c` são recarregados diretamente com as novas strings do idioma selecionado.
4. **Recarregamento de Diálogos do Mapa Atual (`db.class`)**:
   - O campo estático `db.a:[[B` armazena as falas do mapa atual. Ao trocar de idioma, o mapa do jogador (`di.a:B`) é relido na versão do novo idioma e inserido em `db.a:[[B`, fazendo com que diálogos na tela mudem na mesma hora.
5. **Flags de Redesenho Forçado**:
   - Flags estáticas como `n.a:Z`, `rpg/a.a:Z`, `g.a:Z` e `bs.c:Z` são marcadas como *dirty*, disparando o redesenho imediato de todas as camadas visíveis do frame atual.

---

## 3. Regras Estritas de Tradução (Cânone e Consistência)

Ao traduzir ou revisar textos, siga estritamente estas regras:

### ⚠️ Regra 1: NUNCA Traduzir Nomes Próprios
Nomes de personagens e de vilas/cidades **JAMAIS** devem ser aportuguesados ou adaptados:
- **Personagens (Exemplos):**
  - `Lucian` (nunca Luciano)
  - `Clare` / `Claire` (nunca Clara)
  - `Alpez`
  - `Calmon`
  - `Gilbert`
  - `Carl`
  - `Timoros`
  - `Aquila`
  - `Legolas`
- **Cidades e Vilarejos (Exemplos):**
  - `Silverleaf Village` (nunca Vila Folha de Prata)
  - `Melon Village` (nunca Vila Melão)
  - `Humming City` (nunca Cidade do Beija-flor)
  - `Chelen Village`
  - `Plum City`
  - `Southern Fortress`

### ⚠️ Regra 2: Preservação de Tags do Motor de Diálogo
O motor de script do jogo utiliza marcadores de formatação que **devem permanecer intocados**:
- `|[Nome]&`: Diálogo falado pelo personagem especificado, exibindo retrato na esquerda.
- `^[Nome]&`: Diálogo falado por personagem com balão comum.
- `$[Nome]&`: Interações especiais de script.
- `{texto&}`: Destaque de cor amarela/dourada para itens, locais ou palavras-chave.
- `}texto&`: Mensagens do sistema ou notificações de missões (ex: `}Missao [The Truth] concluida!&`).

---

## 4. Como Adicionar Novos Idiomas no Futuro

O sistema foi desenhado de forma totalmente modular e extensível para suportar qualquer novo idioma (ex: Espanhol `es`, Francês `fr`, Alemão `de`, etc.).

### Passo 1: Extrair o texto base em inglês
Execute a ferramenta de extração:
```bash
python tools/extract_texts.py
```
Isso gera ou atualiza os arquivos modelo em `lang/source_en/`:
- `lang/source_en/ui_strings.json`
- `lang/source_en/maps_dialogs.json`
- `lang/source_en/enemies_npcs.json`

### Passo 2: Criar a pasta do novo idioma
Crie o diretório em `lang/<codigo_do_idioma>/`, por exemplo para espanhol:
```bash
mkdir -p lang/es
```
Copie os arquivos de `lang/source_en/` para `lang/es/` e traduza os textos desejados, respeitando as tags e os nomes próprios.

### Passo 3: Compilar os binários de localização
Execute o compilador de assets passando o código do idioma:
```bash
python tools/compile_texts.py es
```
O script compilará automaticamente:
- Todos os arquivos `.tdf` em `assets/lang/es/t/*.tdf`
- Todos os 139 mapas com diálogos em `assets/lang/es/m/m/*.m` e `m/m2/*.m`
- A tabela de inimigos em `assets/lang/es/en/edf`

### Passo 4: Detecção Automática
A engine detecta novos idiomas **automaticamente**:
- A função `Platform::getAvailableLanguages()` varre o diretório `assets/lang/` procurando subpastas disponíveis.
- Ao encontrar `assets/lang/es`, o idioma Espanhol já aparecerá como opção no menu de configurações (`bd.class`), alternando ciclicamente entre todos os idiomas instalados (`English` -> `Portugues` -> `Espanol` -> ...).

---

## 5. Estrutura de Arquivos

```
heroes_lore_zero_recomp/
├── lang/
│   ├── source_en/            # Textos originais extraídos em inglês (JSON)
│   └── pt_br/                # Textos traduzidos para Português (JSON)
├── assets/
│   └── lang/
│       └── pt/               # Binários compilados para a engine (.tdf, .m, edf)
│           ├── t/
│           ├── m/
│           └── en/
├── tools/
│   ├── extract_texts.py      # Extrai do JAR / extracted para JSON
│   ├── translate_to_pt.py    # Gera lang/pt_br/*.json com terminologia canônica
│   └── compile_texts.py      # Compila JSON para arquivos binários em assets/lang/<lang>/
└── docs/
    └── LOCALIZATION.md       # Esta documentação
```
