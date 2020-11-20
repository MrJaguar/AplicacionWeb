package com.web.app.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.web.app.validations.MayorDeEdad;

public class Persona {

	@NotEmpty(message = "El nombre no puede ser vacio")
	private String nombre;
	@NotEmpty
	private String apellido;
	@NotNull
	@Min(value = 10)
	@MayorDeEdad
	private Integer edad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
}
