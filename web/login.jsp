<%-- 
    Document   : login
    Created on : 30-04-2019, 20:31:25
    Author     : 17821050-5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acceso</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    </head>
    <body style="font-family: arial" class="blue">
    <center>
        <div class="container center">
            <div class="card-panel white z-depth-5">
                <img src="WEB-INF/img/login.png"/>
                <h1>Ingresar al Sistema</h1>
                <form action="LoginController" method="POST">
                    <input type="text" name="x1" placeholder="RUT"/>
                    <input type="password" name="x2" placeholder="Contraseña"/>
                    <button class="btn blue">Acceder</button>
                </form>
                <p>
                    ${error}
                </p>
            </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </body>
</html>