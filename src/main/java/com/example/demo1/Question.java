package com.example.demo1;

public class Question {

    protected String Enonce;
    protected boolean Effectue;
    protected int score;

    public Question(String Enonce, boolean Effectue, int score){
        this.Enonce=Enonce;
        this.Effectue=Effectue;
        this.score=score;
    }

    public String getConsigne() {
        // TODO Auto-generated method stub
        return this.Enonce;
    }

    public int getScore(){
        return this.score;
    }

    public String getEnonce() {
        return Enonce;
    }
}
