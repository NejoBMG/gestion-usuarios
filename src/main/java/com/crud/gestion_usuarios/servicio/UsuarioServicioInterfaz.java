package com.crud.gestion_usuarios.servicio;

import java.util.List;

import com.crud.gestion_usuarios.modelo.Usuario;

public interface UsuarioServicioInterfaz {

    public List<Usuario> listar();

    public Usuario guardarUsuario(Usuario usuario);

    public Usuario obtenerUsuarioId(int id);

    public Usuario modificarUsuario(Usuario usuario);

    public void eliminarUsuario(int id);
}
