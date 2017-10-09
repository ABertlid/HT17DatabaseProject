package com.anneli.Application;

import java.util.logging.Level;

import javafx.application.Application;
import javafx.stage.Stage;

public class NewMainGraphic extends Application {

	public static void main(String[] args) {

		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		new ViewGraphic(primaryStage);

	}

}
