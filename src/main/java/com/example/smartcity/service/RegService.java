package com.example.smartcity.service;

import com.example.smartcity.dao.DB;
import com.example.smartcity.model.UsersBean;

public class RegService {
    public static boolean registration(UsersBean usersBean){
        return DB.getIstanza().addUtente(usersBean);
    }
}