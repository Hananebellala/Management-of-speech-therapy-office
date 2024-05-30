package com.example.demo1;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class Atelier extends RendezVous implements Serializable {
    private String thematique;
    private int[] listeDossiers;
    private static final long serialVersionUID = 6264016623953139405L;
    public Atelier() {

    }
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