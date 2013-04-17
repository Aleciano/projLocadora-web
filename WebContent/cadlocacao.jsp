<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	if (session.getAttribute("login") != null) {
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora de video: Gerenciar Locaçoes</title>
<style type="text/css">
#popup {
	position: fixed;
	top: 67%;
	left: 75%;
	margin: -75px 0 0 -150px;
	width: 300px;
	height: 180px;
	padding: 15px;
	border: solid 1px #331;
	background: #ffffd0;
	display: none;
}
</style>
</head>
<body>
	<script language="JavaScript">
		function ValidaSemPreenchimento(form) {
			if (form.cpf.value == "") {
				alert("Por favor o CPF do cliente");
				return false;
			}
			if (form.mat.value == "") {
				alert("Por favor fornece a matrícula do funcionário");
				return false;
			}

			if (form.id.value == "") {
				alert("Por favor forneça o id do produto	");
				return false;
			}

			return true;
		}
		function SomenteNumero(e) {
			var tecla = (window.event) ? event.keyCode : e.which;
			if ((tecla > 47 && tecla < 58))
				return true;
			if ((tecla == 8) || (tecla == 13) || (tecla == 9))
				return true;
			else
				return false;

		}
		function fechar() {
			document.getElementById('popup').style.display = 'none';
		}

		function abrir() {
			document.getElementById('popup').style.display = 'block';
			setTimeout("fechar()", 10000);
		}
	</script>

	<center>
		<img src="imagens/fitas.jpg" width="75" height="75">
		<h1>BEM VINDO AO REGISTRO DE LOCAÇÃO</h1>
		<hr>
		<br>
		<br>
		<form action="LocacaoServlet" method="post"
			onSubmit="return ValidaSemPreenchimento(this)">

			CPF DO CLIENTE <input type="text" name="cpf"
				onkeypress='return SomenteNumero(event)' value=""
				onblur="if(this.value=='') this.value=''"><br>
			<br>
			<br>
			<br> MATRICULA DO FUNCIONÁRIO <input type="text" name="mat"
				onkeypress='return SomenteNumero(event)' value=""
				onblur="if(this.value=='') this.value=''"><br>
			<br>
			<br>
			<br> ID DO PRODUTO <input type="text" name="id"
				onkeypress='return SomenteNumero(event)' value=""
				onblur="if(this.value=='') this.value=''"><br>
			<br>
			<br>
			<br> <input type="hidden" name="flag" value="locar"> <input
				type="reset" value="limpar"> <input type="submit"
				value="locar">
		</form>
		<br>
		<br>
		<br>
		<br>
		<br> <a href="menu.jsp"><font color="green"
			face="Georgia, Arial">VOLTAR AO MENU</font> </a>
		<%
			String msg = (String) request.getAttribute("locacao");
				if (msg != null) {
		%>
		<h2>
			<font color="red"> <%=msg%>
			</font>
		</h2>
		<%
			}
		%>
		<%
			String promocao = (String) request.getAttribute("promocao");
				if (promocao != null) {
					
		%>

		<div align="center"><a href="javascript:abrir();"><h3>>> Promoção obtida << </h3></a></div>
		<DIV id="popup" class="popup">
			<h3>
				<img src="imagens/promocao.jpg" width="85" height="85"><br>
				Promocão: <font color="red"> <%=promocao%>
				</font>
			</h3>
			<h3>
				Tudo por: <font color="red"> <%=request.getAttribute("valor")%>
				</font> Promocão: <font color="red"> <%=promocao%>
				</font></h3>
		</DIV>
		
		<%
			}
		%>
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