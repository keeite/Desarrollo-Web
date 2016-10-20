<%-- 
    Document   : shop
    Created on : 11-oct-2016, 23:08:56
    Author     : Dani
--%>

<%@page import="net.ausiasmarch.carritogson.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario user = (Usuario) request.getSession().getAttribute("user");
    if (user == null) {
        response.sendRedirect("index.jsp");
    }    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="js/path.min.js" type="text/javascript"></script>
        <script src="js/controller.js" type="text/javascript"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Shop</title>
    </head>
    <body>
         <jsp:include page="nav.jsp" />
        <section class="container">
            <article class="row" id="stock">
                <script>fillStock();</script>
            </article>      
        </section>
    </body>
</html>
