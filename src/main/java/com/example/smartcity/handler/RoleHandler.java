package com.example.smartcity.handler;

import com.example.smartcity.model.AccessoLogin;

public class RoleHandler extends Handler {

    /**
     *
     * @param email
     * @param password
     * @return
     */
    @Override
    public AccessoLogin handle(String email, String password) {
        if("admin@admin.com".equals(email)){
            System.out.println("Caricamento Pagina Admin...");
            return AccessoLogin.SUCCESSO_ADMIN;
        }
        System.out.println("Caricamento Pagina di Default ");
        return handleNext(email, password);
    }
}