package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ProjetTherapController {

    @FXML
    private Button Finishbutton;

    @FXML
    private TextArea demarche;

    private EpreuveClinique epreuveClinique;
    private BO bo;
    private int patientId;

    public void initData(EpreuveClinique epreuveClinique, BO bo, int patientId) {
        this.epreuveClinique = epreuveClinique;
        this.bo = bo;
        this.patientId = patientId;
    }

    @FXML
    void Finish(ActionEvent event) {
        String demarcheText = demarche.getText();
        if (demarcheText == null || demarcheText.isEmpty()) {
            showAlert("Error", "Please enter a demarche before finishing.");
            return;
        }

        // Save the demarche to the BO object
        bo.saveProjetTherapeutique(demarcheText);

        showAlert("Success", "Demarche saved successfully.");

        // Optionally, you can navigate to another page or close the window
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
