package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Modelo.Visita;
import com.example.demo.Repositorio.VisitaRepo;

@Controller
public class ListarVisitasControlador {

	@Autowired
    private VisitaRepo visitaRepo;
	
	@GetMapping("/listarVisitas")
    public String listarVisitas(Model model){
        List<Visita> visitas = visitaRepo.findAll();
        model.addAttribute("visitas", visitas);
        return "listadovisitas";
    }
}
