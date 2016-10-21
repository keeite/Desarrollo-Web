/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.carritogson.control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.ausiasmarch.carritogson.model.Pedido;
import net.ausiasmarch.carritogson.model.Producto;

/**
 *
 * @author Dani
 */
public class StockDAO {

    BoneCpConnection cp;

    public StockDAO() {
        cp = new BoneCpConnection();
    }

    public List<Producto> getStock() {
        try {
            Connection conn = cp.getConnection();

            String query = "SELECT * FROM stock";
            ResultSet rs = conn.createStatement().executeQuery(query);
            List<Producto> stock = new ArrayList();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setDesc(rs.getString("description"));
                p.setPrice(rs.getFloat("price"));
                p.setAmount(rs.getInt("amount"));
                p.setImage(rs.getString("image"));
                stock.add(p);
            }
            conn.close();
            return stock;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Producto getProducto(int id) {

        try {
            Connection conn = cp.getConnection();

            String query = "SELECT * FROM stock WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Producto p = null;
            while (rs.next()) {
                p = new Producto();
                p.setId(rs.getInt("id"));
                p.setDesc(rs.getString("description"));
                p.setPrice(rs.getFloat("price"));
                p.setAmount(rs.getInt("amount"));
                p.setImage(rs.getString("image"));

            }
            conn.close();
            return p;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public boolean checkout(List<Producto> carro, int userID) {
        Connection conn = cp.getConnection();

        try {
            conn.setAutoCommit(false);
            PreparedStatement ps;
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            String query = "INSERT INTO pedidos VALUES(null,?,?)";
            ps = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userID);
            ps.setDate(2, sqlDate);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int idPedido = rs.getInt(1);
            if (idPedido == -1) {
                conn.rollback();
                return false;
            }

            for (Producto p : carro) {
                query = "SELECT amount FROM stock WHERE id=" + p.getId();
                Statement st = conn.createStatement();
                rs = st.executeQuery(query);
                rs.next();
                if(rs.getInt(1) < p.getAmount()) {
                    conn.rollback();
                    return false;
                }
                query = "UPDATE stock SET amount=amount - ? WHERE id = ?;";
                ps = conn.prepareStatement(query);
                ps.setInt(1, p.getAmount());
                ps.setInt(2, p.getId());
                ps.execute();
                query = "INSERT INTO itemspedidos VALUES(?,?,?,?)";
                ps = conn.prepareStatement(query);
                ps.setInt(1, idPedido);
                ps.setInt(2, p.getId());
                ps.setFloat(3, p.getPrice());
                ps.setInt(4, p.getAmount());
                ps.execute();

            }
            conn.commit();
            conn.close();
            return true;
        } catch (SQLException ex) {

            try {
                conn.rollback();
            } catch (SQLException ex1) {
                return false;
            }
            return false;
        }

    }
    
    public List<Pedido> getCheckouts(int userID){
        try {
            List<Pedido> checkouts = new ArrayList();
            StringBuilder query = new StringBuilder();
            query.append("SELECT id,COUNT(id),SUM(cantidad * precio),date FROM pedidos ")
                    .append("INNER JOIN itemspedidos ON id = idPedido ")
                    .append("WHERE userId = " + userID + " GROUP By id;");
            
            Connection conn = cp.getConnection();
            
            ResultSet rs = conn.createStatement().executeQuery(query.toString());
            
            while(rs.next()){
                Pedido p = new Pedido(rs.getInt(1),rs.getInt(2),rs.getFloat(3),rs.getDate(4));
                checkouts.add(p);
            }
            
            return checkouts;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
    }
}
