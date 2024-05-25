package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class pageEpreuve extends Application {

    private Stage primaryStage;
    private AnamneseController pickController;
    private EpreuveClinique epreuveClinique; // Add this attribute

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Page d'épreuve");

        initMainLayout();
    }

    private void initMainLayout() {
        try {
            // Load the pick.fxml file as the initial page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("QestionTestAnamnese.fxml"));
            Parent root = loader.load();

            // Get the controller for the pick.fxml file
            pickController = loader.getController();
            //pickController.initData(this.getEpreuveClinique());

            // Create a scene with thae loaded root
            Scene scene = new Scene(root);

            // Set the scene on the primary stage
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to return the EpreuveClinique object
    public EpreuveClinique getEpreuveClinique() {
        return epreuveClinique;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
