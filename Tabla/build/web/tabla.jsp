<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body class="container">
        <%
            int cols = Integer.parseInt(request.getParameter("cols"));
            int rows = Integer.parseInt(request.getParameter("rows"));
        %>

        <section class="row" style="margin-top: 25%">
            <article class="col-md-4 col-md-offset-4">
                <div class="panel panel-warning">
                    <div class="panel-heading">
                        <h4>Solucion de tabla</h4>
                    </div>
                    <div class="panel-body">
                        <table class="table table-bordered text-center">
                            <tbody>
                                <% for (int i = 1; i <= rows; i++) { %>
                                <tr>
                                    <% for (int j = 1; j <= cols; j++) {%>
                                    <td><%=j * i%></td>
                                    <%}%>        
                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </article>
        </section>
    </body>
</html>
