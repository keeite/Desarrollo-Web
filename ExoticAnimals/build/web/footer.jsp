<%
    String[] footer = new String[]{"Contacto", "Patrocinadores", "Nosotros", "Aviso Legal"};
    int r = (int) (Math.random() * 255 + 1);
    int g = (int) (Math.random() * 255 + 1);
    int b = (int) (Math.random() * 255 + 1);
%>

<footer style="background-color: rgb(<%=r%>,<%=g%>,<%=b%>)"  class="container-fluid">
    <div class="row">
        <ul class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1 col-lg-4 col-lg-offset-4 text-center">
            <% for (int i = 0; i < footer.length; i++) {%>
            <li class="footer-item"><a href="#"><%=footer[i]%></a></li>
                <%}%>
        </ul>   
    </div>
</footer>
