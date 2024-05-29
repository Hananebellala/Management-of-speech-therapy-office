package com.example.demo1;

import java.time.LocalDate;

public class Enfant extends Patient {
    private String classe;
    private String numPere;
    private String numMere;
    public Enfant(String classe, String numP, String numM,String nom, String prenom,  String lieuNaiss, LocalDate dateNaiss) {
        super(nom,prenom,lieuNaiss,dateNaiss);
        this.classe=classe;
        numPere=numP;
        numMere=numM;
    }

}