/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jospin Nabonyimana
 */
import java.util.Scanner;

public class CalculatorApp {
    
    //Method for addition
    static double add(double a, double b) {
        return a + b;
    }
    //Method for subtraction
    static double subtract(double a, double b) {
        return a - b;
    }
    //Method for multiplication
    static double multiply(double a, double b) {
        return a * b;
    }
    //Method for division
    static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // This loop will only stop when a valid calculation is performed
        while (true) {
            try {
                System.out.println("\n=== Simple Calculator ===");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.print("Choose an operation (1-4): ");

                int choice = scanner.nextInt();

                // If number is valid, we proceed. If not, we skip the rest and loop again.
                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid choice. Please select 1 to 4.");
                    continue; 
                }

                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                double result;

                switch (choice) {
                    case 1:
                        result = add(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 2:
                        result = subtract(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 3:
                        result = multiply(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 4:
                        result = divide(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                }
                break;

            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numeric values (1-4).");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
}