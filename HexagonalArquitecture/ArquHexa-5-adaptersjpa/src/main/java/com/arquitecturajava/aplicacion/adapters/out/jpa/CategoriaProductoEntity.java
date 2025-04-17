package com.arquitecturajava.aplicacion.adapters.out.jpa;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name="Categoria")
@Table(name="productosCategorias")
public class CategoriaProductoEntity {

	@Id
	private int id;
	private String nombre;
	@OneToMany(mappedBy="categoria")
	private List<ProductoEntity> productos;
	
	
	public List<ProductoEntity> getProductos() {
		return productos;
	}
	public void setProductos(List<ProductoEntity> productos) {
		this.productos = productos;
	}
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
	public CategoriaProductoEntity(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public CategoriaProductoEntity(int id) {
		super();
		this.id = id;
	}
	public CategoriaProductoEntity() {
		super();
	}
	
}
