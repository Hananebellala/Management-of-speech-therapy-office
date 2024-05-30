package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
    private Button retourButton;
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
            Session.setCompte(compteOrtho);
            chargerNouvelleScene();
        } catch (NumberFormatException e) {
            // Gérer l'erreur (par exemple, afficher un message d'erreur)
            e.printStackTrace();
        }
    }

    private void creerFichierCompte(Compte compte) {
        nomFichier = "orthophoniste.ser";
        try (FileOutputStream fileOut = new FileOutputStream(nomFichier);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(compte);
            System.out.println("Serialized data is saved in " + nomFichier);
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
    public void retourPremierePage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FirstPage.fxml")); // Remplacez par le nom de votre fichier FXML
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
