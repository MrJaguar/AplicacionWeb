package com.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.app.controllers.entitys.Trabajador;
import com.web.app.models.Persona;
import com.web.app.services.TrabajadorService;

@Controller
@RequestMapping("/bd")
public class BaseDeDatosContoller {
	
	@Autowired
	private TrabajadorService trabajadorS;
	
	@GetMapping(path = {"/", ""})
	public String form(Model model) {
		model.addAttribute("titulo", "Formulario Basico");
		model.addAttribute("persona", new Persona());
		return "baseDatos/form";
	}
	
	@GetMapping(path = {"/insert"})
	public String agregar( Model model) {
		Trabajador t =  new Trabajador();
		t.setId(3);
		t.setNombre("Raquel");
		t.setEdad(22);
		trabajadorS.insert(t);
		model.addAttribute("titulo", "Formulario Basico");
		model.addAttribute("persona", new Persona());
		return "baseDatos/form";
	}

}
