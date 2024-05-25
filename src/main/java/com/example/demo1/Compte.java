package com.example.demo1;

public class Compte {
    private String nom;
    private String prenom;
    private String adresse;
    private int numero;
    private String email;
    private String motdepasse;
    private Dossier[] dossiersPatients;
    private Dossier[] dossiersParticuliers;

    public Compte(String nom, String prenom, String adresse, int numero, String email, String motdepasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse=adresse;
        this.numero=numero;
        this.email=email;
        this.motdepasse=motdepasse;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getAdresse() {
        return adresse;
    }
    public int getNumero() {
        return numero;
    }
    public String getEmail() {
        return email;
    }
    public String getMdp() {
        return motdepasse;
    }
}
