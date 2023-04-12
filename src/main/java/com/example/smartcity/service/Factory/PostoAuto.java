package com.example.smartcity.service.Factory;

import com.example.smartcity.model.ParkingBean;
import com.example.smartcity.service.ModifyService;

public class PostoAuto implements Posto {
    @Override
    public void parcheggia(ParkingBean parkingBean) {

        int posti = parkingBean.getPostiAuto();
        ModifyService.modifyPostiAuto(parkingBean.getNomeParcheggio(), posti-1);
        System.out.println("posti: "+ posti);
        System.out.println("Auto Inserita");
    }
}