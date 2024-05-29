package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;


import javafx.fxml.Initializable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

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
        this.Enonce = Enonce;
    }

    public void SetScore(int score){
        this.score=score;
    }

    public String[] getProposition() {
        return proposition;
    }

    public int[] getAnswer() {
        return this.answer;
    }

    public int calculerScore(int[] reponse, int[] answer) {
        int score = 0;

        // Check if the arrays have the same length
        if (reponse.length != answer.length) {
            throw new IllegalArgumentException("Arrays must have the same length");
        }

        // Iterate through the arrays and compare corresponding elements
        for (int i = 0; i < reponse.length; i++) {
            if (reponse[i] == answer[i]) {
                score++;
                System.out.println("hereeeeee");
            }
        }

        return score;
    }

    public static QCM getRandomQCM() {
        String enonce = "";
        String[] propositions = new String[0];
        int[] answer = new int[0];
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/QCM.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            if (!lines.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(lines.size());
                String randomLine = lines.get(randomIndex);

                // Split the random line to get enonce, propositions, and answers
                String[] parts = randomLine.split(",");
                enonce = parts[0];
                propositions = parts[1].split(";");
                String[] answerStrings = parts[2].split(";");
                answer = new int[answerStrings.length];
                for (int i = 0; i < answerStrings.length; i++) {
                    answer[i] = Integer.parseInt(answerStrings[i].trim());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return new QCM(enonce, true, 0, propositions, answer);
    }

    public String getEnonce() {
        String enonce = "";
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/QCM.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            if (!lines.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(lines.size());
                String randomLine = lines.get(randomIndex);

                // Split the random line at the first comma and take the first part as the enonce
                enonce = randomLine.split(",")[0];
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return enonce;
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

    public int[] getCorrectAnswers() {

        return this.answer;
    }
}
