<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	if (session.getAttribute("login") != null) {
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora de video: Cadastro de DVDs</title>
</head>
<body>
	<center>
		<h1>Bem vindo ao Cadastro de DVD</h1>
		<hr>

		<%
			String msg = (String) request.getAttribute("cadastro");
				if (msg != null) {
		%>
		<h2>
			<font color="red"> <%=msg%>
			</font>
		</h2>
		<%
			}
		%>
		<form action="DvdServlet" method="post">
			<br>Título <input type="text" name="titulo"><br> <br>
			Classificacao <select name="genero">
				<option value="filme">Filme</option>
				<option value="show">Show</option>
				<option value="infantil">Infantil</option>
			</select> <br> <br> Qde Disc <select name="qt">
				<option value="">---</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select><br> <br> Duração(Minutos) <input type="text"
				name="duracao"><br> <br> <br> Sinopse
			<textarea name="sinopse" onclick="this.value= '';">Resumo do dvd....</textarea>
			<br> <br> <br> Qde de Cópias <select name="qtcopias">
				<option value="">---</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select><br> <br> <input type="submit" name="botaoCad"
				value="Cadastrar..."> <input type="reset" value="Limpar" />
			<br> <br> <br> <br> <a href="menu.jsp"
				title="index">Voltar ao Menu</a><br> <input type="hidden"
				name="flag" value="cadastrar">
	</form>
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