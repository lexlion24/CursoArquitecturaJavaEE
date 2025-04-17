package com.arquitecturajava.aplicacion.ports.in.commands;

public class AltaProductoCommand {
	
	private String numeroSerie;
	private String nombre;
	private double precio;
	private int idCategoria;
	
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public AltaProductoCommand(String numeroSerie, String nombre, double precio, int idCategoria) {
		super();
		this.numeroSerie = numeroSerie;
		this.nombre = nombre;
		this.precio = precio;
		this.idCategoria = idCategoria;
	}
	
}
