package com.anneli.view;

/**
 * Simple class that only prints out text in the console
 * 
 * @author Anneli
 *
 */
public class View {

	public void startMenu() {

		System.out.println("\n--- MENU ---");
		System.out.println("1. Create and add new Serie in database? ");
		System.out.println("2. Read all data in database? ");
		System.out.println("3. Update some data in database? ");
		System.out.println("4. Delete data in database? ");
		System.out.println("5. Search for serie in database? ");
		System.out.println("6. Search for category and series in database? ");
		System.out.println("7. Exit ");

	}

	public void displayAdd() {
		System.out.println("Add serie : ");
	}

	public void displayAll() {
		System.out.println("Displaying the complete database (procedure)\n\n");
	}

	public void displayUpdateID() {
		System.out.println("Add serie_ID you want to update : ");
	}

	public void displayUpdateSerie() {
		System.out.println("Add new serie name : ");
	}

	public void displayDelete() {
		System.out.println("Add serie-ID you want to delete : ");
	}

	public void displaySearchSerie() {
		System.out.println("Write a letter to search : ");
	}

	public void displaySerieByCategory() {
		System.out.println("Write a category to search series : ");
	}

	public void exitScanner() {
		System.out.println("Scanner closed");
	}

	public void exitFactory() {
		System.out.println("Factory closed");
	}
}
