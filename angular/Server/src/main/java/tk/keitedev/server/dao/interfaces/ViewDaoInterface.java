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
package tk.keitedev.server.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tk.keitedev.server.beans.implementation.FilterBean;
import tk.keitedev.server.beans.implementation.OrderBean;

/**
 *
 * @author Dani
 */
public interface ViewDaoInterface<BeanSelected> {
    
    public Long getCount(List<FilterBean> filters) throws SQLException;

    public List<BeanSelected> getPage(int intRegsPerPag, int intPage, List<FilterBean> filters, List<OrderBean> orders, Integer expand) throws SQLException;

    public List<BeanSelected> getAll(List<FilterBean> filters, List<OrderBean> orders, Integer expand) throws SQLException;
}
