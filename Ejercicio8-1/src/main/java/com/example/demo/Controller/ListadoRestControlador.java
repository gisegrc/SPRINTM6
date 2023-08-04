package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Modelo.Roles;
import com.example.demo.Modelo.Usuario;
import com.example.demo.Repositorio.UsuarioRepo;

@RestController
public class ListadoRestControlador {

	@Autowired
    private UsuarioRepo usuarioRepo;

    @GetMapping("/clientes")
    public List<Usuario> obtenerUsuarios(){
        return usuarioRepo.findAllClientes(Roles.Cliente);
    }
}
