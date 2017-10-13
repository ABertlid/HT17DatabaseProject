package com.anneli.Application;

import java.util.logging.Level;

public class NewMain {

	public static void main(String[] args) {
		handleLogging();

		View view = new View();
		view.startMenu();
	}
	
	public static void handleLogging() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
	}
}
