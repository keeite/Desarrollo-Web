<%-- 
    Document   : pedidos
    Created on : 19-oct-2016, 2:59:43
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
        <title>Pedidos</title>
    </head>
    <body>
        <jsp:include page="nav.jsp"/>
        
        <section class="container">
            <section class="row">
                <article class="col-md-12">
                    <table class="table table-striped"
                           <thead>
                            <tr>
                                <th>Nº Pedido</th>
                                <th>Fecha</th>
                                <th>Nª articulos</th>
                                <th>Total €</th>
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
