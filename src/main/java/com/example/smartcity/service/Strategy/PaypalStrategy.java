package com.example.smartcity.service.Strategy;

public class PaypalStrategy implements PaymentStrategy {
    private String emailId;
    private String password;
    public PaypalStrategy(String email, String password){
        this.emailId = email;
        this.password = password;
    }


    @Override
    public boolean pay(double amount) {
        System.out.println(amount + " paid using Paypal.");
        return true;
    }
}