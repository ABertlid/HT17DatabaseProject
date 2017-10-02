package com.anneli.repository;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.anneli.entity.Category;
import com.anneli.entity.Rating;
import com.anneli.entity.Serie;

public class SerieRepository implements SerieRepositoryI {

	@Override
	public Serie get(int primaryKey, String update) {

		try {
			Session session = new Configuration().configure().addAnnotatedClass(Serie.class)
					.addAnnotatedClass(Category.class).addAnnotatedClass(Rating.class).buildSessionFactory()
					.openSession();
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
			Session session = new Configuration().configure().addAnnotatedClass(Serie.class)
					.addAnnotatedClass(Category.class).addAnnotatedClass(Rating.class).buildSessionFactory()
					.openSession();

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
			Session session = new Configuration().configure().addAnnotatedClass(Serie.class)
					.addAnnotatedClass(Category.class).addAnnotatedClass(Rating.class).buildSessionFactory()
					.openSession();

			session.beginTransaction();

			Serie tempSerie = new Serie(userInput);
			session.save(tempSerie);
			session.getTransaction().commit();
			close(session);
			
		} catch (HibernateException ex) {
			throw new HibernateException("ERROR " + ex.getStackTrace());
		}

	}

	@Override
	public void delete(int userInput) {

		try {
			Session session = new Configuration().configure().addAnnotatedClass(Serie.class)
					.addAnnotatedClass(Category.class).addAnnotatedClass(Rating.class).buildSessionFactory()
					.openSession();

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
			Session session = new Configuration().configure().addAnnotatedClass(Serie.class)
					.addAnnotatedClass(Category.class).addAnnotatedClass(Rating.class).buildSessionFactory()
					.openSession();

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

		session.getSessionFactory().close();
		session.close();
	}

}
