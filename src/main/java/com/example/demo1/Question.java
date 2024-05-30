package com.example.demo1;

import java.io.Serializable;

public class Question implements Serializable {

    protected String Enonce;
    protected boolean Effectue;
    protected int score;
    private static final long serialVersionUID = 6264016623953139405L;

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
