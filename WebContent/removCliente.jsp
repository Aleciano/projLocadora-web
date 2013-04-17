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
<script language="JavaScript">
			function ValidaSemPreenchimento(form) {
				if(form.cpf.value==""){
					 alert ("Por favor preencha o CPF");
					 return false;
				}
				
				
					
				return true;
			}
			function SomenteNumero(e){
			    var tecla=(window.event)?event.keyCode:e.which;   
			    if((tecla>47 && tecla<58)) return true;
			    else{
			    	if ((tecla == 8) || (tecla == 13) || (tecla == 9) || (tecla == 46)) return true;
					else  return false;
			    }
			}
		</script>
	<center><img src="imagens/cliente.jpeg" width="85" height="85">
		<h1>Bem vindo a Remoção de Cliente</h1>
		<hr>

		<form action="ClienteServlet" method="post" onSubmit="return ValidaSemPreenchimento(this)">
			<br>
			<br>
			<br> Digite o CPF do Cliente <input type="text" maxlength=11
				name="cpf" onkeypress='return SomenteNumero(event)' value="" onblur="if(this.value=='') this.value=''"> <input type="submit" name="botaoPesqcpf"
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