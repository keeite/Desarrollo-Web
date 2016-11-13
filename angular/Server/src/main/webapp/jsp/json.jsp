<%-- 
    Document   : json
    Created on : 13-nov-2016, 2:23:59
    Author     : Dani
--%>

<%@page import="tk.keitedev.server.beans.implementation.ReplyBean"%>
<%@page contentType="application/json" pageEncoding="UTF-8"%><%
    ReplyBean oReplyBean = (ReplyBean) request.getAttribute("answer");
    //response.sendError(oReplyBean.getCode(), oReplyBean.getMessage());
    response.setStatus(oReplyBean.getStatus());
    out.print(oReplyBean.getJson());%>
