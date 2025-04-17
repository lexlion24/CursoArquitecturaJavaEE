package com.arquitecturajava.aplicacion.adapters.out.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
/*Con esto estamos trabajando los mapeos de entidades con la bbdd y el mapeodeconsutla
 * porque sino luego al usar jpql tendriamos que hacer la select p from productoentity p
 */
@Entity(name="Producto")
@Table(name="Productos")
public class ProductoEntity {
	@Id
	@Column(name="numero")
	private String numeroSerie;
	private String nombre;
	private double precio;
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private CategoriaProductoEntity categoria;
	
	public CategoriaProductoEntity getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaProductoEntity categoria) {
		this.categoria = categoria;
	}
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
	public ProductoEntity(String numeroSerie, String nombre, double precio) {
		super();
		this.numeroSerie = numeroSerie;
		this.nombre = nombre;
		this.precio = precio;
	}
	public ProductoEntity() {
		super();
	}
	public ProductoEntity(String numeroSerie) {
		super();
		this.numeroSerie = numeroSerie;
	}
	
}
