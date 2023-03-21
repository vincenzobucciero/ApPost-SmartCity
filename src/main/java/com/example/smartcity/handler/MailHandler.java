package com.example.smartcity.handler;

import com.example.smartcity.model.AccessoLogin;
import com.example.smartcity.dao.DB;

public class MailHandler extends Handler {
    private DB database;

    public MailHandler(DB database){
        this.database = database;
    }

    public AccessoLogin handle(String username, String password){
        if(!database.controllaLogin(username)){
            System.out.println("Non sei registrato");
            System.out.println("Registrati ora");
            return AccessoLogin.UTENTE_INESISTENTE;
        }
        return handlerNext(username,password);
    }

}