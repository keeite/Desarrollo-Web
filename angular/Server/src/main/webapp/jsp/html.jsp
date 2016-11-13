<%-- 
    Document   : html
    Created on : 13-nov-2016, 2:23:11
    Author     : Dani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi Server</title>
    </head>
    <body>
        <h1><%=request.getAttribute("title")%></h1>
        <p><%=request.getAttribute("message")%></p>
    </body>
</html>
