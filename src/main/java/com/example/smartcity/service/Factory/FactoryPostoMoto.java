package com.example.smartcity.service.Factory;

public class FactoryPostoMoto extends FactoryPosto{
    public Posto creaPosto(){
        return new PostoMoto();
    }
}