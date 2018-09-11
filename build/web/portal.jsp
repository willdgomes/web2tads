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
            if (session.getAttribute("usuario") == null) {
            session.invalidate();
            RequestDispatcher rd = request.
                    getRequestDispatcher("erro.jsp");
            request.setAttribute("msg", "Sessao expirou");
            request.setAttribute("page", "index.html");
            rd.forward(request, response);
        } else {
                u = request.getParameter("usuario");
                u.getNomeUsuario();
        }
            
        %>
    </body>
</html>
