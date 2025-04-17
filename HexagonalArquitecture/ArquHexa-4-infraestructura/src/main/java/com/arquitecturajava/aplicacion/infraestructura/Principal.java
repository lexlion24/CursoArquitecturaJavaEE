package com.arquitecturajava.aplicacion.infraestructura;

import com.arquitecturajava.aplicacion.adapters.in.console.SolicitarProductoConsoleAdapter;
import com.arquitecturajava.aplicacion.adapters.out.memory.ProductoCategoriaOutMemoryAdapter;
import com.arquitecturajava.aplicacion.ports.in.BuscarProductosUseCase;
import com.arquitecturajava.aplicacion.ports.in.NuevoProductoUseCase;
import com.arquitecturajava.aplicacion.ports.out.BuscarCategoriasOut;
import com.arquitecturajava.aplicacion.ports.out.BuscarProductosOut;
import com.arquitecturajava.aplicacion.ports.out.NuevoProductoOut;
import com.arquitecturajava.aplicacion.services.ProductoService;

public class Principal {

	public static void main(String[] args) {
		/*
		 * Esto es un output adapter que imita la bbdd
		 * y funciona porque implementa BuscarCategoriasOut,NuevoProductoOut
		 * y se encarga de guardar productos y devolver las cateogiras 
		 */
		ProductoCategoriaOutMemoryAdapter adaptadorOut = new ProductoCategoriaOutMemoryAdapter();
		/*
		 * Aqui estas diciendo que este adaptadorOut implementa ambos 
		 * puertos de salida 
		 */
		NuevoProductoOut nuevoProductoOut = adaptadorOut;
		BuscarCategoriasOut buscarCategoriaOut = adaptadorOut;
		BuscarProductosOut buscarProductosOut = adaptadorOut;
		/*
		 * Aqui se crea el caso de uso real en el que llamas 
		 * al producto service para aplicar la logica de negocio
		 * usando el inputPort NuevoProductoUseCase y definiendo la accion que tiene registrarProducto()
		 * para lo que utiliza los outputports para guardar y leer datos
		 */
		//NuevoProductoUseCase nuevoProductoUc = new ProductoService(nuevoProductoOut, buscarCategoriaOut, buscarProductosOut);
		
		ProductoService servicio = new ProductoService(nuevoProductoOut, buscarCategoriaOut, buscarProductosOut);
		NuevoProductoUseCase nuevoProductoUc  = servicio; 
		/*Como tenemos una interfaz extra reutilizamos la clase servicio
		 *para implementar dos inputports diferentes  nuevoProducto y buscarproducto
		 */
		BuscarProductosUseCase buscarProductoUc = servicio;
		/*
		 * Aqui viene el adaptador de entrada seria como el 
		 * @restcontroller ya que va a pedir datos por consola 
		 * construye el command y va a registrarProducto
		 */
		//SolicitarProductoConsoleAdapter adaptadorIn = new SolicitarProductoConsoleAdapter(nuevoProductoUc);
		SolicitarProductoConsoleAdapter adaptadorIn = new SolicitarProductoConsoleAdapter(nuevoProductoUc,buscarProductoUc);
		/*
		 * 1.Pide datos al usuario 
		 * 2.Crea un CrearProductoCommand con los datos
		 * 3.Lo pasa al caso de uso
		 * 4.El caso de uso busca la categoria y guarda el producto
		 */
		adaptadorIn.SolicitarProducto();
		adaptadorIn.SolicitarProducto();
		adaptadorIn.BuscarProductos();
	}
}
