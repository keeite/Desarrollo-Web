<%@page import="net.ausiasmarch.carritogson.model.Usuario"%>
<% int rank = ((Usuario)request.getSession().getAttribute("user")).getRank();

%>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Mi tienda</a>
        </div>
        <ul class="nav navbar-nav">
            <li id="shop" ><a href="shop.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Productos</a></li>
            <li id="carrito"><a href="carrito.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Carrito</a></li>
            <li id="pedido"><a href="pedidos.jsp"><span class="glyphicon glyphicon-log-out"></span> Pedidos</a></li>
            
        </ul>
        <ul class="nav navbar-nav navbar-right">
      <% if(rank == 1){ %>
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Administracion</a></li>
      <%}%>
      <li><a href="javascript:closeSession()"><span class="glyphicon glyphicon-log-out"></span> Salir</a></li>
    </ul>
    </div>
</nav>
