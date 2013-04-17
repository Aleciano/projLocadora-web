<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	if (session.getAttribute("login") != null) {
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora de video: Cadastro de DVDs</title>
</head>
<body>
	<center><img src="imagens/dvd.jpg" width="85" height="85">
		<h1>Bem vindo ao Cadastro de DVD</h1>
		<hr>
		<script language="JavaScript">
			function ValidaSemPreenchimento(form) {
				if(form.titulo.value==""){
					 alert ("Por favor preencha o Título do DVD");
					 return false;
				}
				if(form.duracao.value==""){
					 alert ("Por favor preencha a duração do DVD");
					 return false;
				}
				if(form.duracao.value=="Minutos"){
					 alert ("Por favor preencha a duração do DVD");
					 return false;
				}
				if(form.qt.value==""){
					 alert ("Por favor preencha a quantidade de mídias");
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
		<%
			String msg = (String) request.getAttribute("cadastro");
				if (msg != null) {
		%>
		<h2>
			<font color="red"> <%=msg%>
			</font>
		</h2>
		<%
			}
		%>
		<form action="DvdServlet" method="post" onSubmit="return ValidaSemPreenchimento(this)">
			<br>Título <input type="text" name="titulo" > *<br> <br>
			Classificacao <select name="genero">
				<option value="filme">Filme</option>
				<option value="show">Show</option>
				<option value="infantil">Infantil</option>
			</select> <br> <br> Qde Disc <select name="qt">
				
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select><br> <br> Duração(Minutos) <input type="text"
				name="duracao" onkeypress='return SomenteNumero(event)' value="Minutos" onclick="this.value=''" onblur="if(this.value=='') this.value='Minutos'"> *<br> <br> <br> Sinopse
			<textarea name="sinopse" onclick="this.value= '';">Resumo do dvd....</textarea>
			<br> <br> <br> Qde de Cópias <select name="qtcopias">
				
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select><br> <br> <input type="submit" name="botaoCad"
				value="Cadastrar..."> <input type="reset" value="Limpar" />
			<br> <br> <br> <br> <a href="menu.jsp"
				title="index">Voltar ao Menu</a><br> <input type="hidden"
				name="flag" value="cadastrar">
	</form>
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