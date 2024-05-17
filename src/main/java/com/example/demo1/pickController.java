package com.example.demo1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import java.io.IOException;

public class pickController {

    @FXML
    private Pane mainLayout; // Assuming mainLayout is properly initialized elsewhere

    @FXML
    private RadioButton Exercice;

    @FXML
    private RadioButton Quiz;

    @FXML
    private Button SuivantButton;

    @FXML
    public void showExercisePage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Exercice.fxml"));
            Parent exercisePage = loader.load();
            ExerciceController exerciceController = loader.getController();
            // Pass any necessary data to the exercise controller
            // exerciceController.initData(pageEpreuve); // Assuming ExerciceController has a method initData(pageEpreuve)
            mainLayout.getChildren().setAll(exercisePage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initData(pageEpreuve pageEpreuve) {
    }
}
