<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	if (session.getAttribute("login") != null) {
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora de video: Cadastro de Funcionários</title>
</head>
<body>
	<center><img src="imagens/func.jpeg" width="85" height="85">
		<h1>Bem vindo ao Cadastro de Funcionário</h1>
		<hr>
		<script language="JavaScript">
			function ValidaSemPreenchimento(form) {
				if(form.nome.value==""){
					 alert ("Por favor preencha o campo Nome");
					 return false;
				}
				if(form.cpf.value==""){
					 alert ("Por favor preencha o CPF (sem pontos)");
					 return false;
				}
				if(form.login.value==""){
					 alert ("Por favor forneça o login desejado para o Funcionário");
					 return false;
				}
				if(form.senha.value==""){
					 alert ("Por favor forneça uma senha para o Funcionário");
					 return false;
				}				
				if(form.logradouro.value==""){
					 alert ("Por favor preencha o campo Logradouro");
					 return false;
				}	
				if(form.numero.value==""){
					 alert ("Por favor forneça o numreo da residência");
					 return false;
				}	
				if(form.cep.value==""){
					 alert ("Por favor forneça o CEP (sem hífen)");
					 return false;
				}	
				return true;
			}
		</script>	
		<form action="FuncionarioServlet" method="post" onsubmit="return ValidaSemPreenchimento(this)">
			<br>
			<br> Nome <input type="text" size="70" name="nome"> *<br>
			<br> CPF <input type="text" maxlength=11 name="cpf"> * (sem pontos)<br>
			<br> Logradouro <input type="text" size="70" name="logradouro"> *
			Nº <input type="text" size="4" name="numero"> *<br>
			<br> Bairro <input type="text" name="bairro"><br>
			<br> Cidade <input type="text" name="cidade"><br>
			<br> CEP <input type="text" maxlength=8 name="cep"> * (sem hífen)<br>
			<br> Email <input type="text" size="40" name="email"><br>
			<br> Fone(DDD) <input type="text" maxlength=11 name="fone"><br>
			<br> Celular(DDD) <input type="text" maxlength=11 name="cel"><br>
			<br> Login <input type="text" maxlength=10 name="login"> *
			Senha <input type="password" maxlength=6 name="senha"> *<br>
			<br> <input type="submit" name="botaoCad" value="Cadastrar...">
			<input type="reset" value="Limpar" />
		</form>
		<%
			if (request.getAttribute("cadastro") != null) {
		%>
		<h4>
			<font color="red"> <%=request.getAttribute("cadastro")%>
			</font>
		</h4>

		<%
			}
		%>
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