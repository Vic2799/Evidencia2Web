<%-- 
    Document   : transferencias
    Created on : 31-mar-2020, 20:25:44
    Author     : Brandon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Transferencias</title>

    <link rel="stylesheet" type="text/css" href="styles/skeleton.css" />
    <link rel="stylesheet" type="text/css" href="styles/normalize.css" />
</head>

<body>
    <jsp:include page="header.jsp" />
    <div class="container">
        <h1>Lista de transferencias</h1>

        <table class="u-full-width">
            <thead>
                <tr>
                    <th>Cuenta origen</th>
                    <th>Cuenta destino</th>
                    <th>Cantidad</th>
                    <th>Fecha</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="transferencia"
                    items="${transferencias.stream().filter(t -> t.getNumeroCliente() == sessionScope.usuario.getNumeroCliente()).toList()}">
                    <tr>
                        <td>${transferencia.getNumeroCuentaOrigen()}</td>
                        <td>${transferencia.getNumeroCuentaDestino()}</td>
                        <td>${transferencia.getCantidad()}</td>

                        <fmt:parseDate value="${transferencia.getFecha()}" pattern="yyyy-MM-dd" var="parsedDate"
                            type="date" />
                        <fmt:formatDate value="${parsedDate}" var="newParsedDate" type="date" pattern="dd/MM/yyyy" />
                        <td>${newParsedDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>

</html>