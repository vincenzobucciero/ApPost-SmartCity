package com.example.smartcity.service.ChainOfResponsability;

/**
 * Questa classe astratta rappresenta un handler base del design pattern Chain of Responsibility
 * che fornisce un'implementazione comune per gestire le richieste di accesso al sistema.
 */
public abstract class Handler {
    private Handler next;

    /**
     * Imposta handler successivo nella catena di gestione delle richieste di accesso al sistema.
     *
     * @param next handler successivo.
     * @return handler successivo.
     */
    public Handler setNextHandler(Handler next){
        this.next = next;
        return  next;
    }

    /**
     * Gestisce la richiesta di accesso al sistema per l'utente specificato.
     *
     * @param username l'username dell'utente che vuole accedere al sistema.
     * @param password la password dell'utente che vuole accedere al sistema.
     * @return l'esito del tentativo di accesso al sistema.
     */
    public abstract AccessoLogin handle(String username, String password);


    /**
     * Richiama l'handler successivo nella catena di gestione delle richieste di accesso al sistema.
     *
     * @param username l'username dell'utente che vuole accedere al sistema.
     * @param password la password dell'utente che vuole accedere al sistema.
     * @return l'esito del tentativo di accesso al sistema gestito dall'handler successivo.
     */
    protected AccessoLogin handleNext(String username, String password){
        if(next == null){
            return AccessoLogin.SUCCESSO;
        }
        return next.handle(username, password);
    }
}