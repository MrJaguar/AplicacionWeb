package com.web.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.models.Persona;

@RestController
@RequestMapping("/appiRest")
public class ControladorRest {
	
	@GetMapping("/ver")
	public Persona obtener() {
		Persona a = new Persona();
		a.setApellido("Guajardo");
		a.setNombre("Luis");
		return a;
	}
	

}
