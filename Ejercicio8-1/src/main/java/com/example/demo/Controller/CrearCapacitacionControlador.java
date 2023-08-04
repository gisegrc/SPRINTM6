package com.example.demo.Controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Modelo.Capacitacion;
import com.example.demo.Repositorio.CapacitacionRepo;


@Controller
public class CrearCapacitacionControlador {
    @Autowired
    private CapacitacionRepo capacitacionRepo;

    @RequestMapping(path="/crearCapacitacion", method = RequestMethod.GET)
    public String MostrarCrearCapacitacion(){
        return "crearcapacitacion";
    }

    @PostMapping("/crearCapacitacion")
    public String crearCapacitacion(@RequestParam("nombre") String nombre,
                                    @RequestParam("detalle") String detalle,
                                    @RequestParam("dia") LocalDate dia,
                                    @RequestParam("hora") LocalTime hora,
                                    @RequestParam("lugar") String lugar,
                                    @RequestParam("duracion") LocalTime duracion,
                                    @RequestParam("cantidadAsistentes") Integer cantidadAsistentes)   {

        Capacitacion capacitacion = new Capacitacion();
        capacitacion.setNombre(nombre);
        capacitacion.setDetalle(detalle);
        capacitacion.setDia(dia);
        capacitacion.setHora(hora);
        capacitacion.setLugar(lugar);
        capacitacion.setDuracion(duracion);
        capacitacion.setCantidadAsistentes(cantidadAsistentes);
        capacitacionRepo.save(capacitacion);

        return "redirect:/listarCapacitaciones";
    }
}
