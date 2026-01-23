# A simple dictionary that maps words to emojis
emoji_map = {
    "happy": "😊",
    "sad": "😢",
    "pizza": "🍕",
    "fire": "🔥",
    "dog": "🐶"
}

print("--- Emoji Translator ---")
word = input("Type a word (happy, sad, pizza, fire, dog): ").lower()

# Look up the word in our dictionary
translation = emoji_map.get(word, "Unknown word"

print(f"The emoji for {word} is: {translation}"
