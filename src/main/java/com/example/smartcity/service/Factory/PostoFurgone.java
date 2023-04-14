package com.example.smartcity.service.Factory;

import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.ModifyDao;

public class PostoFurgone implements Posto{
    @Override
    public void parcheggia(ParkingBean parkingBean) {
        int posti = parkingBean.getPostiFurgone();
        ModifyDao.modifyPostiFurgone(parkingBean.getNomeParcheggio(), posti-1);
        System.out.println("Furgone Inserito");
    }
}