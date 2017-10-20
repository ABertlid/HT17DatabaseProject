package com.anneli.repository.model;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;

import com.anneli.entity.pojo.model.Category;
import com.anneli.entity.pojo.model.Rating;
import com.anneli.entity.pojo.model.Serie;

public class Repository implements RepositoryI {
	
	private Session factory() {
		Session session = Factory.getInstance().getCurrentSession();
		return session;
	}

	private Session startNewSessionBeginTransaction() {
		Session session = factory();
		session.beginTransaction();
		return session;
	}

	@Override
	public Serie updateSerie(int primaryKey, String update) {
		
		Session session = startNewSessionBeginTransaction();
		
		Serie theSerie = session.get(Serie.class, primaryKey);

		theSerie.setTitle(update);

		session.getTransaction().commit();
		close(session);

		return theSerie;
	}

	@Override
	public Category updateCategory(int primaryKey, String uString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating updateRating(int primaryKey, double uDouble) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Serie> getAllInDatabase() {
		
		Session session = startNewSessionBeginTransaction();

		StoredProcedureQuery allSeries = session.createStoredProcedureQuery("all_series", Serie.class);

		allSeries.execute();
		List<Serie> series = allSeries.getResultList();

		session.getTransaction().commit();
		close(session);

		return series;
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSerie(String userInput) {
		
		Session session = startNewSessionBeginTransaction();

		Serie tempSerie = new Serie(userInput);
		session.save(tempSerie);
		session.getTransaction().commit();
		close(session);
		
	}

	@Override
	public void addCategory(String uString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRating(double uDouble) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSerie(int userInput) {
		
		Session session = startNewSessionBeginTransaction();

		Serie theSerie = session.get(Serie.class, userInput);
		session.delete(theSerie);
		session.getTransaction().commit();
		close(session);
		
	}

	@Override
	public void deleteCategory(int uInt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Serie> searchSerie(String userInput) {
		
		Session session = startNewSessionBeginTransaction();

		String searchIndex = userInput + "%";

		String query = "FROM Serie WHERE title LIKE :title";

		List<Serie> theSeries = session.createQuery(query, Serie.class).setParameter("title", searchIndex)
				.getResultList();

		session.getTransaction().commit();
		close(session);

		return theSeries;
	}

	@Override
	public List<Category> searchCategory(String uString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> searchSerieByCategory(String userInput) {
		
		Session session = startNewSessionBeginTransaction();
		
		String query = "FROM Category WHERE type LIKE :type";

		List<Category> theCategories = session.createQuery(query, Category.class).setParameter("type", userInput)
				.getResultList();

		session.getTransaction().commit();
		close(session);
		
		return theCategories;
	}
	
	private void close(Session session) {

		session.close();
	}

	@Override
	public void close() throws Exception {
		Factory.getInstance().close();
		
	}

}
