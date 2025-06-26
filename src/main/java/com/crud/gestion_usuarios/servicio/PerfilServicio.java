package com.crud.gestion_usuarios.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.gestion_usuarios.modelo.Perfil;
import com.crud.gestion_usuarios.repositorio.PerfilRespositorio;

@Service
public class PerfilServicio implements PerfilServicioInterfaz{
    @Autowired
    private PerfilRespositorio perfilRespositorio;

    @Override
    public List<Perfil> listar(){
        return perfilRespositorio.findAll();
    }
    @Override
    public Perfil obtenerPerfilId(int id) {
        return perfilRespositorio.findById(id).orElse(null);
    }

    @Override
    public void guardarPerfil(Perfil perfil) {
        perfilRespositorio.save(perfil);
    }

    @Override
    public void eliminarPerfil(int id) {
        perfilRespositorio.deleteById(id);
    }

}
