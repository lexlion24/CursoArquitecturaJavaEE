package com.arquitecturajava.web1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arquitecturajava.web1.models.Examen;
import com.arquitecturajava.web1.models.Persona;
import com.arquitecturajava.web1.repositories.PersonaRepository;

@Service 
public class PersonaService {

	private PersonaRepository repositorioPersona;

	public PersonaService(PersonaRepository repositorioPersona) {
		super();
		this.repositorioPersona = repositorioPersona;
	}

	public List<Examen> buscarTodosLosExamenesPersona(String id) {
		
		Optional <Persona> oPersona = repositorioPersona.findById(id);
		if(oPersona.isPresent()) {
			return oPersona.get().getExamenes();
		}else {
			return new ArrayList<Examen>();
		}
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
