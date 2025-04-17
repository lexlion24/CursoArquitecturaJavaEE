package com.arquitecturajava.aplicacion.ports.in;

import java.util.List;

import com.arquitecturajava.aplicacion.dominio.Categoria;
import com.arquitecturajava.aplicacion.ports.in.commands.AltaProductoCommand;

public interface NuevoProductoUseCase {
	/*No se trabaja directamente con producto porque el interfaz de usuario mezcla
	un conjunto de datos muy heterogeneo que no siempre encaja con un objeto de dominio
 	void registrarProducto(Producto producto);*/
	
	void registrarProducto(AltaProductoCommand comando);
	List<Categoria> buscarTodasLasCategorias();
	
}
