package com.nicksoddsandends.entitymanager.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
