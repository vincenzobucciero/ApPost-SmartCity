package com.example.smartcity.handler;

import com.example.smartcity.dao.LoginDAO;
import com.example.smartcity.model.AccessoLogin;
import com.example.smartcity.model.UsersBean;

public class MailHandler extends Handler {
    private LoginDAO database;

    public MailHandler(LoginDAO database){
        this.database = database;
    }

    public AccessoLogin handle(UsersBean usersBean){
        if(!database.controllaLogin(usersBean)){
            System.out.println("Non sei registrato");
            System.out.println("Registrati ora");
            return AccessoLogin.UTENTE_INESISTENTE;
        }
        return handlerNext(usersBean);
    }

}