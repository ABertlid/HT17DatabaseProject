package com.anneli.Application;

import java.util.logging.Level;

import com.anneli.controller.Controller;
import com.anneli.repository.model.Repository;
import com.anneli.repository.model.RepositoryI;
import com.anneli.view.ConsoleReader;
import com.anneli.view.View;

public class SerieLibrary {

	public static void main(String[] args) {
		handleLogging();

		ConsoleReader reader = new ConsoleReader();
		View view = new View();		
		RepositoryI repository = new Repository();
		
			new Controller.ControllerBuilder()
				.setNewReader(reader)
				.setNewView(view)
				.setNewRepository(repository)
				.create()
				.startProgram();
		
	}

	public static void handleLogging() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
	}
}
