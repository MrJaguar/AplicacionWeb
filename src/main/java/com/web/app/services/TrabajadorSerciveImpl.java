package com.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.app.controllers.entitys.Trabajador;
import com.web.app.repositorys.TrabajadorDAO;

@Service
public class TrabajadorSerciveImpl implements TrabajadorService {

	@Autowired
	private TrabajadorDAO trabajadorDAO;
	
	@Override
	public void insert(Trabajador t) {
		trabajadorDAO.insert(t);
	}

	@Override
	public Trabajador find(Integer id) {
		return trabajadorDAO.find(id);
	}

	@Override
	public List<Trabajador> findAll() {
		return trabajadorDAO.findAll();
	}

	@Override
	public void update(Trabajador t) {
		trabajadorDAO.update(t);

	}

	@Override
	public void delete(Trabajador t) {
		trabajadorDAO.delete(t);
	}

}
