package com.arquitecturajava.web1.repositories;

import java.util.List;

import com.arquitecturajava.web1.models.Examen;

public interface ExamenRepository extends GenericRepository<Examen, Integer>{
	
	List <Examen> buscarTodosPorNombre(String nombre);

}