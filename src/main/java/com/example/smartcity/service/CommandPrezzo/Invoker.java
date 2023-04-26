package com.example.smartcity.service.CommandPrezzo;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;

public class Invoker {
    public double getTot(VeicoliEnum operation, ParkingBean parkingBean, BookingBean bookingBean) {
        Command<Double> toExecute = operation.getPrezzoPosto();
        return toExecute.execute(parkingBean, bookingBean);
    }

    public int getPosti(VeicoliEnum operation, ParkingBean parkingBean, BookingBean bookingBean){
        Command<Integer> toExecute = operation.getTotPosti();
        return toExecute.execute(parkingBean, bookingBean);

    }
}