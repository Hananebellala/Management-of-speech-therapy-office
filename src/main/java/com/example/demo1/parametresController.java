package com.example.demo1;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
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
}
