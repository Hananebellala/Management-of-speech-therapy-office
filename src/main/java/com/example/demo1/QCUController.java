package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class QCUController {

    @FXML
    private Button AjouterButton;

    @FXML
    private Button PrecedButton;

    @FXML
    private CheckBox fifth;

    @FXML
    private CheckBox first;

    @FXML
    private CheckBox fourth;

    @FXML
    private BorderPane mainLayout;

    @FXML
    private Label qst;

    @FXML
    private CheckBox second;

    @FXML
    private CheckBox sixth;

    @FXML
    private CheckBox third;


    private QCU qcu;

    @FXML
    void Ajouter(ActionEvent event) {
        // Get the selected answer index (assuming the CheckBoxes are mutually exclusive)
        int selectedAnswerIndex = -1;
        if (first.isSelected()) selectedAnswerIndex = 0;
        if (second.isSelected()) selectedAnswerIndex = 1;
        if (third.isSelected()) selectedAnswerIndex = 2;
        if (fourth.isSelected()) selectedAnswerIndex = 3;

        // Calculate the score based on the selected answer
        int score=0;


            if (selectedAnswerIndex==qcu.GetAnser()) {
                score++;
            }


            qcu.SetScore(score);



        // Set the score in the QCU object
        qcu.SetScore(score);

        // Show the score in a window
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Score");
        alert.setHeaderText(null);
        alert.setContentText("Your score is: " + score);
        alert.showAndWait();
    }

    @FXML
    public void initialize() {
        // Get a random QCU object
        qcu = QCU.getRandomQCU();

        // Set the question label
        qst.setText(qcu.getEnonce());

        // Set the propositions to the CheckBoxes
        String[] propositions = qcu.getProposition();
        if (propositions.length > 0) first.setText(propositions[0]);
        if (propositions.length > 1) second.setText(propositions[1]);
        if (propositions.length > 2) third.setText(propositions[2]);
        if (propositions.length > 3) fourth.setText(propositions[3]);
    }

    @FXML
    void Precedent(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pick.fxml"));
            Parent page = loader.load();

            // Assuming EpreuveCliniqueController has a similar initData method
            pickController epreuveController = loader.getController();
            //epreuveController.initData(epreuveClinique);

            mainLayout.getChildren().setAll(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initData(EpreuveClinique epreuveClinique, BO bo, int patientId) {
    }
}
