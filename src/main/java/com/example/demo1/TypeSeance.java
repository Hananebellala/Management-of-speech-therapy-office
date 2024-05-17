package com.example.demo1;

public enum TypeSeance {
    PRESENTIEL("Presentiel"),
    ENLIGNE("En ligne");
    private final String libelle;
    TypeSeance(String libelle){
        this.libelle=libelle;
    }
    public String getLibelle() {
        return libelle;
    }
}