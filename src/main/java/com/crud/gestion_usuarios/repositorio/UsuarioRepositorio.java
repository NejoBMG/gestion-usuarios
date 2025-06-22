package com.crud.gestion_usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.gestion_usuarios.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends
        JpaRepository<Usuario, Integer> {
}
