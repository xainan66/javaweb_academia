<%-- 
    Document   : error
    Created on : 28-ene-2014, 13:24:13
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
        <jsp:include page="../cabecera.jsp" />
        <h3>ERROR: </h3><%= request.getAttribute("msg") %>
        <jsp:include page="../pie.html" />
    </body>
</html>
