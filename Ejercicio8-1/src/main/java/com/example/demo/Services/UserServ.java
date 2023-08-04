package com.example.demo.Services;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Modelo.Usuario;
import com.example.demo.Repositorio.UsuarioRepo;


public class UserServ implements UserDetailsService{

    private UsuarioRepo usuarioRepo;

    public void UserService(UsuarioRepo usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findByEmail(email);

        if (usuario == null) {
            throw new UsernameNotFoundException("No existen registros de este usuario en el sistema: " + email);
        }
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getTipo().name()));
        return new User(usuario.getEmail(), usuario.getPassword(), authorities);
    }
}

