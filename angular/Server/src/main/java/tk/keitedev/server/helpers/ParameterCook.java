/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.keitedev.server.helpers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dani
 */
public class ParameterCook {
    
    public static String prepareMode(HttpServletRequest request) {
        return request.getParameter("mode") == null ? "wrappered" : request.getParameter("mode");
    }

    public static String prepareObject(HttpServletRequest request) {
                return request.getParameter("ob") == null ? "" : request.getParameter("ob");

    }

    public static String prepareCamelCaseObject(HttpServletRequest request) {
        String result = null;
        if (request.getParameter("ob") == null) {
            result = "Usuario";
        } else {
            result = Character.toUpperCase(request.getParameter("ob").charAt(0)) + request.getParameter("ob").substring(1);
        }
        return result;
    }

    public static int prepareId(HttpServletRequest request) {
                return request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id"));

    }

    public static String prepareJson(HttpServletRequest request) throws UnsupportedEncodingException {
        String result = null;
        if (request.getParameter("json") == null) {
            result = "";
        } else {
            //result = request.getParameter("json").replaceAll("%2F", "/");
            result = EncodingHelper.decodeURIComponent(request.getParameter("json"));
        }
        return result;
    }

    public static String prepareOperation(HttpServletRequest request) {
        String result = null;
        if (request.getParameter("op") == null) {
            result = "";
        } else {
            result = request.getParameter("op").toLowerCase();
        }
        return result;
    }

    public static String prepareCamelCaseOperation(HttpServletRequest request) {
        String result = null;
        if (request.getParameter("op") == null) {
            result = "Inicio";
        } else {
            result = Character.toUpperCase(request.getParameter("op").charAt(0)) + request.getParameter("op").substring(1);
        }
        return result;
    }

    public static Integer prepareRpp(HttpServletRequest request) {
        int intRegsPerPag;
        if (request.getParameter("rpp") == null) {
            intRegsPerPag = 10;
        } else {
            intRegsPerPag = Integer.parseInt(request.getParameter("rpp"));
        }
        return intRegsPerPag;
    }

    public static Integer preparePage(HttpServletRequest request) {
        int intPage;
        if (request.getParameter("page") == null) {
            intPage = 1;
        } else {
            intPage = Integer.parseInt(request.getParameter("page"));
        }
        return intPage;
    }

    public static String prepareOrder(HttpServletRequest oRequest) {
        String strOrder = oRequest.getParameter("order");
        if (strOrder != null) {
            if (strOrder.toLowerCase().contains("select") || strOrder.toLowerCase().contains("insert") || strOrder.toLowerCase().contains("update") || strOrder.toLowerCase().contains("delete")) {
                return null;
            }
        }
        return strOrder;
    }

    public static String prepareFilter(HttpServletRequest oRequest) {
        String strFilter = oRequest.getParameter("filter");
        if (strFilter != null) {
            if (strFilter.toLowerCase().contains("select") || strFilter.toLowerCase().contains("insert") || strFilter.toLowerCase().contains("update") || strFilter.toLowerCase().contains("delete")) {
                return null;
            }
        }
        return strFilter;
    }

    public static int prepareInt(String strParameter, HttpServletRequest request) {
        int result = 0;
        if (request.getParameter(strParameter) == null) {
            result = 0;
        } else {
            result = Integer.parseInt(request.getParameter(strParameter));
        }
        return result;
    }

//    private static FilterBeanHelper getFilterExpression(String s) {
//        if (s.indexOf(",") >= 0) {
//            String[] temp = s.split(",");
//            if (temp.length == 4) {
//                FilterBeanHelper oFilterBeanHelper = new FilterBeanHelper();
//                oFilterBeanHelper.setFilterConnector(temp[0]);
//                oFilterBeanHelper.setFilter(temp[1]);
//                oFilterBeanHelper.setFilterOperator(temp[2]);
//                oFilterBeanHelper.setFilterValue(temp[3]);
//                return oFilterBeanHelper;
//            } else {
//                return null;
//            }
//        } else {
//            return null;
//        }
//    }
//
//    public static ArrayList<FilterBeanHelper> getFilterParams(String strFilter) {
//        ArrayList<FilterBeanHelper> oFilterBean = new ArrayList<>();
//        if (strFilter != null && strFilter.length() > 0) {
//            strFilter += " ";
//            String[] split1 = strFilter.split(Pattern.quote(" "));
//            for (String s : split1) {
//
//                oFilterBean.add(getFilterExpression(s));
//            }
//        } else {
//            oFilterBean = null;
//        }
//
//        return oFilterBean;
//    }
//
//    public static HashMap<String, String> getOrderParams(String strOrder) {
//        HashMap<String, String> oHMOrder = new HashMap<>();
//        if (strOrder != null && strOrder.length() > 0) {
//            strOrder += " ";
//            String[] split1 = strOrder.split(Pattern.quote(" "));
//            for (String s : split1) {
//                if (s.contains(",")) {
//                    String[] split2 = s.split(",");
//                    if ("asc".equalsIgnoreCase(split2[1])) {
//                        oHMOrder.put(split2[0], "ASC");
//                    } else {
//                        oHMOrder.put(split2[0], "DESC");
//                    }
//                } else {
//                    oHMOrder.put(s, "ASC");
//                }
//            }
//        } else {
//            oHMOrder = null;
//        }
//        return oHMOrder;
//    }
}
