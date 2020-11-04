package com.web.app.models;

public class Alumno {

	private int matricula;
	private String nombre;
	private String correo;

	public Alumno() {
	}

	public Alumno(int matricula, String nombre, String correo) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.correo = correo;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public static class Builder {

		private Alumno instance;

		public Builder() {
			instance = new Alumno();
		}

		public Builder setNombre(String nombre) {
			this.instance.nombre = nombre;
			return this;
		}

		public Builder setMatricula(int matricula) {
			this.instance.matricula = matricula;
			return this;
		}

		public Builder setCorreo(String correo) {
			this.instance.correo = correo;
			return this;
		}

		public Alumno build() {
			return instance;
		}
	}
}
