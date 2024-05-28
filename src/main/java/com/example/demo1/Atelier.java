package com.example.demo1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class Atelier extends RendezVous {
    private String thematique;
    private int[] listeDossiers;
    public Atelier(String thematique, int[] dossiers) {
        this.thematique=thematique;
        listeDossiers=dossiers;
    }
    public void programmer(LocalDate dat, LocalTime heure, int duree) {
        this.dat=dat;
        this.time=heure;
        this.duree=duree;
        this.type=TypeRdv.ATELIER;
    }
    public String getThematique() {
        return thematique;
    }
    public int[] getDossiers() {
        return listeDossiers;
    }
}