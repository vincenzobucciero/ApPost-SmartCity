package com.example.smartcity.model;

import com.example.smartcity.handler.PasswordHandler;


public class LoginDao {
    public DB users;

    public LoginDao() {

        users = DB.getIstanza();
    }
}