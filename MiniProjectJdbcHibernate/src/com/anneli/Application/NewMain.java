package com.anneli.Application;

import java.util.logging.Level;

import javafx.application.Application;
import javafx.stage.Stage;

public class NewMain extends Application {

	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		launch(args);
		
		//View view = new View();
		//view.startMenu();
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		new ViewGraphic(primaryStage);

	}

}
