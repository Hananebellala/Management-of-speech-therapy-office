package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ProjetTherapController {

    @FXML
    private Button Finishbutton;

    @FXML
    private TextArea demarche;

    private EpreuveClinique epreuveClinique;
    private BO bo;
    private Patient patient;

    public void initData(EpreuveClinique epreuveClinique, BO bo, Patient patient) {
        this.epreuveClinique = epreuveClinique;
        this.bo = bo;
        this.patient = patient;
    }

    @FXML
    void Finish(ActionEvent event) throws IOException {
        String demarcheText = demarche.getText();
        if (demarcheText == null || demarcheText.isEmpty()) {
            showAlert("Error", "Please enter a demarche before finishing.");
            return;
        }

        // Save the demarche to the BO object
        bo.saveProjetTherapeutique(demarcheText);

        // Add the patient to the dossier list
        Compte compte = Session.getCompte();
        compte.ajouterDossier(new Dossier(patient, "Dossier " + (compte.getDossiersPatients().size() + 1)));

        showAlert("Success", "Demarche saved successfully.");
        navigateToFiches();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void navigateToFiches() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fiches.fxml"));
            Parent root = loader.load();
            FichesController fichesController = loader.getController();
            fichesController.initData(epreuveClinique, bo, patient); // Pass the necessary data

            Stage stage = (Stage) Finishbutton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
