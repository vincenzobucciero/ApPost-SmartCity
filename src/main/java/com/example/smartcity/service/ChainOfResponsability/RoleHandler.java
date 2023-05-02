package com.example.smartcity.service.ChainOfResponsability;

/**
 * Questa classe rappresenta un gestore della catena di gestione delle richieste di accesso
 * al sistema che gestisce le richieste di accesso degli utenti in base al ruolo dell'utente.
 */
public class RoleHandler extends Handler{

    /**
     * Gestisce la richiesta di accesso al sistema per l'utente specificato in base al ruolo dell'utente.
     *
     * @param email l'email dell'utente che vuole accedere al sistema.
     * @param password la password dell'utente che vuole accedere al sistema.
     * @return l'esito del tentativo di accesso al sistema.
     */
    public AccessoLogin handle(String email, String password) {
        if("admin@admin.com".equals(email)){
            System.out.println("Caricamento Pagina Admin...");
            return AccessoLogin.SUCCESSO_ADMIN;
        }
        System.out.println("Caricamento Pagina di Default ");
        return handleNext(email, password);
    }
}