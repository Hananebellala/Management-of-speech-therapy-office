package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class EvolutionController implements Initializable {

    @FXML
    private BarChart<String, Number> stat;

    @FXML
    private CategoryAxis xaxis;

    @FXML
    private NumberAxis yaxis;
    @FXML
    private Button button;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Configurer les axes du graphique
        xaxis.setLabel("Trouble");
        yaxis.setLabel("Nombre de patients");

        // Charger les données dans le graphique
        chargerDonnees();
    }

    private void chargerDonnees() {
        // Supposons que vous ayez une méthode pour obtenir la liste des patients
        Compte ortho = Session.getCompte();
        List<Dossier> dossiers = ortho.getDossiersPatients();

        // Compter le nombre de patients par trouble
        Map<String, Integer> countByTrouble = new HashMap<>();
        for (Dossier dos : dossiers) {
            Patient patient = dos.getPatient();
            for (BO bo : patient.getListBO()) {
                Diagnostic diagnostic = bo.getDiagnostic();
                DiagnoCategorie categorie = diagnostic.getCategorie();
                String categorieNom = categorie.toString(); // Méthode pour obtenir le nom de la catégorie
                countByTrouble.put(categorieNom, countByTrouble.getOrDefault(categorieNom, 0) + 1);
            }
        }

        // Créer une série de données pour le BarChart
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Nombre de patients par trouble");

        // Ajouter les données au BarChart
        for (Map.Entry<String, Integer> entry : countByTrouble.entrySet()) {
            series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
        }

        // Ajouter la série de données au BarChart
        stat.getData().add(series);
    }
    public void retourButton() throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PageAccueil.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
