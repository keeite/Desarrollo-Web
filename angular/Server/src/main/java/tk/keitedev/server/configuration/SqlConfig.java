/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.keitedev.server.configuration;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import tk.keitedev.server.connection.implementations.BoneCPConnection;
import tk.keitedev.server.connection.interfaces.ConnectionInterface;
import tk.keitedev.server.data.implementation.MysqlData;
import tk.keitedev.server.data.interfaces.DataInterface;

/**
 *
 * @author Dani
 */
public class SqlConfig {
    public static String DRIVER = "com.mysql.jdbc.Driver";
    public static String HOST = "localhost";
    public static String PORT = "3306";
    public static String DBNAME = "tienda";
    public static String USER = "root";
    public static String PASSWORD = "bitnami";
    
    public static ConnectionInterface getSource() throws SQLException{
        ConnectionInterface source = BoneCPConnection.getInstance();
        return source;
    }
    
    public static DataInterface getBdData(){
        return new MysqlData();
    }
}
