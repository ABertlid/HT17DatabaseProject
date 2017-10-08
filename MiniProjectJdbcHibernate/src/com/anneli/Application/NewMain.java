package com.anneli.Application;

import java.util.logging.Level;

import javafx.application.Application;
import javafx.stage.Stage;

public class NewMain  {

	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		//launch();
		
		View view = new View();
		view.startMenu();
	}
	//@Override
	/*public void start(Stage primaryStage) throws Exception {
		new ViewGraphic(primaryStage);

	}*/

}
