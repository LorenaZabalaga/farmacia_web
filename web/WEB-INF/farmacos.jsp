<%-- 
    Document   : farmacos
    Created on : 06-05-2019, 21:18:13
    Author     : 17821050-5
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"/> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <a href="LoginController">
            <img src="WEB-INF/img/home.png" height="50"/>
            <c:import url="opciones.jsp"/>
        </a>
        <h1>Farmacos!</h1>
        <div style="width: 50%; border: 1px solid black; padding: 30px">
            <form action="ListaFarmacoController" method="post">
                <table id="example">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Tipo</th>
                            <th>Accion</th>
                            <th>Laboratorio</th>
                            <th>Precio</th>
                            <th>Stock</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${farmacos}" var="f">
                            <tr>
                                <td>${f.id}</td>
                                <td>${f.nombre}</td>
                                <td>${f.tipo}</td>
                                <td>${f.accion}</td>
                                <td>${f.laboratorio}</td>
                                <td>${f.precio}</td>
                                <td>${f.stock}</td>
                                <td><button class="btn-floating" name="bt" value="${f.id}">Agregar al Carro</button></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <button name="bt" value="clear">Vaciar Carro</button>

                <br>
                <c:if test="${empty carro}">
                    Ningún producto en el carro
                </c:if>
                <c:if test="${not empty carro}">
                    Productos en el carro: ${carro.carroList().size()}<br>

                    <c:forEach items="${carro.carroList()}" var="i">
                        ${i.farmaco.nombre} -
                        ${i.farmaco.precio} -
                        ${i.cantidad} -
                        ${i.cantidad * i.farmaco.precio}
                        <br>
                    </c:forEach>

                </c:if>
            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#example').DataTable(
                        {
                            "language": {
                                "lengthMenu": "Mostrar _MENU_ registros por página",
                                "search": "Buscar",
                                "paginate": {
                                    "previous": "Anterior",
                                    "next": "Siguiente"
                                },

                                "zeroRecords": "Nothing found - sorry",
                                "info": "página _PAGE_ de _PAGES_",
                                "infoEmpty": "No records available",
                                "infoFiltered": "(filtered from _MAX_ total records)"
                            }
                        }
                );
            });
        </script>
    </center>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>