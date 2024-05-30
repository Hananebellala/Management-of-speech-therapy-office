package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class App extends Application {
    public void start(Stage primaryStage) throws Exception{
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FirstPage.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.setTitle("First page");

        // Ajout d'un écouteur de fermeture
        primaryStage.setOnCloseRequest(event -> {
            // Appel de la méthode de sauvegarde
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("PageAccueil.fxml"));
            try {
                loader2.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            PageAccueilController controller = loader2.getController();
            controller.sauvegardeDonnees();
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}