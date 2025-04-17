package com.arquitecturajava.web1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arquitecturajava.web1.models.Persona;
@Repository
public interface PersonaRepository extends JpaRepository<Persona,String> {


}