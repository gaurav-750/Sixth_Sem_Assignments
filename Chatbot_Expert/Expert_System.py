
def rule1(symptoms):
    values = ['fever', 'cough', 'fatigue']

    if all(value in symptoms for value in values):
        return 'You may have flu.'
    return None


def rule2(symptoms):
    values = ['fever', 'rash', 'headache']

    if all(value in symptoms for value in values):
        return 'You may have measles.'
    return None


def rule3(symptoms):
    values = ['pain', 'swelling', 'bruises']

    if all(value in symptoms for value in values):
        return 'You may have fracture.'
    return None


def rule4(symptoms):
    values = ['abdominal pain', 'diarrahea', 'nausea']

    if all(value in symptoms for value in values):
        return 'You may have food poisoning.'
    return None


def rule5(symptoms):
    values = ['shortness of breath', 'chest pain', 'dizziness']

    if all(value in symptoms for value in values):
        return 'You may have a heart attack! Please seek medical attention immediately.'
    return None


def diagnose(symptoms):
    rules = [rule1, rule2, rule3, rule4, rule5]
    results = []

    for rule in rules:
        result = rule(symptoms)
        if result:
            results.append(result)

    if len(results) == 0:
        return 'Sorry..! We could not diagnose your condition.'
    elif len(results) == 1:
        return results[0]
    else:
        return 'You may have multiple conditions: ' + ', '.join(results)


symtoms = []
while True:
    value = input("Enter a value (or 'q' to quit): ")
    if value == 'q':
        break  # Break out of the loop if 'q' is entered
    symtoms.append(value)

result = diagnose(symtoms)
print(result)
