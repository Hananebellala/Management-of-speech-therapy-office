package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;


public class App extends Application {
    public void start(Stage primaryStage) throws Exception{
        // Charger le fichier FXML
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rdvScene.fxml")));
        // Créer une scène
        Scene scene = new Scene(root);
        // Définir la scène sur la fenêtre principale
        primaryStage.setScene(scene);
        // Afficher la fenêtre principale
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}