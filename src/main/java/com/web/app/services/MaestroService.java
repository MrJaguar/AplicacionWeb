package com.web.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.web.app.models.Maestro;

@Component
@Primary
public class MaestroService implements IMaestroService {

	private List<Maestro> lista = new ArrayList<Maestro>();

	@Override
	public List<Maestro> mostrarMaestros() {
		return lista;
	}

	@Override
	public void agregarMaestro(String nombre, int edad) {
		Maestro nuevo = new Maestro();
		nuevo.setNombre(nombre);
		nuevo.setEdad(edad);
		lista.add(nuevo);

	}

	@Override
	public void agregarMaestro(Maestro nuevo) {
		lista.add(nuevo);
	}

	@Override
	public void eliminarMaestro(Integer id) {
		lista.removeIf(e -> id.equals(e.getId()));
	}
}
