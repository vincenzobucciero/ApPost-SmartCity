package com.example.smartcity.service.ChainOfResponsability;

import com.example.smartcity.model.DAO.UserDao;


/**
 * Questa classe rappresenta un handler della catena di gestione delle richieste di accesso al sistema
 * che gestisce le richieste di accesso degli utenti in base alla password fornita come parametro.
 */
public class PasswordHandler extends Handler{
    private String email;
    private String password;


    /**
     * Costruisce un nuovo handler che gestirà le richieste di accesso degli utenti
     * in base all'email e alla password fornite come parametri.
     *
     * @param email l'email dell'utente che vuole accedere al sistema.
     * @param password la password dell'utente che vuole accedere al sistema.
     */
    public PasswordHandler(String email, String password){
        this.email = email;
        this.password = password;
    }


    /**
     * Gestisce la richiesta di accesso al sistema per l'utente specificato in base alla password.
     *
     * @param email l'email dell'utente che vuole accedere al sistema.
     * @param password la password dell'utente che vuole accedere al sistema.
     * @return l'esito del tentativo di accesso al sistema.
     */
    @Override
    public AccessoLogin handle(String email, String password){
        if(!UserDao.controllaPassword(email, password)){
            System.out.println("Password errata");
            System.out.println("Riprova");
            return AccessoLogin.PASSWORD_ERRATA;
        }
        return handleNext(email, password);
    }
}