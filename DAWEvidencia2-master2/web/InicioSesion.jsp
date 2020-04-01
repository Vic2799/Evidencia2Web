<%-- 
    Document   : InicioSesion
    Created on : 28/03/2020, 03:03:32 PM
    Author     : DAVID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Iniciar Sesion</title>
        
        <link rel="stylesheet" type="text/css" href="styles/skeleton.css"/>
        <link rel="stylesheet" type="text/css" href="styles/normalize.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="container">
            <h1>Iniciar Sesion</h1>
            <form action="iniciarSesion.do" method="post">
                <div class="row">
                    <div class="six columns">
                        <label for="user">Usuario</label>
                        <input class="u-full-width" type="text" name="user" id="user" placeholder="Usuario" required="true">
                    </div>
                </div>
                <div class="row">
                    <div class="six columns">
                        <label for="password">Contrase&ntilde;a</label>
                        <input class="u-full-width" type="password" name="pass" id="password" placeholder="Contrase&ntilde;a" required="true">
                    </div>
                </div>

                <br>
                <input type="submit" value="Iniciar Sesion" class="button-primary">

            </form>
        </div>
    </body>
</html>
