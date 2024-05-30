package com.example.demo1;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public abstract class RendezVous implements Serializable {
    protected LocalDate dat;
    protected LocalTime time;
    protected TypeRdv type;
    protected int duree;
    private static final long serialVersionUID = 6264016623953139405L;
    public abstract void programmer(LocalDate dat,LocalTime time, int duree);
    public LocalDate getDate() {
        return dat;
    }
    public LocalTime getTime() {
        return time;
    }
    public TypeRdv getType() {
        return type;
    }
}