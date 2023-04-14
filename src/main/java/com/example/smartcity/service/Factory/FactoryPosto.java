package com.example.smartcity.service.Factory;

import com.example.smartcity.model.Bean.ParkingBean;

public abstract class FactoryPosto
{
    public Posto getPosto(ParkingBean parkingBean){
        Posto posto = creaPosto();
        posto.parcheggia(parkingBean);
        return posto;
    }

    protected abstract Posto creaPosto();
}