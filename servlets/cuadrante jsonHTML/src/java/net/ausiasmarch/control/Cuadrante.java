/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dani
 */
public class Cuadrante extends HttpServlet {

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
        
        try (PrintWriter out = response.getWriter()) {

            int col = Integer.valueOf(request.getParameter("col"));
            int row = Integer.valueOf(request.getParameter("row"));
            String type = request.getParameter("type");

            String content = "";
            RequestDispatcher reqDispatcher = null;
    
            switch (type) {
                case "json":
                    response.setContentType("application/json;charset=UTF-8");
                    content = getJson(row, col);
                    reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/json.jsp");
                    break;
                case "html":
                    response.setContentType("text/html;charset=UTF-8");
                    content = getHtml(row, col);
                    reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/html.jsp");
                    break;

            }
            request.setAttribute("content", content);
            reqDispatcher.forward(request,response);
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private String getJson(int row, int col) {

        String json = "{";

        for (int i = 1; i <= row; i++) {
            json += "\"row" + i + "\" : {\n";

            for (int z = 1; z <= col; z++) {
                json += "\t\"col" + z + "\" :" + (z * i);
                json += z == col ? "}" : ",\n";
            }
            json += i == row ? "" : ",\n";

        }

        json += "}";

        return json;
    }

    private String getHtml(int rows, int cols) {

        String table = "<table class=\"table table-bordered text-center\">\n";
        
        for (int i = 1; i <= rows; i++) {
            table += "\t<tr>\n";
            for (int j = 1; j <= cols; j++) {
                table += "\t\t<td>" + (j * i) + "</td>\n";
            }
            table += "\t</tr>\n";
        }
        table += "</table>";

        return table;
    }

}
