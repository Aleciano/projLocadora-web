<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	if (session.getAttribute("login") != null) {
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Promoção</title>
</head>
<body>

	<center>
		<h1>Bem vindo ao Cadastro de Promoção</h1>
		<hr>

		<form action="LocacaoServlet" method="post">
			<br>
			<br>
			<br>
			Digite o nome da Promoção <input type="text" size="30" maxlength=20 name="nome"><br><br> 
			Valor R$ <input	type="text" size="5" name="valor"> <br><br>
			Dia <input type="text" size="2" maxlength="2" name="dia"> 
			mes <input type="text" size="2" maxlength="2" name="mes">
			ano <input type="text" size="4" maxlength="4" name="ano"> <br> <br>
			<input type="reset" value="Limpar" />
			<input type="hidden" name="flag" value="promocao" >
			<input type="submit" name="botaoCadPromocao" value="Cadastrar...">


		</form>
		
		<br>
		<%
			String msg = (String) request.getAttribute("promocao");
				if (msg != null) {
		%>
		<h2>
			<font color="red"> <%=msg%>
			</font>
		</h2>
		<%
			}
		%>
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