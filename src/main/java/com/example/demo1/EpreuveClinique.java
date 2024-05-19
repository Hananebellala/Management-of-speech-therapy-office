package com.example.demo1;

import java.util.*;

public class EpreuveClinique {
    protected Test[] Testepreuve;
    protected String Observation;
    protected int ScoreTotal;
    static protected int max = 10;
    static protected int i = 0;
    private Questionnaire currentQuestionnaire;

    public EpreuveClinique(Test[] Testepreuve, String Observation, int ScoreTotal) {
        this.Testepreuve = Testepreuve;
        this.Observation = Observation;
        this.ScoreTotal = ScoreTotal;
        this.currentQuestionnaire = null; // Initialize to null
    }

    public void RedigerObservation(String text) {
        this.Observation = text;
    }

    public void addExercise(Exercice exercice) {
        if (i >= max) {
            System.out.println("You have reached the maximum number of tests allowed.");
            return;
        }
        Testepreuve[i] = exercice;
        i++;
    }

    public void addQuestionnaire(Questionnaire questionnaire) {
        if (i >= max) {
            System.out.println("You have reached the maximum number of tests allowed.");
            return;
        }
        Testepreuve[i] = questionnaire;
        i++;
    }

    public void addQuestionToCurrentQuestionnaire(Question question) {
        if (currentQuestionnaire == null) {
            Question[] questions = new Question[4]; // Assuming 4 questions per questionnaire
            currentQuestionnaire = new Questionnaire("Quiz", 0, "", questions);
            addQuestionnaire(currentQuestionnaire); // Add the new questionnaire to the test list
        }
        currentQuestionnaire.AddQst(question);
    }

    public void score() {
        for (Test test : Testepreuve) {
            if (test instanceof Exercice) {
                // Add score of the exercise
            } else if (test instanceof Questionnaire) {
                Questionnaire questionnaire = (Questionnaire) test;
                this.ScoreTotal += questionnaire.CalculerScore(); // Add score of the questionnaire
            }
        }
    }

    public int GetScore() {
        return this.ScoreTotal;
    }
}
