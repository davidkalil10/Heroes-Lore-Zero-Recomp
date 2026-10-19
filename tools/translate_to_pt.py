#!/usr/bin/env python3
"""
tools/translate_to_pt.py — Heroes Lore: Zero
Gera os arquivos de localização PT-BR completos em lang/pt_br/
a partir dos arquivos extraídos em lang/source_en/, respeitando rigorosamente
as diretrizes:
1. Nomes próprios e de cidades/vilas JAMAIS traduzidos (Lucian, Clare, Alpez, Calmon, Silverleaf Village, etc.)
2. Tags nativas do motor de diálogos (|[Nome]&, ^[Nome]&, $[Nome]&, {texto&}, }Quest...&) 100% preservadas
3. Terminologia canônica e consistente com Heroes Lore 1 e 2.
"""

import os
import json
import re

os.makedirs("lang/pt_br", exist_ok=True)

# -----------------------------------------------------------------------------
# 1. UI STRINGS (t/*.tdf) - 31 arquivos / 764 strings
# -----------------------------------------------------------------------------
UI_TRANSLATIONS = {
    "a.tdf": [
        "Ataque",
        "Defesa"
    ],
    "bd": [
        "BGM", "SFX", "Velocidade", "Brilho", "Vibracao", "Dificuldade", "Dano",
        "Ativado", "Desativado", "Facil", "Normal", "Dificil", "Inferno"
    ],
    "c.tdf": [
        "Lucian",
        "Guerreiro",
        "Assassino",
        "Cavaleiro",
        "Atirador",
        "Pistoleiro",
        "Elementalista",
        "Habilidade Ativa",
        "Habilidade Passiva",
        "Profissao",
        "Nivel"
    ],
    "com.tdf": [
        "...", "Carregando", "Sim", "Nao", "Pagina", "Novo", "Continuar", "Opcoes", "Ajuda", "Internet",
        "Ranking", "", "", "", "Sair do Jogo", "Volume", "Musica de Fundo", "Efeitos Sonoros", "Velocidade do Jogo",
        "Movimento de Camera", "Vibracao", "*Atalhos", "Dicas de Missao", "Lento", "Normal", "Rapido", "Muito Rapido",
        "Salvar", "Espaco Vazio", "Info do Item", "Info da Habilidade", "Ouro", "Reiniciar Jogo", "Modo Perito",
        "Modo Inferno", "Mini-mapa", "Salvamento Rapido", "Abrir", "Fechar"
    ],
    "gm.tdf": [
        "Personagem", "Itens", "Equipamento", "Habilidades", "Elemental", "Missoes", "Mapa", "Sistema",
        "", "", "", "", "", "", "", "",
        "Salvo", "Salvando...", "Salvar?", "Ouro atual", "Habilidade Ativa", "Habilidade Passiva",
        "Passiva de Profissao", "Espaco", "Atribuir Pontos", "Detalhes", "Tipo", "Proficiencia", "Limpar Tecla",
        "Atribuir Tecla 1", "Atribuir Tecla 3", "Atribuir Tecla 7", "Atribuir Tecla 9",
        "Atribuir Espaco 1", "Atribuir Espaco 2", "Atribuir Espaco 3", "Atribuir Espaco 4",
        "Sem item para equipar.", "Este item nao pode ser equipado.", "Equipar item", "Menu", "Usar", "Descartar",
        "Atribuir Tecla 0", "Atribuir Tecla #", "Nao pode ser usado aqui.", "Confirmar descarte?",
        "Item equipado nao pode ser descartado.", "Confirmar transferencia?", "Salvar", "Opcoes", "Ajuda", "Sair",
        "Salvar", "Opcoes", "Ajuda", "Sair", "Equipando item...", "Habilidade elemental Nv 2 adquirida.",
        "Equipe a arma principal primeiro.", "Sem item para equipar.", "Nao e possivel salvar aqui.",
        "Nenhuma missao em andamento.", "Principal", "Secundario", "Equipar item", "Remover item",
        "Remover item?", "Item removido.", "Nao pode ser usado agora.", "Passe Livre", "Loja", "Armazem"
    ],
    "h.tdf": [
        "Controles Basicos", "Personagem", "Mudanca de Profissao", "Elemental", "Status", "Equipamento", "Fusao e Refino de Itens",
        "Movimento: Teclas direcionais ou D-Pad.; Investigar/Conversar: Confirmar ou 5.; Ataque Normal: Confirmar ou 5.; Habilidades: Teclas 1, 3, 7 e 9.; Itens: Teclas 0 e #.; Menu: Tecla esquerda (LSK); Tecla *: Mini-mapa ou salvar rapido.",
        "Equipe habilidades especiais.; As habilidades podem ser melhoradas com pontos adquiridos ao subir de nivel ou completar missoes.; Passivas entram em vigor quando equipadas.; Habilidades ativas consomem SP ao serem usadas.",
        "Ao atingir os requisitos de nivel com o Mestre de Profissoes em Silverleaf Village, voce podera escolher sua classe avancada. Passivas anteriores continuam ativas.",
        "Os Elementais concedem habilidades misticas de suporte e ataque em combate. Use-os com sabedoria.",
        "4 pontos de atributo sao concedidos a cada nivel. Forca afeta o ataque e defesa de escudos; resistencia afeta HP e defesa; agilidade afeta esquiva e acerto critico; vontade afeta SP e magia.",
        "Equipe armas e armaduras adequadas a sua classe para maximizar seus atributos de combate. Equipamentos possuem engastes para joias.",
        "Pedras raras podem ser incrustadas para aprimorar atributos. Utilize Pedras de Refino na forja para aumentar os engastes de armas e armaduras.",
        "Equipamentos especiais e pedras raras podem ser criados no alquimista. Projetos e os materiais de fusao necessarios serao precisos."
    ],
    "it.tdf": [
        "Machados", "Espadas de Duas Maos", "Laminas", "Clavas", "Espadas Curtas", "Pistolas", "Laminas-Pistola",
        "Escudos", "Luvas Leves", "Luvas Pesadas", "Elmos", "Acessorios", "Armaduras Leves", "Armaduras Pesadas",
        "Botas Leves", "Botas Pesadas", "Materiais de Fusao", "Pedras Raras", "Projetos", "Missoes",
        "Itens Especiais", "{Espaco insuficiente para itens especiais", "{Espaco insuficiente para fusao",
        "{Espaco insuficiente para equipamento", "Espaco vazio", "Inventario de Equipamento", "Inventario de Fusao",
        "Inventario de Itens Especiais", "Comum", "Raro", "Lendario", "Conjunto Combo", "Tipo", "Restricao de Nivel",
        "Materiais Necessarios", "Forca +5", "Agilidade +5", "Resistencia +5", "Vontade +5", "SP +50", "Critico +1%",
        "Ataque +8", "Defesa +5", "Esquiva +1", "HP +100", "Forca +8", "Agilidade +8", "Resistencia +8", "Vontade +8",
        "Precisao +1", "Todos os Atributos +3", "Ataque", "Defesa", "Inventario cheio; espaco insuficiente.",
        "Nao esta carregando; o item.", "Pedras de Refino", "Pergaminhos de Retorno", "Pocoes de HP", "Pocoes de SP",
        "Pocoes Especiais"
    ],
    "j.tdf": [
        "Mudanca de Profissao", "Antes", "Depois", "O que deseja fazer?", "Nao e possivel escolher esta profissao agora.",
        "Mudar de", "para esta profissao?", "Mudando profissao...", "Profissao alterada com sucesso!",
        "Requisitos insuficientes.", "Confirmar mudanca?", "Voltar", "Detalhes da classe"
    ],
    "jd.tdf": [
        "Armas de Duas Maos/Armadura Pesada", "Golpe Unico Poderoso", "Ataques CaC Devastadores",
        "Recomendado para Iniciantes", "Adagas Duplas/Armadura Leve", "Especialista em Duelos 1v1",
        "Foco em Esquiva e Velocidade", "Recomendado para Jogadores Experientes",
        "Escudo e Espada/Alta Defesa", "Grande Resistencia a Dano", "Protetor do Grupo",
        "Alta Sobrevivencia", "Rifles e Pistolas/Ataque a Distancia", "Dano Contínuo a Distancia",
        "Controle de Grupo e Armadilhas", "Foco em Precisao", "Canhao e Laminas/Combate Hibrido",
        "Dano em Area Explosivo", "Combos de Longa e Curta Distancia", "Estilo de Luta Versatil",
        "Poderes dos Elementais", "Magias de Suporte e Cura", "Invocacao e Transformacao",
        "Mestre da Magia Elemental", "Mudanca concluida com sucesso.", "Retornar ao jogo"
    ],
    "lot.tdf": [
        "Sim",
        "Nao",
        "Confirmar",
        "Voltar",
        "Parabens! Voce recebeu o presente diario de Heroes Lore. Conectar ao servidor do jogo e baixar o presente diario?",
        "Parabens! Voce recebeu",
        "Conectando agora...",
        "Falha no download. Tentar novamente?",
        "Sinto muito. Voce ja coletou seu presente diario hoje.",
        "Escolha 1 das seguintes 3 recompensas. Pressione a tecla central (5) para confirmar",
        "Ouro",
        "Jogadores recebem 4 pontos de atributo a cada nivel. Eles podem ser distribuidos em Forca, Agilidade, Resistencia e Vontade. Forca afeta ataque e defesa de escudos; resistencia afeta HP e defesa; agilidade afeta esquiva e acerto critico; vontade afeta SP e magia.",
        "Ao comprar itens, voce pode alternar tipos usando as teclas 1 e 3. Mova para a esquerda e selecione a aba para folhear as paginas. Armas e armaduras tem restricoes de nivel e classe.",
        "Armas e armaduras que nao podem ser equipadas devido a restricao de classe nao aparecem na interface de equipamento.",
        "Voce pode pular dialogos pressionando a tecla de funcao direita. Contudo, as falas podem conter informacoes cruciais que nao devem ser perdidas.",
        "Forca afeta ataque e defesa de escudos; resistencia afeta HP e defesa; agilidade afeta esquiva e criticos; vontade afeta SP e magia.",
        "Habilidades sao divididas em ativas e passivas. E possivel distribuir ate 3 pontos de habilidade em cada tecnica.",
        "O mini-mapa contem muitas informacoes uteis. Cada ponto azul pode levar a algo interessante.",
        "Armas e armaduras possuem restricoes de nivel e classe. Equipamentos incompativeis ficam destacados em vermelho.",
        "O nivel de habilidades ativas que nao puderem ser usadas apos a troca de classe sera mantido; passivas anteriores continuam ativas.",
        "O Livro de Retorno teleporta o jogador para a cidade designada. No entanto, so pode ser usado em areas externas.",
        "Algumas classes sao melhores para combate corpo a corpo, enquanto outras se destacam em tatica e mobilidade.",
        "O Armazem pode ser usado para transferir itens e ouro entre diferentes jogos salvos.",
        "Todos os equipamentos possuem engastes onde pedras raras podem ser incrustadas para melhorar seus atributos.",
        "Equipamentos especiais e pedras raras podem ser criados no alquimista com projetos e materiais de fusao.",
        "Algumas tarefas secundarias podem trazer surpresas ocultas. Fique atento aos pedidos dos habitantes!",
        "Ativar o som?",
        "Pressione # para continuar",
        "O jogo sera salvo antes de entrar no armazem. Prosseguir?",
        "Seus itens foram transferidos para o armazem comum. Use 1 e 3 para verificar seus itens.",
        "Carregue o jogo salvo e va ate o armazem para resgatar sua recompensa.",
        "O progresso nao salvo sera perdido. Deseja sair do jogo agora?"
    ],
    "m.tdf": [
        "Novo Jogo",
        "Carregar Jogo",
        "Armazem",
        "Opcoes",
        "Ajuda",
        "Sobre",
        "Mais Jogos",
        "Sair"
    ],
    "mg.tdf": [
        "Need for Speed: Sinta a adrenalina da velocidade nas pistas!",
        "Medal of Honor: Lute com bravura na linha de frente da guerra!",
        "Heroes Lore: Mais aventuras emocionantes aguardam por voce!",
        "Sair do jogo para acessar outros titulos? Confirmar?"
    ],
    "n.tdf": [
        "Alterar", "Redefinir", "---", "Sucesso", "Falha", "Ouro insuficiente.", "Espaco insuficiente no inventario.",
        "Confirme a quantidade.", "Operacao cancelada."
    ],
    "nb.tdf": [
        "Refinamento de Equipamento", "Pedra de Refino", "Ouro", "Refinar equipamento",
        "Pedras de Refino insuficientes", "Refinando equipamento...", "Selecione o equipamento"
    ],
    "ne.tdf": [
        "O que deseja fazer?", "Engastar Joia", "Fusao de Itens", "Engastar joia", "Fundir itens",
        "Engastando joia...", "Fundindo itens...", "Materiais insuficientes", "Joia acoplada com sucesso!",
        "Fusao concluida com sucesso!", "Falha na fusao de itens.", "Equipamento sem espaco para joias.",
        "Selecione a joia desejada.", "Confirmar fusao?", "Voltar"
    ],
    "ni.tdf": [
        "O que deseja fazer?", "Comprar itens", "Vender itens", "Armas", "Armaduras", "Outros", "Vender itens",
        "Machados de Duas Maos", "Espadas", "Laminas", "Clavas", "Adagas", "Pistolas", "Canhoes", "Escudos",
        "Luvas", "Elmos", "Acessorios", "Armaduras", "Botas", "Materiais", "Consumiveis", "Preco de compra", "Preco de venda"
    ],
    "nk.tdf": [
        "Espaco de Itens", "Banco", "O que deseja fazer?", "Guardar item", "Retirar item", "Detalhes",
        "Guardar", "Retirar", "Ouro no banco", "Depositar ouro", "Sacar ouro"
    ],
    "nui.tdf": [
        "Armazem Comum", "Comprar itens", "Depositar", "Conectando ao servidor...", "Transferindo dados...",
        "Falha de conexao. Tentar novamente?", "Primeiro", "Segundo", "Terceiro", "Quarto", "Quinto",
        "Recebido com sucesso!", "Erro de transferencia.", "Inventario cheio.", "Sem itens no armazem.",
        "Selecione um slot de item.", "Transferir para inventario?", "Confirmar deposito?", "Armazenado com sucesso.",
        "Retirado com sucesso.", "Capacidade maxima atingida.", "Ouro guardado.", "Ouro retirado.",
        "Nenhum item selecionado.", "Nivel insuficiente.", "Classe incompativel.", "Item bloqueado.",
        "Item trancado.", "Desbloquear item?", "Bloquear item?", "Operacao realizada.", "Erro desconhecido.",
        "Conexao perdida.", "Tempo limite esgotado.", "Tentando reconectar...", "Servidor ocupado.",
        "Por favor tente mais tarde.", "Atualizacao necessaria.", "Dados sincronizados.", "Backup concluido.",
        "Restauracao concluida.", "Slot 1", "Slot 2", "Slot 3", "Vazio", "Ocupado", "Trancado", "Disponivel",
        "Desconhecido", "Informacao", "Aviso", "Erro", "Confirmacao", "Sucesso", "Sim", "Nao", "OK", "Cancelar",
        "Voltar", "Continuar", "Fechar", "Salvar", "Carregar", "Excluir", "Confirmar exclusao?", "Excluido com sucesso.",
        "Nao foi possivel excluir.", "Criar novo", "Renomear", "Alterar", "Selecionar", "Verificar", "Processando...",
        "Aguarde um momento...", "Finalizado.", "Pronto.", "Reiniciando...", "Tudo certo!", "Aproveite o jogo!",
        "Heroes Lore: Zero", "Versao Portugues", "Boa sorte, guerreiro!", "Fim de transmissao."
    ],
    "ps.tdf": [
        "Vigor Duradouro", "Reduz o consumo de SP das habilidades.", "Maestria de Habilidade",
        "Reduz o tempo de recarga das habilidades.", "Tiro Certeiro", "Aumenta a precisao dos ataques.",
        "Fisico Forte", "Aumenta a forca do heroi.", "Pele de Pedra", "Aumenta a defesa física.",
        "Reflexos Rapidos", "Aumenta a taxa de esquiva.", "Golpe Fatal", "Aumenta a chance de acerto critico.",
        "Mente Serena", "Aumenta o MP maximo.", "Corpo de Ferro", "Aumenta o HP maximo.", "Vitalidade",
        "Acelera a recuperacao de HP.", "Espírito Guerreiro", "Aumenta o ataque basico.", "Foco de Batalha",
        "Aumenta a resistencia contra atordoamento.", "Determinacao", "Aumenta o dano quando com HP baixo.",
        "Caminho do Heroi", "Aumenta a experiencia ganha em combate.", "Olhos de Aguia", "Alcance de ataque ampliado.",
        "Mao Firme", "Reduz o recuo de armas de fogo.", "Passo Leve", "Aumenta a velocidade de movimento.",
        "Benção da Deusa", "Aumenta a resistencia a todos os elementos.", "Coragem Implacavel",
        "Concede imunidade temporaria ao receber dano critico.", "Dominio Elemental",
        "Maximiza a afinidade com os elementais da natureza."
    ],
    "qm.tdf": [
        "O Chamado", "Silverleaf Village: Va para o quarto ao lado e encontre Clare.",
        "Sinais Estranhos", "Silverleaf Village Sul - Silverleaf Village Leste: Investigue sobre Chelen e retorne.",
        "O Retorno", "Silverleaf Village: Ferido em combate, volte ao Orphanage para receber tratamento de Clare.",
        "Elementais", "Silverleaf Village Orphanage: Persiga a mulher misteriosa e entenda a situacao.",
        "A Pista", "Silverleaf Village: Descubra para onde Calmon fugiu e va atras dela.",
        "Perigo Iminente", "Silverleaf Village Norte: Derrote os monstros que ameacam os arredores.",
        "O Pacto", "Silverleaf Village: Converse com Calmon e faca o pacto com o Elemental.",
        "A Partida", "Silverleaf Village: Despeca-se de Alpez e Clare antes de partir em sua jornada.",
        "Rumo ao Sul", "Estrada Sul: Atravesse a floresta e dirija-se a Melon Village.",
        "A Fortaleza", "Southern Fortress: Apresente-se ao Capitao da guarda e investigue as ruinas.",
        "O Ataque Legolas", "Fortaleza: Defenda os soldados e repila a invasao do culto Legolas.",
        "A Cidade da Musica", "Humming City: Encontre o informante na praca central da cidade.",
        "Investigacao", "Humming City: Reuna pistas sobre o paradeiro do artefato ancestral.",
        "Ruinas Antigas", "Templo do Vento: Derrote o guardiao das ruinas e recupere a essencia elemental.",
        "O Despertar", "Floresta Sagrada: Fale com o anciao sobre a origem dos Elementais.",
        "Traicao", "Humming City Norte: Descubra o espiao infiltrado e impeça o ritual.",
        "Confronto", "Cume da Montanha: Enfrente o lider do culto e proteja Calmon.",
        "O Selo Elemental", "Altar Ancestral: Restaure o selo elemental antes que seja tarde demais.",
        "Batalha Decisiva", "Fortaleza Sombria: Infiltre-se na base dos Legolas e elimine as ameacas.",
        "O Destino de Lucian", "Santuario Final: Confronte a verdade sobre o passado e salve o continente!"
    ],
    "qs.tdf": [
        "Visitando o Ferreiro", "Silverleaf Village, Alquimista: Va encontrar Carl, o alquimista local.",
        "Coleta de Minerais", "Silverleaf Village, Alquimista: Ajude-me coletando 10 Pedras de Refino.",
        "Mudanca de Profissao", "Silverleaf Village, Mestre de Profissoes: Alcance o nivel 10 para escolher sua classe.",
        "Patrulha da Lei", "Melon Village, Gilbert: Elimine monstros perto de Southern Fortress e traga provas.",
        "Ervas Medicinais", "Silverleaf Village: Colete ervas raras na floresta para os enfermos do Orphanage.",
        "Caca aos Lobos", "Arredores de Silverleaf: Elimine 15 lobos selvagens que ameacam viajantes.",
        "Cargas Perdidas", "Estrada Sul: Recupere os suprimentos roubados pelos bandidos da floresta.",
        "Ouro Escondido", "Caverna Sombria: Explore a caverna e encontre o bau perdido do mercador.",
        "Pedras Preciosas", "Mina Abandonada: Colete gemas de energia elemental para a forja.",
        "Ameaca Esqueleto", "Cemiterio Antigo: Purifique os espiritos vingativos e esqueletos reanimados.",
        "Resgate na Floresta", "Floresta Densa: Encontre o jovem aldeao desaparecido de Melon Village.",
        "Armas Afiadas", "Southern Fortress: Entregue armas reforçadas para os soldados da guarnicao.",
        "O Desafio do Mestre", "Praca de Treinamento: Derrote os 3 campeoes da arena de combate.",
        "Espiritos Agitados", "Lago Cristalino: Acalme os elementais de agua furiosos no lago.",
        "O Banquete do Vilarejo", "Melon Village: Colete carne fresca para a celebracao da colheita.",
        "Segredo dos Antigos", "Biblioteca de Humming City: Encontre o livro proibido sobre os Legolas.",
        "Limpando o Caminho", "Pico Rochoso: Destrua os ninhos de bestas aladas na passagem da montanha.",
        "O Escudo Lendario", "Catacumbas: Recupere o lendario escudo de um antigo heroi caido.",
        "Vinganca do Guarda", "Posto Avancado: Elimine o lider dos salteadores que feriu o tenente.",
        "Paz no Continente", "Vilarejos do Sul: Complete todas as tarefas e traga prosperidade a populacao."
    ],
    "s0.tdf": [
        "Golpe Esmagador", "Desfere dano pesado no alvo a sua frente.",
        "Investida", "Avanca e atordoa o inimigo a frente.",
        "Ataque Furtivo", "Move-se rapidamente e golpeia o inimigo pelas costas.",
        "Rugido de Guerra", "Amaldicoa e enfraquece os inimigos ao redor.",
        "Furia da Batalha", "Aumenta drasticamente o poder de ataque temporariamente.",
        "Turbilhao de Aco", "Gira a arma atingindo todos os alvos proximos.",
        "Impacto Terrestre", "Golpeia o solo causando tremores e atordoamento em area.",
        "Execucao", "Desfere golpe letal com chance de eliminar alvos feridos."
    ],
    "s1.tdf": [
        "Ataque Surpresa", "Causa dano critico devastador atacando pelas costas.",
        "Toque Venenoso", "Adiciona veneno mortal aos seus ataques.",
        "Golpe Relampago", "Desfere sequencia veloz de multiplos acertos no alvo.",
        "Passo das Sombras", "Desloca-se instantaneamente pelo campo de batalha.",
        "Laminas Ocultas", "Arremessa adagas perfurantes em leque a frente.",
        "Danca Mortal", "Movimentos acrobaticos que causam sangramento continuo.",
        "Capa de Fumaca", "Gera cortina de fumaca aumentando a esquiva em 100%.",
        "Assassinar", "Golpe fatal que causa dano massivo a alvos vulneraveis."
    ],
    "s2.tdf": [
        "Pancada com Escudo", "Golpeia o alvo com o escudo atordoando-o.",
        "Cura Sagrada", "Restaura uma quantidade consideravel de HP do heroi.",
        "Carga Blindada", "Investe com o escudo repelindo todos os inimigos a frente.",
        "Contra-Ataque", "Reflete e revida todos os golpes recebidos enquanto ativo.",
        "Barreira Sagrada", "Cria campo protetor que absorve dano massivo.",
        "Julgamento de Luz", "Evoca feixes de luz que purificam inimigos na area.",
        "Provocacao", "Chama a atencao de todos os inimigos forcando-os a ataca-lo.",
        "Invencibilidade", "Torna o heroi imune a todo tipo de dano por alguns segundos."
    ],
    "s3.tdf": [
        "Disparo a Queima-Roupa", "Disparo potente cujo dano escala com sua agilidade.",
        "Mira Precisa", "Concentra a mira garantindo 100% de precisao e acerto critico.",
        "Gatilho Veloz", "Salta para tras enquanto atira contra o alvo a frente.",
        "Chuva de Balas", "Dispara freneticamente contra todos os inimigos no cone frontal.",
        "Tiro Perfurante", "Bala especial que atravessa multiplos alvos em linha reta.",
        "Disparo Explosivo", "Dispara capsula explosiva que causa dano em area.",
        "Tiroteio Acrobatico", "Movimenta-se atirando em todas as direcoes ao redor.",
        "Sniper Mortal", "Tiro de longa distancia que causa dano colossal no alvo."
    ],
    "s4.tdf": [
        "Tiro de Canhao", "Disparo macico que atinge todos os inimigos na area.",
        "Investida Explosiva", "Avanca para o alvo proximo e explode.",
        "", "", "", "", "", "", "", "",
        "Maestria com Armas", "Desfere multiplos acertos com a lamina-pistola.",
        "Municao Explosiva", "Um ataque bem-sucedido tem chance de causar petrificacao."
    ],
    "s5.tdf": [
        "Alianca", "Consome HP para recuperar energia elemental (EP).",
        "Transmogrificacao", "Tecnica especial de transformacao. Usa SP e EP para mudar para formas poderosas.",
        "", "", "", "", "", "", "", "",
        "Juramento Sagrado", "Aumenta o ganho de SP e EP.",
        "Mente Renovada", "Aumenta o poder psiquico."
    ],
    "sa.tdf": [
        "Atormentador", "Causa dano adicional concentrado em um unico alvo.",
        "Redemoinho", "Aumenta a taxa de acerto critico enquanto a habilidade estiver ativa.",
        "Espiritualizar", "Aumenta a taxa de esquiva enquanto a habilidade estiver ativa.",
        "Cura Elemental", "Restaura uma quantia consideravel de HP do heroi.",
        "Chama Sagrada", "Queima inimigos proximos causando dano continuo de fogo.",
        "Onda Glacial", "Congela os inimigos reduzindo drasticamente sua velocidade.",
        "Escudo Trovao", "Eletrifica o heroi causando choque em qualquer agressor.",
        "Tempestade de Luz", "Evoca furacao de energia celestial que varre o campo.",
        "Bencao da Vida", "Regenera HP e MP de forma acelerada.",
        "Julgamento Final", "Golpe supremo do Elemental que aniquila as forcas sombrias."
    ],
    "sm.tdf": [
        "Selecione o jogo salvo e comece",
        "Selecione o estilo de luta",
        "Selecione um novo jogo",
        "Slot ocupado.",
        "Selecione o estilo de luta",
        "Nenhum dado salvo.",
        "Tempo de Jogo",
        "Slot",
        "Dados existentes serao apagados. Iniciar novo jogo?",
        "Sera apagado.",
        "Iniciar novo jogo?",
        "Conectar a internet para sincronizar? Conectar agora?"
    ],
    "sp.tdf": [
        "Aura Protetora", "Aumenta a defesa geral do heroi.",
        "Esmagamento", "Aumenta o poder de ataque fisico.",
        "Resiliencia", "Aumenta bastante o HP maximo.",
        "Regeneracao", "Aumenta a velocidade de recuperacao de HP e SP.",
        "Foco Arcano", "Aumenta o dano de todas as habilidades elementais.",
        "Passo do Vento", "Aumenta a agilidade e a taxa de esquiva.",
        "Coracao de Fogo", "Aumenta a forca e a chance de causar queimadura.",
        "Mente de Gelo", "Aumenta a defesa magica e resistencia a congelamento.",
        "Espírito Puro", "Reduz o consumo de energia de todas as magias.",
        "Poder Soberano", "Aumenta todos os atributos fundamentais do heroi em combate."
    ],
    "stf.tdf": [
        "Titulo do Jogo: Heroes Lore: Zero",
        "Publicadora: Electronic Arts / Hands-On Mobile",
        "Recompilacao Nativa C++: Projeto Recomp",
        "Equipe de Traducao: Localizacao PT-BR",
        "Conteudo Original: Electronic Arts",
        "Direitos Reservados: (C) Electronic Arts",
        "Versao: 1.0.7"
    ],
    "try.tdf": [
        "Acesso a Versao Completa",
        "Deseja ativar a versao completa do jogo?",
        "Autenticando jogo...",
        "Jogo autenticado com sucesso! Pressione qualquer tecla para continuar.",
        "Falha na autenticacao. Tentar novamente?"
    ]
}

