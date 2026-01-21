# A simple program to manage a task list
tasks = []

print("--- Your To-Do List ---")

# 1. Ask the user for 3 tasks
task1 = input("Enter your first task: ")
task2 = input("Enter your second task: ")
task3 = input("Enter your third task: ")

# 2. Add them to the list
tasks.append(task1)
tasks.append(task2)
tasks.append(task3)

# 3. Print the final list
print("\nHere is your list for today:")
print(tasks)
