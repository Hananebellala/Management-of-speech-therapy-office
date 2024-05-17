package com.example.demo1;

public class Atelier extends RendezVous {
    private String thematique;
    private int[] listeDossiers;
    public Atelier(String thematique, int[] dossiers) {
        this.thematique=thematique;
        listeDossiers=dossiers;
    }
    public void programmer(Date dat, float heure, float duree) {
        this.dat=dat;
        this.heure=heure;
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