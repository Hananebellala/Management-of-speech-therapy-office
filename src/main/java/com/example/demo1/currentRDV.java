package com.example.demo1;

public class currentRDV {
    private static Patient patient;
    private static RendezVous selectedRdv;

    public static void setPatient(Patient patient) {
        currentRDV.patient = patient;
    }

    public static Patient getPatient() {
        return patient;
    }

    public static void setSelectedRdv(RendezVous rdv) {
        currentRDV.selectedRdv = rdv;
    }

    public static RendezVous getSelectedRdv() {
        return selectedRdv;
    }
}
