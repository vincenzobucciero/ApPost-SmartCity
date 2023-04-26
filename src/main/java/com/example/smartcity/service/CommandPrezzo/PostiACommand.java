package com.example.smartcity.service.CommandPrezzo;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;

public class PostiACommand implements Command<Integer>{
    Receiver posti;
    public PostiACommand(Receiver posti){
        this.posti = posti;
    }
    @Override
    public Integer execute(ParkingBean parkingBean, BookingBean bookingBean) {
        return posti.getNumPostiA(parkingBean);
    }
}