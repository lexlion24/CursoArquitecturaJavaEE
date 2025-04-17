package com.arquitecturajava.aplicacion.dominio;

import java.util.Objects;

public class Producto {

	private String numeroSerie;
	private String nombre;
	private double precio;
	private Categoria categoria;
	
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
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Producto(String numeroSerie, String nombre, double precio) {
		super();
		this.numeroSerie = numeroSerie;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public Producto() {
		super();
	}
	
	public Producto(String numeroSerie) {
		super();
		this.numeroSerie = numeroSerie;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numeroSerie);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(numeroSerie, other.numeroSerie);
	}
	
	public double getPrecioConIVA() {
		return this.getPrecio()*1.21;
	}
	
}
