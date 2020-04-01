<%-- 
    Document   : transferencia
    Created on : 31-mar-2020, 18:35:11
    Author     : Brandon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Transferencia</title>

    <link rel="stylesheet" type="text/css" href="styles/skeleton.css" />
    <link rel="stylesheet" type="text/css" href="styles/normalize.css" />
</head>

<body>
    <jsp:include page="header.jsp" />
    <div class="container">
        <h1>Transferencia</h1>

        <form action="Transferencia.do" method="POST">
            <label for="numCuentaOrigen">N&uacute;mero de cuenta propia</label>
            <select id="numCuentaOrigen" name="numCuentaOrigen" required="true">
                <c:forEach var="cuenta"
                    items="${listacuentas.stream().filter(c -> c.getNumCliente() == sessionScope.usuario.getNumeroCliente()).toList()}">
                    <option value="${cuenta.getNumCuenta()}">${cuenta.getNumCuenta()}</option>
                </c:forEach>
            </select>

            <label for="numCuentaDestino">N&uacute;mero de cuenta a depositar</label>
            <input id="numCuentaDestino" type="text" name="numCuentaDestino" required="true">

            <label for="cantidad">Cantidad</label>
            <input id="cantidad" type="number" name="cantidad" min="0" required="true"><br><br>

            <input class="button-primary" type="submit" value="Transferir">
        </form>
    </div>
</body>

</html>