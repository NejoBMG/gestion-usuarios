package com.crud.gestion_usuarios.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.gestion_usuarios.modelo.Perfil;
import com.crud.gestion_usuarios.servicio.PerfilServicio;

@Controller
public class PerfilControlador {

    @Autowired
    private PerfilServicio perfilServicio;

    @GetMapping("/perfil")
    public String listarPerfiles(Model modelo) {
        List<Perfil> perfiles = perfilServicio.listar();
        modelo.addAttribute("perfiles", perfiles);
        return "/perfil/index"; 
    }

    @GetMapping("/perfil/nuevo")
    public String formularioRegistroPerfil(Model modelo) {
        modelo.addAttribute("perfil", new Perfil());
        return "perfil/crear";
    }

    @PostMapping
    public String guardarPerfil(@ModelAttribute("perfil") Perfil perfil) {
        perfilServicio.guardarPerfil(perfil);
        return "redirect:/perfil";
    }

    @GetMapping("/perfil/editar/{id}")
    public String formularioEditarPerfil(@PathVariable int id, Model modelo) {
        Perfil perfil = perfilServicio.obtenerPerfilId(id);
        modelo.addAttribute("perfil", perfil);
        return "/perfil/editar";
    }

    @PostMapping("/{id}")
    public String actualizarPerfil(@PathVariable int id, @ModelAttribute("perfil") Perfil perfilActualizado) {
        Perfil perfilExistente = perfilServicio.obtenerPerfilId(id);
        perfilExistente.setNombre(perfilActualizado.getNombre());
        perfilServicio.guardarPerfil(perfilExistente);
        return "redirect:/perfiles";
    }

    @GetMapping("/{id}")
    public String eliminarPerfil(@PathVariable int id) {
        perfilServicio.eliminarPerfil(id);
        return "redirect:/perfil";
    }
}
