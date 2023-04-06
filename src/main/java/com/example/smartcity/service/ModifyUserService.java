package com.example.smartcity.service;

import com.example.smartcity.model.ModifyDao;
import com.example.smartcity.model.ModifyUserDao;
import com.example.smartcity.model.ParkingDao;

public class ModifyUserService {

    public static void modifyNome(String email, String nome){ ModifyUserDao.getIstanza().modifyNome(email, nome);}

    public static void modifyCognome(String email, String cognome){ModifyUserDao.getIstanza().modifyCognome(email, cognome);}

    public static void modifyEmail(String email, String newEmail){ModifyUserDao.getIstanza().modifyEmail(email, newEmail);}

    public static void modifyPassword(String email, String password){ModifyUserDao.getIstanza().modifyPassword(email, password);}



}