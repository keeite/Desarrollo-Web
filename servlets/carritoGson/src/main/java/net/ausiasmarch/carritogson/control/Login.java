/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.carritogson.control;

import com.google.gson.Gson;
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
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        Map<String, Object> json = new HashMap();
        Gson gson = new Gson();

        try (PrintWriter out = response.getWriter()) {
            try {
                json.put("status", 200);
                BoneCpConnection cp = new BoneCpConnection();
                Connection conn = cp.getConnection();
                String query = "SELECT * FROM users WHERE username = ?";
                
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, request.getParameter("username"));
                ResultSet rs = ps.executeQuery();
               
                Usuario user = null;
                while(rs.next()){
                    user = new Usuario();
                    user.setId(rs.getInt(1));
                    user.setUsername(rs.getString(2));
                    user.setHash(rs.getString(3));
                    user.setRank(rs.getInt(4));
                }  
                
                if (user != null) {

                    if (user.getHash().equalsIgnoreCase(request.getParameter("pwd"))) {
                        request.getSession().setAttribute("isloged", true);
                        request.getSession().setAttribute("user", user);
                        json.put("message", true);
                    } else {
                        json.put("message", "Pass_No_Found");
                    }
                } else {
                    json.put("message", "User_No_Found");
                }

                out.print(gson.toJson(json));

            } catch (SQLException ex) {
                
                json.put("status", 500);
                json.put("message","Lo siento hubo un error con la BD");
                out.print(gson.toJson(json));
            }
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
}
