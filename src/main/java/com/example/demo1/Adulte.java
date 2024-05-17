package com.example.demo1;

public class Adulte extends Patient {
    private String diplome;
    private String profession;
    private int numero;
    public Adulte(String nom, String prenom, String lieuNaiss, Date dateNaiss, String diplome, String prof, int num) {
        super(nom,prenom,lieuNaiss,dateNaiss);
        this.diplome=diplome;
        profession=prof;
        numero=num;
    }
}