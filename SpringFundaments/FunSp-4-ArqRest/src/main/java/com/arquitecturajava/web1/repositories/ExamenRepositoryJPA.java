package com.arquitecturajava.web1.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.arquitecturajava.web1.models.Examen;

import jakarta.persistence.TypedQuery;

@Repository
public class ExamenRepositoryJPA extends GenericRepositoryJPA<Examen,Integer> implements ExamenRepository {
	
	@Override
	public List<Examen> buscarTodosPorNombre(String nombre) {
		
		TypedQuery<Examen> consulta = entityManager.createQuery("select e from Examen e where e.persona.nombre =:nombre ",Examen.class);
		consulta.setParameter("nombre", nombre);
		return consulta.getResultList();
	}

}
