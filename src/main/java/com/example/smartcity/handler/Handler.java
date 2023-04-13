package com.example.smartcity.handler;

import com.example.smartcity.model.AccessoLogin;

/**
 *
 *
 */
public abstract class Handler {
    private Handler next;

    /**
     *
     * @param next
     * @return
     */
    public Handler setNextHandler(Handler next){
        this.next = next;
        return  next;
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public abstract AccessoLogin handle(String username, String password);

    /**
     *
     * @param username
     * @param password
     * @return
     */
    protected AccessoLogin handleNext(String username, String password){
        if(this.next == null){
            return AccessoLogin.SUCCESSO;
        }
        return next.handle(username, password);
    }
}