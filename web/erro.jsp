<%-- 
    Document   : erro
    Created on : 11/09/2018, 18:23:22
    Author     : gomes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4>${msg}</h4>
        <h4>${param.msg}</h4>
        <a href=${param.page}>${page}</a>
    </body>
</html>
