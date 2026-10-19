# LEARNINGS — Heroes Lore: Zero

## Sessão 1 (Análise do JAR, Arquitetura e Scaffolding Inicial)
- **Estrutura do Pacote Original:**
  - Arquivo: `Heroes Lore - Zero [360x640] (Nokia C6-00) (andrew-lviv.net).jar` (1.232.363 bytes).
  - Vendedor: *Electronic Arts / [ANDREW-LVIV]*
  - Versão: 4.4.56
  - Perfil: MIDP-2.0, CLDC-1.1.
  - MIDlet Principal: `rpg.RPGHeroEx` (localizado em `rpg/RPGHeroEx.class`).
  - Total de classes: 141 classes (9 classes no pacote `rpg` e 132 classes ofuscadas na raiz de `a.class` até `eb.class`).
  - Total de recursos: 938 arquivos (459 arquivos `.mpm`, 139 mapas `.m`, 31 `.tdf`, 25 `.png`, 1 `.dat`, textos em inglês na pasta `en/`).

- **Resolução e Sistema de Display:**
  - Esta versão foi projetada para Symbian S60v5 / Symbian^3 (Nokia C6-00) com **resolução de 360x640 pixels** (aspect ratio 9:16 portrait).
  - A classe Canvas é `f` (`public final class f extends Canvas`), que inicializa `this.setFullScreenMode(true)`, obtém `getWidth() = 360`, `getHeight() = 640`, e carrega `/vpad.png` para exibir controles virtuais de toque na parte inferior da tela caso o aparelho seja touch (`pointerPressed`, `pointerReleased`).
  - O gerenciador de Display é `ct`, que intermedia a troca de telas entre a MIDP e o jogo.

- **Arquitetura de Telas e Renderização:**
  - `az`: Classe abstrata base para qualquer tela do jogo (`d(cm var1)` para desenho, `boolean_a(int var1, int var2)` para input).
  - `rpg.a`: Classe base abstrata das telas do jogo (estende `az`, implementa `Runnable`, `d`).
  - Telas concretas que estendem `rpg.a`:
    - `bv`: Tela inicial / Splash Screen (`bv.bv_a().a((byte)1)`).
    - `bs`: Menu principal / Seleção de personagens e jogo (`bs.bs_a()`).
    - `do`: Tela principal de exploração do mapa e RPG (27 KB - maior classe do jogo!).
    - Telas secundárias: `aa`, `ak`, `av`, `ba`, `bi`, `bm`, `bu`, `cq`, `cr`, `cs`, `cx`, `dq`, `dv`, `k`, `v`, `z`.
  - `cm`: Contexto gráfico que encapsula `javax.microedition.lcdui.Graphics` e controle de clipping / offsets.
  - `cg`: Invólucro de `javax.microedition.lcdui.Image`.
  - `ch`: Carregador e interpretador de arquivos `.tdf` (Tile Definition Files).
  - `s`: Renderizador de sprites e animações de personagens e inimigos.

- **Controlador Principal e Áudio:**
  - `rpg.c`: Controlador mestre do jogo (`implements Runnable`). Chamado por `RPGHeroEx.startApp()`, instancia o Canvas, inicia a tela `bv` e dispara o Game Loop na thread principal.
  - `bq`: Gerenciador de áudio (`implements d`), encapsulando `javax.microedition.media.Manager` e `Player`.
  - `snd/`: Contém os arquivos de áudio `b` e `e`.

- **Sistema de Salvamento (RMS):**
  - Gerenciado pelas classes `rpg.b`, `ah` e `bh`, utilizando `javax.microedition.rms.RecordStore`.

## Sessão 2 (Marco 0 / Milestone 1 — Boot Nativo, Resolução 360x640, Áudio e Menu)
- **Nativos J2ME / Java VM Implementados:**
  - `java/util/Hashtable`: Implementado com `HashtableObj` e `K_HASHTABLE` no motor C++. Essencial para decodificação e mapeamento de parâmetros em `cpid.txt` pela thread worker `ar`.
  - `java/lang/String`: Construtores de decodificação de bytes `([B)V`, `([BLjava/lang/String;)V`, métodos `concat`, `getBytes`, `valueOf(Object)`.
  - `java/util/Vector`: Métodos `indexOf:(Ljava/lang/Object;)I` e `insertElementAt:(Ljava/lang/Object;I)V`.
  - `java/io/DataInputStream` e `DataOutputStream`: Leitura e escrita de `readLong:()J` e `writeLong:(J)V`, além de `available:()I`.
  - `javax/microedition/lcdui/Graphics` e `Image`: `drawRGB`, `fillTriangle`, `drawString`, `createRGBImage`, `getRGB`, `Font.getDefaultFont`, `Font.substringWidth`, `Display.getCurrent`, `Displayable.isShown`, `Canvas.serviceRepaints`.
  - Limpeza de hooks nativos específicos de Heroes Lore 1 (Wind of Soltia) que não correspondiam às assinaturas do Zero.

- **Arquitetura de Resolução Dinâmica (360x640 & Desativação do VPad):**
  - No JAR original, a classe Canvas `f` sobrescrevia `getWidth()` retornando `240` e subtraía 90 pixels de altura para acomodar `/vpad.png` (teclado touch virtual para aparelhos touch sem teclado físico).
  - O motor gráfico `rpg.a` e o contexto `cm` calculam o offscreen buffer (`cm.var_javax_microedition_lcdui_Image_a`) chamando `Canvas.getWidth()` e `Canvas.getHeight()`.
  - Ao registrar os métodos nativos `f.getWidth:()I` (retornando `g_screenWidth = 360`) e `f.getHeight:()I` (retornando `g_screenHeight = 640`), o motor aloca um buffer perfeito de 360x640.
  - Para jogar no PC, Switch e consoles sem o teclado virtual na tela, o campo estático `f.a` (`vpad.png`) é ajustado para `nullptr` após `startApp()`. Isso faz `f.paint()` desenhar o jogo puro em tela cheia sem sobreposição.

- **Fluxo do Splash Screen (`bv`) e Transição para o Menu (`bs` / `i`):**
  - `bv.java` gerencia o ciclo:
    1. `case 3`: Carregamento assíncrono e exibição de barra de progresso.
    2. `case 1`: Apresentação do logotipo da Electronic Arts (`/ealogo.png`) centralizado.
    3. `case 4`: Diálogo modal de som ("Ativar som? Sim / Não").
    4. `case 2`: Tela de apresentação "Pressione qualquer tecla para continuar".
  - Ao confirmar com Enter / Tecla '5' (código 53), a música MIDI `/snd/b/0` (6.153 bytes) é iniciada com loop infinito via TinySoundFont + SoundFont TimGM6mb.
  - A seguir, `rpg.c.rpg_c_a().d()` instancia e apresenta o Menu Principal (`bs.java` / `i.java`) com arte dos heróis e opções completas.

## Sessão 3 (Correção da Resolução Nativa 240x320, True Widescreen 16:9, Modo Auto e Bezels)
- **Descoberta da Resolução Real do Motor e Causa Raiz da Distorção:**
  - Embora a embalagem do JAR de Andrew-Lviv indicasse "360x640" (resolução de tela de aparelhos touch Symbian S60v5 como Nokia C6-00), a lógica matemática do bytecode de Heroes Lore: Zero é estritamente construída sobre altura nativa de **320 pixels** (240x320, proporção clássica 3:4):
    - O viewport do mapa em `bs.java` calcula: `k = rpg.a.var_int_b - 33`. Para altura 320, `k = 287px` (~18 tiles de 16x16).
    - A caixa de diálogo em `df.java` calcula: `y = rpg.a.var_int_b - 37`. Para altura 320, `y = 283px`. A caixa (37px de altura) ocupa Y=283..320, colada perfeitamente na base do mapa.
    - O retrato dos personagens (`rpg.e.o`) é ancorado com flag 40 (`BOTTOM | RIGHT`), desenhando na posição `y = rpg.a.var_int_b - 1` (319), repousando exatamente acima da caixa de diálogo.
  - Ao forçar `SCREEN_HEIGHT = 640`, a caixa de diálogo era empurrada para Y=603, criando um vazio preto de 280 pixels entre o mapa e a fala, além de esticar a janela para uma proporção estreita 9:16 (540x960) que cortava a base da tela em monitores desktop 1080p.

