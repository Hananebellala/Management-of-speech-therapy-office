package com.example.demo1;

import java.io.Serializable;

public class Diagnostic implements Serializable {
    private String nom;
    private DiagnoCategorie categorie;
    private static final long serialVersionUID = 6264016623953139405L;

    public Diagnostic(String nom, DiagnoCategorie categorie){
        this.nom=nom;
        this.categorie=categorie;
    }

    public void add(String diagnostic) {
        this.nom=diagnostic;
    }

    public String getNom() {
        return nom;
    }

    public DiagnoCategorie getCategorie() {
        return categorie;
    }
}