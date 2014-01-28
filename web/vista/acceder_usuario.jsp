<%-- 
    Document   : acceder
    Created on : 28-ene-2014, 9:26:44
    Author     : postal
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Curso" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <jsp:include page="../cabecera.jsp" />
    <form name="info_curso" action="servlet_info_curso">
        <table border="1" width="100%">
            <tr>
               <th>Curso</th>
               <th>Duracion</th>
               <th>Precio</th>
            </tr>

            <%  Curso curso;
                List<Curso> listaCursos = (List)request.getAttribute("listaCursos");
                for(int i=0;i<listaCursos.size();i++) {
                curso = listaCursos.get(i);
                %>
            <tr>
               <td style="display:none"><input type="hidden" name="idCurso" value="<%= curso.getId() %>" /></td>
               <td><%= curso.getNombre() %></td>
               <td><%= curso.getDuracion() %></td>
               <td><%= curso.getPrecio() %></td>
               <td width="50"><input type="submit" value="Entrar" name="entrar" /></td>
            </tr>
            <% } %>
                
        </table>
    </form>
    <jsp:include page="../pie.html" />
    </body>
</html>
