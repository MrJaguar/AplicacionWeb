package com.web.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.app.controllers.entitys.Alumno;
import com.web.app.services.AlumnoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired 
	private AlumnoService as;
	
	@GetMapping(path = {"", "/"})
	public String home(Model model) {
		model.addAttribute("titulo", "Home Alumno");
		model.addAttribute("alumnos", as.findAll());
		return "alumno/index";
	}
	
	@GetMapping(path = { "/alta"})
	public String alta(Model model) {
		model.addAttribute("titulo", "Alta Alumno");
		model.addAttribute("alumno", new Alumno());
		return "alumno/alta";
	}
	@GetMapping(path = { "/editar/{matricula}"})
	public String editar(@PathVariable Long matricula,Model model) {
		model.addAttribute("titulo", "Editar Alumno");
		model.addAttribute("alumno", as.find(matricula));
		return "alumno/editar";
	}
	
	@PostMapping(path = {"/guardar"})
	private String guardar(@Valid Alumno alumno, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Alta Alumno");
			return "alumno/alta";
		}
		as.insert(alumno);
		model.addAttribute("titulo", "Home Alumno");
		model.addAttribute("alumnos", as.findAll());
		return "alumno/index";
	}
	@PostMapping(path = {"/update"})
	private String actualizar(@Valid Alumno alumno, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Alta Alumno");
			return "alumno/alta";
		}
		as.update(alumno);
		model.addAttribute("titulo", "Home Alumno");
		model.addAttribute("alumnos", as.findAll());
		return "alumno/index";
	}
	
	@GetMapping(path = {"/eliminar/{matricula}"})
	private String eliminar(@PathVariable Long matricula, Model model) {
		
		as.delete(matricula);
		model.addAttribute("titulo", "Home Alumno");
		model.addAttribute("alumnos", as.findAll());
		return "alumno/index";
	}
}
