package com.example.smartcity.service.Factory;

public class FactoryPostoFurgone extends FactoryPosto{
    public Posto creaPosto(){
        return new PostoFurgone();
    }
}