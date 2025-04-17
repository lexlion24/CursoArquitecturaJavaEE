package com.arquitecturajava.web1.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.arquitecturajava.web1.models.Persona;
@Repository
public interface PersonaRepository extends MongoRepository<Persona,String> {


}