package com.arquitecturajava.aplicacion.ports.out;

import java.util.List;

import com.arquitecturajava.aplicacion.dominio.Producto;

public interface BuscarProductosOut {
	
	List<Producto> buscarTodos();
}
