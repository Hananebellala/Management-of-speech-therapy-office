package com.example.demo1;

import java.io.Serializable;

public class Fiche implements Serializable {
    private Objectif[] Object;
    //private RendezVous Rdv;
    private String Note;
    private static final long serialVersionUID = 6264016623953139405L;


    public Fiche(Objectif[] Object, String Note){
        this.Object=Object;

        this.Note=Note;
    }

    public Objectif[] getObject() {
        return Object;
    }



    public String getNote() {
        return Note;
    }
}