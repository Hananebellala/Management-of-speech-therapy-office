package com.example.demo1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Compte implements Serializable {
    private String nom;
    private String prenom;
    private String adresse;
    private int numero;
    private String email;
    private String motdepasse;
    private List<Dossier> dossiersPatients = new ArrayList<Dossier>();
    private List<Dossier> dossiersParticuliers;
    private List<RendezVous> rdvList = new ArrayList<RendezVous> ();

    public Compte(String nom, String prenom, String adresse, int numero, String email, String motdepasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse=adresse;
        this.numero=numero;
        this.email=email;
        this.motdepasse=motdepasse;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getAdresse() {
        return adresse;
    }
    public int getNumero() {
        return numero;
    }
    public String getEmail() {
        return email;
    }
    public String getMdp() {
        return motdepasse;
    }
    public boolean containsDossier(String numero) {
        for (Dossier dos : dossiersPatients) {
            if (dos.getNumDossier() == numero) return true;
        }
        return false;
    }
    public void setRdvList(List<RendezVous> list) {
        rdvList = list;
    }
    public List<RendezVous> getRdvList() {
        return rdvList;
    }
    public void ajouterDossier(Dossier dos) {
        dossiersPatients.add(dos);
    }
    public List<Dossier> getDossiersPatients() {
        return dossiersPatients;
    }
    public Dossier trouverPatient(Patient patient) {
        for (Dossier dos : dossiersPatients) {
            if(dos.getPatient()==patient) {
                return dos;
            }
        }
        return null;
    }
}
