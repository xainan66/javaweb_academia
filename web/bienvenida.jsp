<%-- 
    Document   : bienvenida
    Created on : 29-ene-2014, 9:46:42
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
        <jsp:include page="cabecera.jsp" />
        <% HttpSession sesion = request.getSession();
            String usuario = (String)sesion.getAttribute("usuario"); %>
            <div>Bienvenido <%= usuario %></div>
            
        <jsp:include page="pie.html" />
    </body>
</html>
