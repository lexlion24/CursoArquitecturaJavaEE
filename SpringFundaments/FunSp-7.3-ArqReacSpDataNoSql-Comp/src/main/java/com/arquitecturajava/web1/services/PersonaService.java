package com.arquitecturajava.web1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arquitecturajava.web1.models.Examen;
import com.arquitecturajava.web1.models.Persona;
import com.arquitecturajava.web1.repositories.PersonaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service 
public class PersonaService {

	private PersonaRepository repositorioPersona;

	public PersonaService(PersonaRepository repositorioPersona) {
		super();
		this.repositorioPersona = repositorioPersona;
	}
	//List
	public Mono<List<Examen>> buscarTodosLosExamenesPersona(String id) {
		//en cuanto se cambia el repository a ReactiveMongoRepository 
		/*Optional <Persona> oPersona = repositorioPersona.findById(id);
		if(oPersona.isPresent()) {
			return oPersona.get().getExamenes();
		}else {
			return new ArrayList<Examen>();
		}*/
		//el mono que es una persona mapealo a los examenes y devuelveme un mono que contiene una lista de examenes
		Mono<Persona> monoPersona = repositorioPersona.findById(id);
		return monoPersona.map(Persona::getExamenes);
	}
	//List
	public Flux<Persona> buscarTodosLasPersonas() {
		return repositorioPersona.findAll();
	}

	public void insertarPersona(Persona persona) {
		repositorioPersona.save(persona).subscribe();
	}

	public void borrarPersona(Persona persona) {
		repositorioPersona.delete(persona).subscribe();
	}
	//List
	public Mono <Persona> buscarUnoPersona(String nombre) {
		return repositorioPersona.findById(nombre);
	}
	
	public void actualizarPersona(Persona persona) {
		repositorioPersona.save(persona);
	}
	
}
