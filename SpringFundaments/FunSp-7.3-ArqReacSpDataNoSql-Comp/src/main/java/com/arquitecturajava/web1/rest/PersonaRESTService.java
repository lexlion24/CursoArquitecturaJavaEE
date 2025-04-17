package com.arquitecturajava.web1.rest;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arquitecturajava.web1.dtos.PersonaDTO;
import com.arquitecturajava.web1.models.Persona;
import com.arquitecturajava.web1.services.PersonaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webapi/personas")
public class PersonaRESTService {

	private PersonaService personaService;

	public PersonaRESTService(PersonaService personaService) {
		super();
		this.personaService = personaService;
	}

	@GetMapping
	public Flux<PersonaDTO> buscarTodos() {
		// programacion funcional
		// de convertir una lista de Personas en una lista de PersonaDTO
		/*return personaService.buscarTodosLasPersonas()
				.stream()
				.map(PersonaDTO::new)
				.collect(Collectors.toList());*/
		return personaService.buscarTodosLasPersonas().map(PersonaDTO::new);
	}

	@GetMapping("{id}")
	public Mono<PersonaDTO> buscarUno(@PathVariable String id) {
		
		/*Optional <Persona> oPersona = personaService.buscarUnoPersona(id); 
		if(oPersona.isPresent()) {
			return new PersonaDTO(oPersona.get());
		}
		
		/*
		 * esto es una posibilidad pero se podria usar un response entity 
		 * para profundizar mas en como se devuelve el dto
		 */
		
		Mono<Persona> monoPersona = personaService.buscarUnoPersona(id);
		
		return monoPersona.map(PersonaDTO::new);
	}
	
	@DeleteMapping("{id}")
	public void borrar(@PathVariable String id) {
		//personaService.borrarPersona(new Persona(id));
		personaService.borrarPersona(new Persona(id));
	}
	
	@PostMapping
	public void insertar (@RequestBody PersonaDTO personaDTO) {
		Persona p = new Persona();
		p.setNombre(personaDTO.getNombre());
		p.setApellidos(personaDTO.getApellidos());
		p.setEdad(personaDTO.getEdad());
		personaService.insertarPersona(p);
	}
	
	@PutMapping("{id}")
	public void actualizar (@PathVariable String id,@RequestBody PersonaDTO personaDTO) {
		
		/*Optional<Persona> oPersona=personaService.buscarUnoPersona(nombre);
		
		if(oPersona.isPresent()) {
			Persona persona = oPersona.get();
			persona.setApellidos(personaDTO.getApellidos());
			persona.setEdad(personaDTO.getEdad());
			personaService.actualizarPersona(persona);
			*/
		Mono<Persona>monoPersona = personaService.buscarUnoPersona(id);
		monoPersona.subscribe((Persona persona) -> {
			persona.setApellidos(personaDTO.getApellidos());
			persona.setEdad(personaDTO.getEdad());
			personaService.actualizarPersona(persona);
		});
	}
	
	
}
