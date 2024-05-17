package com.example.demo1;

public class Patient {
    String nom, prenom, lieuNaiss;
    Date dateNaiss;
    boolean particulier;
    boolean premiere;
    Patient(String nom, String prenom, String lieuNaiss, Date dateNaiss) {
        this.nom=nom;
        this.prenom=prenom;
        this.lieuNaiss=lieuNaiss;
        this.dateNaiss=dateNaiss;
        this.premiere=true;
        this.particulier=false;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public boolean getPremiere() {
        return premiere;
    }
    public void setPremiere() {
        this.premiere=false;
    }
    public boolean getParticulier() {
        return particulier;
    }
    public void setParticulier() {
        this.particulier=true;
    }
}