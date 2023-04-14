package com.example.smartcity.service.ChainOfResponsability;


import java.sql.SQLException;

public abstract class Handler {
    private Handler next;
    public Handler setNextHandler(Handler next){
        this.next = next;
        return  next;
    }

    public abstract AccessoLogin handle(String username, String password);

    protected AccessoLogin handleNext(String username, String password){
        if(next == null){
            return AccessoLogin.SUCCESSO;
        }
        return next.handle(username, password);
    }
}