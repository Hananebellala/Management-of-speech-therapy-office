package com.example.demo1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectifController {

    @FXML
    private CheckBox checked;

    @FXML
    private Label nom1;

    @FXML
    private Label nom2;

    @FXML
    private Label nom3;

    @FXML
    private Label nom4;

    @FXML
    private TextField score1;

    @FXML
    private TextField score2;

    @FXML
    private TextField score3;

    @FXML
    private TextField score4;

    @FXML
    private LineChart<?, ?> stat;

    @FXML
    private TabPane tab;

    @FXML
    private Tab tab1;

    @FXML
    private Tab tab2;

    @FXML
    private Tab tab3;

    @FXML
    private Tab tab4;

    @FXML
    private Label type1;

    @FXML
    private Label type2;

    @FXML
    private Label type3;

    @FXML
    private Label type4;

    @FXML
    private CategoryAxis xaxis;

    @FXML
    private NumberAxis yaxis;



    private int index;

    public void setIndex(int index) {
        this.index = index;
    }

    @FXML
    void Checked(ActionEvent event) {
        if (checked.isSelected()) {
            File file = new File("fiche" + index + ".ser");
            if (file.exists()) {
                file.delete();
                clearLabels();
            }
        }
    }

    public void setFiche(Fiche fiche) {
        Objectif[] objectifs = fiche.getObject();
        // Assume you have 4 objectifs at max
        if (objectifs.length > 0) {
            nom1.setText(objectifs[0].getNom());
            type1.setText(objectifs[0].getType().toString());
        }
        if (objectifs.length > 1) {
            nom2.setText(objectifs[1].getNom());
            type2.setText(objectifs[1].getType().toString());
        }
        if (objectifs.length > 2) {
            nom3.setText(objectifs[2].getNom());
            type3.setText(objectifs[2].getType().toString());
        }
        if (objectifs.length > 3) {
            nom4.setText(objectifs[3].getNom());
            type4.setText(objectifs[3].getType().toString());
        }
    }

    private void clearLabels() {
        nom1.setText("");
        type1.setText("");
        nom2.setText("");
        type2.setText("");
        nom3.setText("");
        type3.setText("");
        nom4.setText("");
        type4.setText("");
    }

    public void saveFiche(Fiche fiche) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fiche" + index + ".ser"))) {
            oos.writeObject(fiche);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        navigateToQuestionTestAnamnese();
    }

    private void navigateToQuestionTestAnamnese() throws IOException {

        Stage stage = (Stage) checked.getScene().getWindow(); // Get the current stage
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Fiches.fxml")); // Load the FXML file for QuestionTestAnamnese
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
