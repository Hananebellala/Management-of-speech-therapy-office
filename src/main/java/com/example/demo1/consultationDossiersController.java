package com.example.demo1;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class consultationDossiersController implements Initializable {
    @FXML
    private ListView listeDossiers;
    @FXML
    private Button button;
    @FXML
    private Button retour;
    public void initialize(URL url, ResourceBundle rb) {
        List<Dossier> listeDos = Session.getCompte().getDossiersPatients();
        System.out.println("Taille de la liste : "+ listeDos.size());

        for(Dossier dos : listeDos) {
            String numDossier = dos.getNumDossier();
            listeDossiers.getItems().add(numDossier);
        }
        button.disableProperty().bind(listeDossiers.getSelectionModel().selectedItemProperty().isNull());
    }
    public void retourButton() throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PageAccueil.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void consulterDossier () throws IOException {
        String selectedItem = listeDossiers.getSelectionModel().getSelectedItem().toString();
        if(selectedItem!=null) {
            Compte ortho = Session.getCompte();
            Patient patient = ortho.trouverDossier(selectedItem);
            try {
                FXMLLoader loader = new FXMLLoader((getClass().getResource("PatientPage.fxml")));
                Parent root = loader.load();
                PatientController controller = loader.getController();

                controller.setConsultationDossiersController(this);
                controller.setPatient(patient);
                Stage stage = new Stage();
                stage.setTitle("Consulter Patient");
                stage.setScene(new Scene(root));
                stage.showAndWait();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
