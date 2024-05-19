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

public class QCMController {

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

    private EpreuveClinique epreuveClinique; // Add this field

    @FXML
    void Ajouter(ActionEvent event) {
        String consigne = "Sample consigne"; // Replace with actual consigne text input
        String[] answers = {"Answer 1", "Answer 2", "Answer 3", "Answer 4"}; // Replace with actual answers input
        String[] correctAnswersStrings = {"1", "3"}; // Replace with actual correct answers input
        int[] correctAnswers = new int[correctAnswersStrings.length];
        for (int i = 0; i < correctAnswersStrings.length; i++) {
            correctAnswers[i] = Integer.parseInt(correctAnswersStrings[i]);
        }

        Question qcm = new QCM(consigne, true, 0, answers, correctAnswers);
        if (epreuveClinique != null) {
            epreuveClinique.addQuestionToCurrentQuestionnaire(qcm);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("EpreuveClinique is not initialized.");
            alert.showAndWait();
        }
    }

    public void initData(EpreuveClinique epreuveClinique) {
        this.epreuveClinique = epreuveClinique; // Initialize the field
    }

    @FXML
    void Precedent(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pick.fxml"));
            Parent page = loader.load();

            // Assuming pickController has a similar initData method
            pickController epreuveController = loader.getController();
            epreuveController.initData(epreuveClinique); // Pass the epreuveClinique instance

            mainLayout.getChildren().setAll(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        // Get a random QCU object
        QCM qcm = QCM.getRandomQCM();

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
