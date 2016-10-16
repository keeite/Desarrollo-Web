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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.ausiasmarch.carritogson.model.Producto;

/**
 *
 * @author Dani
 */
public class StockDAO {

    public List<Producto> getStock() {
        try {
            Connection conn = new BoneCpConnection().getConnection();

            String query = "SELECT * FROM stock";
            ResultSet rs = conn.createStatement().executeQuery(query);
            List<Producto> stock = new ArrayList();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setDesc(rs.getString("description"));
                p.setPrice(rs.getFloat("price"));
                p.setAmount(rs.getInt("amount"));
                stock.add(p);
            }

            return stock;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Producto getProducto(int id) {

        try {
            Connection conn = new BoneCpConnection().getConnection();

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
                
            }
            return p;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
    }
}
