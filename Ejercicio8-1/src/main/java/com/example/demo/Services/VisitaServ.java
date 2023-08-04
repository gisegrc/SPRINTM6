package com.example.demo.Services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Modelo.Visita;
import com.example.demo.Repositorio.VisitaRepo;

@Service
public class VisitaServ {

	@Autowired
    private VisitaRepo visitaRepo;

    public void registrarVisita(String nombreUsuario, String rol){
        LocalDateTime fechaRegistro = LocalDateTime.now();

        Visita visita = new Visita();
        visita.setNombre(nombreUsuario);
        visita.setRol(rol);
        visita.setFechaIngreso(fechaRegistro);
        visitaRepo.save(visita);
    }
}
