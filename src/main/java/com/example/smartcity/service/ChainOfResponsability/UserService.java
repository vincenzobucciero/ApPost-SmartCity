package com.example.smartcity.service.ChainOfResponsability;

import com.example.smartcity.model.Bean.UserBean;
import com.example.smartcity.model.DAO.UserDao;


/**
 * Questa classe rappresenta un servizio che gestisce la richiesta di accesso al sistema degli utenti.
 */
public class UserService {

    /**
     * Gestisce la richiesta di accesso al sistema degli utenti, utilizzando una catena di gestione delle richieste.
     *
     * @param email l'email dell'utente che vuole accedere al sistema.
     * @param password la password dell'utente che vuole accedere al sistema.
     * @return l'esito del tentativo di accesso al sistema.
     */
    public static AccessoLogin logHandler(String email, String password) {

        UserBean userBean = UserDao.getUserBean(email);

        Handler handler = new MailHandler(email);
        handler.setNextHandler(new PasswordHandler(email, password)).setNextHandler(new RoleHandler());


        AuthService authService = new AuthService(handler);
        return authService.logIn(email, password);

    }

}