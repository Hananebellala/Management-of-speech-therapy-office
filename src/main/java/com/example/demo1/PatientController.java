package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PatientController implements Initializable {

    @FXML
    private Label DateNaiss;

    @FXML
    private Button Fiche;

    @FXML
    private Label Lieu;

    @FXML
    private Label Nom;

    @FXML
    private Label Prenom;

    @FXML
    private Button Rdv;

    @FXML
    private Button bilan;
    private Patient patient = new Patient();
    private consultationDossiersController consultationController;
    public void setConsultationDossiersController(consultationDossiersController controller) {
        consultationController=controller;
    }
    public void setPatient(Patient patient) {
        this.patient=patient;
    }
    public void initialize(URL url, ResourceBundle rb) {
        if(patient!=null)
        System.out.println("Heree" +patient.getNom());
    }
    @FXML
    void Bilans(ActionEvent event) {

    }

    @FXML
    void Fiches(ActionEvent event) throws IOException {
        Stage stage = (Stage) Nom.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Fiches.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void updatePatientDetails() {
        if (patient != null) {
            Nom.setText(patient.getNom());
            Prenom.setText(patient.getPrenom());
            DateNaiss.setText(String.valueOf(patient.getDateNaiss()));
            Lieu.setText(patient.getLieu());
        }
    }

    @FXML
    void RendezVous(ActionEvent event) {

    }

}
