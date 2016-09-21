<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%
    List<Integer> list = new ArrayList<>();
    for(int i = 0; i < 100 ; i++) list.add(i);
    Collections.shuffle(list);
    List<Integer> numbers = list.subList(0, 25);
    Collections.sort(numbers);
    int counter = 0;
%>
<html>
    <head>
        <title>Bingo!</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body class="container">
        <section class="row" style="margin-top: 25%;">
            <article class="col-md-4 col-md-offset-4 col-xs-12">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h4 class="h4">Tabla ordenada de numeros random</h4>
                    </div>
                    <div class="panel-body">
                        <table class="table table-bordered text-center">
                            <tbody>
                                <% for (int i = 0; i < 5; i++) {%>
                                    <tr>
                                        <% for (int j = 0; j < 5; j++) {%>
                                        <td><%=numbers.get(counter)%></td>       
                                        <%counter++;}%>
                                    </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                    <div class="panel-footer">
                        <a href="index.jsp" class="btn btn-primary btn-block">Recargar</a>
                    </div>
                </div>
            </article>
        </section>
    </body>
</html>
