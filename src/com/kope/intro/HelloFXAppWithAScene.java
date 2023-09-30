package com.kope.intro;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HelloFXAppWithAScene extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage){
		// Node L2 : declare
		Text msg = new Text("Hello JavaFX");
		
		// Node L1 : declare
		VBox root = new VBox();
		// Node L1 : operation
		root.getChildren().add(msg);
		
		// Node L0 : declare
		Scene scene = new Scene(root, 300, 50);
		
		stage.setScene(scene);
		stage.setTitle("Hello JavaFX Application");
		stage.show();
	}
}