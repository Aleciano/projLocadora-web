<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	if(session.getAttribute("login") != null) {
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Finalizar Locações em Aberto</title>
</head>
<body>

	<center>
		<img src="imagens/fitas.jpg" width="75" height="75">
		<h2>ESCOLHA AS LOCAÇÕES DESEJA FINALIZAR</h2><hr><br>
		<% ArrayList<String> locacoes = (ArrayList<String>)request.getAttribute("locacoes");%>
		<h2> <font color="blue"> <%=locacoes.get(0) %></font> </h2>
		<form action="LocacaoServlet" method="post">
		
			
			<%    for (int i = 1 ; i < locacoes.size()-1; i++ ){ %>
		 <font color="gray"> <%=locacoes.get(i)%> </font> 
		<input type="radio" name="encerrar" value="<%=locacoes.get(i) %>"> <br>
		<% } %>
		<input type="hidden" name="flag" value="encerrar">
		<input type="submit" value="Encerrar">
	<h2>	<font color="blue"><%= locacoes.get(locacoes.size() - 1) %> </font></h2>
		</form>
		<br><br>
	
	<a href="dvLocacao.jsp" >Devolução de locacao</a><br>
	
	
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