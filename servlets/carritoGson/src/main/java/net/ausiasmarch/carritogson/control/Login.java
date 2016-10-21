/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.carritogson.control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ausiasmarch.carritogson.control.dao.BoneCpConnection;
import net.ausiasmarch.carritogson.control.dao.UserDAO;
import net.ausiasmarch.carritogson.model.Usuario;

/**
 *
 * @author Dani
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    UserDAO uDAO = new UserDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        Map<String, Object> json = new HashMap();
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = builder.create();

        try (PrintWriter out = response.getWriter()) {

            json.put("status", 200);

            String type = request.getParameter("type");

            switch (type) {
                case "login":
                    json.put("message", login(request));
                    break;
                case "register":
                    json.put("message", register(request));
                    break;
                case "loged":
                    Usuario u = (Usuario) request.getSession().getAttribute("user");
                    if( u != null){
                        json.put("message", u);
                    }else{
                        json.put("status", 404);
                        json.put("messaage", "no loged");
                        
                    }
                break; 

            }

            out.print(gson.toJson(json));
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

    private Object login(HttpServletRequest request) {
        Usuario user = uDAO.getUserByName(request.getParameter("username"));

        if (user != null) {

            if (user.getHash().equalsIgnoreCase(request.getParameter("pwd"))) {
                request.getSession().setAttribute("isloged", true);
                request.getSession().setAttribute("user", user);
                return true;
            } else {
                return "Pass_No_Found";
            }
        } else {
            return "User_No_Found";
        }
    }

    private Object register(HttpServletRequest request) {
        String username = request.getParameter("username");
        Usuario user = uDAO.getUserByName(username);
        
        if(user == null){
            Usuario u = new Usuario();
            u.setUsername(username);
            u.setHash(request.getParameter("pwd"));
            boolean b = uDAO.createUser(u);
            request.getSession().setAttribute("user", uDAO.getUserByName(username));
            return b;
        }else{
            return "user_exist";
        }
    }
}
