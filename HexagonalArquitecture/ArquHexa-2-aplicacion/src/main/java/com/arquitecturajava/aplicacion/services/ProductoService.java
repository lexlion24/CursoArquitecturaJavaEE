package com.arquitecturajava.aplicacion.services;

import java.util.List;

import com.arquitecturajava.aplicacion.dominio.Categoria;
import com.arquitecturajava.aplicacion.dominio.Producto;
import com.arquitecturajava.aplicacion.ports.in.BuscarProductosUseCase;
import com.arquitecturajava.aplicacion.ports.in.NuevoProductoUseCase;
import com.arquitecturajava.aplicacion.ports.in.commands.AltaProductoCommand;
import com.arquitecturajava.aplicacion.ports.out.BuscarCategoriasOut;
import com.arquitecturajava.aplicacion.ports.out.BuscarProductosOut;
import com.arquitecturajava.aplicacion.ports.out.NuevoProductoOut;

public class ProductoService implements NuevoProductoUseCase,BuscarProductosUseCase{

	NuevoProductoOut nuevoProductoOut;
	BuscarCategoriasOut buscarCategoriasOut;
	BuscarProductosOut buscarProductosOut;
	
	public ProductoService(NuevoProductoOut nuevoProductoOut,BuscarCategoriasOut buscarCategoriasOut, 
			BuscarProductosOut buscarProductosOut) {
		super();
		this.nuevoProductoOut = nuevoProductoOut;
		this.buscarCategoriasOut = buscarCategoriasOut;
		this.buscarProductosOut = buscarProductosOut;
	}
	/*Con este metodo estamos obteniendo un producto a partir 
	 * del commandIn(datos que el usuario introduce) y lo estamos transformando 
	 * ,a partir del inputport, en algo mas orientado al negocio usando el concepto 
	 * de categoria que tambien lo construimos y enlazamos la categoria y el producto 
	 * para finalmente guardar el producto
	 */
	@Override
	public void registrarProducto(AltaProductoCommand comando) {
		//forma generica de gestionar el registro del producto
		Producto producto = new Producto();
		producto.setNumeroSerie(comando.getNumeroSerie());
		producto.setNombre(comando.getNombre());
		producto.setPrecio(comando.getPrecio());
		Categoria categoria = new Categoria(comando.getIdCategoria(), comando.getNombre());
		producto.setCategoria(categoria); 
		nuevoProductoOut.salvarProducto(producto);
		nuevoProductoOut.asignarCategoriaProducto(producto, categoria);
		
	}

	@Override
	public List<Categoria> buscarTodasLasCategorias() {
		return buscarCategoriasOut.buscarTodas();
	}
	@Override
	public List<Producto> buscarTodos() {
		return buscarProductosOut.buscarTodos();
	}
	
	
}
