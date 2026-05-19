package com.rohitksdev.designpatterns.structural.adapter.paymentprocessor;

public interface PaymentProcessor {
    void processPayment(double amount, String currency);
    boolean isPaymentSuccessful();
    String getTransactionId();
}
