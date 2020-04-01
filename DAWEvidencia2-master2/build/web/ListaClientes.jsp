

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" type="text/css" href="styles/skeleton.css"/>
        <link rel="stylesheet" type="text/css" href="styles/normalize.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="container">
            <h1>Lista de Clientes</h1>
            <table class="u-full-width">
                <thead>
                    <tr>
                        <th>Numero de Cliente</th>
                        <th>Nombre</th>
                        <th>Ciudad</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="lista" items="${listaclientes}">
                        <tr>
                            <td>${lista.numeroCliente}</td>
                            <td>${lista.nombre}</td>
                            <td>${lista.ciudad}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
