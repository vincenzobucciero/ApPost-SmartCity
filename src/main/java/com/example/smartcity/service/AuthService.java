
package com.example.smartcity.service;

import com.example.smartcity.handler.Handler;
import com.example.smartcity.model.AccessoLogin;
import com.example.smartcity.model.UsersBean;

public class AuthService {
    private Handler handler;

    public AuthService(Handler handler){this.handler = handler;}
    public AccessoLogin logIn(String email, String password){

        AccessoLogin result = handler.handle(email, password);
        if (result == AccessoLogin.SUCCESSO){
            System.out.println("Autorizzazione effettuata con successo!!!");
            return result;
        }
        return result;
    }
}