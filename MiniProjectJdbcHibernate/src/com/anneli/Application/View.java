package com.anneli.Application;

import java.util.Scanner;

import com.anneli.repository.CategoryRepository;
import com.anneli.repository.CategoryRepositoryI;
import com.anneli.repository.SerieRepository;
import com.anneli.repository.SerieRepositoryI;

public class View {

	private String userData;
	private int userDataInt;
	private Scanner scan = new Scanner(System.in);

	public void startMenu() {
		
		System.out.println("\n--- MENU ---");
		System.out.println("1. Create and add new Serie in database? ");
		System.out.println("2. Read all data in database? ");
		System.out.println("3. Update some data in database? ");
		System.out.println("4. Delete data in database? ");
		System.out.println("5. Search for serie in database? ");
		System.out.println("6. Search for category and series in database? ");
		System.out.println("7. Exit ");

		choice();
	}

	private void choice() {
	
		boolean isRunning = false;

		while (!isRunning) {
			String choiceFromUser = scan.nextLine();
			switch (choiceFromUser) {
			case "1":
				System.out.println("Add serie : ");
				userData = scan.nextLine();
				SerieRepositoryI serieRepositoryCreate = new SerieRepository();
				serieRepositoryCreate.add(userData);
				startMenu();
				break;

			case "2":
				System.out.println("Displaying the complete database (procedure)\n\n");
				SerieRepositoryI serieRepositoryRead = new SerieRepository();
				serieRepositoryRead.getAll();
				startMenu();
				break;

			case "3":
				System.out.println("Add serie_ID you want to update : ");
				userDataInt = scan.nextInt();
				System.out.println("Add new serie name : ");
				scan.nextLine();
				userData = scan.nextLine();
				SerieRepositoryI serieRepositoryUpdate = new SerieRepository();
				serieRepositoryUpdate.get(userDataInt, userData);
				startMenu();
				break;

			case "4":
				System.out.println("Add serie-ID you want to delete : ");
				userDataInt = scan.nextInt();
				SerieRepositoryI serieRepositoryDelete = new SerieRepository();
				serieRepositoryDelete.delete(userDataInt);
				startMenu();
				break;

			case "5":
				System.out.println("Write a letter to search : ");
				userData = scan.nextLine();
				SerieRepositoryI serieRepositorySearch = new SerieRepository();
				serieRepositorySearch.searchSerie(userData);
				startMenu();
				break;

			case "6":
				System.out.println("Write a category to search series : ");
				userData = scan.nextLine();
				CategoryRepositoryI categoryRepositorySearchSerie = new CategoryRepository();
				categoryRepositorySearchSerie.searchSerieByCategory(userData);
				startMenu();
				break;
			case "7":	
				exitProgram(isRunning);	
				break;
			default:
				break;
			}
		}
	}
	private void exitProgram(boolean exit) {
		
		scan.close();
		System.out.println("Scanner closed");
		
		SerieRepository serieRepositoryClose = new SerieRepository();
		serieRepositoryClose.closeFactory();		
		System.out.println("Factory closed");
		
		System.exit(0);		
	}
}
