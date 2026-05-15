package com.rohitksdev.designpatterns.creational.factory.naive;

public class SMSNotification implements Notification{
    @Override
    public String send(String message) {
        return "SMS: " + message;
    }
}
