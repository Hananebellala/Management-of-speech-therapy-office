package com.example.demo1;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class controllerBilan implements Initializable {

    @FXML
    private Button Suivant;

    @FXML
    private TextField adress;

    @FXML
    private AnchorPane adulteContainer;

    @FXML
    private ComboBox<String> categoriePatient;

    @FXML
    private TextField classe;

    @FXML
    private DatePicker date;

    @FXML
    private TextField diplome;

    @FXML
    private AnchorPane enfantContainer;

    @FXML
    private TextField lieu;

    @FXML
    private TextField nmere;

    @FXML
    private TextField nom;

    @FXML
    private TextField npere;

    @FXML
    private TextField numeropers;

    @FXML
    private TextField prenom;

    private RendezVous rdv;

    @FXML
    private TextField profession;
    private TypeRdv typeRdv;
    private BooleanProperty enfantActive = new SimpleBooleanProperty(false);
    private BooleanProperty adulteActive = new SimpleBooleanProperty(false);
    private Compte ortho;
    private Patient patient;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Enfant", "Adulte");
        categoriePatient.setItems(list);
        enfantContainer.disableProperty().bind(enfantActive.not());
        adulteContainer.disableProperty().bind(adulteActive.not());
        ortho = Session.getCompte();
    }
    public void setTypeRdv(TypeRdv typeRdv) {
        this.typeRdv=typeRdv;
    }
    public void Select(ActionEvent event) {
        String s = categoriePatient.getSelectionModel().getSelectedItem();
        if (s != null) {
            switch (s) {
                case "Enfant":
                    enfantActive.set(true);
                    adulteActive.set(false);
                    break;
                case "Adulte":
                    enfantActive.set(false);
                    adulteActive.set(true);
                    break;
                default:
                    enfantActive.set(false);
                    adulteActive.set(false);
                    break;
            }
        }
    }

    @FXML
    public void Suivant(ActionEvent event) {
        boolean isValid = true;
        String errorMessage = "";

        // Check common fields
        if (nom.getText().isEmpty()) {
            isValid = false;
            errorMessage += "Nom est requis.\n";
        }
        if (prenom.getText().isEmpty()) {
            isValid = false;
            errorMessage += "Prenom est requis.\n";
        }
        if (adress.getText().isEmpty()) {
            isValid = false;
            errorMessage += "Adresse est requise.\n";
        }
        if (lieu.getText().isEmpty()) {
            isValid = false;
            errorMessage += "Lieu de naissance est requis.\n";
        }
        if (date.getValue() == null) {
            isValid = false;
            errorMessage += "Date de naissance est requise.\n";
        }

        // Check specific fields based on patient category
        String category = categoriePatient.getSelectionModel().getSelectedItem();
        if ("Adulte".equals(category)) {
            if (diplome.getText().isEmpty()) {
                isValid = false;
                errorMessage += "Diplome est requis pour les adultes.\n";
            }
            if (profession.getText().isEmpty()) {
                isValid = false;
                errorMessage += "Profession est requise pour les adultes.\n";
            }
            if (numeropers.getText().isEmpty()) {
                isValid = false;
                errorMessage += "Numéro de personne à prévenir est requis pour les adultes.\n";
            }
        } else if ("Enfant".equals(category)) {
            if (classe.getText().isEmpty()) {
                isValid = false;
                errorMessage += "Classe est requise pour les enfants.\n";
            }
            if (nmere.getText().isEmpty()) {
                isValid = false;
                errorMessage += "Nom de la mère est requis pour les enfants.\n";
            }
            if (npere.getText().isEmpty()) {
                isValid = false;
                errorMessage += "Nom du père est requis pour les enfants.\n";
            }
        }

        if (isValid) {
            // Create Patient object
            LocalDate localDate = date.getValue();
            String nomPat = nom.getText();
            String prenomPat = prenom.getText();
            LocalDate datenaiss = date.getValue();
            String adr = adress.getText();
            String lieuNaiss = lieu.getText();

            if (typeRdv == TypeRdv.CONSULTATION) {
                if ("Enfant".equals(category)) {
                    String cls = classe.getText();
                    String numPere = npere.getText();
                    String numMere = nmere.getText();
                    Enfant patEnfant = new Enfant(cls, numPere, numMere, nomPat, prenomPat, lieuNaiss, datenaiss);
                    Dossier dos = new Dossier();
                    int nbDoss = dos.getNbDossiers() + 1;
                    dos = new Dossier(patEnfant, Integer.toString(nbDoss));
                    ortho.ajouterDossier(dos);
                    Session.setCompte(ortho);
                } else if ("Adulte".equals(category)) {
                    String prof = profession.getText();
                    String dip = diplome.getText();
                    String numP = numeropers.getText();
                    Adulte adulte = new Adulte(nomPat, prenomPat, lieuNaiss, datenaiss, dip, prof, numP);
                    Dossier dos = new Dossier();
                    int nbDoss = dos.getNbDossiers() + 1;
                    dos = new Dossier(adulte, Integer.toString(nbDoss));
                    ortho.ajouterDossier(dos);
                    Session.setCompte(ortho);
                } else {
                    System.out.println("Erreur creation dossier");
                }
            } else if (typeRdv == TypeRdv.SEANCEDESUIVI) {
                Patient patient = new Patient(nomPat, prenomPat, lieuNaiss, datenaiss);
                Dossier dossier = ortho.trouverPatient(patient);
            }

            // Create the patient object to pass
            Patient patient = new Patient(nomPat, prenomPat, lieuNaiss, datenaiss);
            patient.setAdress(adr); // Assuming there is a setAdress method in Patient class
            //patient.setCategory(category); // Assuming there is a setCategory method in Patient class

            // Load Anamnese.fxml and set the scene
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Anamnese.fxml"));
                Parent anamnesePage = loader.load();

                // Pass the patient object to the AnamneseController
                AnamneseController anamneseController = loader.getController();
                anamneseController.initData(patient);

                Scene scene = new Scene(anamnesePage);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            // Show error message
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Champs requis manquants");
            alert.setHeaderText(null);
            alert.setContentText(errorMessage);
            alert.showAndWait();
        }
    }


    public void setRendezVous(RendezVous selectedRdv) {
        this.rdv=selectedRdv;
    }

    public void setPatient(Patient patient) {
        this.patient=patient;
    }
}
