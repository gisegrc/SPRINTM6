package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Contacto;

@Repository
public interface ContactoRepo extends JpaRepository<Contacto, Integer>{

}
