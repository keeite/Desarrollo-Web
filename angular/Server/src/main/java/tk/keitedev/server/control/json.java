/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.keitedev.server.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tk.keitedev.server.beans.implementation.ReplyBean;
import tk.keitedev.server.connection.implementations.BoneCPConnection;
import tk.keitedev.server.connection.interfaces.ConnectionInterface;
import tk.keitedev.server.helpers.ParameterCook;
import tk.keitedev.server.services.interfaces.ViewServiceInterface;

/**
 *
 * @author Dani
 */
public class json extends HttpServlet {

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
            throws ServletException, IOException, SQLException, InvocationTargetException {

        try (PrintWriter out = response.getWriter()) {
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
            response.setHeader("Access-Control-Allow-Methods", "GET,POST");
            response.setHeader("Access-Control-Max-Age", "86400");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, x-requested-with, Content-Type");
            
            String ob = ParameterCook.prepareObject(request);
            String op = ParameterCook.prepareOperation(request);
            
            if ("".equals(op) && "".equals(ob)) {
                Connection oConnection = null;
                ConnectionInterface oDataConnectionSource = null;
                try {
                    oDataConnectionSource = BoneCPConnection.getInstance();
                    oConnection = oDataConnectionSource.getConection();
                    if (oConnection.isValid(10)) {
                        sendResponseHtml(request, response, "Server", "<p>the server is up and running on " + request.getLocalName() + ":" + request.getLocalPort() + "</p><p>Database access OK</p>");
                    } else {
                        sendResponseHtml(request, response, "Server", "<p>the server is up and running on " + request.getLocalName() + ":" + request.getLocalPort() + "</p><p>Database access timeout KO</p>");
                    }
                } catch (Exception ex) {
                        sendResponseHtml(request, response, "Server", "the server is up and running on " + request.getLocalName() + ":" + request.getLocalPort() + "</p><p>Database access KO</p>");
                } finally {
                    if (oConnection != null) {
                        oConnection.close();
                    }
                    if (oDataConnectionSource != null) {
                        oDataConnectionSource.disposeConections();
                    }
                }
            } else {
                try {
                    String strClassName = "net.daw.service.implementation." + ParameterCook.prepareCamelCaseObject(request) + "Service";
                    ViewServiceInterface oService = (ViewServiceInterface) Class.forName(strClassName).getDeclaredConstructor(HttpServletRequest.class).newInstance(request);
                    Method oMethodService = oService.getClass().getMethod(ParameterCook.prepareOperation(request));
                    ReplyBean oResult = (ReplyBean) oMethodService.invoke(oService);
                    sendResponseJson(request, response, oResult);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |NoSuchMethodException ex) {
                    ReplyBean oReplyBean = new ReplyBean(500, "server error. Please, contact your administrator.");
                    sendResponseJson(request, response, oReplyBean);
                    //Log4j.errorLog(this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName(), ex);
                }
            }
            
            
        }
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            
        }
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    private void sendResponseHtml(HttpServletRequest request, HttpServletResponse response, String title, String message) throws ServletException, IOException {
        request.setAttribute("title", title);
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/jsp/message.jsp").forward(request, response);
    }

    private void sendResponseJson(HttpServletRequest request, HttpServletResponse response, ReplyBean oReplyBean) throws IOException, ServletException {
        request.setAttribute("answer", oReplyBean);
        getServletContext().getRequestDispatcher("/jsp/messageAjax.jsp").forward(request, response);
    }

}
