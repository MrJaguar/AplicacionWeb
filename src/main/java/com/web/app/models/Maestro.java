package com.web.app.models;

public class Maestro {

	private int id;
	private String nombre;
	private int edad;
	private double salario;
	private int cantGrupos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getCantGrupos() {
		return cantGrupos;
	}

	public void setCantGrupos(int cantGrupos) {
		this.cantGrupos = cantGrupos;
	}

}
