<%-- 
    Document   : index
    Created on : 28-ene-2014, 9:17:37
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

        <a href="servlet_acceder">Acceder</a><br>
        <% HttpSession htsession = request.getSession(true);
        if(session.getAttribute("usuario")==null) { %>
        <a href="login.jsp">Login</a><br>
        <a href="registro.jsp">Registro</a>
        <% } %>
    </body>
</html>
