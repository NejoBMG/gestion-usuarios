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

    public List<Perfil> listar(){
        return perfilRespositorio.findAll();
    }
}
