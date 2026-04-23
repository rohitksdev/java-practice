package com.rohitksdev.javapractice.numberguessing;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
