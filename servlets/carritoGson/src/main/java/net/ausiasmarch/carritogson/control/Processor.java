/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.carritogson.control;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.ausiasmarch.carritogson.model.Producto;

/**
 *
 * @author Dani
 */
public class Processor extends HttpServlet {
   
    Gson gson = new Gson();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            
            
            
            List<Producto> carro = session.getAttribute("carro") == null ? new ArrayList() : (List<Producto>) session.getAttribute("carro");
            Stock stock = session.getAttribute("stock") == null ? new Stock() : (Stock) session.getAttribute("stock");
            List<List<Producto>> checkOuts = session.getAttribute("checkOuts") == null ? new ArrayList<List<Producto>>() : (List<List<Producto>>)session.getAttribute("checkOuts");
    
            session.setAttribute("carro", carro);
            session.setAttribute("stock", stock);
            session.setAttribute("checkOuts", checkOuts);
            
            String ob = request.getParameter("ob");
            String op = request.getParameter("op");
            String json = "";

            if (ob.equalsIgnoreCase("product")) {
                if (op.equalsIgnoreCase("list")) {
                    json = getStock(stock);
                }

            } else if (ob.equalsIgnoreCase("cart")) {
                Integer id;
                switch (op) {
                    case "add":
                        id = Integer.parseInt(request.getParameter("id"));
                        Integer amount = Integer.parseInt(request.getParameter("amount"));
                        json = add(id, amount,carro,stock);
                        break;
                    case "list":
                        json = getCarrito(carro);
                        break;
                    case "drop":
                        id = Integer.parseInt(request.getParameter("id"));
                        json = drop(id,carro);
                        break;
                    case "empty":
                        json = empty(carro);
                        break;
                    case "checkout":
                        json = checkOut(stock,carro,checkOuts,session);
                        break;
                }
            } else if (ob.equalsIgnoreCase("purchases")) {
                if (op.equalsIgnoreCase("list")) {
                    json = getPurchases(checkOuts);
                }
            } else if(ob.equalsIgnoreCase("close")){
                session.invalidate();
                json = getMessageJson(200,"Session Closed");
            }
            
            out.print(json);
        }
    }

    private String getStock(Stock stock) {
        
        return getMessageJson(200,stock);
    }

    private String getCarrito(List<Producto> carro) {
        return getMessageJson(200,carro);
    }

    private String add(Integer id, Integer amount,List<Producto> carro,Stock stock) {
        Producto p = null;
        if(id == null || amount == null) return getMessageJson(409,"Error");
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
                        return getMessageJson(200,"Item added");
                    }
                } else if (stock.get(i).getAmount() >= amount) {
                    p = stock.get(i).clone();
                    p.setAmount(amount);
                    carro.add(p);
                    return getMessageJson(200,"Item added");
                }
                break;
            }
        }
        if(p != null) p.setAmount(p.getAmount() - amount);
        return getMessageJson(409,"Not there Enough");
    }

    private String drop(int id,List<Producto> carro) {
        Producto p = null;
        for (int i = 0; i < carro.size(); i++) {
            if (carro.get(i).getId() == id) {
                p = carro.get(i);
            }
        }
        carro.remove(p);
        return p == null ? getMessageJson(403,"Item no found") : getMessageJson(200,"Item droped");
    }

    private String empty(List<Producto> carro) {
        carro.clear();
        return getMessageJson(200,"Items droped");
    }

    private String checkOut(Stock stock,List<Producto> carro,List<List<Producto>> checkOuts,HttpSession session) {

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
            session.setAttribute("carro", new ArrayList<Producto>());
            return getMessageJson(200,"CheckOut OK");
        }       
        return getMessageJson(409,"Not there Enough");
    }

    private String getPurchases(List<List<Producto>> checkOuts) {
        return getMessageJson(200,checkOuts);
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
    
    private String getMessageJson(int num,String message){  
        return "{\"status\":" + num + ",\"message\":\"" + message + "\"}";
    }

    private String getMessageJson(int num,Object object){
        Map<String,Object> map = new HashMap();
        map.put("Status", num);
        map.put("Message", object);
        return gson.toJson(map);
    }
}
