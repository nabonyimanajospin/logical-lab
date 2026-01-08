# A simple tool to convert Celsius to Fahrenheit
def convert_temp():
    print("--- Temperature Converter ---")
    
    # Get user input and turn it into a number (float)
    celsius = float(input("Enter temperature in Celsius: "))
    
    # The math formula: (Celsius * 9/5) + 32
    fahrenheit = (celsius * 9/5) + 32
    
    print(f"{celsius}°C is equal to {fahrenheit}°F")

# Run the function
convert_temp()
