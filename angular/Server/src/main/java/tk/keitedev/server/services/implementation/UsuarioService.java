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
package tk.keitedev.server.services.implementation;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import tk.keitedev.server.beans.implementation.FilterBean;
import tk.keitedev.server.beans.implementation.OrderBean;
import tk.keitedev.server.beans.implementation.ReplyBean;
import tk.keitedev.server.beans.implementation.UsuarioBean;
import tk.keitedev.server.configuration.AppConfig;
import tk.keitedev.server.configuration.GsonConfig;
import tk.keitedev.server.configuration.SqlConfig;
import tk.keitedev.server.connection.implementations.BoneCPConnection;
import tk.keitedev.server.connection.interfaces.ConnectionInterface;
import tk.keitedev.server.dao.implementations.UsuarioDao;
import tk.keitedev.server.helpers.ParameterCook;
import tk.keitedev.server.helpers.UserHelper;
import tk.keitedev.server.services.interfaces.TableServiceInterface;
import tk.keitedev.server.services.interfaces.ViewServiceInterface;

/**
 *
 * @author Dani
 */
public class UsuarioService implements TableServiceInterface, ViewServiceInterface {

    private HttpServletRequest request;
    private ConnectionInterface source;

    public UsuarioService(HttpServletRequest request) throws SQLException {
        this.request = request;
        this.source = SqlConfig.getSource();

    }

    @Override
    public ReplyBean get() throws Exception {
        if (UserHelper.checkPermission(request, "get")) {

        }
        return new ReplyBean(401, "Unauthorized");
    }

    @Override
    public ReplyBean remove() throws Exception {
        if (UserHelper.checkPermission(request, "get")) {

        }
        return new ReplyBean(401, "Unauthorized");
    }

    @Override
    public ReplyBean set() throws Exception {
        if (UserHelper.checkPermission(request, "get")) {

        }
        return new ReplyBean(401, "Unauthorized");
    }

    @Override
    public ReplyBean getall() throws UnsupportedEncodingException, SQLException {
        if (UserHelper.checkPermission(request, "get")) {
            List<FilterBean> filters = ParameterCook.prepareFilter(request);
            List<OrderBean> orders = ParameterCook.prepareOrder(request);
            Connection conn = source.getConection();
            UsuarioDao uDao = new UsuarioDao(conn);
            List<UsuarioBean> users = uDao.getAll(filters, orders, AppConfig.LEVEL_EXPAND_JSON);
            return new ReplyBean(200,GsonConfig.getGson().toJson(GsonConfig.getJson(200, users)));
        }
        return new ReplyBean(401, "Unauthorized");
    }

    @Override
    public ReplyBean getpage() throws Exception {
        if (UserHelper.checkPermission(request, "get")) {

        }
        return new ReplyBean(401, "Unauthorized");
    }

    @Override
    public ReplyBean getcount() throws Exception {
        if (UserHelper.checkPermission(request, "get")) {

        }
        return new ReplyBean(401, "Unauthorized");
    }

    public boolean login() {

        return true;
    }

    public boolean logout() {
        request.getSession().invalidate();
        return request.getSession().isNew();
    }
}
