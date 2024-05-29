package com.example.demo1;

import java.time.LocalDate;

public class Adulte extends Patient {
    private String diplome;
    private String profession;
    private String numero;
    public Adulte(String nom, String prenom, String lieuNaiss, LocalDate dateNaiss, String diplome, String prof, String num) {
        super(nom,prenom,lieuNaiss,dateNaiss);
        this.diplome=diplome;
        profession=prof;
        numero=num;
    }
}