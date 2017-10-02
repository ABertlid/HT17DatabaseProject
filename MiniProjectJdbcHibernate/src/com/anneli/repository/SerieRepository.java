package com.anneli.repository;

import java.util.List;

import javax.persistence.Entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

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
			

			List<Serie> theSeries = session.createQuery("from Serie").getResultList();

			displaySerie(theSeries);
			session.getTransaction().commit();
			close(session);

			return theSeries;
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

	public void getProcedure(){
		
		try {
			Session session = new Configuration().configure().addAnnotatedClass(Serie.class)
					.addAnnotatedClass(Category.class).addAnnotatedClass(Rating.class).buildSessionFactory()
					.openSession();

			session.beginTransaction();
			
			@SuppressWarnings({ "unchecked", "rawtypes" })
			String theProcedure = session.createNativeQuery("CALL all_series()")
			.addEntity(Serie.class).getQueryString();
			System.out.println(theProcedure);
			//displayProcedure(theProcedure);
			session.getTransaction().commit();
			close(session);

			
		} catch (HibernateException ex) {
			throw new HibernateException("ERROR " + ex.getStackTrace());
		}
		
	}
	private void displaySerie(List<Serie> theSeries) {

		for (Serie tempSerie : theSeries) {
			System.out.println(tempSerie);
		}
	}
	private void displayProcedure(List<Serie> theProcedure) {
		for (Serie procedure : theProcedure) {
			System.out.println(Entity.class.getName() + procedure);
		}
	}

	private void close(Session session) {

		session.getSessionFactory().close();
		session.close();
	}

}
