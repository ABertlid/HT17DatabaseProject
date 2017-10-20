package com.anneli.repository.model;

import java.util.List;

import org.hibernate.Session;

import com.anneli.entity.pojo.model.Category;

public class CategoryRepository implements CategoryRepositoryI {

	private Session factory() {
		Session session = Factory.getInstance().getCurrentSession();
		return session;
	}

	@Override
	public Category get(int primaryKey) {

		Session session = factory();
		session.beginTransaction();

		Category category = session.find(Category.class, primaryKey);

		session.getTransaction().commit();
		session.close();

		return category;

	}

	@Override
	public List<Category> getAll() {

		Session session = factory();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Category> theCategories = session.createQuery("from Category").getResultList();

		session.getTransaction().commit();
		session.close();
		
		return theCategories;

	}

	public List<Category> searchSerieByCategory(String userInput) {

		Session session = factory();
		session.beginTransaction();

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

	public void closeFactory() {

		Factory.getInstance().close();
	}
}
