import random

def dice_roller():
    print("=== Welcome to the dice roller ===")
    
    while True:
        # I use random.randint to get a number
        number = random.randint(1, 6)
        print(f"You rolled a: {number}")
        
        # This stops the loop so it doesn't run forever
        user_input = input("Press Enter to roll again or type 'q' to quit: ")
        if user_input.lower() == 'q':
            break

dice_roller()
