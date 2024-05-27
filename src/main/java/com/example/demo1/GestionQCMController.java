package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionQCMController {

    @FXML
    private Button Ajouter;

    @FXML
    private TextField Proposition;

    @FXML
    private TextField Question;

    @FXML
    private TextField Reponses;

    @FXML
    private Button Suprimer;

    @FXML
    private Label ans1;

    @FXML
    private Label ans2;

    @FXML
    private Label ans3;

    @FXML
    private Label ans4;

    @FXML
    private Label ans5;

    @FXML
    private Label ans6;

    @FXML
    private Label prop1;

    @FXML
    private Label prop2;

    @FXML
    private Label prop3;

    @FXML
    private Label prop4;

    @FXML
    private Label prop5;

    @FXML
    private Label prop6;

    @FXML
    private Label qst1;

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

    private Label[] qstLabels;
    private Label[] propLabels;
    private Label[] ansLabels;

    private final String FILE_PATH = "C:/Users/Administrator/IdeaProjects/demo1/src/main/resources/QCU.txt";

    @FXML
    public void initialize() {
        qstLabels = new Label[]{qst1, qst2, qst3, qst4, qst5, qst6};
        propLabels = new Label[]{prop1, prop2, prop3, prop4, prop5, prop6};
        ansLabels = new Label[]{ans1, ans2, ans3, ans4, ans5, ans6};

        loadQCMs();
    }

    @FXML
    void Ajouter(ActionEvent event) {
        String question = Question.getText().trim();
        String proposition = Proposition.getText().trim();
        String reponse = Reponses.getText().trim();

        if (!question.isEmpty() && !proposition.isEmpty() && !reponse.isEmpty()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                writer.write(question + "," + proposition + "," + reponse);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            updateLabels();
            Question.clear();
            Proposition.clear();
            Reponses.clear();
            showAlert("Success", "QCM added successfully!");
        } else {
            showAlert("Error", "All fields must be filled!");
        }
    }

    @FXML
    void Suprimer(ActionEvent event) {
        int indexToRemove = -1;
        for (int i = 0; i < qstLabels.length; i++) {
            if (!qstLabels[i].getText().isEmpty()) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            removeQCMFromFile(indexToRemove);
            updateLabels();
            showAlert("Success", "QCM deleted successfully!");
        } else {
            showAlert("Error", "No QCM selected for deletion!");
        }
    }

    private void loadQCMs() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < qstLabels.length) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    qstLabels[index].setText(parts[0]);
                    propLabels[index].setText(parts[1]);
                    ansLabels[index].setText(parts[2]);
                }
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeQCMFromFile(int index) {
        List<String> qcms = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int currentIndex = 0;
            while ((line = reader.readLine()) != null) {
                if (currentIndex != index) {
                    qcms.add(line);
                }
                currentIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String qcm : qcms) {
                writer.write(qcm);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateLabels() {
        for (Label label : qstLabels) {
            label.setText("");
        }
        for (Label label : propLabels) {
            label.setText("");
        }
        for (Label label : ansLabels) {
            label.setText("");
        }
        loadQCMs();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
