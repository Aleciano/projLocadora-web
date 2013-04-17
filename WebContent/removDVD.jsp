<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	if(session.getAttribute("login") != null) {
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora de video: Remover DVD </title>
</head>
<body>
	<center><img src="imagens/dvd.jpg" width="85" height="85">
		<h1>Bem vindo a Remoção de DVD</h1>
		<hr>
		<script language="JavaScript">
			function ValidaSemPreenchimento(form) {
				if(form.cod.value==""){
					 alert ("Você quer que eu adivinhe qual DVD você quer remover??");
					 return false;
				}
									
				return true;
			}
		</script>		
		<form action="DvdServlet" method="post" onsubmit="return ValidaSemPreenchimento(this)">
			<br> <br> <br> Digite o código do DVD <input
				type="text" name="cod"> <input type="submit"
				name="botaoRemov" value="Remover..."> <input type="reset"
				value="Limpar" />
				<input type="hidden" name="flag" value="remover">
		</form>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
 	<% String msg = (String)request.getAttribute("dvd");		
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