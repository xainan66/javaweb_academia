<%-- 
    Document   : login
    Created on : 28-ene-2014, 9:58:40
    Author     : postal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="cabecera.jsp" />
        <form name="login" action="servlet_login" method="POST">
            <input type="text" name="usuario" value="" size="20" /><br>
            <input type="password" name="clave" value="" size="20" /><br>
            <input type="submit" value="Enviar" name="enviar" />
        </form>
        <jsp:include page="pie.html" />    
    </body>
</html>
