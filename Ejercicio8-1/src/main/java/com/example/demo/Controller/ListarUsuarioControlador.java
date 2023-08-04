package com.example.demo.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Modelo.Administrativo;
import com.example.demo.Modelo.Cliente;
import com.example.demo.Modelo.Profesional;
import com.example.demo.Modelo.Usuario;
import com.example.demo.Repositorio.AdministrativoRepo;
import com.example.demo.Repositorio.ClienteRepo;
import com.example.demo.Repositorio.ProfesionalRepo;
import com.example.demo.Repositorio.UsuarioRepo;


@Controller
public class ListarUsuarioControlador {
	@Autowired
    private ClienteRepo cliente;
    @Autowired
    private ProfesionalRepo profesional;
    @Autowired
    private AdministrativoRepo administrativo;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @GetMapping("/listarUsuario")
    public String listarUsuarios(Model model){
        List<Cliente> clientes = cliente.findAll();
        List<Profesional> profesionales = profesional.findAll();
        List<Administrativo> administrativos = administrativo.findAll();
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.addAll(clientes);
        usuarios.addAll(profesionales);
        usuarios.addAll(administrativos);
        model.addAttribute("usuarios", usuarios);
        return "listarusuario";
    }

    @GetMapping("/editarUsuario/{id}")
    public String mostrarFormularioEditarUsuario(@PathVariable("id") Integer id, Model model) {
        Optional<Usuario> usuarioOptional = usuarioRepo.findById(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            model.addAttribute("usuario", usuario);

            if (usuario instanceof Cliente) {
                model.addAttribute("cliente", usuario);
            } else if (usuario instanceof Profesional) {
                model.addAttribute("profesional", usuario);
            } else if (usuario instanceof Administrativo) {
                model.addAttribute("administrativo", usuario);
            }

            return "editarusuario";
        }
        return "redirect:/listarUsuario";

    }

    @PostMapping("/actualizarUsuario")
    public String actualizarUsuario(@ModelAttribute Cliente clienteActualizado,
                                    @ModelAttribute Profesional profesionalActualizado,
                                    @ModelAttribute Administrativo administrativoActualizado) {
        Optional<Usuario> usuarioExistenteOptional = usuarioRepo.findById(clienteActualizado.getId());

        if (usuarioExistenteOptional.isPresent()) {
            Usuario usuarioExistente = usuarioExistenteOptional.get();

            // Actualizar los campos comunes para todos los usuarios
            usuarioExistente.setNombre(clienteActualizado.getNombre());
            usuarioExistente.setFechaNacimiento(clienteActualizado.getFechaNacimiento());
            usuarioExistente.setRut(clienteActualizado.getRut());

            // Verificar el tipo de usuario y actualizar los campos específicos
            if (usuarioExistente instanceof Cliente) {
                Cliente clienteExistente = (Cliente) usuarioExistente;
                clienteExistente.setTelefono(clienteActualizado.getTelefono());
                clienteExistente.setAfp(clienteActualizado.getAfp());
                clienteExistente.setSistemaSalud(clienteActualizado.getSistemaSalud());
                clienteExistente.setDireccion(clienteActualizado.getDireccion());
                clienteExistente.setComuna(clienteActualizado.getComuna());
                clienteExistente.setEdad(clienteActualizado.getEdad());
                cliente.save(clienteExistente);
            } else if (usuarioExistente instanceof Profesional) {
                Profesional profesionalExistente = (Profesional) usuarioExistente;
                profesionalExistente.setTitulo(profesionalActualizado.getTitulo());
                profesionalExistente.setFechaIngreso(LocalDate.now());
                profesional.save(profesionalExistente);
            } else if (usuarioExistente instanceof Administrativo) {
                Administrativo administrativoExistente = (Administrativo) usuarioExistente;
                administrativoExistente.setArea_exp(administrativoActualizado.getArea_exp());
                administrativoExistente.setExperienciaPrevia(administrativoActualizado.getExperienciaPrevia());
                administrativo.save(administrativoExistente);
            }
        }

        return "redirect:/listarUsuario";
    }}
