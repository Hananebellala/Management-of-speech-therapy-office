package com.example.demo1;

public enum TypeRdv {
    CONSULTATION("Consultation"),
    SEANCEDESUIVI("Seance de suivi"),
    ATELIER("Atelier");
    private final String libelle;
    TypeRdv(String libelle){
        this.libelle=libelle;
    }
    public String getLibelle() {
        return libelle;
    }

}