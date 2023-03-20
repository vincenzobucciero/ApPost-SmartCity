package com.example.smartcity.model;

import java.io.IOException;

public class mainTest {
    public static void main(String[] args) throws IOException{
        AccessoLogin accessoLogIn = DB.getIstanza().logIn("patata", "ciao");
        switch (accessoLogIn) {
            case UTENTE_INESISTENTE:
                System.out.println("Non sei registrato");
                break;
            case PASSWORD_ERRATA:
                System.out.println("Password no");
                break;
            case SUCCESSO:
                System.out.println("Dentro|");
                break;
            default:
                System.out.println("Default");
                break;
        }

        //DB.getIstanza().addUtente("patata","ciao");

    }
}
