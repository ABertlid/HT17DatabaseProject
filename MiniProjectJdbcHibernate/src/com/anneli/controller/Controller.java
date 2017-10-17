package com.anneli.controller;

import java.util.List;

import com.anneli.entity.model.Category;
import com.anneli.entity.model.Serie;
import com.anneli.repository.model.CategoryRepositoryI;
import com.anneli.repository.model.RatingRepositoryI;
import com.anneli.repository.model.SerieRepositoryI;
import com.anneli.view.Handler;
import com.anneli.view.View;

public class Controller {

	private Handler handler;
	private View view;
	private SerieRepositoryI serieRepository;
	private CategoryRepositoryI categoryRepository;
	private RatingRepositoryI ratingRepository;

	public Controller(Handler handler, View view, SerieRepositoryI serieRepository,
			CategoryRepositoryI categoryRepository, RatingRepositoryI ratingRepository) {

		this.handler = handler;
		this.view = view;
		this.serieRepository = serieRepository;
		this.categoryRepository = categoryRepository;
		this.ratingRepository = ratingRepository;
	}

	public void startProgram() {
		view.startMenu();
		choicesFromUser();
	}

	private void choicesFromUser() {

		String userData;
		int userDataInt;
		List<Serie> serieList;
		List<Category> categoryList;

		boolean isRunning = false;

		while (!isRunning) {
			String choiceFromUser = handler.inputStringFromUser();
			switch (choiceFromUser) {
			case "1":
				view.displayAdd();
				userData = handler.inputStringFromUser();
				serieRepository.add(userData);
				startProgram();
				break;

			case "2":
				view.displayAll();
				serieList = serieRepository.getAll();
				display(serieList);
				startProgram();
				break;

			case "3":
				view.displayUpdateID();
				userDataInt = handler.inputIntFromUser();
				view.displayUpdateSerie();
				userData = handler.inputStringFromUser();
				serieRepository.get(userDataInt, userData);
				startProgram();
				break;

			case "4":
				view.displayDelete();
				userDataInt = handler.inputIntFromUser();
				serieRepository.delete(userDataInt);
				startProgram();
				break;

			case "5":
				view.displaySearchSerie();
				userData = handler.inputStringFromUser();
				serieList = serieRepository.searchSerie(userData);
				display(serieList);
				startProgram();
				break;

			case "6":
				view.displaySerieByCategory();
				userData = handler.inputStringFromUser();
				categoryList = categoryRepository.searchSerieByCategory(userData);
				display(categoryList);
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

	private <T> void display(List<T> list) {

		list.stream().forEach(System.out::println);

	}

	private void exitProgram(boolean exit) {

		handler.closeScanner();
		view.exitScanner();

		serieRepository.closeFactory();
		view.exitFactory();

		System.exit(0);
	}

}
