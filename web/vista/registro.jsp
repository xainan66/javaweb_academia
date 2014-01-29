<%-- 
    Document   : registro
    Created on : 28-ene-2014, 9:58:48
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
        <form name="registro" action="/javaweb_academia/servlet_registro" method="POST">
            <span>Nombre </span><input type="text" name="nombre" value="" size="20" /><br>
            <span>Clave </span><input type="password" name="clave" value="" size="20" /><br>
            <span>Usuario</span><input type="text" name="usuario" value="" size="20" /><br>
            <span>Correo</span><input type="text" name="correo" value="" size="20" />
            <input type="submit" value="Enviar" name="enviar" />
        </form>
    </body>
</html>
