package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoControlador{

    @GetMapping("/Contacto")
    public String mostrarFormularioContacto() {
        return "contacto"; 
    }
}
