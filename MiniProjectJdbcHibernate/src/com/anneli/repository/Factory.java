package com.anneli.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anneli.entity.Category;
import com.anneli.entity.Rating;
import com.anneli.entity.Serie;

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