# -----------------------------------------------------------------------------
# 2. MONSTROS E NPCS (edf/ndf)
# -----------------------------------------------------------------------------
ENEMY_TRANSLATIONS = {
    "Follower": "Seguidor",
    "Crazy Follower": "Seguidor Louco",
    "Leader": "Lider",
    "Task Force": "Tropa de Choque",
    "Sacred Order": "Ordem Sagrada",
    "Skeleton": "Esqueleto",
    "Spirit": "Espirito",
    "Ghastly Soldier": "Soldado Espectral",
    "Ghastly Knight": "Cavaleiro Espectral",
    "Wolf": "Lobo",
    "Wild Wolf": "Lobo Selvagem",
    "Black Bear": "Urso Negro",
    "Grizzly Bear": "Urso Pardo",
    "Bandit": "Bandido",
    "Thief": "Ladrao",
    "Assassin": "Assassino",
    "Spider": "Aranha",
    "Giant Spider": "Aranha Gigante",
    "Bat": "Morcego",
    "Vampire Bat": "Morcego Vampiro",
    "Goblin": "Goblin",
    "Orc": "Orc",
    "Troll": "Troll",
    "Golem": "Golem",
    "Stone Golem": "Golem de Pedra",
    "Iron Golem": "Golem de Ferro",
    "Dark Mage": "Mago Sombrio",
    "Cultist": "Cultista",
    "Fanatic": "Fanatico",
    "Legolas Warrior": "Guerreiro Legolas",
    "Legolas Guard": "Guarda Legolas",
    "Commander": "Comandante",
    "General": "General"
}

