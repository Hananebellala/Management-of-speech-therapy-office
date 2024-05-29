package com.example.demo1;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;

public class Date {
    private int jour;
    private int mois;
    private int annee;

    public Date(int jour, int mois, int annee) {
        this.jour=jour;
        this.mois=mois;
        this.annee=annee;
    }

    public int getJour() {
        return jour;
    }

    public int getmois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    public String getDate() {
        return jour+"/"+mois+"/"+annee;
    }
}