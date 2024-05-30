package com.example.demo1;

import java.io.Serializable;

public class Questionnaire extends Test implements Serializable {

    private Question[] Qst;
    private static int i;
    private static final long serialVersionUID = 6264016623953139405L;

    public Questionnaire(String nom, int Score, String CompteRdu, Question [] qst) {
        super(nom, Score, CompteRdu);
        this.Qst=qst;
        //TODO Auto-generated constructor stub
    }

    public void AddQst(Question qstion){
        if(i<=5){
            this.Qst[i]=qstion;
            i++;
        }else{
            System.out.println("Question number exceeded");
        }
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
