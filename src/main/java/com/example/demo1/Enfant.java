package com.example.demo1;

public class Enfant extends Patient {
    private String classe;
    private int numPere;
    private int numMere;
    public Enfant(String classe, int numP, int numM,String nom, String prenom,  String lieuNaiss, Date dateNaiss) {
        super(nom,prenom,lieuNaiss,dateNaiss);
        this.classe=classe;
        numPere=numP;
        numMere=numM;
    }

}