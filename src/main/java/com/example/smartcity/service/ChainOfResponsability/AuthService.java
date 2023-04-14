package com.example.smartcity.service.ChainOfResponsability;

import java.sql.SQLException;

;
public class AuthService {
    private Handler handler;

    public AuthService(Handler handler){this.handler = handler;}


    public AccessoLogin logIn(String email, String password){
        AccessoLogin result = handler.handle(email, password);
        if (result == AccessoLogin.SUCCESSO){
            System.out.println("Autorizzazione effettuata con successo!!!");
            return result;
        }
        return result;
    }
}