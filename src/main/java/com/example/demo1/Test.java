package com.example.demo1;

abstract class Test {
    private String Nom;
    protected int Score;
    private String CompteRdu;


    public Test(String nom, int Score, String CompteRdu ){
        this.Nom=nom;
        this.Score=Score;
        this.CompteRdu=CompteRdu;
    }

    public abstract int CalculerScore();



}
