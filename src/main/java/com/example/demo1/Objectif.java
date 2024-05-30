package com.example.demo1;

import java.io.Serializable;

public class Objectif implements Serializable {

    private String nom;
    private TypeObjectif Type;
    private boolean Realized;
    private static final long serialVersionUID = 6264016623953139405L;

    public Objectif(String nom,TypeObjectif Type, boolean Realized){
        this.nom=nom;
        this.Type=Type;
        this.Realized=Realized;
    }

    public String getNom() {
        return nom;
    }

    public TypeObjectif getType() {
        return Type;
    }

    public boolean isRealized() {
        return Realized;
    }
}