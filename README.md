projLocadora-web
================

O Reposit�rio do projeto da disciplina de Programa��o Web.
:
:Dicas para usar o GitHub com o Eclipse:

I. Clonando (baixando o projeto pela primeira vez) via Eclipse � s� importar um projeto e informar que � do tipo Git. O eclipse pedir� uma URI, ent�oo v� at� a p�gina do projeto no Github e copie o link SSH (clique neles que mudar�o no box). Clique duplo em URI, o eclipse capturar� o conte�do na �rea de transfer�ncia, em Connection marque ssh. Embaixo h� um usu�rio, deixe git mesmo e sem senha. Se der certo, o eclipse ir� pedir a frase que voc� passou ao criar as chaves. Abrir� um marcador com o nome 'master', d� Next duas vezes. O eclipse ir� pedir para criar outra senha, bote algo que deseje. Da� para frente � como importar um projeto normal no Eclipse. Ao fechar o assistente, ao lado do projeto ter� um nome como: projLocadora-web master.

II. Dando o commit e salvando no reposit�rio do Github. O commit � como preparar os arquivos para serem upados, depois atrav�s do push � que eles s�o enviados de fato para o site. H� como fazer os dois de uma s� vez, e � da seguite forma: Clique com o bot�o direito na raiz do projeto e depois Team e depois commit. Na janela que abre, h� uma caixa de texto para se comentar o motivo do commit (obrigat�rio), embaixo os arquivos que voc� alterou. Se clicar em Commit and Push, ser�o enviados ao servidor. Se suas credenciais tiverem sem problemas, vai abrir uma janela Push Results, da� clique em OK e pronto. Olhe na p�gina web do projeto e veja se tem um commit recente.
.
III. Para sincronizar com as mudan�as que est�o aplicadas no reposit�rio da web, bot�o direito na raiz do projeto, menu Team, depois Syncronize. Ser� aberta uma nova perspectiva do Eclipse e na aba do lado esquerdo aparecer�o os arquivos com novidades. Clique duplo sobre elas para visualizar a diferen�as. No lado direito ficar� a vers�o do reposit�rio web e na esquerda a sua vers�o local. Da� para ver as diferen�as e verificar se realmente o Egit verificou o reposit�rio web. �s vezes s� pega na 2� Syncronize. Se voc� quiser aceitar todas as mudan�as, clique com o direito na raiz do projeto e Merge. Poderia ser Overwrite, mas para garantir que suas altera��es N�o comitadas sejam perdidas, o merge faz essa mixagem entre a sua vers�o local e a vers�o da web. Nesta situa��o, se ocorrerem conflitos, � mais minuncioso e chato para resolv�-los.

Funcionalidades OK
================

-Cadastrar todas as coisas

-Listando tudo menos as loca�oes ??

-Buscando v�rias entidades pelo nome, ou pelo id quando � o caso.

-Sess�es com JSP??
