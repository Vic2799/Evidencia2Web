<%-- 
    Document   : DetalleCliente
    Created on : 28/03/2020, 09:11:07 PM
    Author     : DAVID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" type="text/css" href="styles/skeleton.css" />
        <link rel="stylesheet" type="text/css" href="styles/normalize.css" />
    </head>

    <body>
        <jsp:include page="header.jsp" />
        <div class="container">
            <h1>Detalle del cliente</h1>
            <table class="u-full-width">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Direccion</th>
                        <th>Codigo Postal</th>
                        <th>Ciudad</th>
                        <th>Estado</th>
                        <th>Pais</th>
                        <th>Telefono</th>
                        <th>Correo</th>
                        <th>Fecha de Nacimiento</th>
                        <th>Nombre de Usuario</th>
                        <th>Numero de Cliente</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="cliente" items="${listaclientes}">
                        <tr>
                            <td>${cliente.nombre}</td>
                            <td>${cliente.apellido}</td>
                            <td>${cliente.direccion}</td>
                            <td>${cliente.cp}</td>
                            <td>${cliente.ciudad}</td>
                            <td>${cliente.estado}</td>
                            <td>${cliente.pais}</td>
                            <td>${cliente.telefono}</td>
                            <td>${cliente.correo}</td>
                            <td>${cliente.fecha_nacimiento}</td>
                            <td>${cliente.nombreUsuario}</td>
                            <td>${cliente.numeroCliente}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br><br>
            <form action="detallecliente.do" method="post">
                <input type="text" name="numerocliente"><br><br>
                <input class="button-primary" type="submit" value="Actualizar">
            </form>
        </div>
    </body>
</html>