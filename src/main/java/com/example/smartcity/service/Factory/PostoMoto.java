package com.example.smartcity.service.Factory;

import com.example.smartcity.model.ParkingBean;
import com.example.smartcity.service.ModifyService;

public class PostoMoto implements Posto{
    @Override
    public void parcheggia(ParkingBean parkingBean) {
        int posti = parkingBean.getPostiMoto();
        ModifyService.modifyPostiMoto(parkingBean.getNomeParcheggio(), posti-1);
        System.out.println("Moto Inserita");
    }
}