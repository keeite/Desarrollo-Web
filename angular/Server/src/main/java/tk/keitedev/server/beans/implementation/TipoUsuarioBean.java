/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.keitedev.server.beans.implementation;

import com.google.gson.annotations.Expose;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import tk.keitedev.server.beans.interfaces.InterfaceBean;

/**
 *
 * @author Dani
 */
class TipoUsuarioBean implements InterfaceBean {

    @Expose
    private int id;
    @Expose
    private String tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    @Override
    public void fill(ResultSet rs,Connection conn, int expand) throws SQLException {
        this.id = rs.getInt("id");
        this.tipo = rs.getString("tipo");
    }

    @Override
    public String getPairs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
