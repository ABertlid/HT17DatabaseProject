package com.anneli.controller;

import java.util.List;

import com.anneli.entity.pojo.model.Category;
import com.anneli.entity.pojo.model.Serie;
import com.anneli.repository.model.RepositoryI;
import com.anneli.view.ConsoleReader;
import com.anneli.view.View;

public class Controller {

	private ConsoleReader reader;
	private View view;
	private RepositoryI repository;

	public Controller(ConsoleReader reader, View view, RepositoryI repository) {

		this.reader = reader;
		this.view = view;
		this.repository = repository;

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
		categoryList = repository.searchSerieByCategory(userData);
		display(categoryList);
	}

	private void searchForSerieInDatabase() {
		String userData;
		List<Serie> serieList;
		view.displaySearchSerie();
		userData = reader.stringInputFromUser();
		serieList = repository.searchSerie(userData);
		display(serieList);
	}

	private void deleteSerieInDatabase() {
		int userDataInt;
		view.displayDelete();
		userDataInt = reader.intInputFromUser();
		repository.deleteSerie(userDataInt);
	}

	private void updateSerieInDatabase() {
		String userData;
		int userDataInt;
		view.displayUpdateID();
		userDataInt = reader.intInputFromUser();
		reader.stringInputFromUser();
		view.displayUpdateSerie();
		userData = reader.stringInputFromUser();
		repository.updateSerie(userDataInt, userData);
	}

	private void readAllInDatabase() {
		List<Serie> serieList;
		view.displayAll();
		serieList = repository.getAllInDatabase();
		display(serieList);
	}

	private void addSerieInDatabase() {
		String userData;
		view.displayAdd();
		userData = reader.stringInputFromUser();
		repository.addSerie(userData);
	}

	private <T> void display(List<T> list) {

		list.stream().forEach(System.out::println);

	}

	public static class ControllerBuilder {

		private ConsoleReader newReader;
		private View newView;
		private RepositoryI newRepository;

		public ControllerBuilder setNewReader(ConsoleReader newReader) {
			this.newReader = newReader;
			return this;
		}

		public ControllerBuilder setNewView(View newView) {
			this.newView = newView;
			return this;
		}

		public ControllerBuilder setNewRepository(RepositoryI newRepository) {
			this.newRepository = newRepository;
			return this;
		}

		public Controller create() {

			return new Controller(newReader, newView, newRepository);
		}

	}

	private void exitProgram(boolean exit) {

		try {
			reader.close();
			repository.close();

			view.exitScanner();
			view.exitFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.exit(0);
	}

}
