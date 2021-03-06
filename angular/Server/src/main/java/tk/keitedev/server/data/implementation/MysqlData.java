/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.keitedev.server.data.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tk.keitedev.server.data.interfaces.DataInterface;

/**
 *
 * @author Dani
 */
public class MysqlData implements DataInterface{
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    
    public MysqlData(Connection conn){
        this.conn = conn;
    }

    public MysqlData() {}
    
    @Override
    public void setConnection(Connection conn){
        this.conn = conn;
    }
    @Override
    public Long getId(String table, String field, String value) throws SQLException {
        String query = "SELECT id FROM ? WHERE ? = ?";
        ps = conn.prepareStatement(query);
        ps.setString(1, table);
        ps.setString(2, field);
        ps.setString(3,value);
        
        rs = ps.executeQuery();
        rs.next();
        return rs.getLong("id");
        
        
    }

    @Override
    public String getOne(String query, String field, int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int removeOne(String table, int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getCount(String query) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getAllSQL(String query) throws SQLException {
        return conn.createStatement().executeQuery(query);
    }

    @Override
    public int executeUpdateSQL(String query) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int executeInsertSQL(String query) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void finalize() throws Throwable {
        if(rs != null)rs.close();
        if(ps != null)ps.close();
        if(st != null)st.close();
        super.finalize();
    }

    
    
}
