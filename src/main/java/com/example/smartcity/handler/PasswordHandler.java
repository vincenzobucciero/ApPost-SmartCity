package com.example.smartcity.handler;

import com.example.smartcity.dao.LoginDao;
import com.example.smartcity.model.AccessoLogin;
// import com.example.smartcity.model.UsersBean;

public class PasswordHandler extends Handler{
    private final String email;
    private final String password;

    //public PasswordHandler(LoginDao database){this.database = database;}

    /*public AccessoLogin handle(UsersBean usersBean){
        if(!database.controllaDB(usersBean)){
            System.out.println("Password errata");
            System.out.println("Riprova");
            return AccessoLogin.PASSWORD_ERRATA;
        }
        return handlerNext(usersBean);
    }*/


    public PasswordHandler(String email, String password){
        this.email = email;
        this.password = password;
    }

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