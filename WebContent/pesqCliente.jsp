<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	if(session.getAttribute("login") != null) {
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora de video: Pesquisar Cliente</title>
</head>
<body>
	<center><img src="imagens/cliente.jpeg" width="85" height="85">
		<h1>Bem vindo à Pesquisa de Cliente</h1>
		<hr>
		<script language="JavaScript">
			function ValidaSemPreenchimento(form) {
				if(form.arg.value=="Pesquisar..."){
					form.arg.value==''; 
					return true;
				}
									
				return true;
			}
			
			
		</script>
		<form action="ClienteServlet" method="post" onSubmit="if(this.value=='Pesquisar...') this.value=' '">
			<br>
			<br> Digite o CPF do Cliente 
				<select name="indicador">
						<option  value="CPF" > CPF</option>
						<option  value="Nome" > NOME</option>
				</select>
				<input type="text" maxlength=11 name="arg" value="Pesquisar..." onclick="this.value= ''" onblur="if(this.value=='') this.value='Pesquisar...'">
				<input type="submit" value="Enviar" name="Enviar">
				<input type="reset" value="Limpar"  />
				

			<input type="hidden" name="flag" value="pesquisar">

		</form>


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