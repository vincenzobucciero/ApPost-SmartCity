package com.example.smartcity.handler;

import com.example.smartcity.dao.LoginDao;
import com.example.smartcity.model.AccessoLogin;

public class MailHandler extends Handler {
    //private LoginDao database;

    /*public MailHandler(LoginDao database){
        this.database = database;
    }*/

    /*public AccessoLogin handle(UsersBean usersBean){
        if(!database.controllaLogin(usersBean)){
            System.out.println("Non sei registrato");
            System.out.println("Registrati ora");
            return AccessoLogin.UTENTE_INESISTENTE;
        }
        return handlerNext(usersBean);
    }*/

    private String email;
    private String password;
    public MailHandler(String email){
        this.email = email;
        //this.password = password;
    }

    public AccessoLogin handle(String email, String password){
        if(!LoginDao.controllaLogin(email)){
            System.out.println("Non sei registrato");
            System.out.println("Registrati ora");
            return AccessoLogin.UTENTE_INESISTENTE;
        }
        return handleNext(email,password);
    }


}