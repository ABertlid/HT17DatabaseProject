package com.anneli.Application;

import java.util.logging.Level;

import com.anneli.view.ViewGraphic;

import javafx.application.Application;
import javafx.stage.Stage;

public class SerieLibraryGraphic extends Application {

	public static void main(String[] args) {

		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		new ViewGraphic(primaryStage);

	}

}
