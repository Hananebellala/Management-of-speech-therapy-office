package com.example.demo1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public abstract class RendezVous {
    protected LocalDate dat;
    protected LocalTime time;
    protected TypeRdv type;
    protected float duree;
    public abstract void programmer(LocalDate dat,LocalTime time, float duree);
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