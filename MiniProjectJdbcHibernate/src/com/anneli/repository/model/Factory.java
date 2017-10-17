package com.anneli.repository.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anneli.entity.model.Category;
import com.anneli.entity.model.Rating;
import com.anneli.entity.model.Serie;

public class Factory {

	public static SessionFactory instance;

	private Factory() {

	}

	public static synchronized SessionFactory getInstance() {

		if (instance == null) {
			instance = new Configuration().configure().addAnnotatedClass(Serie.class).addAnnotatedClass(Category.class)
					.addAnnotatedClass(Rating.class).buildSessionFactory();
		}

		return instance;
	}
}
