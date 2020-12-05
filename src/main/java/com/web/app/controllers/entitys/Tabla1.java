package com.web.app.controllers.entitys;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Tabla1 {

	@Id
	private Long id;
	private String codigo;

	@ManyToMany
	@JoinTable(name="tabla1_tabla2",
	joinColumns=@JoinColumn(name="tabla1_ID"),
	inverseJoinColumns=@JoinColumn(name="tabla2_ID"))
	private List<Tabla2> tabla2;

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

	public List<Tabla2> getTabla2() {
		return tabla2;
	}

	public void setTabla2(List<Tabla2> tabla2) {
		this.tabla2 = tabla2;
	}

}
