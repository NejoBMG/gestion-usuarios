package com.crud.gestion_usuarios.servicio;

import java.util.List;

import com.crud.gestion_usuarios.modelo.Perfil;


public interface PerfilServicioInterfaz {
    public List<Perfil> listar();
    public Perfil obtenerPerfilId(int id);
    public void guardarPerfil(Perfil perfil);
    public void eliminarPerfil(int id);

}
