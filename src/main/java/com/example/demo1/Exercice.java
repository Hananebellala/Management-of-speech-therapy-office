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


}
