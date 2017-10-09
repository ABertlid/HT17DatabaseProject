package com.anneli.Application;

import java.util.logging.Level;

public class NewMain {

	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

		View view = new View();
		view.startMenu();
	}
}
