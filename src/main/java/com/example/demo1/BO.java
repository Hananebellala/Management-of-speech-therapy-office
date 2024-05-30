package com.example.demo1;

import java.util.HashMap;
import java.util.Map;

public class BO {
    protected Anamnese anamnese;
    protected EpreuveClinique epreuve;
    protected Diagnostic diagnostic;
    protected String projetTherapeutique;
    protected  static int id;



    public BO(Anamnese anam, EpreuveClinique epreuve, Diagnostic diag,String projetTherapeutique){
        this.anamnese=anam;
        this.epreuve=epreuve;
        this.diagnostic=diag;
        this.projetTherapeutique=projetTherapeutique;
        this.id=0;

    }

    private Map<Integer, Patient> patients;

    public BO() {
        this.patients = new HashMap<>();
    }

    public void addPatient(Patient patient) {
        patients.put(id, patient);
        id++;
    }

    public Patient getPatient(int id) {
        return patients.get(id);
    }

    public Anamnese getAnamnese() {
        return this.anamnese;
    }

    public void updateEpreuveClinique(EpreuveClinique epreuveClinique) {
        this.epreuve=epreuveClinique;
    }

    public void setAnamnese(Anamnese anamnese) {
        this.anamnese=anamnese;
    }

    public void addDiagnostic(Diagnostic diagnostic) {
        this.diagnostic=diagnostic;
        System.out.println("Diagnostic added: " + diagnostic.getNom() + ", " + diagnostic.getCategorie());
    }

    public void saveProjetTherapeutique(String demarche) {
        this.projetTherapeutique = demarche;
        System.out.println("Projet Therapeutique saved: " + demarche);
    }

    // Getter for projetTherapeutique if needed
    public String getProjetTherapeutique() {
        return projetTherapeutique;
    }
}
