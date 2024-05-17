package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;


import javafx.fxml.Initializable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class QCM extends Question implements Initializable {

    private String [] proposition;
    private int [] answer;

    @FXML
    private Label questionLabel;

    @FXML
    private CheckBox[] answerCheckBoxes;

    public QCM(String Enonce, boolean Effectue, int score, String [] proposition, int [] answer) {
        super(Enonce, Effectue,score);
        this.proposition=proposition;
        this.answer=answer;
        this.Enonce = String.valueOf(new SimpleStringProperty(Enonce));
    }

    public String[] getProposition() {
        return proposition;
    }

    public int[] getAnswer() {
        return this.answer;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        questionLabel.setText(this.Enonce);

        for (int i = 0; i < answerCheckBoxes.length; i++) {
            if (i < proposition.length) {
                answerCheckBoxes[i].setText(proposition[i]);
                answerCheckBoxes[i].setVisible(true);
            } else {
                answerCheckBoxes[i].setVisible(false);
            }
        }
    }

}
