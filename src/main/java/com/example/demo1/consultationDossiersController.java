package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class consultationDossiersController implements Initializable {
    @FXML
    private ListView listeDossiers;
    @FXML
    private Button button;
    public void initialize(URL url, ResourceBundle rb) {
        List<Dossier> listeDos = Session.getCompte().getDossiersPatients();
        System.out.println("Taille de la liste : "+ listeDos.size()

        );
        for(Dossier dos : listeDos) {
            String numDossier = dos.getNumDossier();
            listeDossiers.getItems().add(numDossier);
        }
        button.disableProperty().bind(listeDossiers.getSelectionModel().selectedItemProperty().isNull());
    }
}
