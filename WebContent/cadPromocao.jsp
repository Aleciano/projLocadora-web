<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
	if(session.getAttribute("login") != null) {
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Promo��o</title>
</head>
<body>

	<center>
		<h1>Bem vindo ao Cadastro de Promo��o</h1>
		<hr>

		<form action="nome do servlet" method="post">
			<br>
			<br>
			<br> Digite o nome da Promo��o <input type="text" size="30"
				maxlength=20 name="nome"><br> Valor R$ <input
				type="text" size="5" maxlength=1 name="valor"> <input
				type="submit" name="botaoCadPromocao" value="Cadastrar...">
			<input type="reset" value="Limpar" />


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
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
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