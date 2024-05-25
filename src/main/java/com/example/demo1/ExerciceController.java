package com.example.demo1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

import java.io.IOException;


public class ExerciceController {

    @FXML
    private Button AjouterButton;



    @FXML
    private TextField consigne;

    @FXML
    private TextField nom;

    @FXML
    private BorderPane mainLayout;

    @FXML
    private TextArea nommat;

    @FXML
    private TextArea nommat1;

    @FXML
    private RadioButton non;

    @FXML
    private RadioButton oui;

    @FXML
    private Button Precedent;

    @FXML
    private TextField score;

    private EpreuveClinique epreuveClinique;

    // Method to initialize the controller with an EpreuveClinique object
    public void initData(EpreuveClinique epreuveClinique, BO bo, int patientId) {
        this.epreuveClinique = epreuveClinique;
    }

    // Method to handle the button action event
    @FXML
    public void updateExercice(ActionEvent event) {
        // Check if all fields are filled

        if (oui.isSelected()) {
            if (consigne.getText().isEmpty() || nom.getText().isEmpty() || nommat.getText().isEmpty()||score.getText().isEmpty()) {
                // Show an error message or handle accordingly
                Alert();
                return;
            }
        }else{
            if (consigne.getText().isEmpty() || nom.getText().isEmpty() ||score.getText().isEmpty()) {
                // Show an error message or handle accordingly
                Alert();
                return;
            }
        }

        // Create an Exercice object with input values

        if(oui.isSelected()) {
            Exercice exercice = new Exercice(
                    nom.getText(),
                    Integer.parseInt(score.getText()), // Set score to 0 initially
                    consigne.getText(),
                    nommat.getText(),
                    oui.isSelected(),
                    "" // Empty string for CompteRdu, you can adjust as needed
            );
            addExerciceToEpreuve(exercice);
            exercice.Afficher(exercice);

        }else{
            Exercice exercice = new Exercice(
                    nom.getText(),
                    Integer.parseInt(score.getText()),// Set score to 0 initially
                    consigne.getText(),
                    "",
                    oui.isSelected(),
                    "" // Empty string for CompteRdu, you can adjust as needed
            );
            addExerciceToEpreuve(exercice);
            exercice.Afficher(exercice);
        }

        // Add the Exercice object to the EpreuveClinique test


        // Optionally, you can close the window or navigate to another page
        // Here's a hypothetical method call to close the window
        closeWindow();
    }

    public void addExerciceToEpreuve(Exercice exercice) {
        if (epreuveClinique != null) {
            epreuveClinique.addExercise(exercice);
            System.out.println("Exercice Added");
        } else {
            System.out.println("EpreuveClinique is not initialized.");
        }
    }

    @FXML
    void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pick.fxml"));
            Parent page = loader.load();

            // Assuming EpreuveCliniqueController has a similar initData method
            pickController epreuveController = loader.getController();
            //epreuveController.initData(epreuveClinique);

            mainLayout.getChildren().setAll(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {

        nommat.setDisable(false);

        oui.setOnAction(event -> {
            if (oui.isSelected()) {
                non.setSelected(false);
            }
        });

        non.setOnAction(event -> {
            if (non.isSelected()) {
                oui.setSelected(false);
            }
        });
        // Add a listener to the selected property of the oui RadioButton
        oui.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                // Check if oui is selected
                if (newValue) {
                    // If oui is selected, enable the nommat TextArea
                    nommat.setDisable(false);
                } else {
                    // If oui is not selected, disable the nommat TextArea
                    nommat.setDisable(true);
                }
            }
        });
    }


    // Method to close the window


    // Method to close the window and show a message
    private void closeWindow() {
        // Show a confirmation dialog
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Exercise Added");
        alert.setHeaderText(null);
        alert.setContentText("Exercise has been successfully added.");
        alert.showAndWait();

        // Get the current stage and close it
        //AjouterButton.getScene().getWindow().hide();
    }

    private void Alert() {
        // Show a confirmation dialog
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("ALERT!");
        alert.setHeaderText(null);
        alert.setContentText("Please fill all fields.");
        alert.showAndWait();

        // Get the current stage and close it
        //AjouterButton.getScene().getWindow().hide();
    }

}
