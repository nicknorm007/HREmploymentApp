package com.nicksoddsandends.entitymanager;

import java.util.List;

public interface GenericEntityInterface<T> {
	public T save(T entity);
	public Boolean delete(T entity);
	public T edit(T entity);
	public T find(Long id, Class<T> type);
	public List<T> findAll(Class<T> type);
}
