package com.arquitecturajava.web1.controllers;

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

	private PersonaService personaService;

	public PersonaController(PersonaService personaService) {
		super();
		this.personaService = personaService;
	}

	@GetMapping("/lista")
	public String lista(Model modelo) {

		modelo.addAttribute("lista", personaService.buscarTodosLasPersonas());

		return "lista";
	}

	@GetMapping("/examenes")
	public String examenes(Model modelo, String id) {

		modelo.addAttribute("lista", personaService.buscarTodosLosExamenesPersona(id));

		return "listaexamenes";
	}

	@GetMapping("/formulario")
	public String formulario() {

		return "formulario";
	}

	@PostMapping("/insertar")
	public String insertar(Model modelo, Persona persona) {

		personaService.insertarPersona(persona);
		modelo.addAttribute("lista", personaService.buscarTodosLasPersonas());

		return "/lista";
	}

	@GetMapping("/borrar")
	public String borrar(Model modelo, @RequestParam String id) {

		personaService.borrarPersona(new Persona(id));
		modelo.addAttribute("lista", personaService.buscarTodosLasPersonas());

		return "lista";
	}

}