- **Arquitetura de Proporções e Viewport Dinâmico:**
  - **Modo Original 3:4 (`ASPECT_ORIGINAL`, 240x320):**
    - Renderização pixel-perfect centralizada no monitor.
    - Em telas widescreen 16:9 (ex: 1920x1080 em fullscreen), as colunas laterais vazias são preenchidas com as molduras temáticas de Soltia / Slate (`bezel_soltia.png` / `bezel_slate.png`), projetadas exatamente para abas de 555px em cada lado (`555 + 810 + 555 = 1920`).
    - Em modo janela no PC, a janela inicial padrão é 540x720 (escala 2.25x, proporção 3:4 exata sem cortes).
  - **Modo True Widescreen 16:9 (`ASPECT_WIDESCREEN`, 568x320):**
    - Aumenta a largura do canvas de 240 para 568 pixels (`568 / 320 = 1.775`, 16:9 widescreen real).
    - Em vez de esticar sprites, o motor renderiza **35 colunas de tiles de mapa** em vez de 15, expandindo drasticamente o campo de visão horizontal.
    - Sincronização de viewport C++ via `updateJavaViewportVariables`:
      - `rpg/a`: `var_int_a = 568`, `c = 284`.
      - `bs`: `j = 568`, `l = (568 - 16) / 2 = 276`.
      - Câmera: desloca `di.var_int_a` pelo delta de centralização (`newBsL - oldBsL`).
      - Menus e Modais: mantém caixas modais centradas (`rpg/f.c = (568 - 230) / 2 = 169`, `menuW = 230`).
      - `cm`: redimensiona o buffer de imagem offscreen `var_javax_microedition_lcdui_Image_a` para 568x320 para suportar renderização expandida sem cortes.
  - **Modo Auto (`ASPECT_AUTO`):**
    - Detecta dinamicamente a orientação da janela ou tela: se horizontal (`winW >= winH`), aplica True Widescreen 16:9; se vertical, aplica 3:4 original.
  - **Controles de Proporção:**
    - Tecla `F7` ou `F10`: cicla entre Auto -> 3:4 Original -> 16:9 Widescreen -> Auto (redimensionando a janela em modo janela para 540x720 ou 1280x720).
    - `Alt+Enter` ou `F11`: alterna entre tela cheia e modo janela.
    - `F5`: alterna o estilo da moldura lateral (Soltia / Slate / Black).

## Sessão 4 (Resolução do Congelamento das Cutscenes e Calibração de Taxa de Quadros Fluida 30/60 FPS)
- **Diagnóstico da Causa Raiz do Travamento das Cutscenes Iniciais:**
  - Ao iniciar um "Novo Jogo" e selecionar "Save 1", o diálogo de abertura inicia chamando `df.void_a()` (motor de cutscenes).
  - O método `df.void_a()` executa explicitamente:
    ```java
    System.gc();
    Runtime.getRuntime().gc();
    ```
  - No motor C++, `Runtime_getRuntime` mantinha uma variável estática local `static Object* rt = nullptr;`. Porém, `rt` **não havia sido adicionado à lista `vm.roots`**!
  - Ao rodar `System.gc()`, a varredura do Garbage Collector não encontrava `rt` nas raízes e desalocava o objeto singleton `Runtime`.
  - Na chamada imediatamente seguinte `Runtime.getRuntime().gc()`, o ponteiro `rt` já era um ponteiro pendente (*dangling pointer* para memória liberada).
  - A tentativa de invocação virtual de `gc:()V` gerava um `SIGSEGV` na thread secundária que orquestrava o script da cutscene (`Thread 5` / `bs.run()`), matando a thread da cena no meio do prólogo e congelando o avanço para o quarto do protagonista.
  - **Correção:** Adicionado `vm.roots.push_back(rt)` em `Runtime_getRuntime`, garantindo que o singleton permaneça protegido da coleta de lixo por todo o ciclo de vida da VM.

- **Resolução da Lentidão e Fluidez de Entrada (GIL Thread Starvation vs Sleep):**
  - O motor J2ME de Heroes Lore: Zero roda sua lógica de jogo e renderização para o buffer offscreen em uma thread dedicada (`Thread 4` — `rpg.c`).
  - No código nativo anterior de `Thread_sleep`, chamadas com `ms <= 80` eram convertidas em `sleepMs(0)`. No Windows, `SDL_Delay(0)` / `Sleep(0)` cede a fatia de tempo apenas brevemente; a thread `rpg.c` imediatamente rebloqueava o GIL em um loop de 100% CPU.
  - Isso causava severa **inanição de threads (GIL starvation)** contra a thread principal do SDL, tornando o polling de teclado, mouse e gamepad extremamente lento, engasgado e com entradas perdidas.
  - Além disso, o limitador de taxa de quadros estava fixado em 15 FPS por padrão (`s_targetFps = 15`), o que em monitores modernos de 60Hz criava forte sensação de travamento.
  - **Correção:**
    1. Calibração precisa do `Thread_sleep` nativo: quando a thread do jogo dorme para regular a velocidade, o tempo de sono é escalado proporcionalmente ao `targetFps` configurado (ex: dividindo por 2 para 30 FPS ou 4 para 60 FPS), e a thread realiza um `SDL_Delay(ms)` real com o GIL destrancado.
    2. Durante o sono da thread lógica, o GIL fica totalmente liberado para a thread principal processar eventos de entrada sem latência.
    3. `s_targetFps` padrão configurado para 30 FPS (Fluido / Padrão), com tecla `F6` ciclando entre 30 FPS -> 60 FPS (Ultra Fluido) -> 15 FPS (Nostalgia).
    4. Substituído `SDL_Delay(0)` por `SDL_Delay(1)` em `VM::sleepMs` para forçar cessão de fatia pelo escalonador do Windows.
  - Resultado: Cutscenes do prólogo (`[Aquila] It's about time.`, `[Kratos] Alright, I should get going too!`) avançam suavemente, transicionam de mapa com áudio MIDI `/snd/b/10` sincronizado, e chegam ao quarto do personagem com resposta instantânea de controles.

## Sessão 5 (Correção de NullPointerException no Redimensionamento e Simplificação de FPS para 15/30)
- **Causa Raiz do Crash / NullPointerException ao Redimensionar a Janela no Meio do Jogo:**
  - Durante o redimensionamento dinâmico da janela ou alternância de aspecto (Auto / 3:4 / 16:9), a função `updateJavaViewportVariables` tentava resetar a caixa de diálogo forçando o campo estático `df.var_cg_a` para `nullptr`:
    ```cpp
    clsDf->statics[fld.index].o = nullptr; // CAUSADOR DO CRASH
    ```
  - Em `df.java`, o método `void_f()` (responsável por instanciar `var_cg_a = cg.a(n2, 37)`) **só é chamado uma vez no início de uma fala/parágrafo**.
  - Durante todos os quadros subsequentes em que uma conversa ou cutscene está ativa, `df.d(cm)` chama continuamente:
    ```java
    cm3.a(var_cg_a, n10, n2, 20);
    cm3.a(rpg.e.var_cg_arr_f[var_byte_e], n10 + var_cg_a.int_a(), n2, 40);
    ```
  - Ao anular `df.var_cg_a`, a chamada `var_cg_a.int_a()` e a passagem de `var_cg_a` para `cm.a` disparavam um `java/lang/NullPointerException` a cada quadro de renderização, travando completamente a execução do jogo.
  - **Correção Definitiva:**
    1. Nunca anular `df.var_cg_a`.
    2. Se `df.var_cg_a` já estiver alocado (`!= nullptr`, indicando diálogo em andamento), o objeto `cg` é acessado e seu `ImageObj` interno é redimensionado de forma segura no próprio motor C++ (`width = g_screenWidth`, `height = 37`, pixels redefinidos e borda da moldura redesenhada via `img->graphics`).
    3. Os ponteiros de texto (`df.c`, `df.d`, `df.e`, `df.g`, `df.h`) têm seus offsets resetados para re-streamar a mensagem atual com a nova largura horizontal sem falhas visuais.
    4. Garantida a proteção de concorrência com aquisição e liberação automática do GIL da VM (`pVm->isGilOwner()`) durante `applyAspectWidth`.

- **Simplificação e Calibração dos Modos de FPS (Estritamente 15 FPS e 30 FPS):**
  - Conforme solicitado, o modo 60 FPS foi removido por ser desnecessário e potencial gerador de descompasso com animações J2ME.
  - O sistema agora opera estritamente com:
    - **30 FPS (Fluido / Padrão):** dobro da taxa original, dividindo os `Thread.sleep` de frame pacing para uma experiência suave sem acelerar a física do jogo.
    - **15 FPS (Nostalgia J2ME original):** timing 100% autêntico dos celulares Symbian/Java da época.
  - A tecla `F6` e a opção de FPS no Menu de Opções agora alternam estritamente entre 30 FPS e 15 FPS (com salvamento persistente em `hl_settings.ini`).

## Sessão 6 (Implementação do Opcode 196 JVM `wide`, Tecla `#` de Pular Cutscenes e Entrada no Quarto do Herói)
- **Causa Raiz do Crash no Final das Cutscenes Iniciais:**
  - Ao concluir a sequência de cutscenes de introdução entre os mapas 1, 45 e 9, o jogo chama o método de transição de mapa para carregar o quarto do protagonista (Mapa 136, arquivo `/m/m2/d6.m`).
  - Durante o carregamento e parsing de colisões dos tiles em `g.java`, o método `public final void a()` contém a instrução bytecode:
    ```
    11: iinc_w 2, 256
    ```
  - Como 256 excede o limite de 8-bits com sinal de um `iinc` comum (-128 a 127), o compilador J2ME gerou a instrução estendida JVM `wide` (opcode 196 / 0xC4).
  - O interpretador em `src/vm/interp.cpp` não possuía o caso para o opcode 196, disparando:
    `[FATAL] opcode não suportado 196 em g.a()V pc=11` e abortando o processo.
  - **Correção:**
    - Implementado suporte completo ao opcode 196 (`wide` / 0xC4) em `src/vm/interp.cpp`, decodificando o sub-opcode:
      - Para `iinc` (132 / 0x84): lê índice de 16 bits (`u2`) e constante com sinal de 16 bits (`s2`), aplicando `L[idx].i += c`.
      - Para instruções de 16 bits de variáveis locais (`iload`, `aload`, `lload`, `istore`, `astore`, `lstore`, `ret`): decodifica o índice de 16 bits e realiza a operação de pilha correspondente.

