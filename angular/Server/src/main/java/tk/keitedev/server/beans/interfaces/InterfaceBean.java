/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.keitedev.server.beans.interfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dani
 */
public interface InterfaceBean {
    public void fill(ResultSet rs,Connection conn ,int expand) throws SQLException;
    public String getPairs();
    public String getColumns();
    public String getValues();
}
