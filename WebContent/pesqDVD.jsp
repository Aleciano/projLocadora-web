<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	if(session.getAttribute("login") != null) {
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora de video: Pesquisar DVD </title>
</head>
<body>

	<center><img src="imagens/dvd.jpg" width="85" height="85">
		<h1>Bem vindo a Pesquisa de DVD</h1>
		<hr>
		<form action="DvdServlet" method="post">
			<br> (Deixe em branco para ver todos os DVDs)<br><br> Digite o T�tulo do DVD <input
				type="text" name="nome"> <input type="submit"
				name="botaoPesq" value="Pesquisar..."> <input type="reset"
				value="Limpar" />
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