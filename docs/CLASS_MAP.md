# CLASS_MAP — Heroes Lore: Zero

Este documento mapeia todas as 141 classes decompiladas de Heroes Lore: Zero para seus papéis no motor.

## Classes de Entrada & Ciclo de Vida
- `rpg.RPGHeroEx`: MIDlet principal (`extends javax.microedition.midlet.MIDlet`). Ponto de entrada que inicializa `rpg.c`.
- `rpg.c`: Controlador mestre do jogo e Game Loop (`implements Runnable`). Inicia o loop de eventos, gerencia transições de tela e clock.
- `ct`: Display and Screen Manager (`javax.microedition.lcdui.Display`). Registra e exibe a tela ativa `az` no `Canvas` `f`.
- `f`: Canvas J2ME (`extends Canvas`). Implementa renderização em 360x640, tratamento de teclado (`keyPressed`/`keyReleased`) e toque (`pointerPressed`/`pointerReleased`) com `/vpad.png`.

## Camada Gráfica e Recursos
- `az`: Classe base abstrata para telas e buffers de desenho (`d(cm g)`, `boolean_a(int code, int type)`).
- `cm`: Contexto de renderização gráfica que envolve `javax.microedition.lcdui.Graphics` e controla clipping e translações.
- `cg`: Encapsulamento de `javax.microedition.lcdui.Image`.
- `ch`: Parser de definições de tiles e fontes `.tdf` (Tile Definition Files).
- `s`: Engine de sprites, frames e animações dos personagens/monstros.
- `rpg.e`: Carregador global de recursos gráficos (sprites, `.tdf`, imagens).

## Telas do Jogo (Subclasses de `rpg.a` / `az`)
- `rpg.a`: Classe base abstrata para todas as telas do jogo (`extends az implements Runnable, d`).
- `bv`: Tela de Apresentação / Splash Screen (logos, aviso de direitos).
- `bs`: Tela de Menu Principal (Novo Jogo, Carregar, Opções).
- `do`: Tela do Mundo / Mapa do Jogo (27 KB - motor principal de renderização de mapa, NPCs e entidades).
- `k`, `v`, `z`, `bm`, `cq`, `cs`, `cx`: Telas de inventário, status, magias, diálogos e lojas.

## Áudio e Mídia
- `bq`: Gerenciador de áudio (`implements d`), responsável por carregar e reproduzir faixas via `javax.microedition.media.Manager`.
- Arquivos de som em `snd/b` e `snd/e`.

## Persistência e Save Game (RMS)
- `rpg.b`: Gerenciador de slots de gravação e serialização de dados de jogo.
- `ah`: Utilitário de persistência via `RecordStore`.
- `bh`: Leitor/escritor de registros de dados salvos.
