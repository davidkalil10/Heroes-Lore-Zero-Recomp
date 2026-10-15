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

