package com.example.smartcity.service.Factory;

import com.example.smartcity.model.ParkingBean;
import com.example.smartcity.service.ModifyService;

public class PostoFurgone implements Posto{
    @Override
    public void parcheggia(ParkingBean parkingBean) {
        int posti = parkingBean.getPostiFurgone();
        ModifyService.modifyPostiFurgone(parkingBean.getNomeParcheggio(), posti-1);
        System.out.println("Furgone Inserito");
    }
}