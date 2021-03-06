package com.nicksoddsandends.entitymanager.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nicksoddsandends.entity.Employee;
import com.nicksoddsandends.entitymanager.GenericEntityInterface;


@Repository
public class GenericEntityImplementation<T> implements GenericEntityInterface<T>{
	
	protected EntityManager entityManager;
	
	public GenericEntityImplementation() {
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	public T save(T entity) {
		entityManager.persist(entity);
		entityManager.flush();
		return entity;
	}

	@Override
	public Boolean delete(T entity) {
		try {
		     entityManager.remove(entity);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public T edit(T entity) {
		try{
		   return entityManager.merge(entity);
		} catch(Exception ex) {
			return null;
		}
	}
	
	@Override
	public T find(Long id, Class<T> type) {
		return (T) entityManager.find(type, id);
	}

	@Override
	public List<T> findAll(Class<T> type) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(type);
		Root<T> entityRoot = criteriaQuery.from(type);
		criteriaQuery.select(entityRoot);
		List<T> entities = entityManager.createQuery(criteriaQuery).getResultList();
		
		return entities;
	}
	public List<T> findWhereColumnNameEquals(Class<T> type, String column, String value)
	{
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(type);
		Root<T> entityRoot = criteriaQuery.from(type);
		ParameterExpression<String> p = builder.parameter(String.class);
		
		criteriaQuery.select(entityRoot).where(builder.equal(entityRoot.get(column), p));
		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		
		query.setParameter(p, value);
		List<T> results = query.getResultList();
		
		return results;
		
	}
}
