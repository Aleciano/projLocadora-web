<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	if(session.getAttribute("login") != null) {
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de DVD</title>
</head>
<body>
	<center>
		<h1>Bem vindo ao Cadastro de DVD</h1>
		<hr>


		<form action="DvdServlet" method="post">
			<br>Título <input type="text" name="titulo"><br>
			<br>
			<br> Gênero <input type="text" name="genero"><br>
			<br>
			<br> Qde Disc <select name="qt">
				<option value="">---</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select><br> <br>
			<br> Duração(Minutos) <input type="text" name="duracao"><br>
			<br>
			<br> Sinopse
			<textarea name="sinopse">Resumo do dvd....</textarea>
			<br>
			<br>
			<br> Qde de Cópias <select name="qtcopias">
				<option value="">---</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select><br>
			<br> <input type="submit" name="botaoCad" value="Cadastrar...">
			<input type="reset" value="Limpar" /> <br>
			<br>
			<br> <br>
			<a href="menu.html" title="index">Voltar ao Menu</a><br>
			<input type="hidden" name="flag" value="cadastrar">
	</center>
	</form>
</body>
</html>

<%
	
	} else {
%>
	<jsp:forward page="index.jsp"></jsp:forward>
<%
}
%>