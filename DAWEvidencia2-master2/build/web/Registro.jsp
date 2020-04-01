<%-- 
    Document   : Registro
    Created on : 28/03/2020, 03:08:06 PM
    Author     : DAVID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Alta de cliente</title>

    <link rel="stylesheet" type="text/css" href="styles/skeleton.css" />
    <link rel="stylesheet" type="text/css" href="styles/normalize.css" />
    <script src="Scripts/validacionRegistro.js"></script>
</head>

<body>
    <jsp:include page="header.jsp" />
    <div class="container">
        <center>
            <h1>Alta de Cliente</h1>
            <form name="altacliente" action="Registro.do" method="post" onsubmit="return validar()">
                Nombre: <input type="text" name="nombre"><br><br>
                Apellidos: <input type="text" name="apellido"><br><br>
                Dirección: <input type="text" name="direccion"><br><br>
                C.P: <input type="text" name="cp"><br><br>
                Ciudad: <input type="text" name="ciudad"><br><br>
                Estado: <input type="text" name="estado"><br><br>
                País: <input type="text" name="pais"><br><br>
                Teléfono: <input type="text" name="telefono"><br><br>
                Correo Electronico: <input type="text" name="correo"><br><br>
                Fecha de nacimiento: <input type="text" name="fechanac"><br><br>
                Nombre Usuario: <input type="text" name="usuario"><br><br>
                Número de cliente: <input type="text" name="numcliente"><br><br>
                Contraseña: <input type="password" name="contrasena" id="contra"><br><br>
                Repetir Contraseña: <input type="password" name="validarcontrasena" id="validarcontra"><br><br>
                <label for="tipoCliente">Tipo de cliente</label>
                <select name="tipoCliente">
                    <option value="cliente">Cliente</option>
                    <option value="administrador">Administrador</option>
                </select>
                <input class="button-primary" type="submit" value="Registro">
            </form>
        </center>
    </div>
</body>

</html>