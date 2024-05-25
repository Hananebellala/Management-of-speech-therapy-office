package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class DiagnosticController {

    @FXML
    private Button Suivantbutton;

    @FXML
    private ChoiceBox<DiagnoCategorie> categorie;

    @FXML
    private TextField trouble;

    @FXML
    private BorderPane mainLayout;

    private EpreuveClinique epreuveClinique;
    private BO bo;
    private int patientId;

    public void initData(EpreuveClinique epreuveClinique, BO bo, int patientId) {
        this.epreuveClinique = epreuveClinique;
        this.bo = bo;
        this.patientId = patientId;

        // Initialize the ChoiceBox with enum values
        categorie.getItems().setAll(DiagnoCategorie.values());
    }

    @FXML
    void Suivant(ActionEvent event) {
        // Get the selected category and entered trouble
        DiagnoCategorie selectedCategory = categorie.getValue();
        String enteredTrouble = trouble.getText();

        if (selectedCategory != null && enteredTrouble != null && !enteredTrouble.isEmpty()) {
            // Create a new Diagnostic object
            Diagnostic diagnostic = new Diagnostic(enteredTrouble, selectedCategory);

            // Add the Diagnostic to the BO object
            bo.addDiagnostic(diagnostic);

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ProjetTherapeutique.fxml"));
                Parent projetTherapeutiquePage = loader.load();
                ProjetTherapController projetTherapeutiqueController = loader.getController();
                projetTherapeutiqueController.initData(epreuveClinique, bo, patientId); // Pass necessary data

                mainLayout.getChildren().setAll(projetTherapeutiquePage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Show an error message or handle the invalid input
        }
    }

    @FXML
    public void initialize() {
        // Initialization code for the diagnostic page
    }
}
