package com.example.smartcity.service.CommandPrezzo;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;

public class PostiMCommand implements Command<Integer>{
    Receiver posti;
    public PostiMCommand(Receiver posti){
        this.posti = posti;
    }
    @Override
    public Integer execute(ParkingBean parkingBean, BookingBean bookingBean) {
        return posti.getNumPostiM(parkingBean);
    }
}