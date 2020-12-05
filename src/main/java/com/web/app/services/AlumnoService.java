package com.web.app.services;

import java.util.List;

import com.web.app.controllers.entitys.Alumno;

public interface AlumnoService {

	Alumno find(Long primary);
	void insert(Alumno entity);
	void update(Alumno entity);
	void delete(Long primary);
	List<Alumno> findAll();
}
