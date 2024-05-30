package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AnamneseTestController {

    @FXML
    private Button Anamn;

    @FXML
    private Button qcm;

    @FXML
    private Button qcu;

    @FXML
    private Button qstLibre;

    @FXML
    void Anamnese(ActionEvent event) {
        loadPage("GestionQuestionsAnamnese.fxml");
    }

    @FXML
    void Libre(ActionEvent event) {
        loadPage("GestionQuestionsLibre.fxml");
    }

    @FXML
    void Retour(ActionEvent event) throws IOException {
        Stage stage = (Stage) Anamn.getScene().getWindow(); // Get the current stage
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PageAccueil.fxml")); // Load the FXML file for QuestionTestAnamnese
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void QCM(ActionEvent event) {
        loadPage("GestionQCM.fxml");
    }

    @FXML
    void QCU(ActionEvent event) {
        loadPage("GestionQCU.fxml");
    }

    private void loadPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent newPage = loader.load();
            Stage stage = (Stage) Anamn.getScene().getWindow(); // Get the current stage
            stage.setScene(new Scene(newPage)); // Set the new scene
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
