<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	if(session.getAttribute("login") != null) {
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora de video: Remover Cliente </title>
</head>
<body>
	<center>
		<h1>Bem vindo a Remoção de Cliente</h1>
		<hr>

		<form action="ClienteServlet" method="post">
			<br>
			<br>
			<br> Digite o CPF do Cliente <input type="text" maxlength=11
				name="cpf"> <input type="submit" name="botaoPesqcpf"
				value="Remover..."> <input type="reset" value="Limpar" /><br>
				<input type="hidden" name="flag" value="remover">


		</form>


		<br>
		<br>
		<br>
		<br>
	<%
		if(request.getAttribute("remv") != null){	
	%>
		<h3>  <font color="red"> <%=request.getAttribute("remv") %> </font> </h3>
	<% } %>	
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