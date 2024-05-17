package com.example.demo1;

public class Exercice extends Test {

    private String Consigne;
    private String nomMateriel;
    private boolean needMateriel;
    private String CompteRdu;

    public Exercice(String nom, int score, String Consigne, String nomMateriel, boolean needMateriel, String CompteRdu){
        super(nom,score,CompteRdu);
        this.Consigne=Consigne;
        this.nomMateriel=nomMateriel;
        this.needMateriel=needMateriel;

    }

    @Override
    public int CalculerScore() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CalculerScore'");
    }


    public String getConsigne() {
        return this.Consigne;
    }

    public String getNomMateriel() {
        return this.nomMateriel;
    }

    public String getCompteRdu() {
        return this.CompteRdu;
    }

    public boolean isNeedMateriel() {
        return this.needMateriel;
    }

    public void setConsigne(String text) {
        this.Consigne=text;
    }

    public void setNomMateriel(String text) {
        this.nomMateriel=text;
    }

    public void setNeedMateriel(boolean selected) {
        this.needMateriel=selected;
    }

    public void setCompteRdu(String text) {
        this.CompteRdu=text;
    }
}
