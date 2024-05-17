package com.example.demo1;

public class Questionnaire extends Test {

    private Question[] Qst;

    public Questionnaire(String nom, int Score, String CompteRdu, Question [] qst) {
        super(nom, Score, CompteRdu);
        this.Qst=qst;
        //TODO Auto-generated constructor stub
    }

    @Override
    public int CalculerScore() {
        // TODO Auto-generated method stub
        int totalScore = 0;
        for (Question question : Qst) {
            totalScore += question.getScore();
        }

        //fih 4 so rah ykon sur 4
        return totalScore;
    }



}
