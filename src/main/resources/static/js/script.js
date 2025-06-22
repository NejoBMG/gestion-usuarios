function validarFormulario() {
    const nombre = document.getElementById('nombre').value.trim();
    const apellido = document.getElementById('apellido').value.trim();
    const login = document.getElementById('login').value.trim();
    const password = document.getElementById('password').value.trim();
    const perfil = document.querySelector('[name="perfil"]').value;

    const guardarBtn = document.getElementById('guardar-usuario');
    const mensaje = document.getElementById('mensaje');

    let errores = [];

    mensaje.innerHTML = '';

    if (nombre.length < 2) {
        errores.push("El nombre debe tener al menos 2 caracteres.")
    }
    if (apellido.length < 2) {
        errores.push("El apellido debe tener al menos 2 caracteres.")
    }
    if (login.length < 3) {
        errores.push("El login debe tener al menos 3 caracteres.")
    }
    if (password.length < 6) {
        errores.push("La contraseña debe tener al menos 6 caracteres.")
    }
    if (perfil === "") {
        errores.push("Debe seleccionar un perfil.")
    }
    if (errores.length > 0) {
        guardarBtn.disabled = true;
        errores.forEach(error => {
            mensaje.innerHTML += `<div class="alert alert-danger">${error}</div>`;
        });
    } else {
        guardarBtn.disabled = false;
        mensaje.innerHTML = `<div class="alert alert-success">Todos los datos son válidos</div>`;
    }
}

// Detectar cambios en tiempo real
window.addEventListener('DOMContentLoaded', () => {
    const campos = ['nombre', 'apellido', 'login', 'password'];
    campos.forEach(id => {
        document.getElementById(id).addEventListener('input', validarFormulario);
    });

    document.querySelector('[name="perfil"]').addEventListener('change', validarFormulario);
});
