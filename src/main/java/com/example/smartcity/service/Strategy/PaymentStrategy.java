package com.example.smartcity.service.Strategy;

import com.example.smartcity.model.BookingBean;
import com.example.smartcity.service.BookingService;

public interface PaymentStrategy {
    public boolean pay(double amount);


}