<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>

    <div class="row u-max-full-width" style="background-color: #ea0b2a; padding: 10px 22px 0px 22px">
        <a href="./"><img class="u-pull-left" src="https://www.banorte.com/cms/redes_sociales/Banorte.jpg" width="180px"
                height="110px"></a>

        <%
            if(session.getAttribute("usuario") != null){
        %>
        <div class="u-pull-right" style="text-align: end;">
            <h4 style="text-align: right; color: white;">Bienvenido ${sessionScope.usuario.getNombre()}</h1>

                <a class="button" href="cerrarSesion.do" style="background-color: #0000001c; color: white;">
                    Cerrar Sesion
                </a>
        </div>
        <%
            }
        %>
    </div>

</body>

</html>