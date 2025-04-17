package com.arquitecturajava.web1.controllers;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arquitecturajava.web1.models.Persona;
import com.arquitecturajava.web1.services.PersonaService;

@Controller
@RequestMapping("/personas")
public class PersonaController {

	/*
	 * static List <Persona> lista = new ArrayList<Persona>(); static {
	 * lista.add(new Persona("pepe","perez",20)); lista.add(new
	 * Persona("ana","gomez",40)); } memoria
	 */
	//@Autowired
	/*private PersonaRepository repositorio;
	private ExamenRepository examenRepositorio;
	
	public PersonaController(PersonaRepository repositorio, ExamenRepository examenRepositorio) {
		this.repositorio = repositorio;
		this.examenRepositorio=examenRepositorio;
	}*/
	
	private PersonaService personaService;

	public PersonaController(PersonaService personaService) {
		super();
		this.personaService = personaService;
	}

	@GetMapping("/lista")
	public String lista(Model modelo) {

		//modelo.addAttribute("lista", lista); memoria
		modelo.addAttribute("lista", personaService.buscarTodosLasPersonas());

		return "lista";
	}
	
	@GetMapping("/examenes")
	public String examenes(Model modelo, String nombre) {

		//modelo.addAttribute("lista", lista); memoria
		modelo.addAttribute("lista", personaService.buscarTodosLosExamnesPorNombre(nombre));

		return "listaexamenes";
	}

	@GetMapping("/formulario")
	public String formulario() {

		return "formulario";
	}

	@PostMapping("/insertar")
	public String insertar(Model modelo, Persona persona) {
		
		/*lista.add(persona);
		modelo.addAttribute("lista", lista);*/
		personaService.insertarPersona(persona);
		modelo.addAttribute("lista", personaService.buscarTodosLasPersonas());
		
		return "/lista";
	}

	@GetMapping("/borrar")
	public String borrar(Model modelo, @RequestParam String nombre) {

		/*lista.remove(new Persona(nombre));
		modelo.addAttribute("lista", lista);*/
		personaService.borrarPersona(new Persona(nombre));
		modelo.addAttribute("lista", personaService.buscarTodosLasPersonas());

		return "lista";
	}

}
