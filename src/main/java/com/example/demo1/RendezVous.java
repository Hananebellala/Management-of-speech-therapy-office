package com.example.demo1;

public abstract class RendezVous {
    protected Date dat;
    protected float heure;
    protected TypeRdv type;
    protected float duree;
    public abstract void programmer(Date dat, float heure, float duree);
}