package com.example.demo1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PageAccueilController implements Initializable {
    public Label nom;
    @FXML
    private Button rdvButton;
    @FXML
    void Stat(ActionEvent event) throws IOException {
        Stage stage = (Stage) nom.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Statistique.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Test(ActionEvent event) throws IOException {
        Stage stage = (Stage) nom.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("QestionTestAnamnese.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private Button quitterButton;
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
        Compte compte = Session.getCompte();  // Récupérer le compte depuis la classe Session
        if (compte != null) {
            nom.setText(compte.getNom() + " " + compte.getPrenom());
        }
    }
    public void loadSceneCalendar() throws IOException {
        Stage stage = (Stage) nom.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Calendrier.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void loadSceneDossiers() throws IOException {
        Stage stage = (Stage) nom.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ConsultationDossiers.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void sauvegardeDonnees() {
        Compte compte = Session.getCompte();
        String nomFichier = "orthophoniste.ser";
        try (FileOutputStream fileOut = new FileOutputStream(nomFichier);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(compte);
            System.out.println("Serialized data is saved in " + nomFichier);
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer l'erreur (par exemple, afficher un message à l'utilisateur)
        }
        Platform.exit();
    }

    public void loadParametres() throws IOException {
        Stage stage = (Stage) nom.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Parametres.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
