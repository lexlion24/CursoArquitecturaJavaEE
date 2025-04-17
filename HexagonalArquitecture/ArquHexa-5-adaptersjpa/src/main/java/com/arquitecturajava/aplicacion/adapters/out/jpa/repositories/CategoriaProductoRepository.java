package com.arquitecturajava.aplicacion.adapters.out.jpa.repositories;

import java.util.List;

import com.arquitecturajava.aplicacion.adapters.out.jpa.CategoriaProductoEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CategoriaProductoRepository {
	
	private final EntityManager em;
	
	public CategoriaProductoRepository(EntityManager em) {
		super();
		this.em = em;
	}

	public List<CategoriaProductoEntity> buscartodos(){
		TypedQuery<CategoriaProductoEntity> consultaCategoria = em.createQuery("select c from Categoria c",CategoriaProductoEntity.class);
		List <CategoriaProductoEntity> listaEntidades = consultaCategoria.getResultList();
		return listaEntidades;
	}
}
