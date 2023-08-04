package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Modelo.Pago;
import com.example.demo.Repositorio.PagoRepo;

@Controller
public class ListarPagosControlador {

	  @Autowired
	    private PagoRepo pagoRepo;

	    @GetMapping("/listarPagos")
	    public String listarPagos(Model model){
	        List<Pago> pagos = pagoRepo.findAll();
	        model.addAttribute("pagos", pagos);
	        return "listadoPagos";
	    }
}
