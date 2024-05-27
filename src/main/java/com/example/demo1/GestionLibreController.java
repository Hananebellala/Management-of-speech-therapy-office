package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionLibreController {

    @FXML
    private Button Ajouter;

    @FXML
    private TextField Enonce;

    @FXML
    private Button Suprimer;

    @FXML
    private Label qst1;

    @FXML
    private Label qst10;

    @FXML
    private Label qst2;

    @FXML
    private Label qst3;

    @FXML
    private Label qst4;

    @FXML
    private Label qst5;

    @FXML
    private Label qst6;

    @FXML
    private Label qst7;

    @FXML
    private Label qst8;

    @FXML
    private Label qst9;

    @FXML
    private RadioButton radio1;

    @FXML
    private RadioButton radio10;

    @FXML
    private RadioButton radio2;

    @FXML
    private RadioButton radio3;

    @FXML
    private RadioButton radio4;

    @FXML
    private RadioButton radio5;

    @FXML
    private RadioButton radio6;

    @FXML
    private RadioButton radio7;

    @FXML
    private RadioButton radio8;

    @FXML
    private RadioButton radio9;

    private Label[] labels;
    private RadioButton[] radioButtons;

    private final String FILE_PATH = "C:/Users/Administrator/IdeaProjects/demo1/src/main/resources/Libre.txt";

    @FXML
    void Ajouter(ActionEvent event) {
        handleAddQuestion();
    }

    @FXML
    void suprimer(ActionEvent event) {
        handleDeleteQuestion();
    }

    @FXML
    public void initialize() {
        labels = new Label[]{qst1, qst2, qst3, qst4, qst5, qst6, qst7, qst8, qst9, qst10};
        radioButtons = new RadioButton[]{radio1, radio2, radio3, radio4, radio5, radio6, radio7, radio8, radio9, radio10};

        loadQuestions();
    }

    private void loadQuestions() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < labels.length) {
                labels[index].setText(line);
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddQuestion() {
        String question = Enonce.getText().trim();
        if (!question.isEmpty()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                writer.write(question);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            updateLabels();
            Enonce.clear();
            showAlert("Success", "Question added successfully!");
        } else {
            showAlert("Error", "Question cannot be empty!");
        }
    }

    @FXML
    private void handleDeleteQuestion() {
        int indexToRemove = -1;
        for (int i = 0; i < radioButtons.length; i++) {
            if (radioButtons[i].isSelected()) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            removeQuestionFromFile(indexToRemove);
            updateLabels();
        } else {
            showAlert("Error", "No question selected for deletion!");
        }
    }

    private void removeQuestionFromFile(int index) {
        List<String> questions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int currentIndex = 0;
            while ((line = reader.readLine()) != null) {
                if (currentIndex != index) {
                    questions.add(line);
                }
                currentIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String question : questions) {
                writer.write(question);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateLabels() {
        for (Label label : labels) {
            label.setText("");
        }
        loadQuestions();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
