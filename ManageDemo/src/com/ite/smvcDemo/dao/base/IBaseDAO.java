package com.ite.smvcDemo.dao.base;

import java.io.Serializable;
import java.util.List;

public interface IBaseDAO<T> {
	public Serializable save(T entity);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public T findByKey(Serializable id);
	
	public List<T> findAll();

}
