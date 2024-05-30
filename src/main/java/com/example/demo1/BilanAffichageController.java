package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class BilanAffichageController implements Initializable {

    @FXML
    private Button button;

    @FXML
    private ListView<String> listeDossiers;

    @FXML
    private Button retour;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Assuming Session.getCompte().getDossiersPatients() returns a list of Dossiers
        List<Dossier> listeDos = Session.getCompte().getDossiersPatients();
        System.out.println("Taille de la liste : " + listeDos.size());

        // Iterate through each dossier to add the patient's BO bilan details
        for (Dossier dos : listeDos) {
            Patient patient = dos.getPatient();
            BO[] boList = patient.getListBO(); // Assuming getBOList() returns a list of BO objects for the patient

            for (BO bo : boList) {
                String bilanDetails = "Patient: " + patient.getNom() + " - Bilan: " ;
                listeDossiers.getItems().add(bilanDetails);
            }
        }

        button.disableProperty().bind(listeDossiers.getSelectionModel().selectedItemProperty().isNull());
    }

    @FXML
    void consulterDossier(ActionEvent event) {
        String selectedBilanDetails = listeDossiers.getSelectionModel().getSelectedItem();
        if (selectedBilanDetails != null) {
            Patient selectedPatient = null;
            for (Dossier dos : Session.getCompte().getDossiersPatients()) {
                Patient patient = dos.getPatient();
                if (selectedBilanDetails.contains(patient.getNom())) {
                    selectedPatient = patient;
                    break;
                }
            }

            if (selectedPatient != null) {
                navigateToPatientPage(selectedPatient);
            }
        }
    }

    private void navigateToPatientPage(Patient patient) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientPage.fxml"));
            Parent root = loader.load();
            PatientController patientController = loader.getController();
            patientController.setPatient(patient);  // Pass the patient to the controller
            patientController.updatePatientDetails(); // Ensure details are updated

            Stage stage = (Stage) button.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void retourButton(ActionEvent event) {
        try {
            Stage stage = (Stage) button.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PageAccueil.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
