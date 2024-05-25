package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AnamneseController {

    @FXML
    private Label Question4;

    @FXML
    private Label Question5;

    @FXML
    private Label Question6;

    @FXML
    private Label Question7;

    @FXML
    private Label question2;

    @FXML
    private Button SuivantBoutton;

    @FXML
    private Label categorie1;

    @FXML
    private Label categorie2;

    @FXML
    private Label categorie3;

    @FXML
    private Label categorie4;

    @FXML
    private Label categorie5;

    @FXML
    private Label categorie6;

    @FXML
    private Label categorie7;

    @FXML
    private Label question1;

    @FXML
    private Label question3;

    @FXML
    private TextArea text1;

    @FXML
    private TextArea text2;

    @FXML
    private TextArea text3;

    @FXML
    private TextArea text4;

    @FXML
    private TextArea text5;

    @FXML
    private TextArea text6;

    @FXML
    private TextArea text7;
    @FXML
    private BorderPane mainLayout;

    private Patient patient;

    @FXML
    void Suivant(ActionEvent event) {
        // Validate that all text areas are filled
        boolean isValid = true;
        String errorMessage = "";

        if (text1.getText().isEmpty()) {
            isValid = false;
            errorMessage += "Réponse à la question 1 est requise.\n";
        }
        if (text2.getText().isEmpty()) {
            isValid = false;
            errorMessage += "Réponse à la question 2 est requise.\n";
        }
        if (text3.getText().isEmpty()) {
            isValid = false;
            errorMessage += "Réponse à la question 3 est requise.\n";
        }
        if (text4.getText().isEmpty()) {
            isValid = false;
            errorMessage += "Réponse à la question 4 est requise.\n";
        }
        if (text5.getText().isEmpty()) {
            isValid = false;
            errorMessage += "Réponse à la question 5 est requise.\n";
        }
        if (text6.getText().isEmpty()) {
            isValid = false;
            errorMessage += "Réponse à la question 6 est requise.\n";
        }
        if (text7.getText().isEmpty()) {
            isValid = false;
            errorMessage += "Réponse à la question 7 est requise.\n";
        }

        if (isValid) {
            // Collect responses
            QuestionAnamnese[] questions = Anamnese.getQuestion();
            if (questions.length > 0) questions[0].setReponse(text1.getText());
            if (questions.length > 1) questions[1].setReponse(text2.getText());
            if (questions.length > 2) questions[2].setReponse(text3.getText());
            if (questions.length > 3) questions[3].setReponse(text4.getText());
            if (questions.length > 4) questions[4].setReponse(text5.getText());
            if (questions.length > 5) questions[5].setReponse(text6.getText());
            if (questions.length > 6) questions[6].setReponse(text7.getText());

            // Create Anamnese object
            Anamnese anamnese = new Anamnese(questions);
            // Assuming you have already initialized your QuestionAnamnese array

            anamnese.displayQuestionsWithAnswers();


            // Save Anamnese to patient
            patient.setAnamnese(anamnese);


            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("pick.fxml"));
                Parent pickPage = loader.load();
                pickController pickController = loader.getController();
                // Pass any necessary data
                // pickController.initData(patient);

                mainLayout.getChildren().setAll(pickPage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Show error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Champs requis manquants");
            alert.setHeaderText(null);
            alert.setContentText(errorMessage);
            alert.showAndWait();
        }

    }

    public void initData(Patient patient) {
        this.patient = patient;
    }

    @FXML
    public void initialize() {
        // Get a random QCM object
        QCM qcm = QCM.getRandomQCM();

        // Get the enonce and set it to the qst label
        String enonce = qcm.Enonce;

        QuestionAnamnese[] question = Anamnese.getQuestion();

        System.out.println(enonce);
        // Get the propositions and set them to the CheckBoxes
        String[] propositions = qcm.getProposition();
        if (question.length > 0) question1.setText(question[0].Enonce);
        if (question.length > 1) question2.setText(question[1].Enonce);
        if (question.length > 2) question3.setText(question[2].Enonce);
        if (question.length > 3) Question4.setText(question[3].Enonce);
        if (question.length > 4) Question5.setText(question[4].Enonce);
        if (question.length > 5) Question6.setText(question[5].Enonce);
        if (question.length > 6) Question7.setText(question[6].Enonce);
    }
}
