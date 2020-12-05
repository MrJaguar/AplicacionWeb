package com.web.app.controllers.entitys;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tabla2 {

	@Id
	private Long id;
	private String codigo;

	@ManyToMany(mappedBy = "tabla2")
	private List<Tabla1> tabla1;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Tabla1> getTabla1() {
		return tabla1;
	}

	public void setTabla1(List<Tabla1> tabla1) {
		this.tabla1 = tabla1;
	}

}
