<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	if (session.getAttribute("login") != null) {
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora de video: Gerenciar Locaçoes</title>
</head>
<body>

	<%
		String promocao = (String) request.getAttribute("promocao");
			if (promocao != null) {
	%>
	<h3>
		Promocão: <font color="red">   <%= promocao %> </font>
	</h3>
		<h3>Tudo por: <font color="red"> <%= request.getAttribute("valor") %> </font></h3>
	<%
		}
	%>

	<center>
		<h1>BEM VINDO AO REGISTRO DE LOCAÇÃO</h1><hr><br><br>
		<form action="LocacaoServlet" method="post">

			CPF DO CLIENTE <input type="text" name="cpf"><br><br><br><br>
			MATRICULA DO FUNCIONARIO <input type="text" name="mat"><br><br><br><br>
			ID DO PRODUTO <input type="text" name="id"><br><br><br><br>
			<input type="hidden" name="flag" value="locar">	
			<input type="reset" value="limpar">
			<input type="submit" value="locar">			
		</form>
			<br><br><br><br><br>
		<a href="menu.jsp"><font color="green" face="Georgia, Arial">VOLTAR AO MENU</font> </a> 
		<%
 			String msg = (String) request.getAttribute("locacao");
 				if (msg != null) {
 		%>
<h2><font color="red"> <%=msg%> </font></h2>
<%
	}
%>
  
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