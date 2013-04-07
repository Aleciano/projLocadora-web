<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
	ArrayList<String> lista = (ArrayList<String>)request.getAttribute("lista");
	String tlista = (String) request.getAttribute("tipo");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista</title>
</head>
<body>
<h2>Lista de <%=tlista %></h2><br>
<% for(String s : lista) {%>
	<center>
		<h4 >
			<font color="blue">  <%= s %>     </font>	
		</h4>
	</center>
	<%} %>
	
	<center> <a href="menu.jsp"><font color="green" >VOLTAR AO MENU</font> </a> </center>
</body>
</html>