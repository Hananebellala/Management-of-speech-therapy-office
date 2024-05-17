package com.example.demo1;

public class Consultation extends RendezVous {
    private String nom;
    private String prenom;
    private int age ;
    public Consultation(String nom, String prenom, int age) {
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
    }
    public void programmer(Date dat, float heure, float duree) {
        this.dat=dat;
        this.heure=heure;
        this.type=TypeRdv.CONSULTATION;
        this.duree=duree;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public int getAge() {
        return age;
    }
}