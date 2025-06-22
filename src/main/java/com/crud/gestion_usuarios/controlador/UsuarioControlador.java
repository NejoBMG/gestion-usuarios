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
import com.crud.gestion_usuarios.modelo.Usuario;
import com.crud.gestion_usuarios.servicio.PerfilServicio;
import com.crud.gestion_usuarios.servicio.UsuarioServicio;


@Controller
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private PerfilServicio perfilServicio;

    @GetMapping({"/usuarios", "/"})
    public String listarUsuarios(Model modelo) {
        List<Usuario> usuarios = usuarioServicio.listar();
        modelo.addAttribute("usuarios", usuarios);
        return "index";
    }

    @GetMapping("usuarios/nuevo")
    public String formularioRegistroUsuario(Model modelo) {
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        
        List<Perfil> listaPerfiles = perfilServicio.listar();
        modelo.addAttribute("perfiles", listaPerfiles);
        return "crear";
    }

    @PostMapping("/usuarios")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioServicio.guardarUsuario(usuario);
        return "redirect:/usuarios";
    }
    
    @GetMapping("/usuarios/editar/{id}")
    public String formularioEditarUsuario(@PathVariable int id, Model modelo) {
        modelo.addAttribute("usuario", usuarioServicio.obtenerUsuarioId(id));
        List<Perfil> listaPerfiles = perfilServicio.listar();
        modelo.addAttribute("perfiles", listaPerfiles);
        return "editar";
    }
    
    @PostMapping("/usuarios/{id}")
    public String actualizarUsuario(@PathVariable int id, @ModelAttribute("usuario") Usuario usuario, Model modelo) {
        Usuario usuarioExistente = usuarioServicio.obtenerUsuarioId(id);
        usuarioExistente.setId(id);
        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setApellido(usuario.getApellido());
        usuarioExistente.setLogin(usuario.getLogin());
        usuarioExistente.setContrasenia(usuario.getContrasenia());
        usuarioExistente.setPerfil(usuario.getPerfil());
        usuarioServicio.guardarUsuario(usuarioExistente);
        return "redirect:/usuarios";
    }
    
    @GetMapping("/usuarios/{id}")
    public String eliminarAlumno(@PathVariable int id) {
        usuarioServicio.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
    
}
