package com.example.demo1;

public class SeanceSuivi extends RendezVous {
    private int numDossier;
    private TypeSeance typeSnc;
    public SeanceSuivi(int num, TypeSeance type) {
        numDossier=num;
        this.typeSnc=type;
    }
    public void programmer(Date dat, float heure, float duree) {
        this.dat=dat;
        this.heure=heure;
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