package com.example.demo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String nom;
    private String prenom;
    private String lieuNaiss;
    private LocalDate dateNaiss;
    private boolean particulier;
    private boolean premiere;
    protected BO[] bo;
    protected static int i;
    protected List<Fiche> fiches;

    public Patient(String nom, String prenom, String lieuNaiss, LocalDate dateNaiss) {
        this.nom = nom;
        this.prenom = prenom;
        this.lieuNaiss = lieuNaiss;
        this.dateNaiss = dateNaiss;
        this.premiere = true;
        this.particulier = false;
        this.i = 0;
        this.bo = new BO[10]; // Initialize the bo array with a size of 10, or any other appropriate size
        this.fiches = new ArrayList<>(); // Initialize the fiches list
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
        this.premiere = false;
    }

    public boolean getParticulier() {
        return particulier;
    }

    public BO getBO(int i) {
        return bo[i];
    }

    public void setParticulier(boolean b) {
        this.particulier = true;
    }

    public void setBO(BO bo) {
        if (i < this.bo.length) {
            this.bo[i] = bo;
            i++;
        } else {
            System.out.println("Maximum BOs reached for this patient.");
        }
    }



    public void setAnamnese(Anamnese anamnese) {
        if (i > 0) {
            bo[i - 1].setAnamnese(anamnese);
        } else {
            System.out.println("No BOs available to set Anamnese.");
        }
    }

    public void addFiche(Fiche fiche) {
        this.fiches.add(fiche);
    }

    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setAdress(String adr) {
        this.lieuNaiss=adr;
    }



}
