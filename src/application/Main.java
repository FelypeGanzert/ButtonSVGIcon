package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Carrega o arquivo FXML da tela
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Case2.fxml"));
			Parent parent = loader.load();
			Scene scene = new Scene(parent);
			// Carrega o arquivo CSS
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm()); 
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
