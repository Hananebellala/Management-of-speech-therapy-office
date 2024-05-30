package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
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
        System.out.println(patient.getNom());
    }
    @FXML
    void Bilans(ActionEvent event) {

    }

    @FXML
    void Fiches(ActionEvent event) {

    }

    @FXML
    void RendezVous(ActionEvent event) {

    }

}
