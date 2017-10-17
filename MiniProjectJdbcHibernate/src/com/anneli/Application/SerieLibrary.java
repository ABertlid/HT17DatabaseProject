package com.anneli.Application;

import java.util.logging.Level;

import com.anneli.controller.Controller;
import com.anneli.repository.model.CategoryRepository;
import com.anneli.repository.model.CategoryRepositoryI;
import com.anneli.repository.model.RatingRepository;
import com.anneli.repository.model.RatingRepositoryI;
import com.anneli.repository.model.SerieRepository;
import com.anneli.repository.model.SerieRepositoryI;
import com.anneli.view.Handler;
import com.anneli.view.View;

public class SerieLibrary {

	public static void main(String[] args) {
		handleLogging();

		Handler handler = new Handler();
		View view = new View();
		SerieRepositoryI serieRepository = new SerieRepository();
		CategoryRepositoryI categoryRepository = new CategoryRepository();
		RatingRepositoryI ratingRepository = new RatingRepository();

		new Controller(handler, view, serieRepository, categoryRepository, ratingRepository).startProgram();
	}

	public static void handleLogging() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
	}
}
