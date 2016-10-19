<%-- 
    Document   : carrito
    Created on : 16-oct-2016, 15:44:09
    Author     : Dani
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.ausiasmarch.carritogson.model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Boolean isloged = (Boolean) request.getSession().getAttribute("isloged");
    if (isloged == null) {
        response.sendRedirect("index.jsp");
    }
    List<Producto> carro = (ArrayList<Producto>) request.getSession().getAttribute("carro");
    
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
        <title>Carrito</title>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Mi tienda</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="shop.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Productos</a></li>
                    <li class="active"><a href="carrito.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Carrito</a></li>
                    <li><a href="pedidos.jsp"><span class="glyphicon glyphicon-log-out"></span> Pedidos</a></li>
                    <li><a href="javascript:closeSession()"><span class="glyphicon glyphicon-log-out"></span> Salir</a></li>
                </ul>
            </div>
        </nav>
        <section class="container">
            <article class="row">
                <div class="col-md-12 well"><h1 class="text-center">Carrito</h1></div>
            </article>   
        </section>
        <section class="container" id="content">
            <article class="row">
                <section class="col-md-12">
                    <table class="table table-striped"
                           <thead>
                            <tr>
                                <th>Producto</th>
                                <th>Cantidad</th>
                                <th>Precio/ud</th>
                                <th>Precio total</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody id="carro">
                            <% if (carro != null) {
                                    for (Producto p : carro) {%>
                            <tr id="tr<%= p.getId()%>">
                                <td><%= p.getDesc()%></td>
                                <td><%= p.getAmount()%></td>
                                <td><%= p.getPrice()%></td>
                                <td><%= p.getPrice() * p.getAmount()%></td>
                                <td><button class="btn btn-danger" id="b<%= p.getId()%>">
                                        <span class="glyphicon glyphicon-remove"></span>
                                    </button></td>

                            </tr>
                            <%}
                                }%>
                        </tbody>
                    </table>
                    <script>getCarrito();</script>
                </section>
            </article>
            <article class="row">
                <section class="col-md-3 col-md-offset-9">
                    <% if (carro != null) {
                      float total = 0;
                      DecimalFormat df = new DecimalFormat("###,###.##");
                      for(Producto p: carro){
                          total += p.getPrice() * p.getAmount();
                      }
                    %>
                    <table class="table table-bordered">
                            <tr>
                                <td>Total sin iva</td>
                                <td><%= df.format(total)%></td>
                            </tr>
                            <tr>
                                <td>Iva a aplicar</td>
                                <td>21%</td>
                            </tr>
                            <tr>
                                <td>Total con iva</td>
                                <td><%= df.format(total*1.21)%></td>
                            </tr>
                    </table>
                            <button class="btn btn-success" onclick="checkout()">Comprar</button>
                    <%}%>
                </section>
            </article>

        </section>
    </body>
</html>
