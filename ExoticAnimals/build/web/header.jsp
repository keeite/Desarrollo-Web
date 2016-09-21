<%
    String[] menuItems = new String[]{"Home", "Cangrejo Yeti", "Atheris", "Tigre", "Okapi", "Koala"};
    String[] menuUrls = new String[]{"index.jsp", "cangrejo.jsp", "atheris.jsp", "tigre.jsp", "okapi.jsp", "koala.jsp"};
%>
<header class="jumbotron container-fluid">
    <div class="row">
        <div class="col-md-12">
            <hgroup>
                <h1 class="h1">Exotics Animals</h1>
                <h2 class="h2">Tu mejor web de animales exoticos</h2>
            </hgroup>
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div id="icon" class="navbar-header">
                        <span style="font-size: 1.2em; position:relative; top:1em; right: .4em" class="glyphicon glyphicon-menu-hamburger"></span>
                    </div>
                    <ul class="nav navbar-nav">
                        <% for (int i = 0; i < menuItems.length; i++) {%>
                        <li><a href="<%= menuUrls[i]%>"><%= menuItems[i]%></a></li>
                            <%}%>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</header>

