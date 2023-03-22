package com.example.smartcity.handler;

import com.example.smartcity.dao.LoginDAO;
import com.example.smartcity.model.AccessoLogin;
import com.example.smartcity.model.UsersBean;

public class PasswordHandler extends Handler{
   /* private final Map<String, String> database;
    public PasswordHandler(Map database){this.database = database;}
    public AccessoLogin handle(String username, String password){
            if(!database.get(username).equals(password)){
            System.out.println("Password errata");
            System.out.println("Riprova");
            return AccessoLogin.PASSWORD_ERRATA;
        }
        return handlerNext(username, password);
    }*/


    private LoginDAO database;

    public PasswordHandler(LoginDAO database){this.database = database;}

    public AccessoLogin handle(UsersBean usersBean){
        if(!database.controllaDB(usersBean)){
            System.out.println("Password errata");
            System.out.println("Riprova");
            return AccessoLogin.PASSWORD_ERRATA;
        }
        return handlerNext(usersBean);
    }

    /*private LoginDAO database;
    public PasswordHandler(LoginDAO database){
        this.database = database;
    }
    @Override
    public boolean handle(String username, String password) {
        if(!database.isValidPassword(username,password)){
            System.out.println("Password errata");
            System.out.println("Riprova");
            return false;
        }
        return handleNext(username, password);
    }*/
}