package com.example.demo1;

import java.io.Serializable;
import java.time.LocalDate;

public class Enfant extends Patient implements Serializable {
    private static final long serialVersionUID = 6264016623953139405L;
    private String classe;
    private String numPere;
    private String numMere;
    public Enfant() {

    }
    public Enfant(String classe, String numP, String numM,String nom, String prenom,  String lieuNaiss, LocalDate dateNaiss) {
        super(nom,prenom,lieuNaiss,dateNaiss);
        this.classe=classe;
        numPere=numP;
        numMere=numM;
    }

}