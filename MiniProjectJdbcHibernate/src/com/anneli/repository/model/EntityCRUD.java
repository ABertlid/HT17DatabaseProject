package com.anneli.repository.model;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;

import com.anneli.entity.pojo.model.Category;
import com.anneli.entity.pojo.model.Serie;
import com.anneli.view.Reader;

public abstract class EntityCRUD<T> implements AutoCloseable{
	private T type;
	
	private Session factory() {
		Session session = Factory.getInstance().getCurrentSession();
		return session;
	}
	
	public T update(Class<T> clazz, int primaryKey, String update) {

		Session session = factory();
		session.beginTransaction();

		type = session.get(clazz, primaryKey);
		
		//	theSerie.setTitle(update);

		session.getTransaction().commit();
		close(session);

		return type;

	}
	public List<T> getAll(Class<T> clazz) {

		Session session = factory();
		session.beginTransaction();

		StoredProcedureQuery type = session.createStoredProcedureQuery("all_series", clazz);

		type.execute();
		List<T> list = type.getResultList();

		session.getTransaction().commit();
		close(session);

		return list;
	}
	private void close(Session session) {

		session.close();
	}
	
	public void close() {
		factory().close();
	}

}
