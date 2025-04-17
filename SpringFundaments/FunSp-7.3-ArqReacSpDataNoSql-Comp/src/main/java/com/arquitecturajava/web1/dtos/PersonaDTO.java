package com.arquitecturajava.web1.dtos;

import com.arquitecturajava.web1.models.Persona;

public class PersonaDTO {

	private String id;
	private String nombre;
	private String apellidos;
	private int edad;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public PersonaDTO(String id, String nombre, String apellidos, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public PersonaDTO(String id) {
		super();
		this.id = id;
	}

	public PersonaDTO() {
		super();
	}

	public PersonaDTO(Persona persona) {
		this.setId(persona.getId());
		this.setNombre(persona.getNombre());
		this.setApellidos(persona.getApellidos());
		this.setEdad(persona.getEdad());

	}

}
