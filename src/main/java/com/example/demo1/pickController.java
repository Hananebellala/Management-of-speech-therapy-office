package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class pickController {

    @FXML
    private Pane mainLayout;

    @FXML
    private RadioButton Exercice;

    @FXML
    private RadioButton Quiz;

    @FXML
    private Button SuivantButton;

    @FXML
    private Button TerminerButton;

    @FXML
    private CheckBox qcm;

    @FXML
    private CheckBox qcu;

    @FXML
    private CheckBox qstLibre;

    @FXML
    private TextArea conclusion;

    @FXML
    private RendezVous rdv;

    private EpreuveClinique epreuveClinique = new EpreuveClinique("", 0);
    private BO bo = new BO(); // Instantiate BO
    private int patientId = 1; // Example patientId, replace as needed

    @FXML
    public void initialize() {
        // Disable the checkboxes initially
        qcm.setDisable(true);
        qcu.setDisable(true);
        qstLibre.setDisable(true);

        // Add listeners to the radio buttons
        Exercice.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                qcm.setDisable(true);
                qcu.setDisable(true);
                qstLibre.setDisable(true);
            }
        });

        Quiz.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                qcm.setDisable(false);
                qcu.setDisable(false);
                qstLibre.setDisable(false);
            } else {
                qcm.setDisable(true);
                qcu.setDisable(true);
                qstLibre.setDisable(true);
            }
        });
    }

    public void showPage(ActionEvent event) {
        try {
            FXMLLoader loader;
            Parent page = null;
            if (Exercice.isSelected()) {
                loader = new FXMLLoader(getClass().getResource("Exercice.fxml"));
                page = loader.load();
                ExerciceController exerciceController = loader.getController();
                exerciceController.initData(epreuveClinique, bo, patientId);
            } else if (Quiz.isSelected()) {
                if (qcm.isSelected()) {
                    loader = new FXMLLoader(getClass().getResource("QCM.fxml"));
                    page = loader.load();
                    QCMController qcmController = loader.getController();
                    qcmController.initData(epreuveClinique, bo, patientId); // Pass all parameters
                } else if (qcu.isSelected()) {
                    loader = new FXMLLoader(getClass().getResource("QCU.fxml"));
                    page = loader.load();
                    QCUController qcuController = loader.getController();
                    qcuController.initData(epreuveClinique, bo, patientId); // Pass all parameters
                } else if (qstLibre.isSelected()) {
                    loader = new FXMLLoader(getClass().getResource("Libre.fxml"));
                    page = loader.load();
                    LibreController libreController = loader.getController();
                    libreController.initData(epreuveClinique, bo, patientId); // Pass all parameters
                }
            } else {
                return;
            }
            mainLayout.getChildren().setAll(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Terminer(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Diagnostic.fxml"));
            Parent diagnosticPage = loader.load();
            DiagnosticController diagnosticController = loader.getController();
            diagnosticController.initData(epreuveClinique, bo, patientId); // Pass necessary data

            mainLayout.getChildren().setAll(diagnosticPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void GoQcm(ActionEvent event) {
        // Handle GoQcm action
    }

    @FXML
    void Goqcu(ActionEvent event) {
        // Handle Goqcu action
    }

    @FXML
    void qstLibre(ActionEvent event) {
        // Handle qstLibre action
    }

    public void initData(EpreuveClinique epreuveClinique, BO bo, int patientId) {
        this.epreuveClinique = epreuveClinique;
        this.bo = bo;
        this.patientId = patientId;
    }

    public void setRendezVous(RendezVous selectedRdv) {
        this.rdv=selectedRdv;
    }
}
