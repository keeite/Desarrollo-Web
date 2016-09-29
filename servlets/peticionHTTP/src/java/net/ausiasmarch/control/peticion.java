/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dani
 */
public class peticion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet peticion</title>");
            out.println("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>");
            out.println("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Parametros de sistema</h2>");
            out.println("<p class=\"well well-sm\">Protocolo: " + request.getProtocol() + "</p>");
            out.println("<p class=\"well well-sm\">Metodo: " + request.getMethod() + "</p>");
            out.println("<p class=\"well well-sm\">URI: " + request.getRequestURI() + "</p>");
            out.println("<p class=\"well well-sm\">URL: " + request.getRequestURL().toString() + "</p>");
            out.println("<p class=\"well well-sm\">Path: " + request.getPathInfo() + "</p>");
            out.println("<p class=\"well well-sm\">Codificacion: " + request.getCharacterEncoding() + "</p>");
            out.println("<p class=\"well well-sm\">Tipo mime: " + request.getContentType() + "</p>");
            out.println("<p class=\"well well-sm\">Nombre ifaz recepcion: " + request.getServerName() + "</p>");
            out.println("<p class=\"well well-sm\">Path: " + request.getServletPath() + "</p>");
            out.println("<p class=\"well well-sm\">IP remota: " + request.getRemoteAddr() + "</p>");
            out.println("<p class=\"well well-sm\">Host remoto: " + request.getRemoteHost() + "</p>");
            out.println("<p class=\"well well-sm\">Nombre del host remoto: " + request.getRemoteHost() + "</p>");
            out.println("<p class=\"well well-sm\">Puerto: " + request.getLocalPort() + "</p>");
            out.println("<h2>Cabeceras</h2>");
            
            String cabecera = "<table class=\"table table-striped\">";
            cabecera += "<tr><th>Cabecera</th><th>Valor</th></tr>";
            
            List<String> names = new ArrayList();
            
            Enumeration<String> headers = request.getHeaderNames();
            
            while(headers.hasMoreElements()){
                names.add(headers.nextElement());
                System.out.println("entra");
            }
            
            for(int i = 0; i< names.size(); i++){
                cabecera += "<tr><td>" + names.get(i) + "</td><td>" + request.getHeader(names.get(i)) + "</td></tr>";
            }
            
            cabecera += "</table>";
            
            out.println(cabecera);
            
            out.println("<h2>Paramentros</h2>");
            
            String params = "<table class=\"table table-striped\">";
            params += "<tr><th>Parametro</th><th>Valor</th></tr>";
            
            List<String> namesParams = new ArrayList();
            
            Enumeration<String> nameParam = request.getParameterNames();
            
            while(nameParam.hasMoreElements()){
                namesParams.add(nameParam.nextElement());
            }
            
            for(int i = 0; i< namesParams.size(); i++){
                params += "<tr><td>" + namesParams.get(i) + "</td><td>" + request.getParameter(namesParams.get(i)) + "</td></tr>";
            }
            
            params += "</table>";
            
            out.println(params);
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
