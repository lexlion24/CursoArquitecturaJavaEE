package com.arquitecturajava.web1.models;

public class Examen {

	private int id; 
	private String asignatura;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAsignatura() {
		return asignatura;
	}
	
	public Examen(int id, String asignatura) {
		super();
		this.id = id;
		this.asignatura = asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	
	public Examen() {
		super();
	}
	public Examen(int id) {
		super();
		this.id = id;
	}
}
