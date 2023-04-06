package com.example.smartcity.service;

import com.example.smartcity.model.ParkingDao;
import com.example.smartcity.model.ParkingBean;

import java.util.List;

public class ParkingService {
    public static List<ParkingBean> getAllParkings() {
        ParkingDao parkingDao = ParkingDao.getIstanza();

        List<ParkingBean> parkingBean = parkingDao.getParkings();
        return parkingBean;
    }
}

