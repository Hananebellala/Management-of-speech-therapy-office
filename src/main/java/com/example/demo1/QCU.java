package com.example.demo1;

public class QCU extends Question {
    private String [] proposition;
    private int answer;

    public QCU(String Enonce, boolean Effectue,int score, String [] proposition, int answer) {
        super(Enonce, Effectue,score);
        this.proposition=proposition;
        this.answer=answer;
        //TODO Auto-generated constructor stub
    }

}
