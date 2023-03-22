package com.example.smartcity.service;

import com.example.smartcity.dao.LoginDAO;
import com.example.smartcity.model.AccessoLogin;
import com.example.smartcity.model.UsersBean;

public class LogService {
    public static boolean registration(UsersBean usersBean){
        return LoginDAO.getIstanza().addUtente(usersBean);
    }

    public static AccessoLogin logHandler(UsersBean usersBean) {
        return LoginDAO.getIstanza().logIn(usersBean);
    }
}