<%-- 
    Document   : index
    Created on : 12-oct-2016, 22:00:41
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
        <script src="js/forge-sha256.min.js" type="text/javascript"></script>
        <script src="js/controller.js" type="text/javascript"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>
        <section class="container">
            <article class="col-md-4 col-md-offset-4" id="login">
                <div class="panel panel-success">
                    <div class="panel-heading">Login</div>
                    <div class="panel-body">
                        <form method="post" id="form">
                            <div class="form-group">
                                <label for="username">Username:</label>
                                <input type="text" class="form-control" name="username" id="username" placeholder="Dani" required>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Password:</label>
                                <input type="password" class="form-control" name="pwd" placeholder="root" required>
                            </div>
                            <button type="submit" id="button" class="btn btn-default">Login</button>
                        </form>
                    </div>
                    <div id="panelError" class="panel-footer">
                        <p id="errorMessage"></p>
                    </div>
                </div>
            </article>
        </section>
    </body>
</html>
