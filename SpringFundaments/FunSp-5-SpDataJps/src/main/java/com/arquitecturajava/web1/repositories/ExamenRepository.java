package com.arquitecturajava.web1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arquitecturajava.web1.models.Examen;
@Repository
public interface ExamenRepository extends JpaRepository<Examen, Integer>{
	
	@Query("select e from Examen e where e.persona.nombre =:nombre")
	List <Examen> buscarTodosPorNombre(String nombre);

}