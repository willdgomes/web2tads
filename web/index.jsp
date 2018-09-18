<%-- 
        Document   : index
    Created on : 16/09/2018, 15:37:19
    Author     : gomes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>WEB II - Login </title>

        <meta name="description" content="Source code generated using layoutit.com">
        <meta name="author" content="LayoutIt!">

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

    </head>
    <body>
        <h4>${msg}</h4>
        <h4>${param.msg}</h4>
        <br><br><br>
        <h3 class="text-center"> Login </h3>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">


                        <div class="col-md-4">
                        </div>


                        <div class="col-md-4">
                            <form action="LoginServlet" method="POST">
                                <div class="form-group">			 
                                    <label for="usuario">
                                        Usuario
                                    </label>
                                    <input type="text" name="login" value="" class="form-control">
                                </div>
                                <div class="form-group">

                                    <label for="senha">
                                        Senha
                                    </label>
                                    <input type="password" name="senha" value="" class="form-control">
                                </div> 
                                <button type="submit" class="btn btn-primary" type="submit" value="Logar">
                                    Entrar
                                </button>
                            </form>
                        </div>


                        <div class="col-md-4">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts.js"></script>
    </body>
<!--    <footer class="footer">
        <div class="container">
            <span class="text-muted">Em caso de problemas contactar o administrador.</span>
            <span class="text-muted">email@email.com</span>
        </div>
    </footer>-->
</html>
