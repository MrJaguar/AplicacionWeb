package com.web.app.repositorys;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.controllers.entitys.Alumno;

@Repository
public class AlumnoDaoImpl implements AlumnoDao {

	@Autowired
	private EntityManager en;
	
	@Override
	@Transactional(readOnly = true)
	public Alumno find(Long primary) {
		return en.find(Alumno.class, primary);
	}

	@Override
	@Transactional
	public void insert(Alumno entity) {
		en.persist(entity);

	}

	@Override
	@Transactional
	public void update(Alumno entity) {
		en.merge(entity);

	}

	@Override
	@Transactional
	public void delete(Long primary) {
		Alumno eliminar  = find(primary);
		en.remove(eliminar);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll() {
		return en.createQuery("from Alumno").getResultList();
	}

}
