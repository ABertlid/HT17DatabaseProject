package com.anneli.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.anneli.entity.Category;
import com.anneli.entity.Rating;
import com.anneli.entity.Serie;

public class CategoryRepository implements CategoryRepositoryI {

	@Override
	public Category get(int primaryKey) {

		Session session = new Configuration().configure().addAnnotatedClass(Category.class).buildSessionFactory()
				.openSession();

		Transaction transaction = session.beginTransaction();
		Category category = session.find(Category.class, primaryKey);
		transaction.commit();
		session.getSessionFactory().close();
		session.close();

		return category;

	}

	@Override
	public void getAll() {

		Session session = new Configuration().configure().addAnnotatedClass(Category.class).buildSessionFactory()
				.openSession();

		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Category> theCategories = session.createQuery("from Category").getResultList();

		displayCategory(theCategories);

		session.getTransaction().commit();
		session.getSessionFactory().close();
		session.close();

	}

	public List<Category> searchSerieByCategory(String userInput) {

		try {
			Session session = new Configuration().configure().addAnnotatedClass(Category.class)
					.addAnnotatedClass(Serie.class).addAnnotatedClass(Rating.class).buildSessionFactory()
					.openSession();

			session.beginTransaction();

			String query = "from Category where type LIKE :type";

			@SuppressWarnings("unchecked")
			List<Category> theCategories = session.createQuery(query).setParameter("type", userInput).getResultList();

			displayCategory(theCategories);

			session.getTransaction().commit();
			close(session);

			return theCategories;

		} catch (HibernateException ex) {
			throw new HibernateException("ERROR " + ex.getStackTrace());
		}

	}

	private void displayCategory(List<Category> theCategories) {
		for (Category tempCategory : theCategories) {
			System.out.println(tempCategory);
		}
	}

	private void close(Session session) {

		session.getSessionFactory().close();
		session.close();
	}
}
