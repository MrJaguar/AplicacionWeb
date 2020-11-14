package com.web.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.web.app.models.Maestro;

@Service("servicio2")
public class MaestroServicio2 implements IMaestroService{

	private List<Maestro> lista = new ArrayList<Maestro>();
	
	@Override
	public List<Maestro> mostrarMaestros() {
		return lista.stream()
				.filter(e -> (e.getId() != 1)?true:false)
				.collect(Collectors.toList());

	}

	@Override
	public void agregarMaestro(String nombre, int edad) {
		Maestro nuevo = new Maestro();
		nuevo.setCantGrupos(3);
		nuevo.setNombre(nombre);
		nuevo.setEdad(edad);
		lista.add(nuevo);

	}

	@Override
	public void agregarMaestro(Maestro nuevo) {
		nuevo.setCantGrupos(3);
		lista.add(nuevo);
	}

	@Override
	public void eliminarMaestro(Integer id) {
		lista.removeIf(e -> id.equals(e.getId()));
	}

}
