PROJECT: Temperature Converter
INTERN: Jospin Nabonyimana  
DATE: January 8, 2026
COMPANY: SaiKet Systems - Java Development Internship

ABOUT THIS PROJECT:
This program helps users convert temperatures between Celsius and Fahrenheit.
It's a practical tool that demonstrates basic Java input/output operations
and mathematical formula implementation in code.

KEY FEATURES:
1. Simple menu system for choosing conversion type
2. Accurate conversion formulas (C to F and F to C)
3. Error handling for invalid numeric inputs
4. Clean, formatted output with degree symbols

WHAT I LEARNED:
- Implementing mathematical formulas in Java
- Creating user-friendly console interfaces
- Using Scanner class for user input
- Formatting double values to 2 decimal places
- The importance of testing edge cases

CHALLENGES & SOLUTIONS:
1. CHALLENGE: Getting the formula wrong initially - I mixed up 9/5 and 5/9
   SOLUTION: Tested with known values (0°C=32°F, 100°C=212°F) to verify
   
2. CHALLENGE: Output showed too many decimal places (e.g., 32.0000000)
   SOLUTION: Used System.out.println with "%.2f" to format to 2 decimals
   
3. CHALLENGE: Program crashed when user entered text instead of numbers
   SOLUTION: Added try-catch block to handle InputMismatchException

HOW TO RUN:
1. Compile: javac TemperatureConverter.java
2. Run: java TemperatureConverter
3. Choose option 1 or 2 and enter temperature value

TEST WITH THESE VALUES:
- 0°C should equal 32°F
- 100°C should equal 212°F
- -40°C should equal -40°F (interesting crossover point!)

This is my original work for Task 2 of my internship.