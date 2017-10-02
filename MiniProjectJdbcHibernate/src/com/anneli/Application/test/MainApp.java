package com.anneli.Application.test;

import java.util.List;
import java.util.logging.Level;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.anneli.entity.Serie;

public class MainApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Serie.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {	
		
			//-------- DELETE ----------------------------
			//deleta 
			int serieId = 12;
			session.beginTransaction();
			
			Serie theSerie = session.get(Serie.class, serieId);
			session.delete(theSerie);
	
			/*
			//-------- UPDATE ----------------------------
			//updatera en rad i tabellen
			int serieId = 11;
			session.beginTransaction();
			Serie theSerie = session.get(Serie.class, serieId);
			System.out.println("Updating serie...");
			theSerie.setTitle("Downton");
			
			//uppdatera flera rader
			session.createQuery("update Serie set title='Downton Abbey' where serie_id=11").executeUpdate();
										
			//------- READ --------------------------------
			//skapa query av Serie
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Serie> theSeries = session.createQuery("from Serie").getResultList();
			System.out.println("\n\nalla serier");
			displaySerie(theSeries);
			
			theSeries = session.createQuery("from Serie s where s.title='Homeland'").getResultList();
			System.out.println("\n\ntar fram vald serie Homeland");
			displaySerie(theSeries);
			
			theSeries = session.createQuery("from Serie s where s.title Like '%o%'").getResultList();
			System.out.println("\n\nalla serier som innehåller ett o");
			displaySerie(theSeries);
		
			 //------- CREATE ------------------------------
			//skapa ny serie save()
			Serie tempSerie = new Serie("Downton Abbey");
			session.beginTransaction();
			session.save(tempSerie);			
			session.getTransaction().commit();
			
			//och hämta resultatet get()
			System.out.println("sparad serie samt id: " +tempSerie.getSerieId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Serie nySerie = session.get(Serie.class, tempSerie.getSerieId());
			System.out.println("Ny serie: " + nySerie.getTitle());*/
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	
	}

	private static void displaySerie(List<Serie> theSeries) {
		for (Serie tempSerie : theSeries) {
			System.out.println(tempSerie);
		}
	}

}
