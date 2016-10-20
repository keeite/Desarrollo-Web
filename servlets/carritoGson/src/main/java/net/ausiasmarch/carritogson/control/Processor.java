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
import net.ausiasmarch.carritogson.control.dao.StockDAO;
import net.ausiasmarch.carritogson.model.Pedido;
import net.ausiasmarch.carritogson.model.Producto;
import net.ausiasmarch.carritogson.model.Usuario;

/**
 *
 * @author Dani
 */
public class Processor extends HttpServlet {
   
    Gson gson = new Gson();
    StockDAO stDAO = new StockDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            
            
            
            List<Producto> carro = session.getAttribute("carro") == null ? new ArrayList() : (List<Producto>) session.getAttribute("carro");
            int userId = ((Usuario)session.getAttribute("user")).getId();
            session.setAttribute("carro", carro);
            
            
            String ob = request.getParameter("ob");
            String op = request.getParameter("op");
            String json = "";

            if (ob.equalsIgnoreCase("product")) {
                if (op.equalsIgnoreCase("list")) {
                    json = getMessageJson(200,stDAO.getStock());
                }

            } else if (ob.equalsIgnoreCase("cart")) {
                Integer id;
                switch (op) {
                    case "add":
                        id = Integer.parseInt(request.getParameter("id"));
                        Integer amount = Integer.parseInt(request.getParameter("amount"));
                        json = add(id, amount,carro);
                        break;
                    case "list":
                        json = getMessageJson(200,carro);
                        break;
                    case "drop":
                        id = Integer.parseInt(request.getParameter("id"));
                        json = drop(id,carro);
                        break;
                    case "empty":
                        json = empty(carro);
                        break;
                    case "checkout":
                        json = checkOut(carro,userId);
                        break;
                }
            } else if (ob.equalsIgnoreCase("purchases")) {
                if (op.equalsIgnoreCase("list")) {
                    json = getPurchases(userId);
                }
            } else if(ob.equalsIgnoreCase("close")){
                session.invalidate();
                json = getMessageJson(200,"Session Closed");
            }
            
            out.print(json);
        }
    }

    

    

    private String add(Integer id, Integer amount,List<Producto> carro) {
        
        if(id == null || amount == null) return getMessageJson(409,"Error");
        
        Producto p = stDAO.getProducto(id);
        
        for(Producto pr: carro){
            if(pr.getId() == p.getId()){
                int total = pr.getAmount() + amount;
                if(total <= p.getAmount()) {
                    pr.setAmount(total);
                    return getMessageJson(200,"Item added");
                }else{
                    return getMessageJson(409,"Not there Enough");
                }   
            }  
        }
        if(p.getAmount() >= amount){
            p.setAmount(amount);
            carro.add(p);
            return getMessageJson(200,"Item added");
        }else{
            return getMessageJson(409,"Not there Enough");
        }
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

    private String checkOut(List<Producto> carro,int userId) {

        if(stDAO.checkout(carro, userId)){
            carro.clear();
            return getMessageJson(200,"CheckOut OK");
        }else{
            return getMessageJson(409,"CheckOut Fail");
        }
    }

    private String getPurchases(int userId) {
        List<Pedido> pedidos = stDAO.getCheckouts(userId);
        if(pedidos == null){
            return getMessageJson(404,"Not found");
        }
        return getMessageJson(200,pedidos);
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
    
    

    private String getMessageJson(int num,Object object){
        Map<String,Object> map = new HashMap();
        map.put("status", num);
        map.put("message", object);
        return gson.toJson(map);
    }
}