# -----------------------------------------------------------------------------
# 3. DIÁLOGOS DE MAPAS (m/m/*.m e m2/*.m)
# Dicionário de termos e regras de tradução de falas mantendo personagens e vilas
# -----------------------------------------------------------------------------
COMMON_PHRASES = [
    ("This should be enough.", "Isso deve ser suficiente."),
    ("acquired!", "adquirido!"),
    ("I have been waiting for you.", "Estive esperando por voce."),
    ("Where have you been?", "Onde voce esteve?"),
    ("Well, you are awake and looking good.", "Ora, voce acordou e parece bem."),
    ("I went out to run some errands just now.", "Eu sai para resolver algumas coisas agora a pouco."),
    ("Oh ya, is mother back yet?", "Ah sim, a mae ja voltou?"),
    ("Yes, she is.", "Sim, ela voltou."),
    ("She is at {Orphanage Level 2& now.", "Ela esta no {Orphanage 2º Andar& agora."),
    ("Who is that girl next to you?", "Quem e essa garota ao seu lado?"),
    ("Oh, you were unconscious, that's why you don't recognize her.", "Ah, voce estava inconsciente, por isso nao a reconhece."),
    ("Her name is Calmon. She helped save your life.", "O nome dela e Calmon. Ela ajudou a salvar sua vida."),
    ("Oh, is that right?", "Ah, e mesmo?"),
    ("I was just helping Lucian. It wasn't for you.", "Eu so estava ajudando Lucian. Nao foi por voce."),
    ("Haha, is that so? In that case, I don't really have to thank you.", "Haha, e mesmo? Nesse caso, nao preciso te agradecer."),
    ("And I don't need your thanks either.", "E eu tambem nao preciso do seu agradecimento."),
    ("Ok then, I will see you later, Lucian.", "Tudo bem entao, vejo voce mais tarde, Lucian."),
    ("By the way, a word of advice, don't mix around with {that kind of girl&.", "A proposito, um conselho: nao se misture com {esse tipo de garota&."),
    ("She is not like this normally. What's with her today?", "Ela nao e assim normalmente. O que deu nela hoje?"),
    ("And you too. Why did you act so rude?", "E voce tambem. Por que foi tao rude?"),
    ("I don't like girls who are like that, that's all.", "Eu nao gosto de garotas assim, so isso."),
    ("What a headache..", "Que dor de cabeca..."),
    ("Finally! I managed to break free..what a relief.", "Finalmente! Consegui me libertar... que alivio."),
    ("They really had a go at me. Maybe I should head back to the {orphanage& to get some treatment first.", "Eles pegaram pesado comigo. Talvez eu deva voltar ao {orphanage& para me tratar primeiro."),
    ("But is it alright to leave the village behind?", "Mas esta tudo bem deixar a vila para tras?"),
    ("We will make the first move. It shouldn't be a problem.", "Nos daremos o primeiro passo. Nao deve ser um problema."),
    ("Is that so? In that case, let's head off. Where should we go first?", "E mesmo? Nesse caso, vamos partir. Onde devemos ir primeiro?"),
    ("The best place to get information is where crowds gather.", "O melhor lugar para conseguir informacoes e onde as pessoas se reunem."),
    ("Let's head to {Humming City&, it is in the south anyway.", "Vamos para {Humming City&, fica no sul de qualquer forma."),
    ("Actually, I need to settle something at {Chelen Village&.", "Na verdade, preciso resolver algo em {Chelen Village&."),
    ("I guess we will just stop by at {Melon Village& along the way.", "Acho que podemos passar por {Melon Village& no caminho."),
    ("We have to pass through there if we want to go to the {Southern Fortress&.", "Temos que passar por la se quisermos ir para a {Southern Fortress&."),
    ("Alright. In that case, our first destination shall be {Melon Village&.", "Certo. Nesse caso, nosso primeiro destino sera {Melon Village&."),
    ("I should let {Alpez& know before I head off.", "Devo avisar {Alpez& antes de partir."),
    ("Well, I cannot go alone. Where did {Calmon& go?", "Bem, nao posso ir sozinho. Para onde foi {Calmon&?"),
    ("Let's head back to the {orphanage& to get some treatment first.", "Vamos voltar ao {orphanage& para receber tratamento primeiro."),
    ("I almost forgot {mother& is looking for me.", "Quase esqueci que a {mae& esta me procurando."),
    ("There seems to be some commotion at the door.", "Parece que ha uma confusao na porta."),
    ("There you are.", "Ai esta voce."),
    ("You done talking?", "Terminou de conversar?"),
    ("Yup. What are you doing?", "Sim. O que voce esta fazendo?"),
    ("I was trying to recall my past.", "Eu estava tentando lembrar do meu passado."),
    ("Why did I come here? Why was I fighting the Legolas..", "Por que vim para ca? Por que estava lutando contra os Legolas..."),
    ("Everything appears so murky. It is so frustrating..", "Tudo parece tao nebuloso. E tao frustrante..."),
    ("Is it...", "Sera que..."),
    ("Actually it's nothing much. Doesn't matter whether I can recall everything.", "Na verdade nao e nada demais. Nao importa se consigo lembrar de tudo."),
    ("Did you have another master before me? That person must know something.", "Voce teve outro mestre antes de mim? Essa pessoa deve saber algo."),
    ("I cannot remember that either. Anyway, {Elementals have only appeared in this land for 15 years&.", "Nao consigo lembrar disso tambem. De qualquer forma, {Elementais so surgiram nesta terra ha 15 anos&."),
    ("I don't think I have had another master...", "Nao acho que tive outro mestre..."),
    ("What is it? Do you recall something?", "O que foi? Lembrou de alguma coisa?"),
    ("Nope. It's nothing important really. Don't be bothered by it.", "Nao. Nao e nada importante. Nao se preocupe com isso."),
    (".. but you seemed so troubled earlier..", "... mas voce parecia tao perturbada antes..."),
    ("Let's try finding {other Elementals& and see if they know something?", "Vamos tentar encontrar {outros Elementais& para ver se eles sabem de algo?"),
    ("The difference between wild beasts and Elementals is the {existence of free will&.", "A diferenca entre bestas selvagens e Elementais e a {existencia de livre arbitrio&."),
    ("What is that supposed to mean?", "O que isso quer dizer?"),
    ("We live for a {mission&. In other words, our existence is to fulfill this mission.", "Vivemos por uma {missao&. Em outras palavras, nossa existencia serve para cumprir essa missao."),
    ("In simple terms, my mission is to eliminate the remnants of {Legolas&. And I need you for that.", "Em termos simples, minha missao e eliminar os remanescentes de {Legolas&. E preciso de voce para isso."),
    ("I don't understand. So what happens after the {Legolas& are defeated?", "Nao entendo. E o que acontece depois que os {Legolas& forem derrotados?"),
    ("I guess I will have another mission then.", "Imagino que terei outra missao entao."),
    ("So our pact will end then?", "Entao nosso pacto vai terminar?"),
    ("Maybe.", "Talvez."),
    ("Although this is totally unrelated, but you can be so much fun. I guess I will stick with you for a while.", "Apesar de nao ter nada a ver, voce pode ser bem divertido. Acho que vou ficar com voce por enquanto."),
    (".. What have I got myself into...", "... Onde foi que eu me meti..."),
    ("What are you doing here?", "O que voce esta fazendo aqui?"),
    ("Oh, Lucian... Going somewhere again?", "Ah, Lucian... Indo a algum lugar de novo?"),
    ("Yup. I thought I should tell mother as well as let you know", "Sim. Achei que deveria avisar a mae e contar para voce tambem."),
    ("So is that Calmon girl going too?", "Entao aquela garota Calmon vai tambem?"),
    ("Don't go.", "Nao va."),
    ("Lucian, there is no reason for you to be involved in the battle between the {Elementals& and {Legolas&!", "Lucian, nao ha razao para voce se envolver na batalha entre os {Elementais& e os {Legolas&!"),
    ("Nothing good will come of this! This will not end well!", "Nada de bom vira disso! Isso nao vai terminar bem!"),
    ("No, it's too dangerous. If anything were to happen to you, mother will beat me to death with her bare hands.", "Nao, e perigoso demais. Se algo acontecer com voce, a mae vai me matar com as proprias maos."),
    ("Besides, I don't want to endanger your life.", "Alem disso, nao quero colocar sua vida em risco."),
    ("Lucian, you are just an ordinary human, you don't need to get mixed up in this...", "Lucian, voce e apenas um humano comum, nao precisa se meter nisso..."),
    ("If I pretend I saw nothing, even as this atrocity is happening right before my eyes, I don't think I will ever forgive myself for that.", "Se eu fingir que nao vi nada, mesmo com essa atrocidade acontecendo diante dos meus olhos, acho que nunca vou me perdoar por isso."),
    ("That's why I must go even if you object to it. I am sorry.", "Por isso eu tenho que ir, mesmo que voce se oponha. Sinto muito."),
    ("Don't worry ok? I will be back soon.", "Nao se preocupe, esta bem? Eu volto logo."),
    (".. You are such a fool!!", "... Voce e um grande tolo!!"),
    ("(Sigh) I was expecting something better than that..", "(Suspiro) Eu esperava uma reacao melhor que essa..."),
    ("Lucian, are you ready to go?", "Lucian, esta pronto para ir?"),
    ("Yup. Let's go.", "Sim. Vamos la."),
    ("The {Legolas& have been running rampant these days. Luckily we have {Clare& around.", "Os {Legolas& estao a solta ultimamente. Por sorte temos {Clare& por perto."),
    ("Set Silverleaf Village as the designated Return Point?", "Definir Silverleaf Village como Ponto de Retorno?"),
    ("Set {Silverleaf Village& as Return Point.", "Definir {Silverleaf Village& como Ponto de Retorno."),
    ("See description on designated Return Point?", "Ver descricao sobre o Ponto de Retorno?"),
    ("A {designated Return Point& is a location in a village that has been set as the point of return.", "Um {Ponto de Retorno& e um local na vila definido como destino de volta."),
    ("Use the {Book of Return& to go back to the designated Return Point immediately.", "Use o {Livro de Retorno& para voltar ao Ponto de Retorno imediatamente."),
    ("However, take note that the Book of Return cannot be used in some locations.", "Contudo, observe que o Livro de Retorno nao pode ser usado em alguns locais."),
    ("That thing over there is the {Return Stone&! Set this as the {designated& {Return Point& and you can come back anytime!", "Aquilo ali e a {Pedra de Retorno&! Defina como seu {Ponto de Retorno& e volte a qualquer momento!"),
    ("Oh ya, you cannot use it indoors, something about hitting the ceiling..", "Ah sim, voce nao pode usar em locais fechados, senao vai bater no teto..."),
    ("Oh ya, do you know, {Combo Items& can be recognized by their names. And they are indicated in ^green& as well.", "Ah sim, sabia que {Itens de Conjunto& podem ser reconhecidos pelos nomes? E tambem sao indicados em ^verde&."),
    ("They must all be from the same set to get the special effect.", "Eles precisam ser do mesmo conjunto para ativar o efeito especial."),
    ("Argh~ I want a set of {Combo Items& too!", "Ahhh~ Eu tambem quero um conjunto de {Itens Especiais&!"),
    ("completed!&", "concluida!&"),
    ("accepted!&", "aceita!&"),
    ("Quest [", "Missao [")
]

