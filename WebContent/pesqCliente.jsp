<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	if(session.getAttribute("login") != null) {
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pesquisar Cliente</title>
</head>
<body>
	<center>
		<h1>Bem vindo a Pesquisa de Cliente</h1>
		<hr>

		<form action="ClienteServlet" method="post">
			<br>
			<br>
			<br> Digite o CPF do Cliente <input type="text" maxlength=11
				name="cpf"> <input type="submit" name="botaoPesqcpf"
				value="Pesquisar..."> <input type="reset" value="Limpar" /><br>
			OU<br> Digite o nome do Cliente <input type="text" size="50"
				name="nome"> <input type="submit" name="botaoPesqNome"
				value="Pesquisar..."> <input type="reset" value="Limpar" />
			<input type="hidden" name="flag" value="pesquisar">

		</form>


		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br> <br>
		<a href="menu.jsp" title="index">Voltar ao Menu</a><br>
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