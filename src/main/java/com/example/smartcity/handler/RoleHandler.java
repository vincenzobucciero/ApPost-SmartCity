package com.example.smartcity.handler;

import com.example.smartcity.model.AccessoLogin;
import com.example.smartcity.model.UsersBean;

public class RoleHandler extends Handler {
    @Override
    public AccessoLogin handle(UsersBean usersBean) {
        if("admin@admin.it".equals(usersBean.getEmail())){
            System.out.println("Caricamento Pagina Admin...");
            return AccessoLogin.SUCCESSO_ADMIN;
        }
        System.out.println("Caricamento Pagina di Default ");
        return handlerNext(usersBean);
    }
}