package com.anneli.repository;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.anneli.entity.Serie;

public class SerieRepository implements SerieRepositoryI {


	@Override
	public Serie get(int primaryKey, String update) {
		
		try {
			Session session = factory();
			session.beginTransaction();

			Serie theSerie = session.get(Serie.class, primaryKey);

			theSerie.setTitle(update);

			session.getTransaction().commit();
			close(session);

			return theSerie;

		} catch (HibernateException ex) {
			throw new HibernateException("ERROR " + ex.getStackTrace());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Serie> getAll() {

		try {
			Session session = factory();
			System.out.println(Factory.getInstance().hashCode() + " = SF");
			session.beginTransaction();

			StoredProcedureQuery allSeries = session.createStoredProcedureQuery("all_series", Serie.class);

			allSeries.execute();
			List<Serie> series = allSeries.getResultList();

			displaySerie(series);

			session.getTransaction().commit();
			close(session);

			return series;

		} catch (HibernateException ex) {
			throw new HibernateException("ERROR " + ex.getStackTrace());
		}

	}

	@Override
	public void add(String userInput) {

		try {
			Session session = factory();
			session.beginTransaction();

			Serie tempSerie = new Serie(userInput);
			session.save(tempSerie);
			session.getTransaction().commit();
			close(session);

		} catch (HibernateException e) {
			throw new HibernateException("Duplicate insert");
		}
	}

	@Override
	public void delete(int userInput) {

		try {
			Session session = factory();
			session.beginTransaction();

			Serie theSerie = session.get(Serie.class, userInput);
			session.delete(theSerie);
			session.getTransaction().commit();
			close(session);

		} catch (HibernateException ex) {
			throw new HibernateException("ERROR " + ex.getStackTrace());
		}
	}

	@Override
	public List<Serie> searchSerie(String userInput) {

		try {
			Session session = factory();
			session.beginTransaction();

			String searchIndex = userInput + "%";

			String query = "from Serie where title LIKE :title";

			List<Serie> theSeries = session.createQuery(query, Serie.class).setParameter("title", searchIndex).getResultList();
			
			displaySerie(theSeries);

			session.getTransaction().commit();
			close(session);

			return theSeries;

		} catch (HibernateException ex) {
			throw new HibernateException("ERROR " + ex.getStackTrace());
		}

	}

	private Session factory() {
		Session session = Factory.getInstance().getCurrentSession();
		return session;
	}

	private void displaySerie(List<Serie> theSeries) {

		for (Serie tempSerie : theSeries) {
			System.out.println(tempSerie);
		}
	}

	private void close(Session session) {

		session.close();
	}
	public void closeFactory() {

		Factory.getInstance().close();	
	}

}
