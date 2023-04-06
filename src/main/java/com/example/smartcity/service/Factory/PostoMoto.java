package com.example.smartcity.service.Factory;

import com.example.smartcity.model.ParkingBean;
import com.example.smartcity.service.ModifyService;

public class PostoMoto implements Posto{
    @Override
    public void parcheggia(int id, ParkingBean parkingBean) {
        int posti = parkingBean.getPostiMoto();
        ModifyService.modifyPostiMoto(id, posti-1);
        System.out.println("Moto Inserita");
    }
}