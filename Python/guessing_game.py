import random

def start_game():
    print("--- Welcome to the Number Guessing Game! ---")
    secret_number = random.randint(1, 100)
    attempts = 0
    
    while True:
        try:
            guess = int(input("Guess a number between 1 and 100: "))
            attempts += 1

            if guess < secret_number:
                print("Too low! Try again.")
            elif guess > secret_number:
                print("Too high! Try again.")
            else:
                print(f"Congratulations! You found it in {attempts} attempts.")
                break
        except ValueError:
            print("Please enter a valid whole number.")

# Run the game
start_game()
