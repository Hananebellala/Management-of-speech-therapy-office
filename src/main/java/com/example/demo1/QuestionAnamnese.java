package com.example.demo1;

public class QuestionAnamnese {
    protected String Enonce;
    private Categorie cat;
    private String reponse;

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
