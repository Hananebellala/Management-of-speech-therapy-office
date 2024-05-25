package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class creationCompteController {

    @FXML
    private TextField champsNom;
    @FXML
    private TextField champsPrenom;
    @FXML
    private TextField champsAdresse;
    @FXML
    private TextField champsNumero;
    @FXML
    private TextField champsEmail;
    @FXML
    private PasswordField champsMotPasse;

    private Compte compteOrtho;
    private String nomFichier;

    @FXML
    private void creerCompte() {
        try {
            String nom = champsNom.getText();
            String prenom = champsPrenom.getText();
            String adresse = champsAdresse.getText();
            int numero = Integer.parseInt(champsNumero.getText());
            String email = champsEmail.getText();
            String mdp = champsMotPasse.getText();
            compteOrtho = new Compte(nom, prenom, adresse, numero, email, mdp);
            creerFichierCompte(compteOrtho);
            chargerNouvelleScene();
        } catch (NumberFormatException e) {
            // Gérer l'erreur (par exemple, afficher un message d'erreur)
            e.printStackTrace();
        }
    }

    private void creerFichierCompte(Compte compte) {
        nomFichier = "orthophoniste.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier))) {
            writer.write("Nom: " + compte.getNom() + "\n");
            writer.write("Prénom: " + compte.getPrenom() + "\n");
            writer.write("Adresse: " + compte.getAdresse() + "\n");
            writer.write("Numéro: " + compte.getNumero() + "\n");
            writer.write("Email: " + compte.getEmail() + "\n");
            writer.write("Mot de passe: " + compte.getMdp() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer l'erreur (par exemple, afficher un message à l'utilisateur)
        }
    }

    private void chargerNouvelleScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PageAccueil.fxml")); // Remplacez par le nom de votre fichier FXML
            Parent root = loader.load();

            // Obtenez le contrôleur de la nouvelle scène et passez le nom de fichier

            Stage stage = (Stage) champsNom.getScene().getWindow(); // Obtenir la fenêtre actuelle
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer l'erreur (par exemple, afficher un message à l'utilisateur)
        }
    }
}

