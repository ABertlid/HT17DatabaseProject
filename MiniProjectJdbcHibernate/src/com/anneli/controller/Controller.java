package com.anneli.controller;

import java.util.List;

import com.anneli.entity.pojo.model.Category;
import com.anneli.entity.pojo.model.Serie;
import com.anneli.repository.model.CategoryRepositoryI;
import com.anneli.repository.model.RatingRepositoryI;
import com.anneli.repository.model.SerieRepositoryI;
import com.anneli.view.ConsoleReader;
import com.anneli.view.View;

public class Controller {

	private ConsoleReader reader;
	private View view;
	private SerieRepositoryI serieRepository;
	private CategoryRepositoryI categoryRepository;
	private RatingRepositoryI ratingRepository;

	public Controller(ConsoleReader reader, View view, SerieRepositoryI serieRepository,
			CategoryRepositoryI categoryRepository, RatingRepositoryI ratingRepository) {

		this.reader = reader;
		this.view = view;
		this.serieRepository = serieRepository;
		this.categoryRepository = categoryRepository;
		this.ratingRepository = ratingRepository;

	}

	public void startProgram() {
		view.startMenu();
		crudAndSearchInDatabase();
	}

	private void crudAndSearchInDatabase() {

		boolean isRunning = false;

		while (!isRunning) {

			String choiceFromUser = reader.stringInputFromUser();

			switch (choiceFromUser) {
			case "1":
				addSerieInDatabase();
				startProgram();
				break;

			case "2":
				readAllInDatabase();
				startProgram();
				break;

			case "3":
				updateSerieInDatabase();
				startProgram();
				break;

			case "4":
				deleteSerieInDatabase();
				startProgram();
				break;

			case "5":
				searchForSerieInDatabase();
				startProgram();
				break;

			case "6":
				searchByCategoryFindSerie();
				startProgram();
				break;

			case "7":
				exitProgram(isRunning);
				break;
			default:
				break;
			}
		}
	}

	private void searchByCategoryFindSerie() {
		String userData;
		List<Category> categoryList;
		view.displaySerieByCategory();
		userData = reader.stringInputFromUser();
		categoryList = categoryRepository.searchSerieByCategory(userData);
		display(categoryList);
	}

	private void searchForSerieInDatabase() {
		String userData;
		List<Serie> serieList;
		view.displaySearchSerie();
		userData = reader.stringInputFromUser();
		serieList = serieRepository.searchSerie(userData);
		display(serieList);
	}

	private void deleteSerieInDatabase() {
		int userDataInt;
		view.displayDelete();
		userDataInt = reader.intInputFromUser();
		serieRepository.delete(userDataInt);
	}

	private void updateSerieInDatabase() {
		String userData;
		int userDataInt;
		view.displayUpdateID();
		userDataInt = reader.intInputFromUser();
		view.displayUpdateSerie();
		userData = reader.stringInputFromUser();
		serieRepository.get(userDataInt, userData);
	}

	private void readAllInDatabase() {
		List<Serie> serieList;
		view.displayAll();
		serieList = serieRepository.getAll();
		display(serieList);
	}

	private void addSerieInDatabase() {
		String userData;
		view.displayAdd();
		userData = reader.stringInputFromUser();
		serieRepository.add(userData);
	}

	private <T> void display(List<T> list) {

		list.stream().forEach(System.out::println);

	}

	public static class ControllerBuilder {

		private ConsoleReader newReader;
		private View newView;
		private SerieRepositoryI newSerieRepository;
		private CategoryRepositoryI newCategoryRepository;
		private RatingRepositoryI newRatingRepository;

		public ControllerBuilder setNewReader(ConsoleReader newReader) {
			this.newReader = newReader;
			return this;
		}

		public ControllerBuilder setNewView(View newView) {
			this.newView = newView;
			return this;
		}

		public ControllerBuilder setNewSerieRepository(SerieRepositoryI newSerieRepository) {
			this.newSerieRepository = newSerieRepository;
			return this;
		}

		public ControllerBuilder setNewCategoryRepository(CategoryRepositoryI newCategoryRepository) {
			this.newCategoryRepository = newCategoryRepository;
			return this;
		}

		public ControllerBuilder setNewRatingRepository(RatingRepositoryI newRatingRepository) {
			this.newRatingRepository = newRatingRepository;
			return this;
		}

		public Controller create() {

			return new Controller(newReader, newView, newSerieRepository, newCategoryRepository, newRatingRepository);
		}

	}

	private void exitProgram(boolean exit) {

		try {
			reader.close();
			view.exitScanner();
		} catch (Exception e) {
			e.printStackTrace();
		}

		serieRepository.closeFactory();
		view.exitFactory();

		System.exit(0);
	}

}
