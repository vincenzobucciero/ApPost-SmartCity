package com.example.smartcity.service;

import com.example.smartcity.dao.LoginDao;
import com.example.smartcity.handler.Handler;
import com.example.smartcity.handler.MailHandler;
import com.example.smartcity.handler.PasswordHandler;
import com.example.smartcity.handler.RoleHandler;
import com.example.smartcity.model.AccessoLogin;
import com.example.smartcity.model.UsersBean;

public class LogService {
    public static boolean registration(UsersBean usersBean){
        return LoginDao.getIstanza().addUtente(usersBean);
    }

    public static AccessoLogin logHandler(String email, String password) {
        //return LoginDao.getIstanza().logIn(usersBean);
        Handler handler = new MailHandler(email);
        handler.setNextHandler(new PasswordHandler(email, password)).setNextHandler(new RoleHandler());


        AuthService authService = new AuthService(handler);
        return authService.logIn(email, password);
    }
}