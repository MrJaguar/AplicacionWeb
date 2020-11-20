package com.web.app.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.app.models.Persona;

@Controller
@RequestMapping("/form")
public class FormularioController {
	
	@GetMapping(path = {"","/"})
	public String formularioSimple(Model model) {
		model.addAttribute("titulo", "Formulario Basico");
		return "formulario";
	}
	
	@GetMapping(path = {"/objeto"})
	public String formulario(Model model) {
		model.addAttribute("titulo", "Formulario Basico");
		model.addAttribute("persona", new Persona());
		return "form";
	}
	
	@PostMapping(path = {"","/"})
	//@RequestMapping(method = RequestMethod.GET)
	public String resultadoSimple(
			@RequestParam(name = "nombre") String nombre, 
			@RequestParam String apellido,
			Model model) {
		model.addAttribute("titulo", "Formulario Basico Resultado");
		Persona p = new Persona();
		p.setNombre(nombre);
		p.setApellido(apellido);
		model.addAttribute("persona", p);
		model.addAttribute("nombreCompleto", p.getNombre().concat(" ").concat(p.getApellido()));
		
		return "resultado";
		
	}
	@PostMapping(path = {"/resultado"})
	//@RequestMapping(method = RequestMethod.GET)
	public String resultadoSimple(@Valid Persona persona, BindingResult result,
			Model model) {
		
		model.addAttribute("titulo", "Formulario Objeto Resultado");
		if(result.hasErrors()) {
			return "form";
		}
		
		model.addAttribute("persona", persona);
		model.addAttribute("nombreCompleto", persona.getNombre().concat(" ").concat(persona.getApellido()));
		
		return "resultado";
		
	}
	
	

}
