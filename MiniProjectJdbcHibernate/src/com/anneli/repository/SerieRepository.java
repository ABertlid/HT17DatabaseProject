package com.anneli.repository;


import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.anneli.entity.Serie;

public class SerieRepository implements SerieRepositoryI {

	private SessionFactory sessionFactory = Factory.getInstance();
	private Session session = sessionFactory.getCurrentSession();

	@Override
	public Serie get(int primaryKey, String update) {

		try {
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
			System.out.println(sessionFactory.hashCode() + " = SF");
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
			System.out.println(sessionFactory.hashCode() + " = SF");
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
			System.out.println(sessionFactory.hashCode() + " = SF");
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
			session.beginTransaction();

			String searchIndex = userInput + "%";

			String query = "from Serie where title LIKE :title";

			@SuppressWarnings("unchecked")
			List<Serie> theSeries = session.createQuery(query).setParameter("title", searchIndex).getResultList();

			displaySerie(theSeries);

			session.getTransaction().commit();
			close(session);

			return theSeries;

		} catch (HibernateException ex) {
			throw new HibernateException("ERROR " + ex.getStackTrace());
		}

	}

	private void displaySerie(List<Serie> theSeries) {

		for (Serie tempSerie : theSeries) {
			System.out.println(tempSerie);
		}
	}

	private void close(Session session) {

		//session.getSessionFactory().close();
		session.close();
	}

}
