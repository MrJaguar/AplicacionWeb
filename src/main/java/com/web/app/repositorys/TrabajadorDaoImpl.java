package com.web.app.repositorys;

import java.util.List;

import javax.persistence.EntityManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.app.controllers.entitys.Trabajador;

@Repository
public class TrabajadorDaoImpl implements TrabajadorDAO {

	@Autowired
	private EntityManager em;

	@Override
	@Transactional
	public void insert(Trabajador t) {
		em.persist(t);
	}

	@Override
	@Transactional(readOnly = true)
	public Trabajador find(Integer id) {
		// em.createQuery("from Trabajador t where t.nombre = :nombre").setParameter("nombre", "Luis").getFirstResult();
		return em.find(Trabajador.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Trabajador> findAll() {
		//Query no es SQL es un HQL o JPQL -> a los objetos Las clases
		return em.createQuery("from Trabajador").getResultList(); //select * from trabajador sql
		//select t form Trabajador t
	}

	/*
	 * Entidad que es la tabla
	 * Primer estado detached
	 * Segundo estado es que esta dentro de nuestro contexto
	 * */
	@Override
	@Transactional
	public void update(Trabajador t) {
		///em.merge(t); Opcion uno
		Trabajador cambio = find(t.getId());
		cambio.setNombre(t.getNombre());
		cambio.setEdad(t.getEdad());
		
	}

	@Override
	@Transactional
	public void delete(Trabajador t) {
		Trabajador delete = find(t.getId());
		em.remove(delete);	
	}

}
