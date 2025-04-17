package com.arquitecturajava.aplicacion.adapters.in.console;

import java.util.List;
import java.util.Scanner;

import com.arquitecturajava.aplicacion.dominio.Producto;
import com.arquitecturajava.aplicacion.ports.in.BuscarProductosUseCase;
import com.arquitecturajava.aplicacion.ports.in.NuevoProductoUseCase;
import com.arquitecturajava.aplicacion.ports.in.commands.AltaProductoCommand;

public class SolicitarProductoConsoleAdapter {
	//pantalla 1
	private NuevoProductoUseCase nuevoProductoUseCase;
	//pantalla 2 la que lista los productos 
	private BuscarProductosUseCase buscarProductoUseCase;

	public SolicitarProductoConsoleAdapter(NuevoProductoUseCase nuevoProductoUseCase,
			BuscarProductosUseCase buscarProductoUseCase) {
		super();
		this.nuevoProductoUseCase = nuevoProductoUseCase;
		this.buscarProductoUseCase = buscarProductoUseCase;
	}
	/* esto va a ser un adaptador de consola
	 * para que sea una forma sencilla de 
	 * introducir datos 
	 */
	public void SolicitarProducto () {
		
		Scanner sc = new Scanner (System.in);
		System.out.println("Introduce numero de serie");
		String numero=sc.next();
		System.out.println("Introduce nombre");
		String nombre=sc.next();
		System.out.println("Introduce precio");
		double precio=sc.nextDouble();
		System.out.println("Introduce id categoria");
		int idCategoria=sc.nextInt();
		
		AltaProductoCommand commandAlta = new AltaProductoCommand(numero, nombre, precio, idCategoria);
		nuevoProductoUseCase.registrarProducto(commandAlta);
	}
	public void BuscarProductos(){
		for(Producto p :buscarProductoUseCase.buscarTodos()) {
			System.out.println(p.getNumeroSerie());
			System.out.println(p.getNombre());
			System.out.println(p.getPrecio());
		}
	}
}
