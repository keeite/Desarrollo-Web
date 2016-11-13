/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.keitedev.server.connection.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Dani
 */
public interface ConnectionInterface {
    public Connection getConection() throws SQLException;
    public void disposeConections();
}
