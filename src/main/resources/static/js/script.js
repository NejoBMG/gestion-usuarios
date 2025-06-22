function validarFormulario() {
    var nombre = document.getElementById('nombre').value;
    var apellido = document.getElementById('apellido').value;
    var login = document.getElementById('login').value;
    var password = document.getElementById('password').value;

    var mensaje = document.getElementById('mensaje');
    mensaje.innerHTML = '';
    console.log(nombre);
    if (nombre.length < 2) {
        mensaje.innerHTML += '<div class="alert alert-danger">El nombre debe tener al menos 2 caracteres.</div>';
    }
    if (apellido.length < 2) {
        mensaje.innerHTML += '<div class="alert alert-danger">El apellido debe tener al menos 2 caracteres.</div>';
    }
    if (login.length < 3) {
        mensaje.innerHTML += '<div class="alert alert-danger">El login debe tener al menos 3 caracteres.</div>';
    }
    if (password.length < 6) {
        mensaje.innerHTML += '<div class="alert alert-danger">La contraseña debe tener al menos 6 caracteres.</div>';
    }
    if (mensaje.innerHTML == '') {
        mensaje.innerHTML = '<div class="alert alert-success">Todos los datos son correctos.</div>';
    }
}

