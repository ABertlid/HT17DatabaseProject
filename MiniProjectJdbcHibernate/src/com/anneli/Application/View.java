package com.anneli.Application;

import java.util.Scanner;

import com.anneli.repository.CategoryRepository;
import com.anneli.repository.CategoryRepositoryI;
import com.anneli.repository.SerieRepository;
import com.anneli.repository.SerieRepositoryI;

public class View {

	private String userData;
	private int userDataInt;

	public void startMenu() {

		Scanner scan = new Scanner(System.in);

		System.out.println("--- MENU ---");
		System.out.println("1. Create and add new Serie in database? ");
		System.out.println("2. Read all data in database? ");
		System.out.println("3. Update some data in database? ");
		System.out.println("4. Delete data in database? ");
		System.out.println("5. Search for serie in database? ");
		System.out.println("6. Search for category and series in database? ");

		String choice = scan.nextLine();

		switch (choice) {
		case "1":
			System.out.println("Add serie : ");
			userData = scan.nextLine();
			SerieRepositoryI serieRepositoryCreate = new SerieRepository();
			serieRepositoryCreate.add(userData);
			scan.close();
			break;

		case "2":
			System.out.println("Displaying the complete database (procedure)\n\n");
			SerieRepositoryI serieRepositoryRead = new SerieRepository();
			serieRepositoryRead.getAll();
			break;

		case "3":
			System.out.println("Add serie_ID you want to update : ");
			userDataInt = scan.nextInt();
			System.out.println("Add new serie name : ");
			scan.nextLine();
			userData = scan.nextLine();
			SerieRepositoryI serieRepositoryUpdate = new SerieRepository();
			serieRepositoryUpdate.get(userDataInt, userData);
			scan.close();
			break;

		case "4":
			System.out.println("Add serie-ID you want to delete : ");
			userDataInt = scan.nextInt();
			SerieRepositoryI serieRepositoryDelete = new SerieRepository();
			serieRepositoryDelete.delete(userDataInt);
			scan.close();
			break;

		case "5":
			System.out.println("Write a letter to search : ");
			userData = scan.nextLine();
			SerieRepositoryI serieRepositorySearch = new SerieRepository();
			serieRepositorySearch.searchSerie(userData);
			scan.close();
			break;

		case "6":
			System.out.println("Write a category to search series : ");
			userData = scan.nextLine();
			CategoryRepositoryI categoryRepositorySearchSerie = new CategoryRepository();
			categoryRepositorySearchSerie.searchSerieByCategory(userData);
			scan.close();
			break;

		default:
			break;
		}
	}
}
