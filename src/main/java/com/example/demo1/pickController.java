package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
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
    private CheckBox qcm;

    @FXML
    private CheckBox qcu;

    @FXML
    private CheckBox qstLibre;

    @FXML
    void GoQcm(ActionEvent event) {

    }

    @FXML
    void Goqcu(ActionEvent event) {

    }

    @FXML
    void qstLibre(ActionEvent event) {

    }



    private EpreuveClinique epreuveClinique = new EpreuveClinique(new Test[EpreuveClinique.max], "", 0);

    @FXML
    public void showPage(ActionEvent event) {
        try {
            FXMLLoader loader;
            Parent page;
            if (Exercice.isSelected()) {
                loader = new FXMLLoader(getClass().getResource("Exercice.fxml"));
                page = loader.load();

                // Get the controller associated with Exercice.fxml
                ExerciceController exerciceController = loader.getController();

                // Initialize the controller with the epreuveClinique instance
                exerciceController.initData(epreuveClinique);

            } else if (Quiz.isSelected()) {

                if(qcm.isSelected()){
                    loader = new FXMLLoader(getClass().getResource("QCM.fxml"));
                    page = loader.load();
                    mainLayout.getChildren().setAll(page);
                }else if(qcu.isSelected()){
                    loader = new FXMLLoader(getClass().getResource("QCU.fxml"));
                    page = loader.load();
                    mainLayout.getChildren().setAll(page);
                }else if(qstLibre.isSelected()){
                    loader = new FXMLLoader(getClass().getResource("Libre.fxml"));
                    page = loader.load();
                    mainLayout.getChildren().setAll(page);


                }


                // Assuming QuizController has a similar initData method
                //QuizController quizController = loader.getController();
                //quizController.initData(epreuveClinique);
            } else {
                // Neither Exercice nor Quiz is selected, do nothing
                return;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void initData(pageEpreuve pageEpreuve) {
        // Implementation for pageEpreuve if necessary
    }
}
