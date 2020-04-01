function validar() {
    var pass = document.getElementById("contra").value;
    var confpass = document.getElementById("validarcontra").value;

    if (pass !== confpass) {
        alert("Las contraseñas no son iguales");
        return false;
    }
    return true;
}

