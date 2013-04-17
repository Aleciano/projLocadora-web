<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
	if(session.getAttribute("login") != null) {
// 		session.setMaxInactiveInterval(10800);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora de video: Menu</title>
<style type="text/css">
#popup {
	position: fixed;
	top: 76%;
	left: 75%;
	margin: -75px 0 0 -150px;
	width: 300px;
	height: 170px;
	padding: 15px;
	border: solid 1px #331;
	background: #ffffd0;
	display: none;
}
</style>
<script type="text/javascript">
	function fechar() {
		document.getElementById('popup').style.display = 'none';
	}

	function abrir() {
		document.getElementById('popup').style.display = 'block';
		setTimeout("fechar()", 10000);
	}
</script>
</head>
<body>

<center>
		<h1>PROJETO LOCADORA DE VÍDEO</h1>
		<hr>
		<h2>Escolha uma opção...</h2>

			1 - <a href="cadDVD.jsp"> Cadastrar DVD </a> 
			2 - <a href="pesqDVD.jsp"> Pequisar DVD</a> 
			3 - <a href="removDVD.jsp">	Remover DVD</a>
		    4 - <a href="DvdServlet"> Listar DVD's</a><br><br><br>
		    5 - <a href="cadCliente.jsp"> Cadastrar Cliente</a> 
		    6 -	<a href="pesqCliente.jsp"> Pesquisar Cliente </a> 
		    7 - <a	href="removCliente.jsp"> Remover Cliente</a>
		    8 - <a	href="ClienteServlet"  > Listar Clientes</a><br><br><br>
		    9 - <a href="cadlocacao.jsp"> Realizar Locação</a>
		    10 - <a	href="dvLocacao.jsp"> Devolução de Locação</a> 
		    11 - <a	href="LocacaoServlet"> Listar Locações</a><br><br><br>
		    12 - <a href="cadPromocao.jsp"> Cadastrar Promoção</a><br><br><br>
		    13 - <a href="cadFunc.jsp" > Cadastrar Funcionário</a>
		    14 - <a href="FuncionarioServlet"> Listar Funcionários</a>
		<br>
		<br>
		<br>
		<br>
		<hr>
		<br>
		<h3><a href="LoginServlet" title="index" >Sair e logar com outro usuário</a></h3>
	</center>
	

	<div align="right"><a href="javascript:abrir();">Sobre o sistema</a></div>
	<DIV id="popup" class="popup">Desenvolvido entre Março e Abril de 2013 com o objetivo de obter nota parcial na disciplina de Desenvolvimento Web, Prof. Cesar Rocha.<br><br><b>Leonardo Vidal<br>Tercio Barbosa<br>Aleciano Júnior</b></DIV>
	
</body>
</html>

<%
	
	} else {
%>
	<jsp:forward page="index.jsp"></jsp:forward>
<%
}
%>