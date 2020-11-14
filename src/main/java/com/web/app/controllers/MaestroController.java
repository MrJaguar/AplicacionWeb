package com.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.app.models.Maestro;
import com.web.app.services.IMaestroService;

@Controller
//@RequestScope
@RequestMapping(path = "/maestro")
public class MaestroController {
	
	//Inyeccion de dependencias
	@Autowired
	@Qualifier("servicio2")
	private IMaestroService service;

	@Value("${mensaje.titulo}")
	private String titulo;

	@Autowired
	private Environment env;
	
	@GetMapping(path = "/")
	public String verLista(Model model) {
		Maestro m = new Maestro();
		m.setId(1);
		m.setNombre("Luis");
		m.setEdad(24);
		m.setCantGrupos(3);
		m.setSalario(11515.225);
		service.agregarMaestro(m);
		model.addAttribute("titulo", env.getProperty("mensaje.titulo"));
		model.addAttribute("listaMaestros", service.mostrarMaestros());
		return "maestro/listar";
	}

	@GetMapping(path = "/alta")
	public String alta(@RequestParam String nombre, @RequestParam Integer edad, Model model) {
		service.agregarMaestro(nombre, edad);
		model.addAttribute("titulo", titulo);
		model.addAttribute("listaMaestros", service.mostrarMaestros());
		return "maestro/listar";
	}

	@GetMapping(path = "/eliminar")
	public String eliminar(@RequestParam int id, Model model) {
		service.eliminarMaestro(id);
		model.addAttribute("titulo", titulo);
		model.addAttribute("listaMaestros", service.mostrarMaestros());
		return "maestro/listar";
	}

}
