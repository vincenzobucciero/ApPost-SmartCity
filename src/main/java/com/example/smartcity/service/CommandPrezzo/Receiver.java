package com.example.smartcity.service.CommandPrezzo;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;
import com.example.smartcity.model.DAO.BookingDao;

public class Receiver {
    public double getPrezzoAF(ParkingBean parkingBean, BookingBean bookingBean){
        return BookingDao.getTotPrice(parkingBean.getTariffaAF(), bookingBean);
    }

    public double getPrezzoM(ParkingBean parkingBean, BookingBean bookingBean) {
        return BookingDao.getTotPrice(parkingBean.getTariffaM(), bookingBean);
    }

    public int getNumPostiA(ParkingBean parkingBean) {
        return parkingBean.getPostiAuto();
    }
    public int getNumPostiF(ParkingBean parkingBean) {
        return parkingBean.getPostiFurgone();
    }
    public int getNumPostiM(ParkingBean parkingBean) {
        return parkingBean.getPostiMoto();
    }
}