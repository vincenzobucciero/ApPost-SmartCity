package com.example.smartcity.service.CommandPrezzo;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;

public class PrezzoAFCommand implements Command<Double>{
    Receiver prezzo;

    public PrezzoAFCommand(Receiver prezzo){ this.prezzo = prezzo; }

    @Override
    public Double execute(ParkingBean parkingBean, BookingBean bookingBean) {
        return prezzo.getPrezzoAF(parkingBean, bookingBean);
    }
}