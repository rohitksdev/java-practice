package com.rohitksdev.designpatterns.creational.factory;

public abstract class NotificationCreator {
    abstract Notification createNotification();

    public void send(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}
