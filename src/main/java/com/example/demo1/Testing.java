package com.example.demo1;

import javafx.application.Application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Testing extends Application {
    public void start(Stage primaryStage) throws IOException{
        // Create an array to hold the tests
        Test[] tests = new Test[EpreuveClinique.max];

        // Create an EpreuveClinique instance
        EpreuveClinique epreuveClinique = new EpreuveClinique(tests, "Observation text", 0);

        try {
            // Add tests
            epreuveClinique.addTest();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("QCM.fxml"));

        loader.setControllerFactory((clazz) -> new QCM("Your Enonce", true, 0, new String[]{"Proposition 1", "Proposition 2", "Proposition 3"}, new int[]{0, 0, 0}));
        Parent root = loader.load();

        // Find the index of the last added test


        // Pass the last added test as the controller factory parameter


        primaryStage.setTitle("QCM Test");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
