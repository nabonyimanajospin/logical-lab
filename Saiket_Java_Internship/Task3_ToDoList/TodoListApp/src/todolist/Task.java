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
//This Task.java represents one task item
public class Task {
    // Attributes as specified in instructions
    private String title;
    private boolean isCompleted;
    
    // Constructor
    public Task(String title) {
        this.title = title;
        this.isCompleted = false; // Default status is incomplete
    }
    
    // Getters and Setters
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public boolean isCompleted() {
        return isCompleted;
    }
    
    // Method to mark task as complete
    public void markAsComplete() {
        this.isCompleted = true;
    }
    
    // Method to mark task as incomplete
    public void markAsIncomplete() {
        this.isCompleted = false;
    }
    
    // Display task in readable format
    @Override
    public String toString() {
        String status = isCompleted ? "[✓]" : "[ ]";
        return status + " " + title;
    }
}