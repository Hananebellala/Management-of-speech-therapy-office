package com.example.demo1;

public class Date {
    private int jour;
    private int mois;
    private int annee;
    Date(int jour, int mois, int annee) {
        this.jour=jour;
        this.mois=mois;
        this.annee=annee;
    }
    public int getJour() {
        return jour;
    }
    public int getMois() {
        return mois;
    }
    public int getAnne() {
        return annee;
    }
    public String getDate() {
        String myDate = jour+"/"+mois+"/"+annee;
        return myDate;
    }
}