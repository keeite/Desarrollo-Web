/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ausiasmarch.carritogson.control.dao;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dani
 */
public class BoneCpConnection {
    private BoneCP poolConnections;
    
    public BoneCpConnection(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            BoneCPConfig config = new BoneCPConfig();
            config.setJdbcUrl("jdbc:mysql://localhost/mishop");
            config.setUsername("root");
            config.setPassword("bitnami");
            config.setMinConnectionsPerPartition(1);
            config.setMaxConnectionsPerPartition(10);
            config.setPartitionCount(1);
        
            poolConnections = new BoneCP(config);
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BoneCpConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Connection getConnection() {    
        Connection c = null;
        try {
            c =  poolConnections.getConnection();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }        
        return c;
    }
}
