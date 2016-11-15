/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.keitedev.server.helpers;

import com.google.common.reflect.TypeToken;
import tk.keitedev.server.beans.implementation.FilterBean;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import tk.keitedev.server.beans.implementation.OrderBean;
import tk.keitedev.server.configuration.AppConfig;
import tk.keitedev.server.configuration.GsonConfig;

/**
 *
 * @author Dani
 */
public class ParameterCook {

    public static String prepareMode(HttpServletRequest request) {
        return request.getParameter("mode") == null ? "wrappered" : request.getParameter("mode");
    }

    public static String prepareObject(HttpServletRequest request) {
        String result = request.getParameter("ob");
        return result == null? "" :result.replaceFirst(result.substring(0, 1), result.substring(0, 1).toUpperCase()) ;
    }

    public static int prepareId(HttpServletRequest request) {
        return request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id"));
    }

    public static String prepareJson(HttpServletRequest request) throws UnsupportedEncodingException {
        String result = request.getParameter("json");
        return result == null? "": EncodingHelper.decodeURIComponent(request.getParameter("json"));
    }

    public static String prepareOperation(HttpServletRequest request) {
        String result = request.getParameter("op");
        return result == null ? "": result.toLowerCase();
    }

    public static Integer prepareRpp(HttpServletRequest request) {
        return request.getParameter("rpp") == null ? AppConfig.DEFAULT_RESULT_PER_PAGE : Integer.parseInt(request.getParameter("rpp"));
    }

    public static Integer preparePage(HttpServletRequest request) {
        return request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
    }

    public static List<OrderBean> prepareOrder(HttpServletRequest oRequest) throws UnsupportedEncodingException {
        String json = oRequest.getParameter("order");
        if (json == null || json.matches(".*[insert|delete|select|update].*")) return null;
        
        List<OrderBean> orders = new ArrayList();
        json = EncodingHelper.decodeURIComponent(json);
        orders = GsonConfig.getGson().fromJson(json, new TypeToken<ArrayList<OrderBean>>(){}.getType());
        return orders;
    }

    public static List<FilterBean> prepareFilter(HttpServletRequest oRequest) throws UnsupportedEncodingException {
        String json = oRequest.getParameter("filter");
        if (json == null || json.matches(".*[insert|delete|select|update].*")) return null;
        
        List<FilterBean> filters = new ArrayList();
        json = EncodingHelper.decodeURIComponent(json);
        filters = GsonConfig.getGson().fromJson(json,new TypeToken<ArrayList<FilterBean>>(){}.getType());
        return filters;
    }

    public static int prepareInt(String Parameter, HttpServletRequest request) {
        return request.getParameter(Parameter) == null? 0: Integer.parseInt(request.getParameter(Parameter));
    }
}
