package com.example.smartcity.service.Strategy;

import com.example.smartcity.model.BookingBean;
import com.example.smartcity.model.BookingDao;

import java.time.LocalDate;
import java.util.List;

public class MainS {
    public static void main(String[] args) {

        BookingBean bookingBean = BookingDao.getIstanza().getBookingBean(1);
        //pay by paypal
        //cart.pay(new PaypalStrategy("myemail@example.com", "mypwd"));

        LocalDate data = LocalDate.of(2025,05,31);
        //pay by credit card
        //cart.pay(new CreditCardStrategy("Pankaj Kumar", "1234567890123456", "786",data ));

        PaymentStrategy paymentMethod = new CreditCardStrategy("Pankaj Kumar", "1234567890123456", "786",data );
        paymentMethod.pay(bookingBean.getPrezzo());
    }
}