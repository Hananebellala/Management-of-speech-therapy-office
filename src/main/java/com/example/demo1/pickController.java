package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class pickController {

    @FXML
    private Pane mainLayout;

    @FXML
    private RadioButton Exercice;

    @FXML
    private RadioButton Quiz;

    @FXML
    private Button SuivantButton;



    private EpreuveClinique epreuveClinique = new EpreuveClinique(new Test[EpreuveClinique.max], "", 0);

    @FXML
    public void showPage(ActionEvent event) {
        try {
            FXMLLoader loader;
            Parent page;
            if (Exercice.isSelected()) {
                loader = new FXMLLoader(getClass().getResource("Exercice.fxml"));
                page = loader.load();

                // Get the controller associated with Exercice.fxml
                ExerciceController exerciceController = loader.getController();

                // Initialize the controller with the epreuveClinique instance
                exerciceController.initData(epreuveClinique);

            } else if (Quiz.isSelected()) {
                loader = new FXMLLoader(getClass().getResource("Quiz.fxml"));
                page = loader.load();

                // Assuming QuizController has a similar initData method
                //QuizController quizController = loader.getController();
                //quizController.initData(epreuveClinique);
            } else {
                // Neither Exercice nor Quiz is selected, do nothing
                return;
            }
            mainLayout.getChildren().setAll(page);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void initData(pageEpreuve pageEpreuve) {
        // Implementation for pageEpreuve if necessary
    }
}
