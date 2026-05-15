package com.rohitksdev.designpatterns.creational.factory;

public class EmailNotificationCreator extends NotificationCreator{
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
