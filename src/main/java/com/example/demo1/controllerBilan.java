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

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;
public class controllerBilan implements Initializable {
    public ComboBox categoriePatient;
    @FXML
    private AnchorPane enfantContainer;
    @FXML
    private AnchorPane adulteContainer;
    private BooleanProperty enfantActive = new SimpleBooleanProperty(false);
    private BooleanProperty adulteActive = new SimpleBooleanProperty(false);
    public void initialize(URL url, ResourceBundle rb ) {
        ObservableList list = FXCollections.observableArrayList("Enfant","Adulte");
        categoriePatient.setItems(list);
        enfantContainer.disableProperty().bind(enfantActive.not());
        adulteContainer.disableProperty().bind(adulteActive.not());
    }
    public void Select (ActionEvent event) {
        String s =categoriePatient.getSelectionModel().getSelectedItem().toString();
        switch (s) {
            case "Enfant":
                enfantActive.set(true);
                adulteActive.set(false);
                break;
            case "Adulte":
                enfantActive.set(false);
                adulteActive.set(true);
                break;
            default:
                enfantActive.set(false);
                adulteActive.set(false);
                break;
        }
    }
}
