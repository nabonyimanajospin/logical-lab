/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jospin Nabonyimana
 */

import java.util.*;

public class BasicBankingSystem {
    
    // Bank Account Class
    static class BankAccount {
        private String accountNumber;
        private String accountHolder;
        private double balance;
        private ArrayList<String> transactionHistory;
        
        // Constructor
        public BankAccount(String accNumber, String holderName) {
            this.accountNumber = accNumber;
            this.accountHolder = holderName;
            this.balance = 0.0;
            this.transactionHistory = new ArrayList<>();
            this.transactionHistory.add("Account created for " + holderName);
        }
        
        // Deposit method
        public void deposit(double amount) {
            try {
                if (amount <= 0) {
                    throw new IllegalArgumentException("Deposit amount must be positive");
                }
                this.balance += amount;
                String transaction = "Deposit: +$" + String.format("%.2f", amount);
                this.transactionHistory.add(transaction);
                System.out.println("SUCCESS: " + transaction);
                System.out.println("New Balance: $" + String.format("%.2f", this.balance));
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        
        // Withdraw method
        public void withdraw(double amount) {
            try {
                if (amount <= 0) {
                    throw new IllegalArgumentException("Withdrawal amount must be positive");
                }
                if (amount > this.balance) {
                    throw new IllegalArgumentException("Insufficient funds. Available: $" + 
                                                     String.format("%.2f", this.balance));
                }
                this.balance -= amount;
                String transaction = "Withdrawal: -$" + String.format("%.2f", amount);
                this.transactionHistory.add(transaction);
                System.out.println("SUCCESS: " + transaction);
                System.out.println("New Balance: $" + String.format("%.2f", this.balance));
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        
        // Display balance
        public void displayBalance() {
            System.out.println("\n=== ACCOUNT BALANCE ===");
            System.out.println("Account: " + this.accountNumber);
            System.out.println("Holder: " + this.accountHolder);
            System.out.println("Balance: $" + String.format("%.2f", this.balance));
        }
        
        // Display transaction history
        public void displayTransactionHistory() {
            System.out.println("\n=== TRANSACTION HISTORY ===");
            System.out.println("Account: " + this.accountNumber + " - " + this.accountHolder);
            
            if (this.transactionHistory.isEmpty()) {
                System.out.println("No transactions yet.");
            } else {
                for (int i = 0; i < this.transactionHistory.size(); i++) {
                    System.out.println((i + 1) + ". " + this.transactionHistory.get(i));
                }
            }
            System.out.println("Current Balance: $" + String.format("%.2f", this.balance));
        }
        
        // Get current balance
        public double getBalance() {
            return this.balance;
        }
    }
    
    // Main Program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== BASIC BANKING SYSTEM ===");
        System.out.println("============================\n");
        
        // Create ONE bank account as required
        BankAccount myAccount = new BankAccount("BANK001", "Customer");
        
        boolean systemActive = true;
        
        while (systemActive) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. View Account Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit System");
            System.out.print("Select option (1-5): ");
            
            try {
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        myAccount.deposit(depositAmount);
                        break;
                        
                    case 2:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawAmount = scanner.nextDouble();
                        myAccount.withdraw(withdrawAmount);
                        break;
                        
                    case 3:
                        myAccount.displayBalance();
                        break;
                        
                    case 4:
                        myAccount.displayTransactionHistory();
                        break;
                        
                    case 5:
                        System.out.println("\n=== FINAL ACCOUNT SUMMARY ===");
                        myAccount.displayBalance();
                        System.out.println("\nThank you for using Basic Banking System!");
                        systemActive = false;
                        break;
                        
                    default:
                        System.out.println("Invalid option! Please choose 1-5.");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Please enter a valid number!");
                scanner.nextLine(); // Clear invalid input
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}