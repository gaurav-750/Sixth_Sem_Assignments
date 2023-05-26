import re
import random

rules = {
    'greeting': {
        'patterns': [r'hello', r'hi', r'hey'],
        'responses': [r'Hello! Welcome to our food ordering service.', r'Hi there! How can I assist you with your order?']
    },
    'menu': {
        'patterns': [r'Give me the menu', r'what do you have', r'what is on the menu', r'what can i order', r'menu'],
        'responses': ['Sure! Here is our menu: \n 1. Pav Bhaji \t Rs.35 \n 2. Vada Pav \t Rs.15 \n 3. Chai \n 4. Cheese Masala Dosa \
                    \n 5. Special Bhel \n 6. PaniPuri \n 7. Samosa \n 8. Idli \n 9. Dahi Vada \n 10. Upma \n 11. Misal Pav']
    },
    'order': {
        'patterns': [r'i want to order', r'can i order', r'can i place an order', r'place an order', r'order'],
        'responses': ['Sure! What would you like to order?', 'Great! Please let me know what you would like to order.']
    },
    'food items': {
        'patterns': [r'pav bhaji', r'vada pav', r'chai', r'cheese masala dosa', r'special bhel', r'panipuri', r'samosa', r'idli', r'dahi vada', r'upma', r'misal pav'],
        'responses': ['Do you want to confirm your order?']
    },
    'confirm_order': {
        'patterns': [r'yes', r'yeah', r'ok', r'confirm', r'confirm order'],
        'responses': ['Cool! Your order has been placed. The estimated delivery time is approximately 30 minutes.']
    },
    'cancel_order': {
        'patterns': [r'cancel order', r'change', r'change order', r'cancel'],
        'responses': ['I apologize for the inconvenience. Please contact our customer support for order modification.'
                      'Certainly! Please feel free to contact our customer support for order modification.']
    },
    'gratitude': {
        'patterns': [r'thank you', r'thanks', r'great', r'awesome', r'cool', r'good'],
        'responses': ['You are welcome!', 'My pleasure!', 'Glad to help!']
    },
    'goodbye': {
        'patterns': [r'bye', r'goodbye', r'see you', r'cya', r'catch you later'],
        'responses': ['Bye! Have a great day!', 'See you soon!', 'Sure! Have a nice day!']
    },
    'default': {
        'responses': ['I am sorry, I did not understand that. Could you please rephrase your query?']
    }
}


def does_pattern_matches(user_input, patterns):
    for pattern in patterns:
        match = re.search(pattern, user_input, re.IGNORECASE)
        if match:
            return True

    return False


def get_response(user_input):
    for intent, data in rules.items():
        patterns = data.get('patterns')

        if patterns and does_pattern_matches(user_input, patterns):
            # print('patterns', patterns)
            responses = data['responses']
            return random.choice(responses)

    # if pattern does not match
    return random.choice(rules['default']['responses'])


# Conversation loop
def chat():
    print('Chatbot: Hello! Welcome to our food ordering service.')

    while True:
        user_input = input('User: ')
        response = get_response(user_input)
        print('Chatbot: ', response)

        if any(re.search(pattern, user_input, re.IGNORECASE) for pattern in rules['goodbye']['patterns']):
            break


chat()
