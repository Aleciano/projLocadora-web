<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	if(session.getAttribute("login") != null) {
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora de video: Cadastro de Clientes</title>
</head>
<body>
	<center>
		<h1>Bem vindo ao Cadastro de Cliente</h1>
		<hr>

		<form action="ClienteServlet" method="post">
			<br>
			<br> Nome <input type="text" size="70" name="nome"><br>
			<br> CPF <input type="text" maxlength=11 name="cpf"><br>
			<br> Logradouro <input type="text" size="70" name="logradouro">
			N� <input type="text" size="4" name="numero"><br>
			<br> Bairro <input type="text" name="bairro"><br>
			<br> Cidade <input type="text" name="cidade"><br>
			<br> CEP <input type="text" maxlength=8 name="cep"><br>
			<br> Email <input type="text" size="40" name="email"><br>
			<br> Fone(DDD) <input type="text" maxlength=11 name="fone"><br>
			<br> Celular(DDD) <input type="text" maxlength=11 name="cel"><br>
			<br> <input type="submit" name="botaoCad" value="Cadastrar...">
			<input type="reset" value="Limpar" />
			<input type="hidden" name="flag" value="cadastrar">
		</form>


		
	<%
		if(request.getAttribute("cad") != null){
	%>
	<h4><font color="red"> <%=request.getAttribute("cad") %> </font></h4>
	
	<% }%>
		
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