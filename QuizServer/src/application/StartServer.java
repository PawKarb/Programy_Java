package application;
	

import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class StartServer extends Application {
	ServerController controller;
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Server.fxml"));
			BorderPane root = loader.load();
			controller = loader.getController();
			Scene scene = new Scene(root,500,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("SERVER QUIZ");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		BlockingQueue<Socket> blockingQueue = new ArrayBlockingQueue<>(2);
		controller.setBlockingQueue(blockingQueue);
		controller.startProcess();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
