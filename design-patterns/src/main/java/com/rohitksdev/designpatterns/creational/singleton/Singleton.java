package com.rohitksdev.designpatterns.creational.singleton;

/*
 * Lazy Initialization (Not Thread-Safe)
 * Creates the singleton instance only when it is needed
 * If multiple threads call getInstance() simultaneously when instance is null, it's possible to create multiple instances.
 */
public class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
