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

public class consultationDossiersController implements Initializable {
    @FXML
    private ListView<String> listeDossiers;
    @FXML
    private Button button;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Dossier> listeDos = Session.getCompte().getDossiersPatients();
        System.out.println("Taille de la liste : " + listeDos.size());

        for (Dossier dos : listeDos) {
            String numDossier = dos.getNumDossier();
            listeDossiers.getItems().add(numDossier);
        }

        button.disableProperty().bind(listeDossiers.getSelectionModel().selectedItemProperty().isNull());
    }

    @FXML
    void consulter(ActionEvent event) {

    }

    private void navigateToPatientPage(Patient patient) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientPage.fxml"));
            Parent root = loader.load();
            PatientController patientController = loader.getController();
            patientController.setPatient(patient); // Pass the patient to the controller

            Stage stage = (Stage) button.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void consulterDossier(ActionEvent event) {
        String selectedNumDossier = listeDossiers.getSelectionModel().getSelectedItem();
        if (selectedNumDossier != null) {
            Dossier selectedDossier = null;
            for (Dossier dos : Session.getCompte().getDossiersPatients()) {
                if (dos.getNumDossier().equals(selectedNumDossier)) {
                    selectedDossier = dos;
                    break;
                }
            }

            if (selectedDossier != null) {
                navigateToPatientPage(selectedDossier.getPatient());
            }
        }
    }

    @FXML
    void retourButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PageAccueil.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
