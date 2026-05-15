package com.rohitksdev.designpatterns.creational.factory.naive;

public class Main {
    public static void main(String[] args) {
        Notification notification = new EmailNotification();
        Notification notification2 = new SMSNotification();
        sendNotification(notification, "Sample message");
        sendNotification(notification2, "Sample message");
    }

    public static void sendNotification(Notification notification, String message) {
        System.out.println(notification.send(message));
    }
}
