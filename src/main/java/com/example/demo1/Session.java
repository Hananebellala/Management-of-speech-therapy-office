package com.example.demo1;

import java.util.List;

public class Session {
    private static Compte compte;

    public static void setCompte(Compte compte) {
        Session.compte = compte;
    }

    public static Compte getCompte() {
        return compte;
    }
    public static void setRdvList(List<RendezVous> list) {
        Session.compte.setRdvList(list);
    }
}

