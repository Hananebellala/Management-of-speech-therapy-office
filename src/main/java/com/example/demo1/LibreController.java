package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class LibreController {

    @FXML
    private Button AjouterButton;

    @FXML
    private Label Question;

    @FXML
    private Button buttonPrecedent;

    @FXML
    private TextField reponse;

    @FXML
    private TextField score;

    @FXML
    private BorderPane mainLayout;

    private EpreuveClinique epreuveClinique;
    private BO bo;
    private int patientId;
    private Patient patient;

    public void initData(EpreuveClinique epreuveClinique, BO bo, int patientId) {
        this.epreuveClinique = epreuveClinique;
        this.bo = bo;
        this.patientId = patientId;
    }

    @FXML
    public void initialize() {
        Libre libre = new Libre("", false, 0, ""); // Create a Libre object with default values
        String enonce = libre.getEnonce(); // Get a random enonce from the Libre object
        Question.setText(enonce); // Set the enonce to the Question label
    }

    @FXML
    void AjouterLibre(ActionEvent event) {
        // Get the entered answer and score
        String enteredAnswer = reponse.getText();
        int enteredScore;
        try {
            enteredScore = Integer.parseInt(score.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Question Ajoutee");
            alert.showAndWait();
        } catch (NumberFormatException e) {
            // Show an error message if the score is not a valid integer
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid score.");
            alert.showAndWait();
            return;
        }

        // Get the enonce from the Question label
        String enonce = Question.getText();

        // Create a new Libre object with the entered details
        Libre libre = new Libre(enonce, false, enteredScore, enteredAnswer);

        // Add the Libre object to the EpreuveClinique
        if (epreuveClinique != null) {
            // epreuveClinique.addLibre(libre);
            System.out.println("Libre exercise added");
        } else {
            System.out.println("EpreuveClinique is not initialized.");
        }
    }

    public void initData(EpreuveClinique epreuveClinique, BO bo, Patient patient) {
        this.epreuveClinique = epreuveClinique;
        this.bo = bo;
        this.patient = patient;
    }


    @FXML
    void GoBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pick.fxml"));
            Parent page = loader.load();

            // Assuming pickController has a similar initData method
            pickController epreuveController = loader.getController();
            epreuveController.initData(epreuveClinique, bo, patient);

            mainLayout.getChildren().setAll(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
