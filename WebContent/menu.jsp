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
<title>Menu Locadora</title>
</head>
<body>

<h3>Sua sessao expira em <%=session.getMaxInactiveInterval()/3600 %> minutos</h3>
<center>
		<h1>PROJETO LOCADORA DE V�DEO</h1>
		<hr>
		<h2>Escolha uma op��o...</h2>

			1 - <a href="cadDVD.jsp"> Cadastrar DVD </a> 
			2 - <a href="pesqDVD.jsp"> Pequisar DVD</a> 
			3 - <a href="removDVD.jsp">	Remover DVD</a>
		    4 - <a href="DvdServlet"> Listar DVD's</a><br><br><br>
		    5 - <a href="cadCliente.jsp"> Cadastrar Cliente</a> 
		    6 -	<a href="pesqCliente.jsp"> Pesquisar Cliente </a> 
		    7 - <a	href="removCliente.jsp"> Remover Cliente</a>
		    8 - <a	href="ClienteServlet"  > Listar Clientes</a><br><br><br>
		    9 - <a href="cadlocacao.jsp"> Realizar Loca��o</a>
		    10 - <a	href="removLocacao.jsp"> Remover Loca��o</a>
		    11 - <a	href="dvLocacao.jsp"> Devolu��o de Loca��o</a> 
		    12 - <a	href="LocacaoServlet"> Listar Loca��es</a><br><br><br>
		    13 - <a href="cadPromocao.jsp"> Cadastrar Promo��o</a><br><br><br>
		    14 - <a href="cadFunc.jsp" > Cadastrar Funcion�rio</a>
		    15 - <a href="FuncionarioServlet"> Listar Funcion�rios</a>
		<br>
		<br>
		<br>
		<br>
		<hr>
		<br>
		<a href="index.jsp" title="index" ><h3>Sair e logar com outro
				usu�rio</h3></a>
	</center>


</body>
</html>

<%
	
	} else {
%>
	<jsp:forward page="index.jsp"></jsp:forward>
<%
}
%>