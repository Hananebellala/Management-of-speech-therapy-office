package com.example.demo1;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PageAccueilController implements Initializable {
    public Label nom;
    private final String nomFichier="Orthophoniste.txt";
    private String lireChampDepuisFichier(String champ) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomFichier))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(champ)) {
                    return line.split(":")[1].trim();
                }
            }
        }
        return "";
    }
    private void setLabel () throws IOException {
        if (nomFichier != null) {
            String nom = lireChampDepuisFichier("Nom");
            String prenom = lireChampDepuisFichier("Prénom");
            this.nom.setText(nom + " " + prenom);
        }
    }
    public void initialize(URL url,  ResourceBundle rb){
        System.out.println("Initialisation");
        System.out.println("Nom du fichier : "+nomFichier);
        try {
            setLabel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadSceneCalendar() throws IOException {
        Stage stage = (Stage) nom.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Calendar.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
