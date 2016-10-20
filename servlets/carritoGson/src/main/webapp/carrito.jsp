<%-- 
    Document   : carrito
    Created on : 16-oct-2016, 15:44:09
    Author     : Dani
--%>

<%@page import="net.ausiasmarch.carritogson.model.Usuario"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.ausiasmarch.carritogson.model.Producto"%>
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
        <title>Carrito</title>
    </head>
    <body>
         <jsp:include page="nav.jsp" />
        <section class="container">
            <article class="row">
                <div class="col-md-12 well"><h1 class="text-center">Carrito</h1></div>
            </article>   
        </section>
        <section class="container" id="content">
            <article class="row">
                <section class="col-md-12">
                    <table class="table table-hover"
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
                        </tbody>
                    </table>
                    <script>fillCarrito();</script>
                </section>
            </article>
            <article class="row">
                <section class="col-md-3 col-md-offset-9">
                    
                    <table class="table table-bordered" id="total">
                            <tr>
                                <td>Total sin iva</td>
                                <td id="siniva">40</td>
                            </tr>
                            <tr>
                                <td>Iva a aplicar</td>
                                <td>21%</td>
                            </tr>
                            <tr>
                                <td>Total con iva</td>
                                <td id="coniva">45</td>
                            </tr>
                    </table>
                            <button id="buy" class="btn btn-success" onclick="checkout()">Comprar</button>
                            <button id="empty"class="btn btn-danger" onclick="empty()">Vaciar</button>
                </section>
            </article>

        </section>
    </body>
</html>
