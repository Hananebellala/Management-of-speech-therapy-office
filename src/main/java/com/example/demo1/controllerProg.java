package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
public class controllerProg implements Initializable{
    @FXML
    private ComboBox comb;
    @FXML
    private Label label;
    void Select (ActionEvent event) {
        String s =comb.getSelectionModel().getSelectedItem().toString();
        label.setText(s);
    }
    public void initialize (URL url, ResourceBundle rb ) {
        ObservableList list = FXCollections.observableArrayList("Consultation","Seance de suivi","Atelier");
        comb.setItems(list);
    }


}