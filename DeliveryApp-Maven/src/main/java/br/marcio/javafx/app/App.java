package br.marcio.javafx.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class App extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Pane root;		
			FXMLLoader loader = new FXMLLoader(getClass()
					.getResource("/br/marcio/javafx/DeliveryAppView.fxml"));
			root = loader.load();
			
			Scene scene = new Scene(root,400,400);

			primaryStage.setTitle("App de Delivery");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
