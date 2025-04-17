package com.arquitecturajava.aplicacion.adapters.out.jpa.repositories;

import java.util.List;

import com.arquitecturajava.aplicacion.adapters.out.jpa.ProductoEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ProductoRepository {

	private final EntityManager em;

	public ProductoRepository(EntityManager em) {
		super();
		this.em = em;
	}
	public List<ProductoEntity> buscarTodo(){
		TypedQuery<ProductoEntity> consultaProductos = em.createQuery("select p from Producto p",ProductoEntity.class);
		List <ProductoEntity> listaEntidades = consultaProductos.getResultList();
		return listaEntidades;
	}
	
	public void salvar(ProductoEntity productoEntity) {
		em.persist(productoEntity);
	}
	
	
}
