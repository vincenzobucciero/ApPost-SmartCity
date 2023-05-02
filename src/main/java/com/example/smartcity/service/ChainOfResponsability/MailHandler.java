package com.example.smartcity.service.ChainOfResponsability;

import com.example.smartcity.model.DAO.UserDao;


/**
 * Questa classe rappresenta un handler della catena di gestione delle richieste di accesso
 * al sistema che gestisce le richieste di accesso degli utenti in base all'email fornita come parametro.
 */
public class MailHandler extends Handler{
    private String email;
    private String password;


    /**
     * Costruisce un nuovo handler che gestirà le richieste di accesso degli utenti con l'email fornita come parametro.
     *
     * @param email l'email degli utenti che verrà gestita da questo handler.
     */
    public MailHandler(String email){
        this.email = email;
    }


    /**
     * Gestisce la richiesta di accesso al sistema per l'utente specificato in base all'email.
     *
     * @param email l'email dell'utente che vuole accedere al sistema.
     * @param password la password dell'utente che vuole accedere al sistema.
     * @return l'esito del tentativo di accesso al sistema.
     */
    public AccessoLogin handle(String email, String password){
        if(!UserDao.controllaEmail(email)){
            System.out.println("Non sei registrato");
            System.out.println("Registrati ora");
            return AccessoLogin.UTENTE_INESISTENTE;
        }
        return this.handleNext(email,password);
    }
}