package com.example.demo1;

import java.io.Serializable;

public class QuestionAnamnese implements Serializable {
    protected String Enonce;
    private Categorie cat;
    private String reponse;
    private static final long serialVersionUID = 6264016623953139405L;

    public QuestionAnamnese(String Enonce, Categorie cat, String reponse) {
        this.Enonce = Enonce;
        this.cat = cat;
        this.reponse = reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getReponse() {
        return reponse;
    }

    public String getEnonce() {
        return Enonce;
    }

    public Categorie getCat() {
        return cat;
    }
}
