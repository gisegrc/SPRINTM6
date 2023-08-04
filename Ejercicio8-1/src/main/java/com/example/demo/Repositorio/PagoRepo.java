package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Modelo.Pago;


public interface PagoRepo extends JpaRepository<Pago, Integer> {

}
