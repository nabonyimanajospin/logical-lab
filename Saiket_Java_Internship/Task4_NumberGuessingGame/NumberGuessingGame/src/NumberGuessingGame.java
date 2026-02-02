/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jospin Nabonyimana
 */
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Generate random number between 1 and 100
        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 10; // Reasonable limit
        boolean hasGuessedCorrectly = false;
        
        System.out.println("=================================");
        System.out.println("   WELCOME TO NUMBER GUESSING GAME");
        System.out.println("=================================");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess it!");
        System.out.println("=================================\n");
        
        // Main game loop - allows multiple attempts
        while (attempts < maxAttempts && !hasGuessedCorrectly) {
            attempts++;
            System.out.println("Attempt #" + attempts + " of " + maxAttempts);
            System.out.print("Enter your guess: ");
            
            try {
                int userGuess = scanner.nextInt();
                
                // Here I provide feedback using conditional statements
                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please guess a number between 1 and 100!");
                    attempts--; // Don't count invalid attempts
                } else if (userGuess == secretNumber) {
                    hasGuessedCorrectly = true;
                    System.out.println("=================================");
                    System.out.println("   CONGRATULATIONS! 🎉");
                    System.out.println("=================================");
                    System.out.println("You guessed the number " + secretNumber + " correctly!");
                    System.out.println("It took you " + attempts + " attempt(s).");
                    
                    // Bonus: Performance feedback
                    if (attempts <= 3) {
                        System.out.println("Wow! You're a guessing genius! 🌟");
                    } else if (attempts <= 6) {
                        System.out.println("Great job! That was efficient! 👍");
                    } else {
                        System.out.println("Good persistence! You got it! 💪");
                    }
                    
                } else if (userGuess < secretNumber) {
                    System.out.println("Too LOW! Try a higher number. ↖️");
                    
                    // Additional hint if far off
                    if (secretNumber - userGuess > 30) {
                        System.out.println("Hint: You're way too low!");
                    }
                    
                } else { // userGuess > secretNumber
                    System.out.println("Too HIGH! Try a lower number. ↘️");
                    
                    // Additional hint if far off
                    if (userGuess - secretNumber > 30) {
                        System.out.println("Hint: You're way too high!");
                    }
                }
                
                System.out.println(); // Empty line for readability
                
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
                attempts--; // Don't count invalid attempts
            }
        }
        
        // If player runs out of attempts
        if (!hasGuessedCorrectly) {
            System.out.println("=================================");
            System.out.println("   GAME OVER 💀");
            System.out.println("=================================");
            System.out.println("Sorry! You've used all " + maxAttempts + " attempts.");
            System.out.println("The secret number was: " + secretNumber);
            System.out.println("Better luck next time!");
        }
        
        // Ask if player wants to play again
        System.out.println("\n=================================");
        System.out.print("Play again? (yes/no): ");
        scanner.nextLine(); // Clear buffer
        String playAgain = scanner.nextLine();
        
        if (playAgain.equalsIgnoreCase("yes") || 
            playAgain.equalsIgnoreCase("y")) {
            System.out.println("\n\nStarting new game...\n");
            main(args); // Restart the game
        } else {
            System.out.println("\nThanks for playing! Goodbye! 👋");
        }
        
        scanner.close();
    }
}
