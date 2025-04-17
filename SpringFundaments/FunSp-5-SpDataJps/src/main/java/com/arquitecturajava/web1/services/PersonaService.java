package com.arquitecturajava.web1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arquitecturajava.web1.models.Examen;
import com.arquitecturajava.web1.models.Persona;
import com.arquitecturajava.web1.repositories.ExamenRepository;
import com.arquitecturajava.web1.repositories.PersonaRepository;

@Service 
public class PersonaService {

	private ExamenRepository repositorioExamen;
	private PersonaRepository repositorioPersona;

	public PersonaService(ExamenRepository repositorioExamen, PersonaRepository repositorioPersona) {
		super();
		this.repositorioExamen = repositorioExamen;
		this.repositorioPersona = repositorioPersona;
	}

	public List<Examen> buscarTodosLosExamenes() {
		return repositorioExamen.findAll();
	}

	public void insertarExamen(Examen examen) {
		repositorioExamen.save(examen);
	}

	public void borrarExamen(Examen examen) {
		repositorioExamen.delete(examen);
	}

	public List<Examen> buscarTodosLosExamnesPorNombre(String nombre) {
		return repositorioExamen.buscarTodosPorNombre(nombre);
	}

	public List<Persona> buscarTodosLasPersonas() {
		return repositorioPersona.findAll();
	}

	public void insertarPersona(Persona persona) {
		repositorioPersona.save(persona);
	}

	public void borrarPersona(Persona persona) {
		repositorioPersona.delete(persona);
	}

	public Optional <Persona> buscarUnoPersona(String nombre) {
		return repositorioPersona.findById(nombre);
	}
	
	public void actualizarPersona(Persona persona) {
		repositorioPersona.save(persona);
	}
	
}
