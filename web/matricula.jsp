<%-- 
    Document   : matricula
    Created on : 29-ene-2014, 11:35:45
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
        <% 
            String usuario = (String)session.getAttribute("usuario");
            String curso = (String)request.getAttribute("curso"); %>
            <h5>El usuario <%= usuario %> se ha matriculado en el curso <%= curso %></h5>
            <jsp:include page="pie.html" />
    </body>
</html>
