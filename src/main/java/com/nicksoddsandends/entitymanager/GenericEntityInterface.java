package com.nicksoddsandends.entitymanager;

public interface GenericEntityInterface<T> {
	public T save(T entity);
	public Boolean delete(T entity);
	public T edit(T entity);
	public T find(Long id);
}
