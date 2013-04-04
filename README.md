projLocadora-web
================

O Repositório do projeto da disciplina de Programação Web.
:
:Dicas para usar o GitHub com o Eclipse:

I. Clonando (baixando o projeto pela primeira vez) via Eclipse é só importar um projeto e informar que é do tipo Git. O eclipse pedirá uma URI, então vá até a página do projeto no Github e copie o link SSH (clique neles que mudarão no box). Clique duplo em URI, o eclipse capturará o conteúdo na área de transferência, em Connection marque ssh. Embaixo há um usuário, deixe git mesmo e sem senha. Se der certo, o eclipse irá pedir a frase que você passou ao criar as chaves. Abrirá um marcador com o nome 'master', dê Next duas vezes. O eclipse irá pedir para criar outra senha, bote algo que deseje. Daí para frente é como importar um projeto normal no Eclipse. Ao fechar o assistente, ao lado do projeto terá um nome como: projLocadora-web master.

II. Dando o commit e salvando no repositório do Github. O commit é como preparar os arquivos para serem upados, depois através do push é que eles são enviados de fato para o site. Há como fazer os dois de uma só vez, e é da seguite forma: Clique com o botão direito na raiz do projeto e depois Team e depois commit. Na janela que abre, há uma caixa de texto para se comentar o motivo do commit (obrigatório), embaixo os arquivos que você alterou. Se clicar em Commit and Push, serão enviados ao servidor. Se suas credenciais tiverem sem problemas, vai abrir uma janela Push Results, daí clique em OK e pronto. Olhe na página web do projeto e veja se tem um commit recente.
.
III. Para sincronizar com as mudanças que estão aplicadas no repositório da web, botão direito na raiz do projeto, menu Team, depois Syncronize. Será aberta uma nova perspectiva do Eclipse e na aba do lado esquerdo aparecerão os arquivos com novidades. Clique duplo sobre elas para visualizar a diferença. No lado direito ficará a versão do repositório web e na esquerda a sua versão local. Dá para ver as diferenças e verificar se realmente o Egit verificou o repositório web. Às vezes só pega na 2º Syncronize. Se você quiser aceitar todas as mudanças, clique com o direito na raiz do projeto e Merge. Poderia ser Overwrite, mas para garantir que suas alterações NÃO comitadas sejam perdidas, o merge faz essa mixagem entre a sua versão local e a versão da web. Nesta situação, se ocorrerem conflitos, é mais minuncioso e chato para resolvê-los.

Funcionalidades OK
================

-Cadastrar Cliente, Funcionário, DVDs, Multa, Tipo de Locação(??)

-Listar DVDS, inclusive locados e não locados

-Fazer locação setando data de entrega, especificando valor através de TipoLocacao, setando DVD como Locado.

-Verificando se DVD está locado ou não, caso esteja, não é mostrado como disponível.

-Fazendo devolução de DVD com multa calculada através dos dias que se passaram.

-Buscando várias entidades pelo nome, ou pelo id quando é o caso.
