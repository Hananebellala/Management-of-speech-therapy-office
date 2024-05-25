package com.example.demo1;

public class Diagnostic{
    private String nom;
    private DiagnoCategorie categorie;

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