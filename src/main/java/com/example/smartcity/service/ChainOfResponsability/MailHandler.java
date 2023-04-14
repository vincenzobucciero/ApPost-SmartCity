package com.example.smartcity.service.ChainOfResponsability;

import com.example.smartcity.model.DAO.UserDao;


import java.sql.SQLException;


public class MailHandler extends Handler{
    private String email;
    private String password;
    public MailHandler(String email){
        this.email = email;
    }

    public AccessoLogin handle(String email, String password){
        if(!UserDao.controllaEmail(email)){
            System.out.println("Non sei registrato");
            System.out.println("Registrati ora");
            return AccessoLogin.UTENTE_INESISTENTE;
        }
        return this.handleNext(email,password);
    }
}