package com.arquitecturajava.web1.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arquitecturajava.web1.models.Examen;
import com.arquitecturajava.web1.models.Persona;
import com.arquitecturajava.web1.services.PersonaService;

@Controller
@RequestMapping("/examenes")
public class ExamenController {

	/*
	 * private ExamenRepository repositorio; private PersonaRepository
	 * repositorioPersona;
	 * 
	 * public ExamenController(ExamenRepository repositorio,PersonaRepository
	 * repositorioPersona) { this.repositorio = repositorio;
	 * this.repositorioPersona=repositorioPersona; }
	 */

	private PersonaService personaService;

	public ExamenController(PersonaService personaService) {
		super();
		this.personaService = personaService;
	}

	@GetMapping("/lista")
	public String lista(Model modelo) {

		modelo.addAttribute("lista", personaService.buscarTodosLosExamenes());

		return "listaexamenes";
	}

	@GetMapping("/formulario")
	public String formulario() {

		return "formularioexamen";
	}

	@PostMapping("/insertar")
	public String insertar(Model modelo, Examen examen, String nombrePersona) {
		System.out.println(nombrePersona);
		Optional <Persona> oPersona = personaService.buscarUnoPersona(nombrePersona);
		//si realmente existe la persona y la tengo añade la persona a la lista
		if(oPersona.isPresent()) {
			examen.setPersona(oPersona.get());
			personaService.insertarExamen(examen);
		}else {
			//ir a ventana de error o similar 
		}
		modelo.addAttribute("lista", personaService.buscarTodosLosExamenes());

		return "/listaexamenes";
	}

	@GetMapping("/borrar")
	public String borrar(Model modelo, @RequestParam int id) {

		personaService.borrarExamen(new Examen(id));
		modelo.addAttribute("lista", personaService.buscarTodosLosExamenes());

		return "listaexamenes";
	}

}
