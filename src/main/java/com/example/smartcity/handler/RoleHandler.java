package com.example.smartcity.handler;

import com.example.smartcity.model.AccessoLogin;

public class RoleHandler extends Handler {
    @Override
    public AccessoLogin handle(String username, String password) {
        if("admin".equals(username)){
            System.out.println("Caricamento Pagina Admin...");
            return AccessoLogin.SUCCESSO;
        }
        System.out.println("Caricamento Pagina di Default ");
        return handlerNext(username, password);
    }
}