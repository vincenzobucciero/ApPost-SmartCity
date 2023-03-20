package com.example.smartcity.handler;

import com.example.smartcity.model.AccessoLogin;

public class RoleHandler extends Handler {
    @Override
    public AccessoLogin handle(String username, String password) {
        if("admin@admin.it".equals(username)){
            System.out.println("Caricamento Pagina Admin...");
            return AccessoLogin.SUCCESSO_ADMIN;
        }
        System.out.println("Caricamento Pagina di Default ");
        return handlerNext(username, password);
    }
}