<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora de video: Login</title>
</head>
<body>
	<center>
		<h1>Bem vindo ao acesso da Locadora de video</h1>
		<hr>
		<h2>
			<font color="green"> Por favor Funcionario, entre com sua
				Identificação </font>
		</h2>
		
		<form action="LoginServlet" method="post">
			<table border=1 bgcolor=#00FFFF>
				<tr>
					<td>Login</td>
					<td><input type=text name="login" size=30 maxlength=10></td>
				</tr>
				<tr>
					<td>Senha</td>
					<td><input type=password name="pass" size=6 maxlength=6></td>
				</tr>
				<tr>
					<td><input type="submit" name="enviar" value="entrar">
					</td>
				</tr>
			</table>

			<%
				if (request.getParameter("erro") != null) {
			%>
			<h2>
				<font color="red"> Login Inválido!!! </font>
			</h2>
			<h3>Tente novamente.</h3>
			<%
				}
			%>
		</form>
	</center>
</body>
</html>