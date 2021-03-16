<%-- 
    Document   : menu
    Created on : 30-04-2019, 20:32:54
    Author     : 17821050-5

AL CREAR EL .jsp EN WEB-INF, ÉSTA SERÁ PRIVADA, SOLO EL SERVLET PUEDE INGRESAR A ELLA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <title>Menú</title>  
        <script>
            history.forward(); //Cuando se inicia sesión, hace que no podamos acceder (volver atrás) a Menú.
        </script>
    </head>
    <body style="font-family: arial">
        <c:import url="opciones.jsp"/>
        
        <h1>Menu de ${vendedor.nombre}</h1>
        <a href="ListaFarmacoController">Listar Fármacos</a>
        <br><br>
        <a href="SalirController">Salir</a>
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </body>
</html>