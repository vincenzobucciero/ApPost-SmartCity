package com.example.smartcity.service;

import com.example.smartcity.model.ParkingBean;
import com.example.smartcity.model.ParkingDao;

import java.util.List;

public class ParkingService {
    public static List<ParkingBean> getAllParkings() {
        ParkingDao parkingDao = ParkingDao.getIstanza();

        List<ParkingBean> parkingBean = parkingDao.getParkings();
        return parkingBean;
    }

    public static ParkingBean getParkingBean(String nomeParcheggio){
        return ParkingDao.getIstanza().getParkingBean(nomeParcheggio);
    }

}