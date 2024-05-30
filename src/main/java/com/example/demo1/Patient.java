package com.example.demo1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Patient implements Serializable {
    private String nom;
    private String prenom;
    private String lieuNaiss;
    private LocalDate dateNaiss;
    private boolean particulier;
    private boolean premiere;
    protected BO[] bo;
    protected static int i;
    private static final long serialVersionUID = 6264016623953139405L;
    public Patient() {

    }
    public Patient(String nom, String prenom, String lieuNaiss, LocalDate dateNaiss) {
        this.nom = nom;
        this.prenom = prenom;
        this.lieuNaiss = lieuNaiss;
        this.dateNaiss = dateNaiss;
        this.premiere = true;
        this.particulier = false;
        this.i = 0;
        this.bo = new BO[10]; // Initialize the bo array with a size of 10, or any other appropriate size
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

    public void setAdress(String adr) {
        this.lieuNaiss=adr;
    }

    public BO getBO(int i) {
        return this.bo[i];
    }

    public LocalDate getDateNaiss() {
        return dateNaiss;
    }

    public String getLieu() {
        return this.lieuNaiss;
    }

    public BO[] getListBO() {
        return this.bo;

    }
}
