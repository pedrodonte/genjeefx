package generar;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class HTMLEditorSample extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("HTMLEditor Sample");
		stage.setWidth(400);
		stage.setHeight(300);
		final HTMLEditor htmlEditor = new HTMLEditor();
		Button button = new Button("dsfs");
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println(htmlEditor.getHtmlText());
			}
		});

		VBox box = new VBox();
		box.getChildren().add(htmlEditor);
		box.getChildren().add(button);

		htmlEditor.setPrefHeight(245);
		Scene scene = new Scene(box);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
