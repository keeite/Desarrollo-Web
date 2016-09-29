/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dani
 */
public class carrito extends HttpServlet {

    HttpSession session;
    List<String> carrito,compras;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            session = request.getSession();
            carrito  = session.getAttribute("carrito") == null? new ArrayList<>() : (List<String>)session.getAttribute("carrito");
            compras  = session.getAttribute("compras") == null? new ArrayList<>() : (List<String>)session.getAttribute("compras");
            String ob = request.getParameter("ob");
            String op = request.getParameter("op");
            String json = "";
            
            if(ob.equalsIgnoreCase("product")){
                if(op.equalsIgnoreCase("list")){
                    json = getProductos();
                }            
                               
            }else if(ob.equalsIgnoreCase("cart")){
                int id;
                switch(op){
                    case "add":
                        id = Integer.parseInt(request.getParameter("id"));
                        int amount = Integer.parseInt(request.getParameter("amount"));
                        json = add(id,amount);
                        break;
                    case "list":
                        json = getCarrito();
                        break;
                    case "drop":
                        id = Integer.parseInt(request.getParameter("id"));
                        json = drop(id);
                        break;
                    case "empty":
                        json = empty();
                        break;
                    case "checkout":
                        json = checkOut();
                        break;  
                }
            }else if(ob.equalsIgnoreCase("purchases")){
             if(op.equalsIgnoreCase("list")) json = getPurchases();
            }
            
            out.print(json);
        }
    }
    
    private String getProductos(){
        
        return null;
    }
    
    private String getCarrito(){
        
        
        return null;
    }
    
    private String add(int id, int amount){
        
        return null;
    }
    
    private String drop(int id){
        
        return null;
    }
    
    private String empty(){
        
        
        return null;
    }
    
    private String checkOut(){
        
        
        return null;
        
    }
    
    private String getPurchases(){
        
        return null;
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
