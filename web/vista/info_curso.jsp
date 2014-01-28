<%-- 
    Document   : info_curso
    Created on : 28-ene-2014, 12:45:53
    Author     : postal
--%>

<%@page import="modelo.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../cabecera.html" />
        <% Curso curso = (Curso)request.getAttribute("curso");
            String nombre = curso.getNombre();
            int duracion = curso.getDuracion();
            double precio = curso.getPrecio();
        %>
        <span>Curso: </span><%= nombre %>
        <span>Duracion: </span><%= duracion %>
        <span>Precio: </span><%= precio %>
        <jsp:include page="../pie.html" />
    </body>
</html>
