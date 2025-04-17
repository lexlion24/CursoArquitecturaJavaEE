package com.arquitecturajava.web1.repositories;

import org.springframework.stereotype.Repository;

import com.arquitecturajava.web1.models.Persona;


@Repository
public class PersonaRepositoryJPA extends GenericRepositoryJPA<Persona,String> implements PersonaRepository {
	
}
