package com.arquitecturajava.web1.repositories;

import java.util.List;
import java.util.Optional;

public interface GenericRepository <T,K>{
	void insertar (T tipo);
	void borrar(T tipo);
	Optional<T> buscarUno(K clave);
	void actualizar (T tipo);
	List <T> buscarTodos();
	
}
