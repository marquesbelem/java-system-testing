#language: pt

Funcionalidade: CRUD de Processos

  Contexto:
    Dado que o usuario esta na pagina inicial
    E que o usuario clica no menu processos
    E o usuario clica no botao Novo Processo
    E  o usuario informar "processo_vara" com o valor igual a "Vila Prudente"
    E  o usuario informar "processo_numero_processo" com o valor igual a "43"
    E  o usuario informar "processo_natureza" com o valor igual a "Civil"
    E  o usuario informar "processo_partes" com o valor igual a "Camila X Gabriel"
    E  o usuario selecionar "processo_urgente" com o valor igual a "Não"
    E  o usuario escolher "processo_arbitramento_s" com o valor igual a "Sim"
    E  o usuario informar "processo_assistente_social" com o valor igual a "Camila"
    E  o usuario informar "processo_data_entrada" com o valor igual a "15-10-2020"
    E  o usuario informar "processo_data_saida" com o valor igual a "20-10-2020"
    E  o usuario informar "processo_data_agendamento" com o valor igual a "21-10-2020"
    E  o usuario informar "processo_status" com o valor igual a "Aguardando"
    E  o usuario informar "processo_observacao" com o valor igual a "Gostaria que desse prioridade para o horario de manha"


  @PodeRodar
  Cenario: Adicionar um novo processo - CRIAR
    Quando o usuario clicar no botao de salvar
    Então o usuario deveria ver a mensagem "Processo foi criado com sucesso."

  Esquema do Cenario: Selecionar o Processo criado
    E pegar o codigo do processo salvo
    E clicar em voltar para Processos
    Quando clicar em Mostrar no processo que foi criado
    Então o sistema deve apresentar o valor de processo "<process>"
    E o valor de Vara "<vara>"
    E o valor de natureza "<natureza>"
    E o valor de partes "<partes>"
    Exemplos:
      |process  |vara     |natureza|partes|
      |5         |Vila Prudente |Civil   |Camila X Gabriel|

  Cenario: Editar um novo processo - EDITAR
    E o usuario clicar no botao de salvar
    E o usuario clicar no botão voltar
    E o usuario clica no botao editar do processo cadastrado
    E o usuario informar "processo_natureza" com o valor igual a "Guarda" na tela de edicao
    Quando o usuario clicar no botao de salvar na tela de edicao
    Então o usuario deveria ver o valor "Guarda" no campo "natureza"

  Cenario: Excluir um processo - EXCLUIR
    E pegar o codigo do processo salvo
    E clicar em voltar para Processos
    Quando clicar em Apagar
    E clicar em sim no alerta de confirmação
    Então não deve exibir o processo no grid
