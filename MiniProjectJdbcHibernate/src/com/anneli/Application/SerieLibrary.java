package com.anneli.Application;

import java.util.logging.Level;

import com.anneli.controller.Controller;
import com.anneli.repository.model.CategoryRepository;
import com.anneli.repository.model.CategoryRepositoryI;
import com.anneli.repository.model.RatingRepository;
import com.anneli.repository.model.RatingRepositoryI;
import com.anneli.repository.model.SerieRepository;
import com.anneli.repository.model.SerieRepositoryI;
import com.anneli.view.ConsoleReader;
import com.anneli.view.View;

public class SerieLibrary {

	public static void main(String[] args) {
		handleLogging();

		ConsoleReader reader = new ConsoleReader();
		View view = new View();
		SerieRepositoryI serieRepository = new SerieRepository();
		CategoryRepositoryI categoryRepository = new CategoryRepository();
		RatingRepositoryI ratingRepository = new RatingRepository();
		
			new Controller.ControllerBuilder()
				.setNewReader(reader)
				.setNewView(view)
				.setNewSerieRepository(serieRepository)
				.setNewCategoryRepository(categoryRepository)
				.setNewRatingRepository(ratingRepository)
				.create()
				.startProgram();
		
	}

	public static void handleLogging() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
	}
}
