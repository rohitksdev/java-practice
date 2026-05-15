package com.rohitksdev.designpatterns.creational.factory;

public class Main {
    public static void main(String[] args) {
        NotificationCreator creator;

        creator = new EmailNotificationCreator();
        creator.send("Your OTP is 6666");

        creator = new SMSNotificationCreator();
        creator.send("Your OTP is 7777");
    }
}
