package com.example.smartcity.service;

import com.example.smartcity.model.BookingBean;
import com.example.smartcity.dao.BookingDao;

public class BookingService {

    public static void Booking(BookingBean bookingBean){
        BookingDao.getIstanza().addBooking(bookingBean);
    }
}