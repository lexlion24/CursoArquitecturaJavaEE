package com.arquitecturajava.aplicacion.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Categoria {
	
	private int id;
	private String nombre;
	
	private List<Producto> productos = new ArrayList<Producto>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public void addProducto(Producto producto) {
		this.productos.add(producto);
	}
	public void removeProducto (Producto producto) {
		this.productos.remove(producto);
	}
	public Categoria(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Categoria(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return id == other.id;
	}
	
}
