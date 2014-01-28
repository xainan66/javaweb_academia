<%-- 
    Document   : cabecera
    Created on : 28-ene-2014, 13:28:51
    Author     : postal
--%>

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ACADEMIA LOGOS</h1>
        <% HttpSession htsession = request.getSession(true);
        if(session.getAttribute("usuario")!=null) {
            Usuario usuario = (Usuario)session.getAttribute("usuario");%>
            <h3>Bienvenido <%= usuario.getNombre() %> <span><a href="/javaweb_academia/servlet_salir">(Salir)</a></span></h3>
        <% } %>
    </body>
</html>
