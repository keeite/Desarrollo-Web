<%-- 
    Document   : json
    Created on : 28-sep-2016, 18:25:24
    Author     : a044887852v
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Json format</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body class="container">
        <section class="row">
            <article class="col-md-6 col-md-offset-3">
                <h2 class="h2 well well-md">Datos en formato Json</h2>
                <pre>
                    <%=(String)request.getAttribute("content")%>
                </pre>
            </article>
        </section>
    </body>
</html>
