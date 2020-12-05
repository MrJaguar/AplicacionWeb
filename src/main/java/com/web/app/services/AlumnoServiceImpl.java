package com.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.app.controllers.entitys.Alumno;
import com.web.app.repositorys.AlumnoDao;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	//Patron de diseño Facade -> fachada
	@Autowired
	private AlumnoDao  a;
	@Override
	public Alumno find(Long primary) {
		return a.find(primary);
	}

	@Override
	public void insert(Alumno entity) {
		a.insert(entity);

	}

	@Override
	public void update(Alumno entity) {
		a.update(entity);
	}

	@Override
	public void delete(Long primary) {
		a.delete(primary);
	}

	@Override
	public List<Alumno> findAll() {
		return a.findAll();
	}

}
