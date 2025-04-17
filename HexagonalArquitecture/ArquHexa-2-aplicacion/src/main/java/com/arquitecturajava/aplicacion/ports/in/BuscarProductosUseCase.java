package com.arquitecturajava.aplicacion.ports.in;

import java.util.List;

import com.arquitecturajava.aplicacion.dominio.Producto;

public interface BuscarProductosUseCase {
	List <Producto> buscarTodos();
}
