package com.example.demo1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class Consultation extends RendezVous {
    private String nom;
    private String prenom;
    private int age ;
    public Consultation(String nom, String prenom, int age) {
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
        this.type=TypeRdv.CONSULTATION;
    }
    public void programmer(LocalDate dat, LocalTime heure, float duree) {
        this.dat=dat;
        this.time=heure;
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