- **Mapeamento e Mecânica do Botão `#` (Pular Diálogos / Próxima Poção):**
  - Analisando a descompilação de `bs.java` (linhas 276-282 e 1603-1615 de `reference/javap/bs.javap.txt`):
    ```java
    if (n4 == 35 && di.var_boolean_f) {
        di.var_boolean_f = false;
        return true;
    }
    if (di.var_boolean_f) {
        return true;
    }
    ```
  - `di.var_boolean_f` é a flag booleana global que indica que um diálogo de cutscene está ativo e bloqueia todos os outros comandos. O único código de tecla aceito para cancelar essa flag imediatamente é `35` (tecla `#` do teclado dos celulares).
  - No código original da nossa camada de plataforma, apenas `SDLK_HASH` estava mapeado, que em muitos teclados ABNT2/US não dispara esse evento sem AltGr/Shift. Além disso, no controle o botão `Select / Back` estava enviando `48` ('0' do minimapa) e bloqueando no DOWN para combos.
  - **Mapeamento Ergonomico Completo:**
    - **Teclado:** Mapeadas as teclas `H` (Hash/#), `N` (Next/Avançar), `P` (Pular/Próximo), `.` (Ponto), `]` (Fecha colchete), `/` (Barra), `#` (Shift+3 ou tecla cerquilha) e `#` do teclado numérico para enviar o código `35`.
    - **Gamepad:**
      - Botão `Select / Back`: Ao ser solto (tap isolado), envia o código `35` (`#`), pulando o diálogo ou cutscene instantaneamente.
      - Gatilho `RT` (R2): Envia `cyclePotionNext`, que invoca o código `35` (`#`), servindo tanto para avançar poção na exploração quanto para pular diálogos em cutscenes.

- **Resultado:**
  - As cutscenes podem ser puladas instantaneamente com um toque em `H`, `N`, `P`, `.` ou `Select/RT` no controle.
  - A transição para o Mapa 136 (Quarto do Protagonista) ocorre com sucesso absoluto.
  - A tarefa 1 é atribuída (`received task 1 on map 136`), a música tema do quarto `/snd/b/13` começa a tocar e o jogador recebe o controle direto e total do personagem, com o HUD de vida, mana, atalhos de poções e nível 1 totalmente visíveis e responsivos.

## Sessão 7 (Mapeamento da Tecla `*` e Confirmação Intuitiva de Menus via Botões de Ação)
- **Mapeamento da Tecla `*` (Código 42) para o Teclado Numérico Superior:**
  - O código original da tecla `*` (42) ativa os modos de guardião / comandos especiais no jogo.
  - Foi adicionada a tecla `7` (acima do WASD) como mapeamento direto para `42`, completando a fileira ergonômica:
    - `1` -> Habilidade 1 (`49` / '1')
    - `2` -> Habilidade 2 (`51` / '3')
    - `3` -> Habilidade 3 (`55` / '7')
    - `4` -> Poção MP / Pular Diálogos (`35` / '#')
    - `5` -> Poção HP / Minimapa (`48` / '0')
    - `6` -> Habilidade 4 / Item Rápido (`57` / '9')
    - `7` -> Guardião / Comando Especial (`42` / '*')

- **Análise do Sistema de Menus (`ax.java`) e Resolução do Comportamento de Pular para o Item 5:**
  - No código descompilado de `ax.java`:
    ```java
    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) return true;
        if (n3 >= 49 && n3 <= 56) {
            this.var_byte_a = n3 == 48 ? (byte)9 : (byte)(n3 - 49);
            this.d(this.var_byte_a);
        } else if (n.g(n2, n3)) {
            di.a((byte)7, (byte)0);
        } else if (n.f(n2, 49)) {
            this.d(this.var_byte_a);
        }
    ```
  - Nos celulares J2ME antigos com teclado numérico físico, os desenvolvedores colocaram atalhos diretos `1..8` no menu principal. Ao pressionar `5` no celular (código 53), a condição `n3 >= 49 && n3 <= 56` capturava a tecla antes da verificação de confirmação e forçava `this.var_byte_a = 53 - 49 = 4` (abrindo direto a 5ª opção: "Elemental").
  - Para confirmar o item que o jogador navegava com as setas, o celular exigia pressionar o Left Soft Key (LSK, código `-6`, que correspondia a `n.f(n2, 49)`).
  - Em PCs e consoles, os jogadores utilizam `W`/`S` ou setas para navegar e esperam que o botão de ação padrão (`Espaço`, `Enter` ou botão `A` do controle, mapeados para '5') confirme e abra a opção que está destacada em vermelho.
  - **Solução Implementada:**
    - Criada a função `isMenuModeActive(vm)` que detecta se a tela atual do jogo é o menu (`di.var_byte_d == 5`).
    - Quando o menu está ativo, qualquer pressionamento da tecla de ação '5' (código 53) vindo do teclado (`Espaço`/`Enter`), controle (botão `A`) ou clique do mouse é convertido em tempo de execução para o código de confirmação `-6` (LSK).
    - Com isso:
      1. Navegar com `W`/`S` ou setas move a barra vermelha de seleção.
      2. Pressionar `Espaço`, `Enter` ou `A` no controle confirma e entra imediatamente no item selecionado.
      3. O atalho original via botão de menu (`Q` ou `Tab`) continua funcionando para confirmar.
      4. Todos os submenus (Itens, Equipamentos, Habilidades, Sistema, etc.) continuam funcionando com confirmação via `Espaço`/`Enter` e cancelamento/retorno via `Esc`/`Backspace`/`E`.

## Sessão 8 (Correção da Distorção da Barra de Status e Preenchimento das Lacunas em Widescreen)
- **Diagnóstico da Distorção / Bagunça na Barra de Status ao Alternar Modo Janela / Tela Cheia:**
  - **Causa Raiz 1 (Shearing de Stride de Pixels):**
    - Ao alternar entre modo janela e tela cheia (ou alternar aspecto com F7), a largura da tela `g_screenWidth` varia entre 240px e 568px.
    - O buffer gráfico offscreen `cm.var_javax_microedition_lcdui_Image_a` era redimensionado através de `img->pixels.resize(...)`. Como `std::vector::resize()` preserva os bytes antigos na memória unidimensional sem reindexar as linhas 2D, as linhas antigas de 240 pixels eram interpretadas com stride de 568 pixels (e vice-versa), gerando estrias e ruído horizontal ("shearing") na parte inferior da tela.
    - Substituído `resize()` por `assign(g_screenWidth * g_screenHeight, 0)`, zerando e realocando o buffer limpo imediatamente.
  - **Causa Raiz 2 (Dirty Flags Não Acionados):**
    - Na classe `bs.java`, o método `f()` só redesenha o fundo decorativo da barra de status se `bs.var_boolean_c == true` (campo `bs.c:Z`).
    - Uma vez desenhado, `bs.var_boolean_c` é setado para `false` e mantido falso; o jogo apenas atualiza as barras de vida/mana e os ícones de poção sobre o buffer já existente.
    - Ao redimensionar a tela, `bs.var_boolean_c` permanecia falso, mantendo o lixo residual na tela até que uma mudança de mapa ou abertura de menu chamasse `bs.e()` (que força `var_boolean_c = true`).
    - Criada a função nativa `setVmStaticBool(vm, className, fieldName, val)` e adicionado acionamento explícito de `bs.c:Z = true` e `rpg/a.a:Z = true` em:
      1. `updateJavaViewportVariables(vm)`
      2. `Platform::toggleFullscreen()`
      3. `SDL_WINDOWEVENT_RESIZED` / `SDL_WINDOWEVENT_SIZE_CHANGED`

- **Diagnóstico e Resolução das Lacunas Pretas na Barra de Status em Widescreen (16:9):**
  - **Origem do Espaço Vazio:**
    - No design original do jogo para o Nokia C6-00 (largura 360px), a barra de status inferior era dividida em:
      - `x = 0..60`: Bloco esquerdo `[0  LV 1]` (`rpg.e.q`, largura 60).
      - `x = 60..120`: Módulo de pedra/gárgula esquerda (`rpg.e.var_cg_k`, largura 60).
      - `x = 120..240`: Console central de Vida/Mana/Poções (`rpg.e.var_cg_j`, largura 120, posicionado em `n4 = (360 - 120) / 2 = 120`).
      - `x = 240..300`: Módulo de pedra/gárgula direita (`rpg.e.var_cg_k`, largura 60, em `n4 + 120 = 240`).
      - `x = 300..360`: Módulo de pedra final (`rpg.e.var_cg_k`, largura 60, em `width - 60 = 300`).
      - Totalizando exatamente 360px perfeitamente contínuos sem nenhum espaço vazio.
    - Em True Widescreen (largura 568px):
      - `n4 = (568 - 120) / 2 = 224`.
      - Bloco esquerdo fica em `0..60`.
      - Módulo gárgula fica em `n4 - 60 = 164..224`.
      - Console central fica em `224..344`.
      - Módulo gárgula direito fica em `n4 + 120 = 344..404`.
      - Módulo gárgula final fica em `568 - 60 = 508..568`.
      - **Isso gerava duas lacunas vazias de exatamente 104 pixels cada:**
        1. Lacuna esquerda: `x = 60` até `164` (104px).
        2. Lacuna direita: `x = 404` até `508` (104px).
  - **Solução Implementada:**
    - Em `Platform::present()`, quando a tela está em True Widescreen (`g_screenWidth > 360`) e o HUD do jogo está ativo, os módulos decorativos de pedra gótica modular (`rpg.e.var_cg_k`, largura 60 e altura 33) são clonados e estendidos pelas lacunas:
      - **Lacuna esquerda (60..164):** Tile 1 inicia em `x = 60..120`; Tile 2 conecta em `x = 104..164`, encontrando com precisão de pixel o gárgula em `x = 164`.
      - **Lacuna direita (404..508):** Tile 3 inicia em `x = 404..464`; Tile 4 conecta em `x = 448..508`, encontrando com precisão de pixel o bloco final em `x = 508`.
    - Resultado: A barra de status inferior passa a preencher toda a largura da tela de 568px de ponta a ponta, com textura gótica contínua, sem espaços pretos e sem nenhuma distorção gráfica ao alternar proporção ou tela cheia.

## Sessão 9 (Pipeline de CI Multiplataforma Automatizado para as 4 Plataformas)
- **Estrutura de Compilação Multiplataforma do GitHub Actions (`.github/workflows/build.yml`):**
  - **Nintendo Switch (.nro Homebrew):**
    - Container Docker oficial `devkitpro/devkita64:latest`.
    - Empacotamento automático de partição RomFS via `tools/prepare_switch_romfs.py`, incluindo `reference/extracted` (sem RMS) e `assets/` (fontes TrueType, soundfont GM TimGM6mb e texturas UI).
    - Compilação via `Makefile.switch` com metadados NACP (Title ID `0100484C5A000000`, título "Heroes Lore: Zero", autor, versão 1.0.0 e ícone 256x256 JPEG).
    - Validação de integridade do executável gerado via `tools/inspect_nro.py`.
    - Upload do artefato `heroes_lore_zero_switch_nro` (`heroes_lore_zero.nro`).
  - **Windows x64 (Portable ZIP):**
    - Runner `windows-latest` com ambiente MSYS2 UCRT64 (GCC, CMake, Ninja, SDL2, SDL2_mixer, zip).
    - Compilação do binário C++17 com nível `-O3`.
    - Empacotamento portátil com cópia de todas as bibliotecas de tempo de execução (`SDL2.dll`, `SDL2_mixer.dll`, `libFLAC`, `libmpg123`, `libopus`, `libvorbis`, `libogg`, `libwavpack`, `libxmp`) e diretórios de assets.
    - Upload do artefato `heroes_lore_zero_windows_zip` (`heroes_lore_zero_windows_x64.zip` e `heroes_lore_zero.exe`).
  - **Linux x86_64 (AppImage Portátil / Steam Deck):**
    - Runner `ubuntu-22.04` com dependências de desenvolvimento SDL2, SDL2_mixer, libcurl, CMake e Ninja.
    - Suporte universal no `CMakeLists.txt` via `PkgConfig` para resolução de `SDL2_mixer` e `CURL::libcurl` no Linux.
    - Estruturação do `AppDir` via `tools/prepare_appimage.py` com script `AppRun`, arquivo `.desktop`, ícone de alta resolução e empacotamento das bibliotecas compartilhadas não-glibc do sistema com `ldd`.
    - Geração do executável autossuficiente `heroes_lore_zero_linux_x86_64.AppImage` via `appimagetool`.
    - Upload do artefato `heroes_lore_zero_linux_appimage`.
  - **Android (APKs Universal & ARM64):**
    - Runner `ubuntu-latest` com JDK 17 Temurin, Android SDK/NDK 26 pré-instalados e cache de dependências de compilação.
    - Download automático sob demanda do código-fonte do `SDL2` (tag `release-2.30.12`) e `SDL2_mixer` (tag `release-2.8.0`) na pasta `third_party/`.
    - Preparação de assets na pasta `android/app/src/main/assets/` via `tools/prepare_android_assets.py`.
    - Compilação Gradle com NDK C++17 (`./gradlew assembleRelease`).
    - Geração dos APKs assinados com chave permanente de release (`heroes_lore_zero.keystore`).
    - Upload dos artefatos `heroes_lore_zero_android_universal.apk` e `heroes_lore_zero_android_arm64.apk`.
  - **Publicação Condicional de Releases:**
    - O job `release` está condicionado a: `startsWith(github.ref, 'refs/tags/') || (github.event_name == 'workflow_dispatch' && inputs.create_release == true)`.
    - Desta forma, em pushes normais no branch `main` as 4 plataformas são compiladas e seus artefatos são disponibilizados para download e teste, sem publicar releases públicas prematuras antes da validação do usuário.

## Sessão 10 (Mapeamento de Gamepads Físicos, Virtual Touch e Refinamentos Switch/Mobile)
- **Mapeamento de Gamepads Físicos (Nintendo Switch & PC/Xbox):**
  - **Nintendo Switch (Layout Físico Nintendo):**
    - `A` (Físico Leste / `SDL_CONTROLLER_BUTTON_B`): Código 53 (`'5'` / Atacar / Confirmar menus).
    - `B` (Físico Sul / `SDL_CONTROLLER_BUTTON_A`): Código -7 (RSK / Cancelar / Voltar).
    - `X` (Físico Norte / `SDL_CONTROLLER_BUTTON_Y`): Código 49 (`'1'` / Habilidade 1).
    - `Y` (Físico Oeste / `SDL_CONTROLLER_BUTTON_X`): Código 51 (`'3'` / Habilidade 2).
    - `L` (Shoulder / `LEFTSHOULDER`): Código 55 (`'7'` / Habilidade 3).
    - `R` (Shoulder / `RIGHTSHOULDER`): Código 57 (`'9'` / Habilidade 4).
    - `ZL` (Gatilho / `TRIGGERLEFT`): Código 35 (`'#'` / Poção MP / Pular Diálogo).
    - `ZR` (Gatilho / `TRIGGERRIGHT`): Código 48 (`'0'` / Poção HP).
    - `START` / `+`: Código -7 (Menu Principal do jogo).
    - `SELECT` / `-`: Tecla de atalho duplo inteligente:
      - Em combos com `START` -> Alterna Proporção (Auto <-> 3:4 <-> 16:9).
      - Em combos com `R3` -> Alterna Moldura (Soltia <-> Ardósia <-> Preto).
      - Ao ser solto isoladamente sem uso de combo:
        - Se estiver em cutscene/diálogo (`isCutsceneActive(vm) == true`): Envia tecla 35 (`'#'`) para avançar o diálogo sem esforço.
        - Se estiver em exploração livre: Envia tecla 42 (`'*'`) para abrir o Minimapa da região.
    - `L3`: Minimapa da Região (`'*'` = 42).
    - `R3`: Ciclo de Poções / Pular Diálogo (`'#'` = 35) isolado, ou ciclo de FPS em combos.
  - **Xbox / PlayStation / PC padrão:**
    - `A` / `Cross`: Código 53 (`'5'`).
    - `B` / `Circle`: Código -7 (RSK).
    - `X` / `Square`: Código 49 (`'1'`).
    - `Y` / `Triangle`: Código 51 (`'3'`).
    - `LB` / `L1`: Código 55 (`'7'`).
    - `RB` / `R1`: Código 57 (`'9'`).
    - `LT` / `L2`: Código 35 (`'#'`).
    - `RT` / `R2`: Código 48 (`'0'`).

- **Ergonomia dos Controles Virtuais (Mobile e Handheld):**
  - **Modo Retrato (Vertical / TATE):**
    - Elevação do viewport para o topo da tela (`gameY = std::max(0, (int)(winH * 0.015f))`), deixando 100% da área útil do jogo desobstruída em smartphones 19.5:9 / 20:9.
    - Botões de sistema `[ MENU ]` (-7) e `[ MAPA ]` (42) colocados lado a lado imediatamente acima do D-Pad, eliminando a necessidade de esticar a mão para o topo da tela.
    - Cluster de ação no quadrante direito com geometria em arco ergonômica ajustada em torno do botão `5` (centro grande): `1` e `7` na coluna esquerda, `3` no topo, `9` na direita-cima, e `0` (Item/Poção HP) na direita-baixo.
    - Setas horizontais `<` (-101) e `>` (35 / '#') centralizadas no rodapé.
  - **Modo Paisagem (Horizontal):**
    - Coluna esquerda: `[ MENU ]` no topo, setas de poção no meio, D-Pad espaçoso na base.
    - Coluna direita: `[ MAPA ]` e `0` no topo, cluster de ataque e 4 habilidades na base.

- **Refinamentos para Nintendo Switch:**
  - **Detecção de Dock:**
    - Através de `appletGetOperationMode() == AppletOperationMode_Console`.
    - Ao conectar na TV, os controles virtuais de toque são 100% ocultados e a imagem é centralizada na tela da TV em 1080p.
    - Exibição de mensagem OSD na tela quando o console é acoplado ou desacoplado.
  - **Correção de Congelamento de Modais no Modo Retrato (TATE):**
    - No modo retrato com rotação ativada (`s_screenRotation != 0`), as janelas modais (`Updater::drawModal` e `CloudSave::drawModal`) agora são renderizadas diretamente dentro do render target intermediário `s_rotateTarget` (720x1280) antes do unbind, corrigindo o problema de tela congelada ao abrir diálogos em modo vertical.

## Sessão 11 (Correções Críticas: Menu/Start, Gamepad Touch HL2, Isolamento Cloud Save, Resolução e Navegação Ingame)
## Sessão 12 (Correções Críticas v1.0.2: Fechar/Voltar Menu, Clique Settings Ingame, Tela Preta na Resolução e Updater OTA)
- **1. Fechar Menu e Voltar de Submenus no Gamepad Físico e Virtual:**
  - **Causa Raiz:**
    - No teclado do PC, `Esc` e `Backspace` enviam `-7` (RSK / Voltar / Cancelar), enquanto `Tab` e `Q` enviam `-6` (LSK / Abrir Menu).
    - No toque do celular em modo Retrato, não havia botão virtual para `-7` (Voltar). Em modo Paisagem, o botão com textura de pílula RSK estava enviando `48` (Poção / Item) em vez de `-7`.
    - No controle físico e no botão de toque `[ MENU ]`, ambos enviavam fixamente `-6`. Dentro da máquina de estados do menu J2ME (`ax.java`), `-6` é capturado como tecla de confirmação/seleção (`n.f(n2, 49)`). Assim, ao pressionar `Start` ou tocar em `[ MENU ]` com o menu aberto, o jogo entrava na opção em vez de fechar.
    - Além disso, a detecção de menu `isMenuModeActive(vm)` cacheava o ponteiro da classe `di` no boot; se chamada antes de `di` ser carregada, `s_diCls` ficava nulo permanentemente.
  - **Solução Implementada:**
    - Adicionado botão físico/virtual `[ VOLTAR ]` (`-7`) tanto em Retrato quanto em Paisagem.
    - Implementada lógica proporcional e contextual para `START` do gamepad e botão `[ MENU ]` do touch: se o menu estiver ativo (`isMenuModeActive(vm)`), envia `-7` (fechando o menu ou voltando do submenu); se estiver no jogo, envia `-6` (abrindo o menu).
    - Corrigido `isMenuModeActive` para re-buscar a classe `di` caso ainda não estivesse carregada no boot.

- **2. Clique no Menu Settings Ingame (`bd.java`) Direcionando para Item 0 (BGM):**
  - **Causa Raiz:**
    - No PC, `SDL_MOUSEBUTTONDOWN` calculava `offsetY = (winH - dstH) / 2` (centralizado na janela). No entanto, em modo Retrato com controles ativos, a tela do jogo é desenhada no topo (`y = 0.015 * winH`), gerando uma discrepância de mais de 100px. O clique caía acima da caixa de opções, calculando `row = 0` (BGM).
    - `bd_handle_mouse_click` em `natives.cpp` restringia a área de clique rigidamente a `boxX <= gameX <= boxX + boxW`. Ao clicar nos rótulos à esquerda ou valores à direita em telas widescreen, a função retornava `false`.
    - Ao retornar `false`, o evento do mouse caía no fallback `sendKeyPressed(vm, 53)`, confirmando a opção onde o cursor estava posicionado (item 0)!
  - **Solução Implementada:**
    - Coordenadas de clique do mouse no PC agora utilizam `layout.gameRect` para alinhamento pixel-perfect tanto em Retrato quanto em Paisagem.
    - `bd_handle_mouse_click` agora aceita cliques em toda a extensão horizontal do menu e aciona diretamente as funções nativas (`Platform::openCloudSave`, `Platform::checkForUpdates`, `toggleFps`, `nextAspect`) quando clicadas as opções 7 a 10.

- **3. Tela Preta ao Mudar Resolução ou Orientação:**
  - **Causa Raiz:**
    - Em `Platform::present()`, a checagem de aspecto automático ocorria no final do frame, após o jogo ter renderizado para a resolução anterior. `applyAspectWidth` destruía e recriava `s_screenTexture` e o buffer `cm`, deixando a textura SDL sem dados válidos no momento do `SDL_RenderCopy`.
    - No J2ME, o loop só redesenha os blocos de mapa quando o personagem anda ou se `g.var_boolean_a` (`g.a:Z`) estiver ativo. Com o personagem parado, o jogo ficava preto até que uma tecla fosse pressionada ou a resolução voltasse ao padrão.
    - A função `forceRepaintImmediate` buscava o método `void_a:(II)V`, mas no bytecode desmontado (`az.javap.txt`), o nome do método é `a:(II)V`. O método falhava silenciosamente e nunca forçava o redesenho.
  - **Solução Implementada:**
    - A checagem de proporção e orientação agora ocorre no topo de `Platform::pollEvents()`, antes do ciclo de `paint()`.
    - `forceRepaintImmediate` agora invoca corretamente `a:(II)V`, seta `g.a:Z = true`, invoca `paint()` e atualiza a textura SDL `s_screenTexture` imediatamente de forma síncrona.

- **4. Diagnóstico de Detecção de Updates no GitHub:**
  - **Causa Raiz:**
    - O repositório `davidkalil10/Heroes-Lore-Zero-Recomp` no GitHub está configurado como **Privado**.
    - Requisições sem autenticação (como as feitas pelo updater OTA de dentro do jogo no Switch, Android e PC) para `api.github.com/repos/.../releases/latest` recebem resposta HTTP 404 Not Found. O código antigo tratava 404 como "Jogo atualizado (v1.0.0). Nenhuma versão nova encontrada".
    - Na leitura do JSON, a varredura buscava `"name"` desde o início do JSON e encontrava o nome da release em vez da lista de `assets`.
  - **Solução Implementada:**
    - `parseReleaseJson` corrigido para iniciar a busca a partir da chave `"assets"`.
    - Ao receber 404, o jogo agora exibe mensagem clara: `Atualização: Nenhum release público encontrado. (Verifique se o repositório no GitHub está Público)`.
    - Para que o OTA Updater funcione diretamente nas builds públicas, basta alterar a visibilidade do repositório no GitHub para **Público**.

## Sessão 13 (Correções Críticas v1.0.3: Layout do Botão BACK e Confirmação no Menu Ingame via Tecla 5 / Gamepad A)
- **1. Layout, Rótulo e Posicionamento do Botão BACK no Virtual Gamepad:**
  - **Diagnóstico:**
    - O botão de retorno (`-7`) anteriormente adicionado estava utilizando a textura `btn_rsk` com rótulo "0" e sub-rótulo "ITEM", gerando confusão visual com o atalho de poção HP.
    - Em modo Retrato, o botão estava posicionado no canto direito (`x = 0.86 * winW`), sobrepondo-se ao botão 3 (Skill 2) e gerando um layout poluído.
  - **Solução Implementada:**
    - Em `tools/generate_gamepad_textures.py`, criada a nova textura `btn_back` com rótulo nítido "BACK", tipografia centralizada e contorno de vidro com cor coral/âmbar (`#f06e50`), além de atualizar `btn_rsk` como alias compatível.
    - Em `src/platform/platform_sdl.cpp`, os 3 botões de sistema em modo Retrato foram redimensionados para `pillW = 0.175 * winW` e organizados lado a lado de forma harmoniosa acima do D-Pad:
      - `[ MENU ]` centralizado em `x = 0.12 * winW`
      - `[ MAPA ]` centralizado em `x = 0.31 * winW`
      - `[ BACK ]` centralizado em `x = 0.50 * winW`
    - Elimina 100% da sobreposição com o grupo de botões de ação na direita e com o D-Pad na esquerda, garantindo espaçamento simétrico de 1.5% entre botões.
    - Em modo Paisagem, a textura `btn_back` foi igualmente associada ao botão `-7` no topo da coluna direita.

- **2. Confirmação / Entrada em Itens do Menu Ingame com o Botão 5 / Gamepad A:**
  - **Diagnóstico:**
    - No menu ingame (`ax.java`), o bytecode possui a checagem `if (n3 >= 49 && n3 <= 56)` antes de `n.f(n2, 49)`. Quando o usuário pressionava a tecla 5 (código 53 vindo do botão virtual 5, botão A do gamepad ou Space/Enter), a condição `53 >= 49 && 53 <= 56` capturava a tecla e forçava `this.var_byte_a = 53 - 49 = 4`, abrindo diretamente o item 4 ("Elemental") em vez de entrar no item selecionado pelas setas.
    - Isso obrigava o jogador a ter que pressionar o número correspondente (1 para Equip, 2 para Item, etc.) para entrar em cada opção.
  - **Solução Implementada:**
    - Em `sendKeyPressed` e `sendKeyReleased` de `src/platform/platform_sdl.cpp`, quando `isMenuModeActive(vm)` está ativo (`di.d:B == 5`), qualquer tecla de ação `53` é mapeada em tempo de execução para `-6` (LSK).
    - No menu raiz de `ax.java`, `-6` cai diretamente em `n.f(n2, 49)`, executando `this.d(this.var_byte_a)` e entrando imediatamente na opção destacada pelo cursor direcional.
    - Dentro de todos os submenus (`dc`, `cy`, `dp`, `y`, `ce`, `ch`, `bd`), `-6` é reconhecido nativamente por `n.f(n2, n3)`, confirmando a ação normalmente.
    - O comportamento agora é 100% intuitivo e consistente entre Mobile (Touch), Nintendo Switch (Gamepad) e PC Desktop (Teclado/Mouse/Controle).

## Sessão 14 (Correções Críticas v1.0.4: Instalação de APK no Android e Isolamento de Toques em Modais)
- **1. Falha ao Abrir o Instalador de Pacotes do Android (PackageInstaller OTA):**
  - **Diagnóstico:**
    - Em `android/app/src/main/java/org/libsdl/app/SDLActivity.java` (método `installApk`), a autoridade do content URI estava com o nome do pacote de outro projeto (`content://com.davidbraga.heroeslore2.provider...`) em vez de `com.davidbraga.heroeslorezero.provider`.
    - Ao tentar abrir o intent com uma autoridade inexistente/desconhecida, o Android lançava exceção de segurança/atividade, impedindo o PackageInstaller nativo de abrir.
    - Além disso, no Android 8.0+ (Oreo, API 26+), é necessário verificar `getPackageManager().canRequestPackageInstalls()`. Se falso, deve-se abrir a tela de configurações (`ACTION_MANAGE_UNKNOWN_APP_SOURCES`) para o usuário autorizar a instalação de atualizações vindas do app.
  - **Solução Implementada:**
    - Em `SDLActivity.java`, substituído o prefixo hardcoded por `mSingleton.getPackageName() + ".provider"`, casando com a declaração do `ApkFileProvider` no `AndroidManifest.xml`.
    - Adicionada verificação de `canRequestPackageInstalls()` no Android 8.0+ com redirecionamento amigável para as configurações do sistema caso a permissão ainda não tenha sido concedida.
    - Incluídas flags `FLAG_GRANT_READ_URI_PERMISSION`, `FLAG_GRANT_PREFIX_URI_PERMISSION`, `FLAG_ACTIVITY_NEW_TASK` e `FLAG_ACTIVITY_CLEAR_TOP`.
    - Em `src/platform/updater.cpp`, adicionado fallback de cópia caso a substituição via `rename` atinja partições diferentes, além de acionar novamente o instalador caso o usuário clique no botão de ação da tela de conclusão.

- **2. Tela Piscando e Bloqueio de Toques no Modal de Cloud Save / Menu Ingame:**
  - **Diagnóstico:**
    - Em `src/platform/platform_sdl.cpp`, os eventos `SDL_FINGERDOWN` dos modais (`Updater` e `CloudSave`) calculavam as coordenadas de toque usando `SDL_GetWindowSize(s_window, &winW, &winH)`. Em dispositivos Android modernos, `SDL_GetWindowSize` retorna dimensões lógicas (ex: 412x915), enquanto `drawModal` desenha com `SDL_GetRendererOutputSize` em pixels nativos (ex: 1080x2400). As coordenadas ficavam completamente deslocadas e nenhum toque atingia os botões ou o botão [X].
    - Adicionalmente, quando o usuário tentava tocar no modal aberto pelo menu in-game (`bd.class`), o SDL do Android emitia eventos sintetizados de mouse (`SDL_TOUCH_MOUSEID`) e de soltura de toque que vazavam para `bd_handle_mouse_click`. Ao atingir a linha 9 ("Nuvem") que ficava exatamente atrás do modal na tela, o jogo chamava `Platform::openCloudSave` e reabria o modal imediatamente, causando o efeito visual de piscada e sensação de toque vazando para os elementos de trás.
  - **Solução Implementada:**
    - Em `platform_sdl.cpp`, as coordenadas de toque de `Updater` e `CloudSave` foram corrigidas para utilizar `SDL_GetRendererOutputSize(s_renderer, &renW, &renH)` com fallback para `GetWindowSize`.
    - Eventos `SDL_MOUSEBUTTONDOWN` com `ev.button.which == SDL_TOUCH_MOUSEID` são explicitamente descartados enquanto os modais estão ativos para evitar cliques duplicados ou desfasados.
    - Criado sistema de cooldown de segurança pós-fechamento (`s_modalClosedTime` e `Platform::isModalOrCooldownActive()`): ao fechar qualquer modal, bloqueia por 350ms qualquer clique direcionado a `bd_handle_mouse_click` e ao motor do jogo, além de limpar `s_activeFingers`.
    - Em `bd_handle_mouse_click` (`src/vm/natives.cpp`), adicionada guarda `if (Platform::isModalOrCooldownActive()) return false;`.
    - Em `src/platform/cloud_save.cpp` e `updater.cpp`, expandida a hitbox do botão [X] com padding de 20px e adicionado fechamento amigável ao tocar fora da área do modal (backdrop escuro).

## Sessão 15 (Correções Críticas v1.0.5: Inversão dos Botões X/Y no Switch e Refresh Imediato de Saves Restaurados)
- **1. Inversão dos Botões Físicos X e Y no Nintendo Switch na Tela de Cloud Save:**
  - **Diagnóstico:**
    - No Nintendo Switch (layout ABXY da Nintendo), o botão físico `( X )` fica no topo (posição Norte) e o botão físico `( Y )` fica na esquerda (posição Oeste).
    - O driver SDL2 mapeia os botões pelo padrão posicional do Xbox: a posição Norte é `SDL_CONTROLLER_BUTTON_Y` e a posição Oeste é `SDL_CONTROLLER_BUTTON_X`.
    - Em `platform_sdl.cpp` (bloco `CloudSave::isModalActive()`), o código tratava `ev.cbutton.button == SDL_CONTROLLER_BUTTON_X` como a tecla 50 ("Restaurar / Baixar da Nuvem") e `ev.cbutton.button == SDL_CONTROLLER_BUTTON_Y` como a tecla 51 ("Desconectar").
    - Com isso, ao pressionar o botão físico `( X )` no Switch, o SDL disparava `SDL_CONTROLLER_BUTTON_Y`, caindo erroneamente na ação de desconectar a conta.
  - **Solução Implementada:**
    - Em `src/platform/platform_sdl.cpp`, criado tratamento condicional específico para `#if defined(__SWITCH__)`:
      - Físico `( A )` (`SDL_CONTROLLER_BUTTON_B`) -> tecla `53` (Confirmar / Fazer Backup).
      - Físico `( B )` (`SDL_CONTROLLER_BUTTON_A`) -> tecla `-7` (Cancelar / Voltar).
      - Físico `( X )` (`SDL_CONTROLLER_BUTTON_Y`) -> tecla `50` (Baixar da Nuvem / Restaurar).
      - Físico `( Y )` (`SDL_CONTROLLER_BUTTON_X`) -> tecla `51` (Desconectar Conta).
    - No PC/Xbox, o bloco `#else` mantém a correspondência padrão correta.

- **2. Save Baixado da Nuvem Não Aparecia no Menu sem Reiniciar o Jogo:**
  - **Diagnóstico:**
    - Ao restaurar um save pelo modal de Cloud Save, os arquivos `.rms` (`HOL.slot1.rms`, `HOL.gamedata1.rms`, etc.) eram gravados no disco perfeitamente, mas os metadados dos slots na memória da VM Java (`di.var_byte_arr_arr_a` e `di.var_byte_i`) continuavam vazios (`null` e `0`).
    - Em `CloudSave::update()`, o código tentava chamar métodos inventados que não existiam no bytecode decompilado (`n.p:()V` e `bu.d:()V`), falhando silenciosamente.
    - No bytecode original do J2ME, o método estático responsável por abrir todos os arquivos RMS e popular os dados decodificados dos 3 slots de personagens é `di.m:()V`. Como ele nunca era chamado, o menu principal `i.java` mantinha a opção "Continuar" desabilitada/invisível (`di.var_byte_i <= 0`) até que o jogo fosse fechado e reiniciado (onde o boot em `bv.java` chama `di.m()`).
  - **Solução Implementada:**
    - Em `CloudSave::update()` (`src/platform/cloud_save.cpp`), quando a flag `s_pendingVmReload` é acionada:
      1. Invoca `di.m:()V` na VM Java sob o GIL, relendo os arquivos RMS do disco e populando `di.var_byte_arr_arr_a` e `di.var_byte_i` (> 0).
      2. Localiza a instância ativa do menu principal `i.a` e atualiza a seleção para o item 1 ("Continuar").
      3. Invoca o método `n.f:()V` em `i.a` para recalcular o layout visual do menu e habilitar a opção "Continuar" imediatamente.
      4. Força repintura total dos frames gráficos (`bs.c = true`, `rpg/a.a = true`, `g.a = true`).
    - Agora, assim que o save é baixado, ele fica imediatamente disponível e visível na tela de slots sem necessidade de reiniciar o jogo em nenhuma plataforma.

## Sessão 16 (Correção Crítica v1.0.6: Restauração de Save da Nuvem In-Game com Retorno Automático ao Menu)
- **Restauração de Save da Nuvem Dentro do Jogo (In-Game) Não Atualizava a Partida sem Reiniciar o App:**
  - **Diagnóstico:**
    - Ao realizar o download/restauração do backup na nuvem através do menu de opções in-game (`bd.class`), os arquivos RMS eram corretamente gravados em disco, mas a engine de jogo continuava mantendo na memória RAM os dados da partida ativa anterior (`rpg.e` e `di.var_do_a`), com o mapa, herói e inventário antigos.
    - Como a partida anterior continuava ativa, o jogador não via as alterações até forçar o fechamento do app e reabri-lo do zero.
    - No menu de título a restauração já funcionava, pois `di.m()` atualizava o menu `i.class` diretamente.
  - **Solução Implementada (Seguindo o Padrão do Jogo 1 e do Bytecode Original de Heroes Lore Zero):**
    - Identificada no bytecode a sequência oficial e canônica utilizada pelo jogo em Game Over (`di.java:167-168` e `bs.java:158-159`):
      `rpg.e.rpg_e_a().d();` seguido de `bs.bs_a().a((byte)2, false);`.
    - Em `CloudSave::update()` (`src/platform/cloud_save.cpp`), após gravar os arquivos RMS e invocar `di.m:()V`, inspeciona `di.d:B` (`curGameState`):
      - Se `curGameState > 1` (partida ativa em andamento):
        1. Fecha imediatamente o modal de nuvem com `CloudSave::closeModal()`.
        2. Reseta referências do menu de opções com `bd_reset_active_menu()` em `natives.cpp`.
        3. Invoca `rpg.e.rpg_e_a().d()` na VM Java para descarregar da memória RAM todos os tiles, gráficos de mapa e instâncias ativas da partida antiga.
        4. Invoca `bs.bs_a().a((byte)2, false)` com argumentos `(byte)2, (boolean)false`. Isso dispara a thread nativa do jogo que re-inicializa o menu principal (`i.i_a()`), reseta a engine de mundo (`e2.void_a()`), inicia a música tema de abertura em loop (`bq.b(0, true)`) e define o menu principal como tela visível no Canvas (`di.void_b()`).
        5. Emite aviso visual OSD localizado em 4 idiomas (`OSD_RESTORE_INGAME_RETURN`: "Save restaurado! Retornando ao menu principal...").
      - Se `curGameState <= 1` (menu principal):
        - Mantém a atualização visual dos botões do menu `i.class` (`n.f:()V`), posicionando o cursor na opção "Continuar".
    - Agora o jogador pode restaurar o save a qualquer momento (seja no título ou no meio de qualquer partida) que o save é imediatamente carregado e disponibilizado para jogar.

## Sessão 17 (v1.0.7: Localização Completa PT-BR com Hot-Reload em Tempo de Execução e Suporte Modular a Novos Idiomas)
- **1. Arquitetura de Textos do J2ME Original e Interceptação Binária:**
  - **Diagnóstico:**
    - Ao contrário de Heroes Lore 1 (que centralizava strings em um único arquivo), Heroes Lore: Zero distribui textos em 3 estruturas binárias distintas:
      1. `t/*.tdf` (31 arquivos binários decodificados pela classe `ch.java` sob demanda).
      2. `m/m/*.m` e `m/m2/*.m` (139 arquivos de mapa, cujos bytes finais contêm os diálogos e nomes de área carregados por `db.java`).
      3. `en/edf` (tabela binária de atributos e nomes de NPCs e monstros).
  - **Solução Implementada:**
    - Desenvolvida a ferramenta `tools/extract_texts.py` para extrair os textos originais em inglês para arquivos estruturados JSON em `lang/source_en/` (`ui_strings.json`, `maps_dialogs.json`, `enemies_npcs.json`).
    - Desenvolvida a ferramenta `tools/translate_to_pt.py` para gerar a localização completa em português brasileiro em `lang/pt_br/`.
    - Desenvolvida a ferramenta `tools/compile_texts.py` para compilar os dados JSON de volta para os formatos binários proprietários exatos esperados pelo jogo em `assets/lang/<idioma>/`.
    - Em `src/platform/platform_sdl.cpp` (`Platform::readAsset`), implementada interceptação automática de leituras: quando o idioma ativo difere de `"en"`, o carregador de assets busca primeiro em `assets/lang/<idioma>/...`, com fallback transparente em todas as plataformas (PC, Android e Nintendo Switch RomFS).

- **2. Troca de Idioma a Quente (*Hot-Reload* Instantâneo sem Reiniciar o Jogo):**
  - **Diagnóstico:**
    - A VM Java instancia objetos `ch` durante o boot e mantém arrays pré-carregados de strings em campos estáticos de `rpg/e.a..k` e `ax.a..c`, além dos diálogos do mapa atual em `db.a:[[B`.
    - Apenas alterar os arquivos em disco não atualizaria os textos já carregados na memória RAM da máquina virtual.
  - **Solução Implementada:**
    - Em `src/vm/natives.cpp`, o construtor `ch.<init>:(Ljava/lang/String;)V` foi interceptado nativamente (`ch_init_native`), registrando ponteiros fracos de todas as instâncias ativas de `ch` em `Platform::registerChInstance`.
    - Criada a função `Platform::reloadLanguage(VM& vm)` que:
      1. Itera por todas as instâncias ativas de `ch` na memória e regera o array de strings decodificadas com base no novo idioma.
      2. Recarrega explicitamente os campos estáticos de `rpg/e` e `ax`.
      3. Recarrega instantaneamente os diálogos do mapa atual em `db.a:[[B` a partir do mapa do jogador ativo (`di.a:B`).
      4. Seta flags estáticas de repintura (`n.a:Z`, `rpg/a.a:Z`, `g.a:Z`, `bs.c:Z`), forçando o redesenho imediato de todas as camadas visuais do frame atual.

- **3. Expansão do Menu de Opções (`bd.class`):**
  - O menu de opções foi expandido de 11 para 12 opções (Opção 11: "Idioma" / "Language").
  - A opção suporta:
    - Teclas de seta Esquerda/Direita para alternar entre os idiomas disponíveis.
    - Tecla Confirmar/Fire (5 ou Enter) para avançar ciclicamente.
    - Suporte a Gamepad físico e cliques/toques com mouse ou touchscreen (`bd_handle_mouse_click`).
  - Idioma ativo é salvo no arquivo de configuração do usuário (`hl_settings.ini`).

- **4. Diretrizes Rígidas de Cânone e Não-Tradução de Nomes Próprios:**
  - Garantido que nomes próprios de personagens (`Lucian`, `Clare`, `Alpez`, `Calmon`, `Gilbert`, `Carl`, `Timoros`, `Aquila`, `Legolas`, etc.) e nomes de cidades/vilarejos (`Silverleaf Village`, `Melon Village`, `Humming City`, `Chelen Village`, `Plum City`, `Southern Fortress`, etc.) **nunca** sejam traduzidos ou alterados.
  - Todas as tags de formatação do motor de diálogos (`|[Nome]&`, `^[Nome]&`, `$[Nome]&`, `{destaque&}`, `}Ação&`) são preservadas 100%.

- **5. Documentação e Preparação para Idiomas Futuros:**
  - Criado o documento detalhado `docs/LOCALIZATION.md` com toda a especificação técnica e o guia passo a passo para criar e compilar novos idiomas adicionais (ex: Espanhol `es`, Francês `fr`).
  - O sistema descobre novos idiomas dinamicamente através de `Platform::getAvailableLanguages()`.

## Sessão 18 (Correções Críticas v1.0.8: Pergunta de Som no Boot e Versão Instalada no Menu de Título)
- **1. Pergunta de Som no Boot ("Ativar o som? [Sim] [Não]"):**
  - **Diagnóstico:**
    - Em `reference/extracted/t/lot.tdf`, o índice 26 armazena a pergunta original de ativação de som do boot (`"On sound?"`), índice 0 armazena `"Yes"` e índice 1 armazena `"No"`.
    - No dicionário `UI_TRANSLATIONS["lot.tdf"]` de `tools/translate_to_pt.py`, o índice 26 havia sido traduzido inadvertidamente como `"Continuar"`, gerando o popup confuso `"Continuar [Sim] [Não]"` logo após a exibição do logo da EA.
  - **Solução Implementada:**
    - Corrigido `lot.tdf` em `tools/translate_to_pt.py` com todas as strings mapeadas 1:1 rigorosamente:
      - `0: "Sim"`
      - `1: "Nao"`
      - `26: "Ativar o som?"`
      - `27: "Pressione # para continuar"`
      - `31: "O progresso nao salvo sera perdido. Deseja sair do jogo agora?"`
    - Adicionado merge automático de segurança em `tools/translate_to_pt.py` contra `lang/source_en/ui_strings.json`, assegurando que todos os 31 arquivos binários `.tdf` mantenham exatamente a mesma quantidade de elementos do jogo original, evitando acessos fora dos limites em `ch.a(idx)`.
    - Recompilados os binários com `python tools/compile_texts.py pt` e validados via captura de frame: exibe perfeitamente `"Ativar o som?"` com os botões `[ Sim ]  Nao`.

- **2. Exibição da Versão Instalada no Menu de Título Principal:**
  - **Diagnóstico:**
    - Era necessário exibir o número da versão instalada (ex: `v1.0.8`) no menu principal para facilitar a identificação da build em todas as plataformas (Windows, Linux, Android e Nintendo Switch).
  - **Solução Implementada:**
    - Interceptado nativamente o método estático `rpg/a.c:(Lcm;)V` em `src/vm/natives.cpp` (`rpg_a_c_native`), responsável por desenhar a tela de título e o logo `title.png` (`rpg.e.e`).
    - Adicionada verificação inteligente para renderizar a versão apenas quando o Canvas ativo é o menu de título (`i.java`, evitando poluir a janela de som em `bv.java`).
    - Renderiza `HL_VERSION_TAG` centralizado horizontalmente logo abaixo do logo (`logoY + 47`), utilizando a rotina oficial de desenho de texto `ac.a:(Lcm;II[BII)V`, aplicando sombra preta e tipografia na cor dourada suave / pergaminho (`0xD8C8A8`).
    - Resultado perfeitamente integrado e alinhado com o estilo gótico e clássico do menu original de Heroes Lore: Zero.

## Sessão 19 (Correções Críticas v1.0.9: Localização de Byte Arrays Hardcoded, Intercepção de Mapas e Menu Widescreen Fluido)
- **1. "Press any key to continue" sem Localização na Tela Splash (`rpg.d.C:[B`):**
  - **Diagnóstico:**
    - Logo após a confirmação do som no boot (`bv.java:164` e `f.java:62`), a tela exibe a frase `"Press Any Key To Continue"` via `ac.a(cm, ..., rpg.d.C, 0, 1)`.
    - Esta string não vinha de nenhum arquivo `.tdf` externo, mas sim de um byte array estático hardcoded no bytecode compilado de `rpg.d.<clinit>`: `C = "Press Any Key To Continue".getBytes()`.
    - Além disso, quando o motor tentava alterar o valor antes de `<clinit>`, a inicialização estática da classe Java executava posteriormente e sobrescrevia os valores.
  - **Solução Implementada:**
    - Criado helper nativo `setVmStaticByteArray(VM& vm, className, fieldName, text)` que altera dinamicamente e in-place o vetor de dados do `Array*` estático ou aloca um novo caso necessário.
    - Implementado `Platform::updateHardcodedLanguageStrings(VM& vm)` cobrindo todas as strings hardcoded de `rpg.d` para PT-BR (`C`: "Pressione qualquer tecla para continuar", `u`: "Tem certeza de que deseja sair?", `B`: "Voce nao tem ouro suficiente.;", `D`: "Deseja continuar? ;O jogo sera encerrado.", `s`: "Ouro", etc.).
    - Acoplado hook em `VM::initClass` (`src/vm/vm.cpp:365`) para disparar `Platform::updateHardcodedLanguageStrings` imediatamente após a conclusão do `<clinit>` de `rpg/d`, e garantido disparo também no boot (`main.cpp`) e ao trocar de idioma (`Platform::reloadLanguage`).
    - Validado via captura de frame: exibe perfeitamente `"Pressione qualquer tecla para continuar"`.

- **2. Diálogos de Mapas Permanecendo em Inglês no Início do Jogo:**
  - **Diagnóstico:**
    - Identificadas duas causas concorrentes:
      1. **Prefixos de Ambiente em `Platform::readAsset`:** Quando `natives.cpp` carregava um mapa (`/m/m2/d6.m`), ele chamava `Platform::readAsset("reference/extracted/m/m2/d6.m")`. O interceptador de idioma verificava apenas `if (rel.rfind("m/", 0) == 0)`. Como continha o prefixo `"reference/extracted/"`, a checagem falhava e o motor lia o mapa original em inglês de `reference/extracted/`.
      2. **Tradução Incompleta dos Mapas Iniciais:** Em `tools/translate_to_pt.py`, a lista de substituição de frases não cobria os diálogos do quarto de Lucian (`d6.m`), orfanato/Clare (`09.m`, `10.m`), Silverleaf Village (`00.m`) e Chelen Village (`01.m`).
  - **Solução Implementada:**
    - Atualizado `Platform::readAsset` (`src/platform/platform_sdl.cpp:2847`) com remoção sistemática de prefixos de diretório (`romfs:/`, `reference/extracted/`, `../reference/extracted/`, `extracted/`, `assets/`, `../assets/`) antes de checar as rotas de assets localizados (`t/`, `m/`, `en/edf`).
    - Adicionado suporte a tabelas de diálogos exatas em `tools/translate_to_pt.py` (`MAP_EXACT_DIALOGS`) e expandido o dicionário `COMMON_PHRASES`.
    - Traduzidos 100% dos diálogos do início do jogo (quarto de Lucian com Alpez e Calmon, conversas de Clare no orfanato, vila de Silverleaf e vila destruída de Chelen), preservando todas as tags do motor (`|[Nome]&`, `^[Nome]&`, `}Quest...&`).
    - Recompilados os 139 mapas binários com `python tools/compile_texts.py pt` e espelhados no RomFS do Switch com `python tools/prepare_switch_romfs.py`.
    - Logs confirmam: `[Lang] Interceptado asset localizado: 'reference/extracted/m/m2/d6.m' -> 'm/m2/d6.m' (5837 bytes)`.

- **3. Menu Ingame Estreito / Cortado ao Alternar Resolução (`ax.java` / `rpg.f` / `rpg.d.e_`):**
  - **Diagnóstico:**
    - Ao abrir o jogo do zero em widescreen (568x320), o menu ingame (`ax.java`, subclasse de `l` e `n`) ocupava 558px de largura (largura total da tela menos 10px), visualmente impecável.
    - Contudo, na rotina `updateJavaViewportVariables` (`platform_sdl.cpp`), o valor `menuW = 230` estava hardcoded. Quando o jogador mudava de resolução (ex: F7 ou opções) ou voltava para wide/auto, `rpg.f.b` e `rpg.d.e_` eram forçados permanentemente para 230px, além de as instâncias de `n` não estarem sendo atualizadas porque os campos `a_` e `b_` possuem descritor `I` (int32) e o código tentava usar `setVmInstanceShort` (descritor `S`).
  - **Solução Implementada:**
    - Implementado helper `setVmInstanceInt(Object* obj, fieldName, int32_t val)` para atualizar campos de instância inteiros em subclasses de `n`.
    - Atualizado `updateJavaViewportVariables` para computar `menuW = g_screenWidth - 10;`, `menuX = (g_screenWidth - menuW) / 2;`, `rpg/f.h = g_screenWidth - 20;`, `rpg/d.e_ = menuW;` dinamicamente em qualquer resolução e aspecto de tela.
    - Em 16:9 widescreen, `menuW` passa a ser 558px e `menuX = 5`. Em 3:4 original, `menuW = 230px` e `menuX = 5`.
    - Agora o menu se adapta suavemente e mantém a largura fluida total de 558px sempre que o jogo estiver em widescreen.

## Sessão 20 (Correções Críticas v1.0.10: Mudança de Aspect Ratio Thread-Safe via Menu de Opções)
- **1. Tela Preta ao Alterar Resolução / Proporção de Tela através da Opção no Menu (`bd.class`):**
  - **Diagnóstico:**
    - Quando a proporção de tela era alternada pelo atalho de gamepad (SELECT+START ou F7), o comando era processado dentro de `Platform::pollEvents()`, executando 100% na **thread principal** de renderização (onde o `SDL_Renderer` e o contexto gráfico DirectX11 / OpenGL / Switch residem). A destruição e recriação de `s_screenTexture` ocorriam normalmente.
    - Por outro lado, quando o jogador alterava a opção de proporção (Item 8: "Tela" / "Screen") navegando pelo menu de configurações (`bd.class`), a chamada partia do método nativo `bd_a_native`, que roda dentro de `bs.run()` ou `bv.run()` em uma **thread secundária SDL** (a thread de execução J2ME).
    - Na arquitetura do SDL2, funções de textura (`SDL_DestroyTexture`, `SDL_CreateTexture`, `SDL_UpdateTexture`) não são thread-safe e é proibido invocá-las a partir de uma thread diferente daquela que criou o `SDL_Renderer`.
    - Em decorrência disso, `SDL_CreateTexture` falhava silenciosamente e retornava `nullptr`. A variável `s_screenTexture` ficava permanentemente nula, fazendo com que `Platform::present()` abortasse a renderização e deixasse a tela totalmente preta.
  - **Solução Implementada:**
    - Registrado o ID da thread principal em `Platform::init` (`s_mainThreadId = (unsigned long)SDL_ThreadID()`).
    - Criada a fila de sincronização atômica `static std::atomic<int> s_pendingAspectWidth{-1}`.
    - Quando `Platform::setAspectMode` ou `applyAspectWidth` são chamados a partir de uma thread secundária (como na navegação de menus Java), a alteração gráfica é agendada atomicamente em `s_pendingAspectWidth` sem tocar em texturas SDL fora da thread de renderização.
    - Em `Platform::pollEvents()` e `Platform::present()`, a thread principal consome `s_pendingAspectWidth` e executa `applyAspectWidth` com o contexto gráfico e a GIL sincronizados, recriando as texturas e forçando o repaint imediato do menu na nova resolução sem qualquer falha visual.
    - Tanto o atalho do controle quanto a opção do menu in-game agora alteram a proporção de tela de maneira perfeitamente fluida, sem congelamentos e sem tela preta.

- **2. Falha de Download do NDK no GitHub Actions (`build-android` na v1.0.10):**
  - **Diagnóstico:**
    - O workflow falhava na etapa `assembleRelease` com `ZipException: Archive is not a ZIP archive` e `InstallFailedException: Failed to install the following SDK components: ndk;26.1.10909125`.
    - Isso ocorria porque `android/app/build.gradle` continha a versão rígida `ndkVersion '26.1.10909125'`. Nos runners `ubuntu-latest` do GitHub Actions, o NDK pré-instalado atualmente é a versão 27 (`27.3.13750724` em `$ANDROID_NDK_HOME`).
    - Ao notar a ausência da versão exata 26.1, o AGP tentava baixar dinamicamente o NDK 26 via rede a partir dos servidores do Google SDK, mas o arquivo falhava durante o download/descompressão.
  - **Solução Implementada:**
    - Em `android/app/build.gradle`, substituída a versão estática por detecção dinâmica: prioriza `ANDROID_NDK_VERSION` e, se ausente, busca a pasta instalada em `$ANDROID_SDK_ROOT/ndk` ou `$ANDROID_HOME/ndk`.
    - No workflow `.github/workflows/build.yml`, configurado step de detecção a partir de `$ANDROID_NDK_HOME` / `$ANDROID_SDK_ROOT/ndk`, exportando para `$GITHUB_ENV` e passando `-Pandroid.ndkVersion` para o Gradle.
    - O build reutiliza o NDK 27 nativamente pré-instalado no runner sem requisições de download propensas a erro.


