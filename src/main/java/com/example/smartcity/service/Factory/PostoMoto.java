package com.example.smartcity.service.Factory;

import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.ModifyDao;

public class PostoMoto implements Posto{
    @Override
    public void parcheggia(ParkingBean parkingBean) {
        int posti = parkingBean.getPostiMoto();
        ModifyDao.modifyPostiMoto(parkingBean.getNomeParcheggio(), posti-1);
        System.out.println("Moto Inserita");
    }
}