package com.example.demo1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class SeanceSuivi extends RendezVous {
    private int numDossier;
    private TypeSeance typeSnc;
    public SeanceSuivi(int num, TypeSeance type) {
        numDossier=num;
        this.typeSnc=type;
    }
    public void programmer(LocalDate dat, LocalTime heure, int duree) {
        this.dat=dat;
        this.time=heure;
        this.type=TypeRdv.SEANCEDESUIVI;
        this.duree=duree;
    }
    public int getNumDossier() {
        return numDossier;
    }
    public String getTypeSnc() {
        return typeSnc.getLibelle();
    }
}