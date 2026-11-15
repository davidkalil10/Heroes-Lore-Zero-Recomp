# Heroes Lore Zero — Switch 2 experimental

Build separada para kaiHEN/ounce-hbmenu. O código do jogo, formato RMS e funções de backup/restauração Google Drive são preservados. O NRO original de Switch 1 continua sendo compilado pelo workflow multiplataforma existente.

## Compilar pelo GitHub Actions

O workflow **Experimental Nintendo Switch 2 NRO** usa a imagem `devkitpro/devkita64:20260219`, o instalador ounce-devkit na revisão `0f38ba80d7ee768c5749278f127749d14ece2036` e o SDK `20261115`, cujo SHA-256 é conferido pelo instalador. Não usa o HEAD do SDK nem a imagem `latest`.

Na branch `codex/switch2-action`, mudanças nos arquivos relevantes disparam a compilação experimental. Há também `workflow_dispatch` para execução manual quando o workflow estiver disponível no GitHub. O workflow não publica releases, não altera tags e não modifica os workflows das outras plataformas.

O artefato `heroes_lore_zero_switch2_nro` contém o NRO, SHA-256 e relatório da compilação. O NRO inclui ícone, NACP e RomFS. O artefato de logs é preservado separadamente, inclusive em falhas.

## Diferenças da build

`Makefile.switch2` usa as regras `libounce/switch2_rules` e `SWITCH2_CPU`, com saída `heroes_lore_zero_switch2.nro` e objetos em `build_switch2`. As regras do SDK priorizam as bibliotecas Switch 2/OunceVK, mantendo as portlibs de Switch 1 compatíveis para SDL2, áudio e rede. As bibliotecas gráficas legadas têm aliases de compatibilidade fornecidos pelo SDK.

O atualizador reconhece `__SWITCH2__` e procura apenas `heroes_lore_zero_switch2.nro`, para não substituir a build experimental pelo NRO de Switch 1. A inicialização de rede, autenticação Google Drive, backup, restauração e formatos dos saves permanecem no programa. Não há desativação dessas funções para compilar.

## Saves e validação

Os arquivos `HOL.*.rms`, o pacote `heroes_lore_zero_save.json` e os caminhos de armazenamento existentes são preservados. Isso mantém o contrato de dados, mas ainda é necessário validar os serviços de rede e a leitura/escrita no SDK novo. Antes do teste, guarde cópias dos saves locais e do backup na nuvem. Use progresso de teste para confirmar salvar, fechar/reabrir, enviar backup, restaurar e carregar o progresso.

O NRO homebrew usa saves RMS no SD e Google Drive. Esse fluxo é distinto dos arquivos Account/Device de jogos instalados manipulados pelo módulo de saves do NS2ToolKit.

## Testar no kaiHEN

Com hbmenu já aberto, ative Netloader e envie o NRO com nxlink no PC, usando o IP exibido pelo console. O RomFS acompanha o NRO. O envio não exige reabrir SmileBASIC ou repetir a conexão do toolkit. Logs deste programa vão para `sdmc:/heroes_lore_boot.log`, conforme o código existente; stdout pelo nxlink ainda não foi integrado.

Validação da compilação confirma formato e presença dos recursos, não jogabilidade ou compatibilidade completa. Verificar abertura, imagem, controles, áudio, saves, backup/restauração Google Drive e retorno ao hbmenu.

Créditos: [ounce-devkit](https://github.com/ouncebrew/ounce-devkit), [libounce](https://github.com/ouncebrew/libounce), [OunceVK](https://github.com/ouncebrew/ouncevk), [kaiHEN](https://github.com/ouncebrew/kaihen), devkitPro e contribuidores.
