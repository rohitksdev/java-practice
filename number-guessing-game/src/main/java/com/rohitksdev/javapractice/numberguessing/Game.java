package com.rohitksdev.javapractice.numberguessing;

public class Game {
    private final NumberGenerator generator = new NumberGenerator();
    private final InputHandler inputHandler = new InputHandler();
    private final int MAX_ATTEMPTS = 4;

    public void start() {
        System.out.println("================================");
        System.out.println("Welcome to Number Guessing Game");
        System.out.println("================================");

        int target = generator.generate(1, 100);
        int attempts = 0;

        System.out.println("Guess a number between 1 and 100");

        while (true) {
            int guess = inputHandler.readInt();
            attempts++;

            if (guess < target) {
                System.out.println("Too low!");
            } else if (guess > target) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct! Attempts: " + attempts);
                break;
            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.printf("You have lost the game. Correct number is %d", target);
                break;
            }
        }
    }
}
