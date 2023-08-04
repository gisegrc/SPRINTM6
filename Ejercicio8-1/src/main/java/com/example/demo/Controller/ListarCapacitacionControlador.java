package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Modelo.Capacitacion;
import com.example.demo.Repositorio.CapacitacionRepo;

@Controller
public class ListarCapacitacionControlador {

    @Autowired
    private CapacitacionRepo caprep;

    @GetMapping("/listarCapacitaciones")
    public String listarCapacitacionesCont(Model model){
        List<Capacitacion> capacitaciones = caprep.findAll();
        model.addAttribute("capacitaciones", capacitaciones);
        return "listarcapacitacion";
    }

    @GetMapping("/editarCapacitacion/{id}")
    public String editarCapacitacionForm(@PathVariable("id") Long id, Model model) {
        Optional<Capacitacion> capacitacionOpcional = caprep.findById(id);

        if(capacitacionOpcional.isPresent()){
            Capacitacion capacitacion = capacitacionOpcional.get();
            model.addAttribute("capacitacion", capacitacion);

            return "editarcapacitacion";
        }

        return "redirect:/listarCapacitaciones";


    }

    @PostMapping("/editarCapacitacion")
    public String editarCapacitacion(@ModelAttribute Capacitacion capacitacionActualizada) {
        Optional<Capacitacion> capacitacionExistenteOpcional = caprep.findById(capacitacionActualizada.getId());

        if (capacitacionExistenteOpcional.isPresent()) {
            Capacitacion capacitacionExistente = capacitacionExistenteOpcional.get();
            capacitacionExistente.setNombre(capacitacionActualizada.getNombre());
            capacitacionExistente.setDetalle(capacitacionActualizada.getDetalle());
            capacitacionExistente.setDetalle(capacitacionActualizada.getDetalle());
            capacitacionExistente.setDia(capacitacionActualizada.getDia());
            capacitacionExistente.setHora(capacitacionActualizada.getHora());
            capacitacionExistente.setLugar(capacitacionActualizada.getLugar());
            capacitacionExistente.setDuracion(capacitacionActualizada.getDuracion());
            capacitacionExistente.setCantidadAsistentes(capacitacionActualizada.getCantidadAsistentes());
    
            caprep.save(capacitacionExistente);
        }

        return "redirect:/listarCapacitaciones";
    }


    @GetMapping("/borrarCapacitacion")
    public String borrarCapacitacion(@RequestParam("id") Long id) {
        Optional<Capacitacion> capacitacionOpcional = caprep.findById(id);

        if (capacitacionOpcional.isPresent()) {
            caprep.deleteById(id);
        }

        return "redirect:/listarCapacitaciones";
    }
}