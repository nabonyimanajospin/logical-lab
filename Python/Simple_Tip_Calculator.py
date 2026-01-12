# Simple Tip Calculator
def calculate_tip():
    # 1. Get the bill amount
    bill = float(input("What is the total bill? $"))
    
    # 2. Calculate 15% tip
    tip = bill * 0.15
    
    # 3. Show the result
    print(f"A 15% tip is: ${tip:.2f}")
    print(f"Total with tip: ${bill + tip:.2f}")

calculate_tip()
