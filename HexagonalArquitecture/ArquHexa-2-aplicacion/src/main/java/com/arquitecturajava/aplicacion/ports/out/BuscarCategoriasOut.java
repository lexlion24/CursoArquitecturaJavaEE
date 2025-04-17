package com.arquitecturajava.aplicacion.ports.out;

import java.util.List;

import com.arquitecturajava.aplicacion.dominio.Categoria;

public interface BuscarCategoriasOut {

	List<Categoria> buscarTodas();
	
}
