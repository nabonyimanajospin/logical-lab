/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jospin Nabonyimana
 */
import java.io.*;
import java.util.*;

public class TextFileAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== TEXT FILE ANALYZER ===");
        System.out.print("Enter file name (must be in src folder): ");
        String fileName = scanner.nextLine();
        
        try {
            // Read file from src folder
            File file = new File("src/" + fileName);
            Scanner fileScanner = new Scanner(file);
            
            int lines = 0, words = 0, chars = 0;
            
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                lines++;
                chars += line.length();
                words += line.split("\\s+").length;
            }
            
            fileScanner.close();
            
            System.out.println("\n=== RESULTS ===");
            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Characters: " + chars);
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found in src folder!");
            System.out.println("Make sure " + fileName + " is in the src/ folder");
        }
        
        scanner.close();
    }
}