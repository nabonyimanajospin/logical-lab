# A simple script to count words in a sentence
text = input("Paste your sentence here: ")

# Split the sentence into a list of words and count them
word_count = len(text.split())

print(f"Your sentence has {word_count} words!")
