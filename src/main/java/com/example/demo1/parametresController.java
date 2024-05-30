package com.example.demo1;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class parametresController implements Initializable {
    @FXML
    private Label labelNom;
    @FXML
    private Label labelPrenom;
    @FXML
    private Label labelAdresse;
    @FXML
    private Label labelNumero;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField mdpActuel;
    @FXML
    private PasswordField mdpNouveau;
    public void initialize(URL url, ResourceBundle rb) {
        Compte compte = Session.getCompte();
        String nom = compte.getNom();
        String prenom = compte.getPrenom();
        String adresse = compte.getAdresse();
        int numero = compte.getNumero();
        labelNom.setText(nom);
        labelPrenom.setText(prenom);
        labelAdresse.setText(adresse);
        labelNumero.setText(Integer.toString(numero));
        emailField.setText(compte.getEmail());
    }
    public void sauvegardeChangements() throws IOException {
        String newEmail = emailField.getText();
        String ancienMdp = mdpActuel.getText();

        Compte compte = Session.getCompte();

        compte.setEmail(newEmail);
        if(!ancienMdp.isEmpty()){
            String mdp = compte.getMdp();
            if(Objects.equals(mdp, ancienMdp)) {

                String nvMdp = mdpNouveau.getText();
                compte.setMdp(nvMdp);
            }
        }
        Session.setCompte(compte);
        Stage stage = (Stage) labelNom.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PageAccueil.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void retourButton() throws IOException {
        Stage stage = (Stage) labelNom.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PageAccueil.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
