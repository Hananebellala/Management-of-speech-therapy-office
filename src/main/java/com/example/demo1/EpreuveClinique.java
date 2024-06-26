package com.example.demo1;

import java.io.Serializable;
import java.util.*;

public class EpreuveClinique implements Serializable {
    protected Test[] Testepreuve;
    protected String Observation;
    protected int ScoreTotal;
    static protected int max = 10;
    static protected int i = 0;
    private Questionnaire currentQuestionnaire;
    private static final long serialVersionUID = 6264016623953139405L;


    public EpreuveClinique(String Observation, int ScoreTotal) {
        this.Testepreuve = new Test[max]; // Initialize the array with a fixed size
        this.Observation = Observation;
        this.ScoreTotal = ScoreTotal;
        this.currentQuestionnaire = null; // Initialize to null
    }

    public void RedigerObservation(String text) {
        this.Observation = text;
    }

    public void SetTest(Test[] test){
        this.Testepreuve = test;
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

    }

    public int GetScore() {
        return this.ScoreTotal;
    }

    public void addLibre(Libre libre) {
    }
}