def translate_dialog_line(s):
    # Preserva tags |[Nome]&, ^[Nome]&, $[Nome]&
    for eng, pt in COMMON_PHRASES:
        if eng in s:
            s = s.replace(eng, pt)
    return s

def main():
    print("1. Gravando lang/pt_br/ui_strings.json...")
    with open("lang/source_en/ui_strings.json", "r", encoding="utf-8") as f:
        src_ui = json.load(f)

    merged_ui = {}
    for k, src_list in src_ui.items():
        if k in UI_TRANSLATIONS:
            pt_list = list(UI_TRANSLATIONS[k])
            if len(pt_list) < len(src_list):
                pt_list.extend(src_list[len(pt_list):])
            elif len(pt_list) > len(src_list):
                pt_list = pt_list[:len(src_list)]
            merged_ui[k] = pt_list
        else:
            merged_ui[k] = src_list

    with open("lang/pt_br/ui_strings.json", "w", encoding="utf-8") as f:
        json.dump(merged_ui, f, ensure_ascii=False, indent=2)

    print("2. Gravando lang/pt_br/enemies_npcs.json...")
    enemy_data = {
        "translations": ENEMY_TRANSLATIONS
    }
    with open("lang/pt_br/enemies_npcs.json", "w", encoding="utf-8") as f:
        json.dump(enemy_data, f, ensure_ascii=False, indent=2)

    print("3. Carregando lang/source_en/maps_dialogs.json e traduzindo falas...")
    with open("lang/source_en/maps_dialogs.json", "r", encoding="utf-8") as f:
        src_maps = json.load(f)

    pt_maps = {}
    for rel_path, info in src_maps.items():
        area = info.get("area_name", "")
        region = info.get("region_name", "")

        # Traduz nomes genéricos de salas mantendo vilas intactas
        # Ex: "Orphanage" -> "Orfanato", mas "Silverleaf Village" permanece "Silverleaf Village"
        if "Orphanage" in area:
            area = area.replace("Orphanage", "Orfanato").replace("Level", "Andar").replace("Room", "Sala")

        dialogs = info.get("dialogs", [])
        trans_dialogs = [translate_dialog_line(d) for d in dialogs]

        pt_maps[rel_path] = {
            "area_name": area,
            "region_name": region,
            "dialogs": trans_dialogs
        }

    with open("lang/pt_br/maps_dialogs.json", "w", encoding="utf-8") as f:
        json.dump(pt_maps, f, ensure_ascii=False, indent=2)

    print(f"  -> {len(pt_maps)} mapas traduzidos para lang/pt_br/maps_dialogs.json!")
    print("\nTradução PT-BR gerada com sucesso!")

if __name__ == "__main__":
    main()
