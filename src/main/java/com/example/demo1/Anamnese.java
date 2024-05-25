package com.example.demo1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Anamnese {

    private static QuestionAnamnese[] question;

    public Anamnese(QuestionAnamnese[] question) {
        this.question = question;
    }

    public static QuestionAnamnese[] getQuestion() {
        question = new QuestionAnamnese[Categorie.values().length]; // Initialize the question array

        List<List<String>> categories = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Administrator/IdeaProjects/demo1/src/main/resources/Anamnese.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                List<String> questions = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    questions.add(parts[i].trim());
                }
                categories.add(questions);
            }

            Random random = new Random();
            for (int i = 0; i < categories.size(); i++) {
                List<String> questions = categories.get(i);
                if (!questions.isEmpty()) {
                    int randomIndex = random.nextInt(questions.size());
                    String selectedQuestion = questions.get(randomIndex);
                    // Get the corresponding category
                    Categorie categorie = Categorie.values()[i];
                    // Assuming QuestionAnamnese has a constructor that takes a String question and a Categorie
                    question[i] = new QuestionAnamnese(selectedQuestion, categorie, "");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return question;
    }

    public void displayQuestionsWithAnswers() {
        if (question != null) {
            for (QuestionAnamnese q : question) {
                System.out.println("Question: " + q.getEnonce());
                System.out.println("Answer: " + q.getReponse());
                System.out.println();
            }
        }
    }
}
