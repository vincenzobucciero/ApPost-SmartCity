package com.example.smartcity.handler;

import com.example.smartcity.model.LoginDao;
import com.example.smartcity.model.AccessoLogin;

public class PasswordHandler extends Handler{
    private final String email;
    private final String password;

    /**
     *
     * @param email
     * @param password
     */
    public PasswordHandler(String email, String password){
        this.email = email;
        this.password = password;
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */
    @Override
    public AccessoLogin handle(String email, String password) {
        if(!LoginDao.controllaDB(email, password)){
            System.out.println("Password errata");
            System.out.println("Riprova");
            return AccessoLogin.PASSWORD_ERRATA;
        }
        return handleNext(email, password);
    }
}