/*
 * The MIT License
 *
 * Copyright 2016 Dani.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package tk.keitedev.server.dao.implementations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tk.keitedev.server.beans.implementation.FilterBean;
import tk.keitedev.server.beans.implementation.OrderBean;
import tk.keitedev.server.beans.implementation.UsuarioBean;
import tk.keitedev.server.configuration.AppConfig;
import tk.keitedev.server.configuration.SqlConfig;
import tk.keitedev.server.dao.interfaces.TableDaoInterface;
import tk.keitedev.server.dao.interfaces.ViewDaoInterface;
import tk.keitedev.server.data.interfaces.DataInterface;
import tk.keitedev.server.helpers.PrepareSQLHelper;

/**
 *
 * @author Dani
 */
public class UsuarioDao implements TableDaoInterface<UsuarioBean>,ViewDaoInterface<UsuarioBean> {
    private Connection conn;
    private DataInterface bdData;
    private String table = "usuario";
    private String query = "SELECT * FROM " + table + " WHERE 1 = 1";
    public UsuarioDao(Connection conn) {
        this.conn = conn;
        bdData = SqlConfig.getBdData();
        bdData.setConnection(conn);
    }

    
    @Override
    public UsuarioBean get(UsuarioBean bean, int expand) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int set(UsuarioBean bean) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int remove(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getCount(List<FilterBean> filters) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioBean> getPage(int intRegsPerPag, int intPage, List<FilterBean> filters, List<OrderBean> orders, Integer expand) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioBean> getAll(List<FilterBean> filters, List<OrderBean> orders, Integer expand) throws SQLException {
        List<UsuarioBean> users = new ArrayList();
        query = PrepareSQLHelper.preparedGetAll(query, filters, orders);
        ResultSet rs = bdData.getAllSQL(query);
        while(rs.next()){
            UsuarioBean user = new UsuarioBean();
            user.fill(rs, conn, AppConfig.LEVEL_EXPAND_JSON);
            users.add(user);
        }
        
        
        return users;
    }

   
    
}
