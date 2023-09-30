package com.kope.intro;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImprovedHelloFXApp extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage){
		// Node L2 : declare
		Label nameLbl = new Label("Enter your name:");
		TextField nameFld = new TextField();
		Label msg = new Label();
		Button sayHelloBtn = new Button("Say Hello");
		Button exitBtn = new Button("Exit");
		
		// Node L2 : operation
		msg.setStyle("-fx-text-fill: blue;");
		sayHelloBtn.setOnAction(e -> {
			String name = nameFld.getText();
			if(name.trim().length() > 0) {
				msg.setText("Hello " + name);
			}else {
				msg.setText("Hello there");
			}
		});
		exitBtn.setOnAction(e -> Platform.exit());
		
		// Node L1 : declare
		VBox root = new VBox();
		
		// Node L1 : operation
		root.setSpacing(5);
		root.getChildren().addAll(nameLbl, nameFld, msg, sayHelloBtn, exitBtn);
		
		// Node : L0
		Scene scene = new Scene(root, 350, 150);
		
		stage.setScene(scene);
		stage.setTitle("Hello JavaFX Application");
		stage.show();
	}
}