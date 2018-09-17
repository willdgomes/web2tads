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
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Portal </title>

        <meta name="description" content="Source code generated using layoutit.com">
        <meta name="author" content="LayoutIt!">
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="portal.jsp">WEB II</a>
        <div class="navbar navbar-dark bg-dark" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="ServletCliente">Cadastro de Clientes <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="LogoutServlet">Sair</a>
                </li>
                
            </ul>
        </div>
    </nav>

</head>
<body>
    <jsp:useBean id="u" scope="session" class="com.ufpr.tads.web2.beans.LoginBean.LoginBean"/>
    <%
        String t = null;
        if (session.getAttribute("usuario") == null) {
            session.invalidate();
            RequestDispatcher rd = request.
                    getRequestDispatcher("index.jsp");
            request.setAttribute("msg", "Usuário deve autenticar para acessar o sistema!");
            rd.forward(request, response);
        } else {

            u = (LoginBean) session.getAttribute("usuario");
            t = u.getNomeUsuario();
        }

    %>
    <h3>nome: <%=t%></h3>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>
