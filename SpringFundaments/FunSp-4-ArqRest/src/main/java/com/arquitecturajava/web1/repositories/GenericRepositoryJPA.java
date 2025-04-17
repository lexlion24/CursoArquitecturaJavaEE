package com.arquitecturajava.web1.repositories;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class GenericRepositoryJPA<T, K> implements GenericRepository<T, K> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<T> tipo;

	@Transactional
	public void insertar(T tipo) {

		entityManager.persist(tipo);
	}

	public GenericRepositoryJPA() {
		// api de reflection
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		tipo = (Class) pt.getActualTypeArguments()[0];

	}

	@Transactional
	public void borrar(T tipo) {
		entityManager.remove(entityManager.merge(tipo));
	}

	@Override
	public Optional<T> buscarUno(K clave) {
		return Optional.ofNullable(entityManager.find(tipo, clave));
	}

	@Transactional
	public void actualizar(T tipo) {
		entityManager.merge(tipo);
	}

	@Override
	public List<T> buscarTodos() {
		// api de criteria de jpa
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = cb.createQuery(tipo);
		Root<T> root = criteriaQuery.from(tipo);
		criteriaQuery.select(root);
		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

}
