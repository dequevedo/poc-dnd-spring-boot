import csv
import random
from enum import Enum


class Race(Enum):
    HUMAN = 'Human'
    ELF = 'Elf'
    DWARF = 'Dwarf'
    ORC = 'Orc'


class Gender(Enum):
    MALE = 'Male'
    FEMALE = 'Female'


def generate_character():
    name = f"Character{random.randint(1, 1000)}"
    age = random.randint(1, 100)
    race = random.choice(list(Race)).value
    gender = random.choice(list(Gender)).value
    return [name, age, race, gender]


def write_characters_to_csv(filename, num_characters):
    with open(filename, mode='w', newline='', encoding='utf-8') as file:
        writer = csv.writer(file)
        writer.writerow(['Name', 'Age', 'Race', 'Gender'])

        for _ in range(num_characters):
            writer.writerow(generate_character())


num_characters = 30000
filename = 'characters.csv'

write_characters_to_csv(filename, num_characters)
print(f"{num_characters} characters saved to {filename}")
