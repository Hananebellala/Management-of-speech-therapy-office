package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

public class firstPageController {

    @FXML
    private TextField champsEmail;
    @FXML
    private PasswordField champsMotPasse;
    @FXML
    private Label errorMessage;
    private final String nomFichier = "orthophoniste.ser";

    private Compte lireCompteDepuisFichier() throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(nomFichier);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (Compte) in.readObject();
        }
    }

    @FXML
    public void Authentification() {
        try {
            String email = champsEmail.getText();
            String mdp = champsMotPasse.getText();
            Compte compte = lireCompteDepuisFichier();

            if (compte != null && email.equals(compte.getEmail()) && mdp.equals(compte.getMdp())) {
                Session.setCompte(compte);
                Stage stage = (Stage) champsEmail.getScene().getWindow();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PageAccueil.fxml")));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else {
                errorMessage.setVisible(true);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // Gérer l'erreur (par exemple, afficher un message à l'utilisateur)
        }
    }

    @FXML
    public void creationCompte() throws IOException {
        Stage stage = (Stage) champsEmail.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreationCompte.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
