package com.example.demo1;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class Consultation extends RendezVous implements Serializable {
    private String nom;
    private String prenom;
    private int age ;
    private Patient patient;
    private static final long serialVersionUID = 6264016623953139405L;
    public Consultation() {

    }
    public Consultation(String nom, String prenom, int age) {
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
        this.type=TypeRdv.CONSULTATION;
        patient = new Patient();
    }
    public void programmer(LocalDate dat, LocalTime heure, int duree) {
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
    public Patient getPatient() { return patient; }
}