package com.example.demo1;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class controllerProg implements Initializable{
    public ComboBox typeSeance;
    public ComboBox comb1;
    @FXML
    private ComboBox comb;
    @FXML
    private AnchorPane consultationContainer;
    @FXML
    private AnchorPane suiviContainer;
    @FXML
    private AnchorPane atelierContainer;
    private BooleanProperty consultationActive = new SimpleBooleanProperty(false);
    private BooleanProperty suiviActive = new SimpleBooleanProperty(false);
    private BooleanProperty atelierActive = new SimpleBooleanProperty(false);
    public void Select (ActionEvent event) {
        String s =comb.getSelectionModel().getSelectedItem().toString();
        switch (s) {
            case "Consultation":
                consultationActive.set(true);
                suiviActive.set(false);
                atelierActive.set(false);
                break;
            case "Suivi":
                consultationActive.set(false);
                suiviActive.set(true);
                atelierActive.set(false);
                break;
            case "Atelier":
                consultationActive.set(false);
                suiviActive.set(false);
                atelierActive.set(true);
                break;
            default:
                consultationActive.set(false);
                suiviActive.set(false);
                atelierActive.set(false);
                break;
        }
    }
    public void initialize (URL url, ResourceBundle rb ) {
        ObservableList list = FXCollections.observableArrayList("Consultation","Seance de suivi","Atelier");
        comb.setItems(list);
        consultationContainer.disableProperty().bind(consultationActive.not());
        suiviContainer.disableProperty().bind(suiviActive.not());
        atelierContainer.disableProperty().bind(atelierActive.not());

    }


}