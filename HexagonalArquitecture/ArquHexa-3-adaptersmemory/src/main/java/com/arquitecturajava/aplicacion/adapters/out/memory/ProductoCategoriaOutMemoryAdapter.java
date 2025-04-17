package com.arquitecturajava.aplicacion.adapters.out.memory;

import java.util.ArrayList;
import java.util.List;

import com.arquitecturajava.aplicacion.dominio.Categoria;
import com.arquitecturajava.aplicacion.dominio.Producto;
import com.arquitecturajava.aplicacion.ports.out.BuscarCategoriasOut;
import com.arquitecturajava.aplicacion.ports.out.BuscarProductosOut;
import com.arquitecturajava.aplicacion.ports.out.NuevoProductoOut;

public class ProductoCategoriaOutMemoryAdapter 
implements BuscarCategoriasOut,NuevoProductoOut,BuscarProductosOut{
	/*esto es un proceso parcial en el que vamos 
	a gusrdar primero en memoria antes de ver como usar 
	otras herramientas de persistencia */
	
	private static List<Producto> productos = new ArrayList<Producto>();
	private static List<Categoria> categorias = new ArrayList<Categoria>();
	
	static {
		categorias.add(new Categoria (1,"informatica"));
		categorias.add(new Categoria (2,"deporte"));
	}
	
	@Override
	public void salvarProducto(Producto producto) {
		productos.add(producto);
	}

	@Override
	public void asignarCategoriaProducto(Producto producto, Categoria categoria) {
		
		int indice = productos.indexOf(producto);
		productos.get(indice).setCategoria(categoria);
		
	}

	@Override
	public List<Categoria> buscarTodas() {
		return categorias;
	}

	@Override
	public List<Producto> buscarTodos() {
		return productos;
	}

}
