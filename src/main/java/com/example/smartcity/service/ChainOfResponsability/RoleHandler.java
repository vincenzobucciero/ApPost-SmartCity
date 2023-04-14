package com.example.smartcity.service.ChainOfResponsability;


public class RoleHandler extends Handler{
    public AccessoLogin handle(String email, String password) {
        if("admin@admin.com".equals(email)){
            System.out.println("Caricamento Pagina Admin...");
            return AccessoLogin.SUCCESSO_ADMIN;
        }
        System.out.println("Caricamento Pagina di Default ");
        return handleNext(email, password);
    }
}