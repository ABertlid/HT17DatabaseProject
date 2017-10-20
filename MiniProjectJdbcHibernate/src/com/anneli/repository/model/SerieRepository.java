package com.anneli.repository.model;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;

import com.anneli.entity.pojo.model.Serie;

public class SerieRepository implements SerieRepositoryI {

	private Session factory() {
		Session session = Factory.getInstance().getCurrentSession();
		return session;
	}

	@Override
	public Serie get(int primaryKey, String update) {

		Session session = factory();
		session.beginTransaction();

		Serie theSerie = session.get(Serie.class, primaryKey);

		theSerie.setTitle(update);

		session.getTransaction().commit();
		close(session);

		return theSerie;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Serie> getAll() {

		Session session = factory();
		session.beginTransaction();

		StoredProcedureQuery allSeries = session.createStoredProcedureQuery("all_series", Serie.class);

		allSeries.execute();
		List<Serie> series = allSeries.getResultList();

		session.getTransaction().commit();
		close(session);

		return series;
	}

	@Override
	public void add(String userInput) {

		Session session = factory();
		session.beginTransaction();

		Serie tempSerie = new Serie(userInput);
		session.save(tempSerie);
		session.getTransaction().commit();
		close(session);
	}

	@Override
	public void delete(int userInput) {

		Session session = factory();
		session.beginTransaction();

		Serie theSerie = session.get(Serie.class, userInput);
		session.delete(theSerie);
		session.getTransaction().commit();
		close(session);
	}

	@Override
	public List<Serie> searchSerie(String userInput) {

		Session session = factory();
		session.beginTransaction();

		String searchIndex = userInput + "%";

		String query = "FROM Serie WHERE title LIKE :title";

		List<Serie> theSeries = session.createQuery(query, Serie.class).setParameter("title", searchIndex)
				.getResultList();

		session.getTransaction().commit();
		close(session);

		return theSeries;
	}

	private void close(Session session) {

		session.close();
	}

	public void closeFactory() {

		Factory.getInstance().close();
	}

}
