<%@ page isErrorPage="true" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Locadora de video: Recurso inexistente</title>
    </head>
    <body>
    <center>
        <h2>Recurso n�o encontrado <br/></h1>
        <p>Voc� tentou acessar um recurso inv�lido ou que n�o existe mais.</p>
        <p>C�digo do erro: ${pageContext.errorData.statusCode}
        <br><br><%out.print("<a href=\"mailto:"+this.getServletContext().getInitParameter("emailsadmin")+"\">Informe ao administrador</a>"); %>
        <br> <br>
		<a href="menu.jsp" title="index">Voltar ao Menu</a><br>
        </center>
    </body>
</html>
