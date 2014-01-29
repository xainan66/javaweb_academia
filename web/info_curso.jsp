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
        <jsp:include page="cabecera.jsp" />
        <% Curso curso = (Curso)request.getAttribute("curso");
            String nombre = curso.getNombre();
            int duracion = curso.getDuracion();
            double precio = curso.getPrecio();
        %>
        <div>Curso: </div><%= nombre %>
        <div>Duracion: </div><%= duracion %>
        <div>Precio: </div><%= precio %>
        <form name="matricula" action="servlet_matricula">
            <input type="hidden" name="idCurso" value="<%= curso.getId() %>" />
            <input type="submit" value="Matricular" name="enviar" />
        </form>
        <div><a href="servlet_acceder">Volver</a></div>
        <jsp:include page="pie.html" />
    </body>
</html>
