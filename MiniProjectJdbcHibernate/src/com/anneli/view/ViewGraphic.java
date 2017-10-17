package com.anneli.view;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewGraphic {

	private Stage window;
	private TextField userInput;
	private VBox vBox;
	private HBox hBoxButton;
	private Button addButton;
	private Button updateButton;
	private Button deleteButton;
	private Button showButton;
	private TableView tableView = new TableView();

	public ViewGraphic(Stage primaryStage) {
		this.window = primaryStage;
		createGUI();
	}

	public void createGUI() {
		window.setTitle("SERIE-LIBRARY");

		// Input and labels
		userInput = new TextField();
		userInput.setPromptText("Enter serie here >>");
		userInput.setMaxWidth(300);
		userInput.setFocusTraversable(false);

		HBox bottomText = new HBox();
		bottomText.setAlignment(Pos.CENTER);
		bottomText.setStyle("-fx-border-color: black");

		addButton = new Button("Add");
		updateButton = new Button("Update");
		deleteButton = new Button("Delete");
		showButton = new Button("Show table");
		hBoxButton = new HBox(10, addButton, updateButton, deleteButton, showButton);
		hBoxButton.setAlignment(Pos.CENTER);

		vBox = new VBox(10, userInput, hBoxButton, bottomText, tableView);
		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.setPadding(new Insets(10));

		Scene scene = new Scene(vBox, 800, 500);
		window.setScene(scene);
		window.sizeToScene();
		window.show();
	}
}