<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina de login</title>
</head>
<body>
	<center>
		<h1>Bem vindo ao acesso da Locadora de video</h1>
		<hr>
		<font color="green">
			<h2>Por favor Funcionario, entre com sua Identificação</h2>
		</font>
		<form action="LoginServlet" method="post">
			<table border=1 bgcolor=#00FFFF>
				<tr>
					<td>Login</td>
					<td><input type=text name="login" size=30 maxlength=10></td>
				</tr>
				<tr>
					<td>Senha</td>
					<td><input type=password  name="pass" size=6 maxlength=6></td>
				</tr>
				<td>
				<input type="submit" name="enviar" value="Enviar">
				</td>
			</table>
		</form>
	</center>
</body>
</html>