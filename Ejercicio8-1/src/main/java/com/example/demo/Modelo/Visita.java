package com.example.demo.Modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="visitas")
public class Visita {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column
    private String nombre;

    @Column
    private String rol;

    @Column
    private LocalDateTime fechaIngreso;

	public Visita() {
	}

	public Visita(int id, String nombre, String rol, LocalDateTime fechaIngreso) {
		super();
		Id = id;
		this.nombre = nombre;
		this.rol = rol;
		this.fechaIngreso = fechaIngreso;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
    
	
    
}
