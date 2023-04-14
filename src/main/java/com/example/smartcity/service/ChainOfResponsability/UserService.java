package com.example.smartcity.service.ChainOfResponsability;

import com.example.smartcity.model.Bean.UserBean;
import com.example.smartcity.model.DAO.UserDao;


public class UserService {
    public static AccessoLogin logHandler(String email, String password) {

        UserBean userBean = UserDao.getUserBean(email);

        Handler handler = new MailHandler(email);
        handler.setNextHandler(new PasswordHandler(email, password)).setNextHandler(new RoleHandler());


        AuthService authService = new AuthService(handler);
        return authService.logIn(email, password);

    }

}