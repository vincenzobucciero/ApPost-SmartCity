package com.example.smartcity.handler;

import com.example.smartcity.model.AccessoLogin;
import com.example.smartcity.model.DB;
import com.example.smartcity.model.LoginDao;

import java.util.Map;

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


    private DB database;

    public PasswordHandler(DB database){this.database = database;}

    public AccessoLogin handle(String username, String password){
        if(!database.controllaDB(username,password)){
            System.out.println("Password errata");
            System.out.println("Riprova");
            return AccessoLogin.PASSWORD_ERRATA;
        }
        return handlerNext(username,password);
    }

    /*private LoginDao database;
    public PasswordHandler(LoginDao database){
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