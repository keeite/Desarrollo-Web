<%-- 
    Document   : pedidos
    Created on : 19-oct-2016, 2:59:43
    Author     : Dani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="js/controller.js" type="text/javascript"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Pedidos</title>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Mi tienda</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="shop.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Productos</a></li>
                    <li><a href="carrito.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Carrito</a></li>
                    <li class="active"><a href="#"><span class="glyphicon glyphicon-log-out"></span> Pedidos</a></li>
                    <li><a href="javascript:closeSession()"><span class="glyphicon glyphicon-log-out"></span> Salir</a></li>
                </ul>
            </div>
        </nav>
        <section class="container">
            <section class="row">
                <article class="col-md-12">
                    <table class="table table-striped"
                           <thead>
                            <tr>
                                <th>Nº Pedido</th>
                                <th>Fecha</th>
                                <th>Nª articulos</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody id="pedidos">  
                        
                        </tbody>
                    </table>
                    <script>getCheckouts();</script>
                </article>
            </section>
        </section>
    </body>
</html>
