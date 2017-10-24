package com.anneli.repository.model;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;

import com.anneli.entity.pojo.model.Category;
import com.anneli.entity.pojo.model.Serie;

/**
 * Class that handle hibernate sessions. Implements CRUD interface
 * 
 * @author Anneli
 *
 */
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

	/**
	 * Starts a new hibernate session, transaction and commit. Executes the query
	 * for an update
	 */
	@Override
	public Serie updateSerie(int primaryKey, String update) {

		Session session = startNewSessionBeginTransaction();

		Serie theSerie = session.get(Serie.class, primaryKey);

		theSerie.setTitle(update);

		session.getTransaction().commit();
		close(session);

		return theSerie;
	}

	/**
	 * Starts a new hibernate session, transaction and commit. Executes a stored
	 * procedure for all data in database
	 */
	@Override
	public List<Serie> getAllInDatabase() {

		Session session = startNewSessionBeginTransaction();

		StoredProcedureQuery allSeries = session.createStoredProcedureQuery("all_series", Serie.class);

		@SuppressWarnings("unchecked")
		List<Serie> series = allSeries.getResultList();

		session.getTransaction().commit();
		close(session);

		return series;
	}

	/**
	 * Starts a new hibernate session, transaction and commit. Executes the query
	 * for reading one column in database
	 */
	@Override
	public List<Serie> readAllSeries() {
		Session session = startNewSessionBeginTransaction();

		String query = "select title from Serie";

		Query serie = session.createQuery(query);

		@SuppressWarnings("unchecked")
		List<Serie> series = serie.getResultList();

		session.getTransaction().commit();
		close(session);

		return series;
	}

	/**
	 * Starts a new hibernate session, transaction and commit. Executes the query
	 * for saving a new row in database
	 */
	@Override
	public void addSerie(String userInput) {

		Session session = startNewSessionBeginTransaction();

		Serie tempSerie = new Serie(userInput);
		session.save(tempSerie);
		session.getTransaction().commit();
		close(session);

	}

	/**
	 * Starts a new hibernate session, transaction and commit. Executes the query
	 * for deleting a row in database
	 */
	@Override
	public void deleteSerie(int userInput) {

		Session session = startNewSessionBeginTransaction();

		Serie theSerie = session.get(Serie.class, userInput);
		session.delete(theSerie);
		session.getTransaction().commit();
		close(session);

	}

	/**
	 * Starts a new hibernate session, transaction and commit. Executes the query
	 * for searching data in database
	 */
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

	/**
	 * Starts a new hibernate session, transaction and commit. Executes the query
	 * for searching data in database
	 */
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

	/**
	 * Closes the session factory
	 */
	@Override
	public void close() throws Exception {
		Factory.getInstance().close();

	}

}
