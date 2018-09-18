<%-- 
    Document   : clientesListar
    Created on : 17/09/2018, 20:44:58
    Author     : gomes
--%>

<%@page import="java.util.List"%>
<%@page import="com.ufpr.tads.web2.dao.ClienteDAO.ClienteDAO"%>
<%@page import="com.ufpr.tads.web2.beans.Cliente.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Clientes </title>

        <meta name="description" content="Source code generated using layoutit.com">
        <meta name="author" content="LayoutIt!">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <jsp:useBean id="cliente" scope="session" class="com.ufpr.tads.web2.beans.Cliente.Cliente"/>
        <%
            session = request.getSession(false);
            if (session == null) {
                RequestDispatcher rd = request.
                        getRequestDispatcher("/index.jsp");
                request.setAttribute("msg", "Usuário deve autenticar para acessar o sistema!");
                rd.forward(request, response);
            } else {%>
        <table class="table table-bordered table-sm">
            <th>CPF</th>
            <th>Nome</th>
            <th>E-mail</th><%
                ClienteDAO clienteDAO = new ClienteDAO();
                List<Cliente> listClientes = new ArrayList<Cliente>();
                listClientes = clienteDAO.buscarClientes();
                for (int i = 0; i < listClientes.size(); i++) {
                    String cpf = listClientes.get(i).getCpfCliente();
                    String nome = listClientes.get(i).getNomeCliente();
                    String email = listClientes.get(i).getEmailCliente();
                %><tr>
                    <td><%=cpf %></td>
                    <td><%=nome %></td>
                    <td><%=email%></td>
                </tr><%
                    }
                }
            %>
        </table>
    </body>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</html>
