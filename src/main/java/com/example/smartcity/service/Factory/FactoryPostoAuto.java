package com.example.smartcity.service.Factory;


public class FactoryPostoAuto extends FactoryPosto {
    protected Posto creaPosto() {
        return new PostoAuto();
    }
}