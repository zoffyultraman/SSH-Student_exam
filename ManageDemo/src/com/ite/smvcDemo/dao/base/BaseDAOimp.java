package com.ite.smvcDemo.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseDAOimp<T> implements IBaseDAO<T>{

	@SuppressWarnings("unchecked")
	public BaseDAOimp() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Autowired
	private HibernateTemplate HibernateTemplate;
	
	private Class<T> entityClass;
	
	
	public HibernateTemplate getHibernateTemplate() {
		return HibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		HibernateTemplate = hibernateTemplate;
	}

	
	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public Serializable save(T entity) {
		Serializable key = getHibernateTemplate().save(entity);
		//this.getSession().flush();
		return key;
	}

	@Override
	public void update(T entity) {
		HibernateTemplate.update(entity);
		//this.getSession().flush();
	}

	@Override
	public void delete(T entity) {
		HibernateTemplate.delete(entity);
		//this.getSession().flush();
	}

	@Override
	public T findByKey(Serializable id) {
		return (T) getHibernateTemplate().get(getEntityClass(), id);
	}

	@Override
	public List<T> findAll() {
		return findByCriteria();
	}

	//...表示的传入的参数可以随意，你传多少个参数都被放到一个数组里面。 
	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(Criterion... criterions) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(getEntityClass());
		for (Criterion criterion : criterions) {
			detachedCriteria.add(criterion);
		}
		return getHibernateTemplate().findByCriteria(detachedCriteria);
	}
	
	public Session getSession() {
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		if(session == null){
			session = this.getHibernateTemplate().getSessionFactory().openSession();
		}
		return session;
	}
	
	
	
}