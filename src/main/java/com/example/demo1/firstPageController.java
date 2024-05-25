package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class firstPageController {
    @FXML
    private TextField champsEmail;
    @FXML
    private PasswordField champsMotPasse;

    private final String nomFichier="orthophoniste.txt";
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
    public void Authentification() throws IOException {
        String email = champsEmail.getText();
        String mdp = champsMotPasse.getText();
        String emailFile = lireChampDepuisFichier("Email");
        String mdpFile = lireChampDepuisFichier("Mot de passe");
        if(email.equals(emailFile) && mdp.equals(mdpFile)) {
            Stage stage = (Stage) champsEmail.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PageAccueil.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            // Afficher un message d'erreur
            System.out.println("Email ou mot de passe incorrect");
        }
        }
        public void creationCompte() throws IOException{
            Stage stage = (Stage) champsEmail.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreationCompte.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }


