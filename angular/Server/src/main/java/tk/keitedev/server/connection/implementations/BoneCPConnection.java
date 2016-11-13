/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.keitedev.server.connection.implementations;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tk.keitedev.server.configuration.SqlConfig;
import tk.keitedev.server.connection.interfaces.ConnectionInterface;

/**
 *
 * @author Dani
 */
public class BoneCPConnection implements ConnectionInterface {
    private BoneCP boneCP;
    private static BoneCPConnection pool= null;
    private BoneCPConnection() {
        try {
            Class.forName(SqlConfig.DRIVER);
            BoneCPConfig config = new BoneCPConfig();
            config.setJdbcUrl("jdbc:mysql://" + SqlConfig.HOST + ":" + SqlConfig.PORT + "/" + SqlConfig.DBNAME);
            config.setUsername(SqlConfig.USER);
            config.setPassword(SqlConfig.PASSWORD);
            config.setMinConnectionsPerPartition(1);
            config.setMaxConnectionsPerPartition(10);
            config.setPartitionCount(2);
            boneCP = new BoneCP(config);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BoneCPConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static BoneCPConnection getInstance(){
        if(pool == null) pool = new BoneCPConnection();
        return pool;
    }
    
    @Override
    public Connection getConection() throws SQLException{
       return boneCP.getConnection();
    }

    @Override
    public void disposeConections() {
       boneCP.close();
    }

}
