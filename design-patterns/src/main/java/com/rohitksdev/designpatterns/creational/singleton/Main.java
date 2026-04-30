package com.rohitksdev.designpatterns.creational.singleton;


public class Main {
    public static void main(String[] args) {
        System.out.println("--- Basic Singleton class ---");

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        if (singleton1 == singleton2) {
            System.out.println("Both objects are SAME instance");
        } else {
            System.out.println("Different instances ❌");
        }

    }
}