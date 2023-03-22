package com.example.smartcity.handler;

import com.example.smartcity.model.AccessoLogin;
import com.example.smartcity.model.UsersBean;

public abstract class Handler {
    private Handler next;
    public Handler setNextHandler(Handler next){
        this.next = next;
        return  next;
    }

    public Handler getNext() {
        return next;
    }

    public abstract AccessoLogin handle(UsersBean usersBean);

    protected AccessoLogin handlerNext(UsersBean usersBean){
        if(this.next == null){
            return AccessoLogin.SUCCESSO;
        }
        return next.handle(usersBean);
    }

    //public abstract boolean handle(String username, String password);

    /*protected boolean handleNext(String username, String password){
        if(next == null){
            return true;
        }
        return next.handle(username, password);
    }*/
}