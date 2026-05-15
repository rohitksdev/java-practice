package com.rohitksdev.designpatterns.creational.factory;

public class SMSNotificationCreator extends NotificationCreator{
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
