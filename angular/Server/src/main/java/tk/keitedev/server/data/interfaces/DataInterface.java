/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.keitedev.server.data.interfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dani
 */
public interface DataInterface {
    
    public void setConnection(Connection conn);
    public Long getId(String table, String field, String value) throws SQLException;

    public String getOne(String query, String field, int id) throws SQLException;

    public int removeOne(String table,int id) throws SQLException;

    public Long getCount(String query) throws SQLException;

    public ResultSet getAllSQL(String query) throws SQLException;

    public int executeUpdateSQL(String query) throws SQLException;

    public int executeInsertSQL(String query) throws SQLException;
    
    public void finalize() throws Throwable;
}
