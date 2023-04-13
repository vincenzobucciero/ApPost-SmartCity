package com.example.smartcity.handler;

import com.example.smartcity.model.LoginDao;
import com.example.smartcity.model.AccessoLogin;

public class MailHandler extends Handler {

    private final String email;
    private String password;

    /**
     *
     * @param email
     */
    public MailHandler(String email){
        this.email = email;
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */
    public AccessoLogin handle(String email, String password){
        if(!LoginDao.controllaLogin(email)){
            System.out.println("Non sei registrato");
            System.out.println("Registrati ora");
            return AccessoLogin.UTENTE_INESISTENTE;
        }
        return handleNext(email,password);
    }


}