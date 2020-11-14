package com.web.app.services;

import java.util.List;

import com.web.app.models.Maestro;

public interface IMaestroService {

	public List<Maestro> mostrarMaestros();
	public void agregarMaestro(String nombre, int edad);
	public void agregarMaestro(Maestro nuevo);
	public void eliminarMaestro(Integer id);
}
