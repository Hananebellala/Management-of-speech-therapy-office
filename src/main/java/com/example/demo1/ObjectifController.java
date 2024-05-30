package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

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
        // Add your event handling code here
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

    public void saveFiche(Fiche fiche) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fiche" + index + ".ser"))) {
            oos.writeObject(fiche);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
