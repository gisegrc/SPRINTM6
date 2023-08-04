package com.example.demo.Modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="usuarios")
public class Usuario implements UserDetails{

	@Id
    @GeneratedValue
    private int id;
    @Column
    private String nombre;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    @Enumerated(EnumType.STRING)
    private Roles tipo;
    @Column
    private LocalDate fechaNacimiento;
    @Column
    private String rut;
    
	public Usuario() {
		super();
	}
	
	
	public Usuario(int id, String nombre, String email, String password, Roles tipo, LocalDate fechaNacimiento,
			String rut) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.tipo = tipo;
		this.fechaNacimiento = fechaNacimiento;
		this.rut = rut;
	}

	 public String mostrarEdad() {
	        long edad = ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
	        return "El usuario tiene " + edad + " años";
	    }

	 public String analizarUsuario() {
	        return "Nombre: " + nombre + ", Tipo: " + tipo + ", RUN: " + rut;
	    }

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", password=" + password
				+ ", fechaNacimiento=" + fechaNacimiento + ", rut=" + rut + "]";
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Roles getTipo() {
		return tipo;
	}


	public void setTipo(Roles tipo) {
		this.tipo = tipo;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getRut() {
		return rut;
	}


	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 return Collections.singletonList(new SimpleGrantedAuthority(tipo.name()));
	}
	@Override
	public String getUsername() {
		return email;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}



}
