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
import net.ausiasmarch.model.Producto;

/**
 *
 * @author Dani
 */
public class Processor extends HttpServlet {

    HttpSession session;
    Stock stock;
    Carro carro;
    List<Carro> checkOuts;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            session = request.getSession();
            
            
            
            carro = session.getAttribute("carro") == null ? new Carro() : (Carro) session.getAttribute("carro");
            stock = session.getAttribute("stock") == null ? new Stock() : (Stock) session.getAttribute("stock");
            checkOuts = session.getAttribute("checkOuts") == null ? new ArrayList<>() : (List<Carro>) session.getAttribute("checkOuts");
    
            session.setAttribute("carro", carro);
            session.setAttribute("stock", stock);
            session.setAttribute("checkOuts", checkOuts);
            
            String ob = request.getParameter("ob");
            String op = request.getParameter("op");
            String json = "";

            if (ob.equalsIgnoreCase("product")) {
                if (op.equalsIgnoreCase("list")) {
                    json = getStock();
                }

            } else if (ob.equalsIgnoreCase("cart")) {
                Integer id;
                switch (op) {
                    case "add":
                        id = Integer.parseInt(request.getParameter("id"));
                        Integer amount = Integer.parseInt(request.getParameter("amount"));
                        json = add(id, amount);
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
            } else if (ob.equalsIgnoreCase("purchases")) {
                if (op.equalsIgnoreCase("list")) {
                    json = getPurchases();
                }
            } else if(ob.equalsIgnoreCase("close")){
                session.invalidate();
                json = "{\"status\":200,\"Session Closed\"}";
            }
            
            out.print(json);
        }
    }

    private String getStock() {
        return stock.getJson();
    }

    private String getCarrito() {
        return carro.getJson();
    }

    private String add(Integer id, Integer amount) {
        Producto p = null;
        if(id == null || amount == null) return "{\"status\":409,\"message\":\"Error\"}";
        for (Producto i : carro) {
            if (i.getId() == id) {
                p = i;
            }
        }

        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i).getId() == id) {
                if (p != null) {
                    p.setAmount(p.getAmount() + amount);
                    if (stock.get(i).getAmount() >= p.getAmount()) {
                        return "{\"status\":200,\"message\":\"Item added\"}";
                    }
                } else if (stock.get(i).getAmount() >= amount) {
                    p = stock.get(i).clone();
                    p.setAmount(amount);
                    carro.add(p);
                    return "{\"status\":200,\"message\":\"Item added\"}";
                }
                break;
            }
        }
        if(p != null) p.setAmount(p.getAmount() - amount);
        return "{\"status\":409,\"message\":\"Not there Enough\"}";
    }

    private String drop(int id) {
        Producto p = null;
        for (int i = 0; i < carro.size(); i++) {
            if (carro.get(i).getId() == id) {
                p = carro.get(i);
            }
        }
        carro.remove(p);
        return p == null ? "{\"status\":403,\"message\":\"Item no found\"}" : "{\"status\":200,\"message\":\"Item droped\"}";
    }

    private String empty() {
        carro.clear();
        return "{\"status\":200,\"Items droped\"}";
    }

    private String checkOut() {

        int counter = 0;

        for (Producto s : stock) {
            for (Producto c : carro) {
                if (c.getId() == s.getId() && c.getAmount() <= s.getAmount()) {
                    counter++;
                }
            }
        }

        if (counter == carro.size()) {
            checkOuts.add(carro);
            
            for (Producto s : stock) {
                for (Producto c : carro) {
                    if (c.getId() == s.getId()) s.setAmount(s.getAmount() - c.getAmount());
                }
            }
            session.setAttribute("stock", stock);
            session.setAttribute("carro", new Carro());
            return "{\"status\":200,\"CheckOut OK\"}";
        }       
        return "{\"status\":409,\"message\":\"Not there Enough\"}";
    }

    private String getPurchases() {
        String json = "{";
        for (int i = 0; i < checkOuts.size(); i++) {

            json += "\"purchase_" + i + "\" : " + checkOuts.get(i).getJson();
            json += i == checkOuts.size() - 1 ? "" : ",";
        }

        json += "}";
        return json;
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
