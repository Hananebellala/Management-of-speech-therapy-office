package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class QCUController {

    @FXML
    private Button AjouterButton;

    @FXML
    private Button PrecedButton;

    @FXML
    private CheckBox fifth;

    @FXML
    private CheckBox first;

    @FXML
    private CheckBox fourth;

    @FXML
    private BorderPane mainLayout;

    @FXML
    private Label qst;

    @FXML
    private CheckBox second;

    @FXML
    private CheckBox sixth;

    @FXML
    private CheckBox third;

    @FXML
    void Ajouter(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        // Get a random QCU object
        QCU qcu = QCU.getRandomQCU();

        // Get the enonce and set it to the qst label
        String enonce = qcu.Enonce;
        qst.setText(enonce);

        // Get the propositions and set them to the CheckBoxes
        String[] propositions = qcu.getProposition();
        if (propositions.length > 0) first.setText(propositions[0]);
        if (propositions.length > 1) second.setText(propositions[1]);
        if (propositions.length > 2) third.setText(propositions[2]);
        if (propositions.length > 3) fourth.setText(propositions[3]);
    }

    @FXML
    void Precedent(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pick.fxml"));
            Parent page = loader.load();

            // Assuming EpreuveCliniqueController has a similar initData method
            pickController epreuveController = loader.getController();
            //epreuveController.initData(epreuveClinique);

            mainLayout.getChildren().setAll(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initData(EpreuveClinique epreuveClinique) {
    }
}
