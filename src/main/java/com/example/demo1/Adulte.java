package com.example.demo1;

import java.io.Serializable;
import java.time.LocalDate;

public class Adulte extends Patient implements Serializable {
    private static final long serialVersionUID = 6264016623953139405L;
    private String diplome;
    private String profession;
    private String numero;
    public Adulte() {

    }
    public Adulte(String nom, String prenom, String lieuNaiss, LocalDate dateNaiss, String diplome, String prof, String num) {
        super(nom,prenom,lieuNaiss,dateNaiss);
        this.diplome=diplome;
        profession=prof;
        numero=num;
    }
}