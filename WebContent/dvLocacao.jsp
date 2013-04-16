<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	if (session.getAttribute("login") != null) {
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora de video: Devolver Locação</title>
</head>
<body>
	<center>
		<h1>BEM VINDO A DEVOLUCAO DE LOCAÇÃO</h1>
		<hr>
		<script language="JavaScript">
			function ValidaSemPreenchimento(form) {
				if(form.cod.value==""){
					var nome = form.descricao;
					 alert ("Por favor digite tudo em CPF");
					 return false;
				}
				return true;
			}
		</script>
		<form action="LocacaoServlet" method="post" onSubmit="return ValidaSemPreenchimento(this)"s>
			<br> <br> <br> DIGITE O CPF DO CLIENTE <input
				type="text" name="cod" descricao="CPF"> <br>
			<br> <select name="multa">
				<option value="0">AUTOMÁTICO</option>
				<option value="1">SEM MULTA</option>
				<option value="2">MULTA BRANDA</option>
				<option value="3">MULTA SEVERA</option>
			</select> <input type="hidden" name="flag" value="devolver"> <input
				type="submit" name="Envia" value="Enviar"> <input type="reset" value="Limpar" />

		</form>
		<br> <br> <br> <br> <br> <br> <br>
		<%
			String msg = (String) request.getAttribute("locacao");
				if (msg != null) {
		%>
		<h2>
			<font color="red"> <%=msg%>
			</font>
		</h2>
		<%
			}
		%>
		<br> <br> <br> <br> <br> <br> <br>
		<br> <a href="menu.jsp" title="index">Voltar ao Menu</a><br>
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