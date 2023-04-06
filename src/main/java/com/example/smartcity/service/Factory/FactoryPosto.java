package com.example.smartcity.service.Factory;

import com.example.smartcity.model.ParkingBean;

public abstract class FactoryPosto
{
    public Posto getPosto(int id, ParkingBean parkingBean) {
        Posto posto = creaPosto();
        posto.parcheggia(id, parkingBean);
        return posto;
    }

    protected abstract Posto creaPosto();
}