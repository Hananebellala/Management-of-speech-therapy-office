package com.example.demo1;

import java.io.Serializable;

public class Dossier implements Serializable {
    private Patient pat;
    private static int nbDossiers;
    private String numDossier;
    public Dossier(Patient pat,String numDossier) {
        this.pat=pat;
        this.numDossier=numDossier;
    }
    public Dossier() {

    }
    public Patient getPatient() {
        return pat;
    }
    public String getNumDossier() {
        return numDossier;
    }
    public int getNbDossiers() { return nbDossiers ;}
}
