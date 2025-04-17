package com.arquitecturajava.web1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="examenes")
public class Examen {
	@Id
	private int id; 
	private String asignatura;
	
	@ManyToOne
	@JoinColumn(name="personas_nombre")
	private Persona persona;
	
	public int getId() {
		return id;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
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
