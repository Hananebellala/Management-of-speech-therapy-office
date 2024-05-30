package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjouterObjectifController {

    @FXML
    private Button ajouter;

    @FXML
    private TextField nom;

    @FXML
    private TextField objectif1;

    @FXML
    private TextField objectif2;

    @FXML
    private TextField objectif3;

    @FXML
    private TextField objectif4;

    @FXML
    private ChoiceBox<TypeObjectif> type1;

    @FXML
    private ChoiceBox<TypeObjectif> type2;

    @FXML
    private ChoiceBox<TypeObjectif> type3;

    @FXML
    private ChoiceBox<TypeObjectif> type4;

    private int index;
    private boolean isCompleted = false;
    private Fiche fiche;

    @FXML
    public void initialize() {
        type1.getItems().setAll(TypeObjectif.values());
        type2.getItems().setAll(TypeObjectif.values());
        type3.getItems().setAll(TypeObjectif.values());
        type4.getItems().setAll(TypeObjectif.values());
    }

    @FXML
    void Ajouter(ActionEvent event) {
        // Collect the objectives from text fields and choice boxes
        Objectif[] objectifs = new Objectif[4];
        objectifs[0] = new Objectif(objectif1.getText(), type1.getValue(), false);
        objectifs[1] = new Objectif(objectif2.getText(), type2.getValue(), false);
        objectifs[2] = new Objectif(objectif3.getText(), type3.getValue(), false);
        objectifs[3] = new Objectif(objectif4.getText(), type4.getValue(), false);

        // Initialize a new Fiche with objectives and initial score 0
        fiche = new Fiche(objectifs, "");

        // Indicate that the process is completed
        isCompleted = true;

        // Close the window
        closeWindow();
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Fiche getFiche() {
        return fiche;
    }

    public void setFiche(Fiche fiche) {
        this.fiche = fiche;
        // Fill the form with fiche data
        Objectif[] objectifs = fiche.getObject();
        if (objectifs.length > 0) {
            objectif1.setText(objectifs[0].getNom());
            type1.setValue(objectifs[0].getType());
        }
        if (objectifs.length > 1) {
            objectif2.setText(objectifs[1].getNom());
            type2.setValue(objectifs[1].getType());
        }
        if (objectifs.length > 2) {
            objectif3.setText(objectifs[2].getNom());
            type3.setValue(objectifs[2].getType());
        }
        if (objectifs.length > 3) {
            objectif4.setText(objectifs[3].getNom());
            type4.setValue(objectifs[3].getType());
        }
        // Set other fields as needed
    }

    private void closeWindow() {
        Stage stage = (Stage) ajouter.getScene().getWindow();
        stage.close();
    }
}
