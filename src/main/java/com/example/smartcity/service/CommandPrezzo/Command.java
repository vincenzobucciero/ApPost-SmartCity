package com.example.smartcity.service.CommandPrezzo;

import com.example.smartcity.model.Bean.BookingBean;
import com.example.smartcity.model.Bean.ParkingBean;

public interface Command <T>{
    T execute(ParkingBean parkingBean, BookingBean bookingBean);
}