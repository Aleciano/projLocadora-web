<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	if(session.getAttribute("login") != null) {
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remover Locacao</title>
</head>
<body>
	<center>
		<h1>Bem vindo a Remocao de Locacao</h1>
		<hr>
		<form action="LocacaoServlet" method="post">
			<br> <br> <br> 
			Digite o codigo da locacao <input type="text" name="cod"> 
			<input type="submit" name="botaoRemov" value="Remover..."> 
			<input type="reset"	value="Limpar" />
			<input type="hidden" name="flag" value="remover">
		</form>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
 	<% String msg = (String)request.getAttribute("locacao");		
		if ( msg != null ) 	{
	%>
	<h2><font color="red"> <%=msg %> </font></h2>
	<%} %>
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