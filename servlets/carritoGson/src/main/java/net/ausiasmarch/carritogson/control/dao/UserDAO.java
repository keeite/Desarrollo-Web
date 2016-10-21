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
import java.util.logging.Level;
import java.util.logging.Logger;
import net.ausiasmarch.carritogson.model.Usuario;

/**
 *
 * @author a044887852v
 */
public class UserDAO {

    BoneCpConnection cp;

    public UserDAO() {
        cp = new BoneCpConnection();
    }

    public Usuario getUserByName(String username) {
        Usuario user = null;
        try {
            Connection conn = cp.getConnection();
            String query = "SELECT * FROM users WHERE username = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                user = new Usuario();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setHash(rs.getString(3));
                user.setRank(rs.getInt(4));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return user;
    }
    
    public boolean createUser(Usuario user){
        try {
            Connection conn = cp.getConnection();
            
            String query = "INSERT INTO users VALUES(null,?,?,2)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getHash());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
}
