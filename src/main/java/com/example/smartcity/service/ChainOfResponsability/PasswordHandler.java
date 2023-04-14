package com.example.smartcity.service.ChainOfResponsability;

import com.example.smartcity.model.DAO.UserDao;

import java.sql.SQLException;

public class PasswordHandler extends Handler{
    private String email;
    private String password;


    public PasswordHandler(String email, String password){
        this.email = email;
        this.password = password;
    }

    @Override
    public AccessoLogin handle(String email, String password){
        if(!UserDao.controllaPassword(email, password)){
            System.out.println("Password errata");
            System.out.println("Riprova");
            return AccessoLogin.PASSWORD_ERRATA;
        }
        return handleNext(email, password);
    }
}