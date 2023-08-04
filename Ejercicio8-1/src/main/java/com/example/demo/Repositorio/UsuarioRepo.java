package com.example.demo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Roles;
import com.example.demo.Modelo.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository <Usuario, Integer>{
	Usuario findByEmail(String email);
    @Query("SELECT u FROM Usuario u WHERE u.tipo = :tipoCliente")
    List<Usuario> findAllClientes(@Param("tipoCliente") Roles tipoCliente);
}
