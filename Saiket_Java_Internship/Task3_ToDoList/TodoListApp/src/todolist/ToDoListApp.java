/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

/**
 *
 * @author Jospin Nabonyimana
 */

import java.util.ArrayList;
import java.util.Scanner;

// TodoListApp.java - Main application class
public class ToDoListApp {
    // Using ArrayList as data structure (as implied by "Lists" in skills)
    private ArrayList<Task> tasks;
    private Scanner scanner;
    
    public ToDoListApp() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    // Method to add a task
    public void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        
        if (!title.trim().isEmpty()) {
            Task newTask = new Task(title);
            tasks.add(newTask);
            System.out.println("Task added successfully!");
        } else {
            System.out.println("Task title cannot be empty!");
        }
    }
    
    // Method to mark a task as complete
    public void markTaskComplete() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available!");
            return;
        }
        
        displayTasks();
        System.out.print("Enter task number to mark as complete: ");
        
        try {
            int taskNumber = Integer.parseInt(scanner.nextLine());
            
            if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                Task task = tasks.get(taskNumber - 1);
                task.markAsComplete();
                System.out.println("Task marked as complete!");
            } else {
                System.out.println("Invalid task number!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
        }
    }
    
    // Method to display all tasks
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Your to-do list is empty!");
            return;
        }
        
        System.out.println("\n=== YOUR TO-DO LIST ===");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println("=======================\n");
    }
    
    // Method to display menu
    public void displayMenu() {
        System.out.println("\n=== TO-DO LIST APPLICATION ===");
        System.out.println("1. Add New Task");
        System.out.println("2. Mark Task as Complete");
        System.out.println("3. View All Tasks");
        System.out.println("4. Exit");
        System.out.print("Choose an option (1-4): ");
    }
    
    // Main program loop
    public void run() {
        int choice;
        
        do {
            displayMenu();
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        markTaskComplete();
                        break;
                    case 3:
                        displayTasks();
                        break;
                    case 4:
                        System.out.println("Goodbye! Your tasks are saved.");
                        break;
                    default:
                        System.out.println("Invalid option! Please choose 1-4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number between 1 and 4!");
                choice = 0;
            }
            
        } while (choice != 4);
        
        scanner.close();
    }
    
    // Main method
    public static void main(String[] args) {
        ToDoListApp app = new ToDoListApp();
        app.run();
    }
}
