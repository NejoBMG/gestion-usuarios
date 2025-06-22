package com.crud.gestion_usuarios.servicio;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.gestion_usuarios.modelo.Usuario;
import com.crud.gestion_usuarios.repositorio.UsuarioRepositorio;
@Service
public class UsuarioServicio implements UsuarioServicioInterfaz {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> listar() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario obtenerUsuarioId(int id) {
        return usuarioRepositorio.findById(id).get();
    }

    @Override
    public Usuario modificarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(int id) {
        usuarioRepositorio.deleteById(id);
    }
}
