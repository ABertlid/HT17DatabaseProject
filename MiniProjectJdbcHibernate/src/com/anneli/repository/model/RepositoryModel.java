package com.anneli.repository.model;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;

import com.anneli.entity.pojo.model.Serie;

public class RepositoryModel<T> implements GeneralRepository<T> {
	
	private Session factory() {
		Session session = Factory.getInstance().getCurrentSession();
		return session;
	}

	@Override
	public T get(int primaryKey, String uString) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {

		Session session = factory();
		session.beginTransaction();

		StoredProcedureQuery allSeries = session.createStoredProcedureQuery("all_series", Serie.class);

		allSeries.execute();
		List<T> series = allSeries.getResultList();

		session.getTransaction().commit();
		close(session);

		return series;
	}

	@Override
	public void add(String uString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int uInt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> searchSerie(String uString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> searchSerieByCategory(String userInput) {
		// TODO Auto-generated method stub
		return null;
	}
	private void close(Session session) {

		session.close();
	}
	public void closeFactory() {
		
	}

}
