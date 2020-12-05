package com.web.app.repositorys;

import java.util.List;

import com.web.app.controllers.entitys.Trabajador;

public interface TrabajadorDAO {
	
	void insert(Trabajador t);
	Trabajador find(Integer id);
	List<Trabajador>findAll();
	void update(Trabajador t);
	void delete(Trabajador t);
	

}
