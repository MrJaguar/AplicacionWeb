package com.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.controllers.entitys.Alumno;
import com.web.app.services.AlumnoService;

@RestController
@RequestMapping("/restAlumno")
public class AlumnoRestController {
	
	@Autowired 
	private AlumnoService as;
	
	@GetMapping(path = {"", "/"})
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public List<Alumno> findAll(){
		return as.findAll();
	}
	
	@GetMapping(path = {"/{matricula}"})
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Alumno find(@PathVariable Long matricula){
		return as.find(matricula);
	}
	
	@GetMapping(path = {"/agregar/{matricula}/{nombre}/{edad}"})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Alumno insert(@PathVariable Long matricula, @PathVariable String nombre,
			@PathVariable Short edad){
		Alumno a = new Alumno();
		a.setMatricula(matricula);
		a.setNombre(nombre);
		a.setEdad(edad);
		as.insert(a);
		return as.find(matricula);
	}
	
	@GetMapping(path = {"/modificar/{matricula}/{nombre}/{edad}"})
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Alumno update(@PathVariable Long matricula, @PathVariable String nombre,
			@PathVariable Short edad){
		Alumno a = new Alumno();
		a.setMatricula(matricula);
		a.setNombre(nombre);
		a.setEdad(edad);
		as.update(a);
		return as.find(matricula);
	}
	
	@GetMapping(path = {"/eliminar/{matricula}"})
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Boolean delete(@PathVariable Long matricula){
		as.delete(matricula);
		return true;
	}

}
