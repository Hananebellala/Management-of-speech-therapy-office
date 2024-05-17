package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ExerciceController {

    @FXML
    private Button AjouterButton;

    @FXML
    private TextField consigne;

    @FXML
    private TextField nom;

    @FXML
    private TextArea nommat;

    @FXML
    private RadioButton non;

    @FXML
    private RadioButton oui;

    private pageEpreuve pageEpreuve;

    // Method to initialize the controller with a PageEpreuve object
    public void initData(pageEpreuve pageEpreuve) {
        this.pageEpreuve = pageEpreuve;
    }

    // Method to handle the button action event
    @FXML

    void submitExercice(ActionEvent event) {
        // Check if all fields are filled
        if (consigne.getText().isEmpty() || nom.getText().isEmpty() || nommat.getText().isEmpty()) {
            // Show an error message or handle accordingly
            System.out.println("Please fill all fields.");
            return;
        }

        // Create an Exercice object with input values
        Exercice exercice = new Exercice(
                nom.getText(),
                0, // Set score to 0 initially
                consigne.getText(),
                nommat.getText(),
                oui.isSelected(),
                "" // Empty string for CompteRdu, you can adjust as needed
        );

        // Add the Exercice object to the EpreuveClinique test
        pageEpreuve.getEpreuveClinique().addExercise(exercice);

        // Optionally, you can close the window or navigate to another page
        // Here's a hypothetical method call to close the window
        closeWindow();
    }


    // Method to close the window
    private void closeWindow() {
        // Get the current stage and close it
        AjouterButton.getScene().getWindow().hide();
    }
}
