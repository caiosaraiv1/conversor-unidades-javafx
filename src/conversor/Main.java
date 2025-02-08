package conversor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Conversor.fxml"));
		String arquivoCSS = getClass().getResource("/conversor/style.css").toExternalForm();

		Scene scene = new Scene(root, 400, 300);
		scene.getStylesheets().add(arquivoCSS);
		scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Raleway");
		
		primaryStage.setResizable(false);
		primaryStage.setTitle("Conversor de Unidades");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
