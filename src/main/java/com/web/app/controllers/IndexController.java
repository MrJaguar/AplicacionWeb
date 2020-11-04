package com.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.app.models.Alumno;

@Controller
@RequestMapping(path = "/app")
public class IndexController {

	private List<Alumno> alumnos = new ArrayList<Alumno>();

	@RequestMapping(path = { "/index", "/", "/home" }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("titulo", "Hola mundo desde Model!!");
		Alumno alumno = new Alumno();
		alumno.setNombre("Luis");
		alumno.setMatricula(1231231);
		alumno.setCorreo("correco@correo.com");
		model.addAttribute("alumno", alumno);
		return "index";
	}

	@GetMapping(path = { "/lista" })
	public String lista(Model model) {
		model.addAttribute("titulo", "Lista!!");

		Alumno alumno = new Alumno(1231231, "Luis", "correco@correo.com");
		Alumno alumno2 = new Alumno.Builder().setNombre("Eduardo").setMatricula(5456456)
				// .setCorreo("asdad1@asdad.com")
				.build();

		alumnos.add(alumno);
		alumnos.add(alumno2);
		model.addAttribute("alumnos", alumnos);
		return "lista";
	}

	@GetMapping(path = "/params")
	public String requestParam(@RequestParam String nombre,
			@RequestParam(name = "apellido") String apellido,
			Model model) {
		model.addAttribute("titulo", "Lista!!");
		Alumno alumno = new Alumno.Builder().setNombre(nombre.concat(" ").concat(apellido)).build();
		alumnos.add(alumno);
		model.addAttribute("alumnos", alumnos);
		return "lista";
	}

	@GetMapping(path = "/path/{nombre}/{apellido}")
	public String requestPath(@PathVariable String nombre,
			@PathVariable String apellido, Model model) {
		model.addAttribute("titulo", "Lista!!");
		Alumno alumno = new Alumno.Builder().setNombre(nombre.concat(" ").concat(apellido)).build();
		alumnos.add(alumno);
		model.addAttribute("alumnos", alumnos);
		return "lista";
	}

}
