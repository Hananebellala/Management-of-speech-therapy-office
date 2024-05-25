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
import java.util.ArrayList;
import java.util.List;

public class QCMController {

    private QCM qcm;

    @FXML
    private Button button;

    @FXML
    private BorderPane mainLayout;

    @FXML
    private Button button1;

    @FXML
    private CheckBox fifth;

    @FXML
    private CheckBox first;

    @FXML
    private CheckBox fourth;

    @FXML
    private Label questionLabel;

    @FXML
    private CheckBox second;

    @FXML
    private CheckBox sixth;

    @FXML
    private CheckBox third;

    private EpreuveClinique epreuveClinique = new EpreuveClinique("Initial Observation", 0);

    private BO bo;
    private int patientId;

    public void initData(EpreuveClinique epreuveClinique, BO bo, int patientId) {
        this.epreuveClinique = epreuveClinique;
        this.bo = bo;
        this.patientId = patientId;
    }

    @FXML
    void Ajouter(ActionEvent event) {
        // Get the selected answers
        List<Integer> selectedAnswers = new ArrayList<>();
        if (first.isSelected()) selectedAnswers.add(0);
        if (second.isSelected()) selectedAnswers.add(1);
        if (third.isSelected()) selectedAnswers.add(2);
        if (fourth.isSelected()) selectedAnswers.add(3);
        if (fifth.isSelected()) selectedAnswers.add(4);
        if (sixth.isSelected()) selectedAnswers.add(5);

        // Get the correct answers from the question
        int[] correctAnswers = qcm.getCorrectAnswers();

        // Check if the selected answers match the correct answers
        int score = 0;
        int i = 0;
        for (int k = 0; k < correctAnswers.length; k++) {
            if (selectedAnswers.get(k) == correctAnswers[k]) {
                i++;
            }

            if (i == correctAnswers.length) {
                score = 1;
                qcm.SetScore(1);
            }
        }

        // Add QCM to the current questionnaire in epreuveClinique
        if (epreuveClinique != null) {
            epreuveClinique.addQuestionToCurrentQuestionnaire(qcm);
            if(bo!=null){
                bo.updateEpreuveClinique(epreuveClinique);
            }


            // Show the score in a window
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Score");
            alert.setHeaderText(null);
            alert.setContentText("Your score is: " + score);
            alert.showAndWait();
        } else {
            // Handle the case where epreuveClinique is null
            System.out.println("EpreuveClinique is not initialized.");
        }
    }

    @FXML
    void Precedent(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pick.fxml"));
            Parent page = loader.load();

            // Assuming pickController has a similar initData method
            pickController epreuveController = loader.getController();
            epreuveController.initData(epreuveClinique, bo, patientId);

            mainLayout.getChildren().setAll(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
        // Get a random QCU object
        qcm = QCM.getRandomQCM();

        // Get the enonce and set it to the qst label
        String enonce = qcm.Enonce;
        questionLabel.setText(enonce);
        System.out.println(enonce);
        // Get the propositions and set them to the CheckBoxes
        String[] propositions = qcm.getProposition();
        if (propositions.length > 0) first.setText(propositions[0]);
        if (propositions.length > 1) second.setText(propositions[1]);
        if (propositions.length > 2) third.setText(propositions[2]);
        if (propositions.length > 3) fourth.setText(propositions[3]);
        if (propositions.length > 4) fifth.setText(propositions[4]);
        if (propositions.length > 5) sixth.setText(propositions[5]);
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ALERT!");
        alert.setHeaderText(null);
        alert.setContentText("Please choose at least one answer");
        alert.showAndWait();
    }
}
