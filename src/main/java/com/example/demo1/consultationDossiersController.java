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
import java.util.ResourceBundle;

public class consultationDossiersController implements Initializable {
    @FXML
    private ListView<String> listeDossiers;
    @FXML
    private Button button;

    @FXML
    void Retour(ActionEvent event) throws IOException {
        Stage stage = (Stage) listeDossiers.getScene().getWindow(); // Get the current stage
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PageAccueil.fxml")); // Load the FXML file for QuestionTestAnamnese
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

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
}
