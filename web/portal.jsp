<%-- 
    Document   : portal
    Created on : 28/08/2018, 21:19:17
    Author     : gomes
--%>

<%@page import="com.ufpr.tads.web2.beans.LoginBean.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="u" scope="session" class="com.ufpr.tads.web2.beans.LoginBean.LoginBean"/>
        <%
            u.setNomeUsuario(request.getParameter("usuario"));
            String user = u.getNomeUsuario();
        %>
        <h1>nome: <%=user%></h1>
    </body>
</html>
