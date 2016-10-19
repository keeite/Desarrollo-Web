<%-- 
    Document   : shop
    Created on : 11-oct-2016, 23:08:56
    Author     : Dani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Boolean isloged =(Boolean) request.getSession().getAttribute("isloged");
    if(isloged == null) response.sendRedirect("index.jsp");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="js/controller.js" type="text/javascript"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Shop</title>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Mi tienda</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="shop.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Productos</a></li>
                    <li><a href="carrito.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Carrito</a></li>
                    <li><a href="pedidos.jsp"><span class="glyphicon glyphicon-log-out"></span> Pedidos</a></li>
                    <li><a href="javascript:closeSession()"><span class="glyphicon glyphicon-log-out"></span> Salir</a></li>
                </ul>
            </div>
        </nav>
        <section class="container">
            <article class="row" id="stock">
                <script>fillStock();</script>
            </article>      
        </section>
    </body>
</html>
