package com.arquitecturajava.aplicacion.ports.out;

import com.arquitecturajava.aplicacion.dominio.Categoria;
import com.arquitecturajava.aplicacion.dominio.Producto;

public interface NuevoProductoOut {
	void salvarProducto (Producto producto);
	void asignarCategoriaProducto(Producto producto,Categoria categoria);
}
