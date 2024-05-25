package com.example.demo1;

public class Dossier {
    private Patient pat;
    private int num;
    public Dossier(Patient pat, int num) {
        this.pat=pat;
        this.num=num;
    }
    public Patient getPatient() {
        return pat;
    }
    public int getNumDossier() {
        return num;
    }
}
