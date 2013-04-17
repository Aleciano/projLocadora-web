<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	if (session.getAttribute("login") != null) {
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora de video: Cadastro de Clientes</title>
</head>
<body>
	<center>
		<img src="imagens/cliente.jpeg" width="85" height="85">
		<h1>Bem vindo ao Cadastro de Cliente</h1>
		<hr>
		<script language="JavaScript">
			function ValidaSemPreenchimento(form) {
				if(form.nome.value==""){
					 alert ("Por favor preencha o nome");
					 return false;
				}
				if(form.cpf.value==""){
					 alert ("Por favor preencha o CPF");
					 return false;
				}
				if(form.logradouro.value==""){
					 alert ("Por favor preencha o Logradouro");
					 return false;
				}
				if(form.numero.value==""){
					 alert ("Por favor preencha o numero da residência");
					 return false;
				}
				
				
				if(form.cidade.value==""){
					 alert ("Por favor forneça o nome da Cidade");
					 return false;
				}
				if(form.fone.value==""){
					 alert ("Por favor forneça o numero do telefone residencial");
					 return false;
				}
				
					
				return true;
			}
			function SomenteNumero(e){
			    var tecla=(window.event)?event.keyCode:e.which;   
			    if((tecla>47 && tecla<58)) return true;
			    else
			    	if ((tecla == 8) || (tecla == 13) || (tecla == 9) || (tecla == 71) || (tecla ==75) || (tecla == 77) || (tecla == 79)){ return true;}
			    	else { if((tecla>35 && tecla<40)) return true;}
			    	return false;
			    
			}
		</script>
		<form action="ClienteServlet" method="post"
			onSubmit="return ValidaSemPreenchimento(this)">
			<br> <br> Nosme <input type="text" size="70" name="nome">
			*<br> <br> CPF <input type="text" maxlength=11 name="cpf"
				onkeypress='return SomenteNumero(event)' value=""
				onblur="if(this.value=='') this.value=''"> * (sem pontos)<br>
			<br> Logradouro <input type="text" size="70" name="logradouro">
			Nº <input type="text" size="4" name="numero"
				onkeypress='return SomenteNumero(event)' value=""
				onblur="if(this.value=='') this.value='456'"> *<br> <br>
			Bairro <input type="text" name="bairro"><br> <br>
			Cidade <input type="text" name="cidade"> *<br> <br>
			CEP <input type="text" maxlength=8 name="cep"
				onkeypress='return SomenteNumero(event)' value=""
				onblur="if(this.value=='') this.value='' * (sem hífen)"><br>
			<br> Email <input type="text" size="40" name="email"><br>
			<br> Fone(DDD) <input type="text" maxlength=11 name="fone"
				onkeypress='return SomenteNumero(event)' value=""
				onblur="if(this.value=='') this.value=''"> *<br> <br>
			Celular(DDD) <input type="text" maxlength=11 name="cel"
				onkeypress='return SomenteNumero(event)' value=""
				onblur="if(this.value=='') this.value=''"><br> <br>
			<input type="submit" name="botaoCad" value="Cadastrar..."> <input
				type="reset" value="Limpar" /> <input type="hidden" name="flag"
				value="cadastrar">
		</form>



		<%
			if (request.getAttribute("cad") != null) {
		%>
		<h4>
			<font color="red"> <%=request.getAttribute("cad")%>
			</font>
		</h4>

		<%
			}
		%>

		<br> <br> <a href="menu.jsp" title="index">Voltar ao
			Menu</a><br>
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