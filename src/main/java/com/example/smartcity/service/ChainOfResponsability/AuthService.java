package com.example.smartcity.service.ChainOfResponsability;

/**
 * Questa classe rappresenta un servizio di autenticazione che utilizza il design pattern Chain of Responsibility
 * per gestire le richieste di accesso al sistema.
 */
public class AuthService {

    private Handler handler;

    /**
     * Costruisce un nuovo servizio di autenticazione con handler fornito come parametro.
     *
     * @param handler handler che verrà utilizzato per gestire le richieste di accesso al sistema.
     */
    public AuthService(Handler handler){this.handler = handler;}

    /**
     * Effettua il login al sistema con l'email e la password fornite come parametro.
     *
     * @param email l'email dell'utente che vuole accedere al sistema.
     * @param password la password dell'utente che vuole accedere al sistema.
     * @return l'esito del tentativo di accesso al sistema.
     */
    public AccessoLogin logIn(String email, String password){
        AccessoLogin result = handler.handle(email, password);
        if (result == AccessoLogin.SUCCESSO){
            System.out.println("Autorizzazione effettuata con successo!!!");
            return result;
        }
        return result;
    }
}