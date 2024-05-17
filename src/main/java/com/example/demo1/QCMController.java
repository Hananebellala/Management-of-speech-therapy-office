package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class QCMController implements Initializable {

    @FXML
    private Label questionLabel;

    @FXML
    private CheckBox[] answerCheckBoxes;

    private String consigne;
    private String[] propositions;
    private int[] answers;

    public QCMController(String consigne, String[] propositions, int[] answers) {
        this.consigne = consigne;
        this.propositions = propositions;
        this.answers = answers;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        questionLabel.setText(consigne);

        for (int i = 0; i < answerCheckBoxes.length; i++) {
            answerCheckBoxes[i].setText(propositions[i]);
            answerCheckBoxes[i].setSelected(answers[i] == 1);
        }
    }
}
