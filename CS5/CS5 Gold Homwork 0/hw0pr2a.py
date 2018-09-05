# coding: utf-8
#
# hw0pr2a.py
#

import random          # imports the library named random

def rps():
    """ this plays a game of rock-paper-scissors
        (or a variant of that game)
        arguments: no arguments    (prompted text doesn't count as an argument)
        results: no results        (printing doesn't count as a result)
    """
    user = input("Choose your weapon: ")
    comp = random.choice(['rock','paper','scissors'])
    print()

    print('The user (you)   chose', user)
    print('The computer (I) chose', comp)
    print()

    if user == 'rock' and comp == 'paper':
        print('Ha! I WIN!')
    if user == 'paper' and comp == 'scissors':
        print('Ha! I WIN!')
    if user == 'scissors' and comp == 'rock':
        print('Ha! I WIN!')
    if user == 'rock' and comp == 'scissors':
        print('No! You WIN!')
    if user == 'scissors' and comp == 'paper':
        print('No! You WIN!')
    if user == 'paper' and comp == 'rock':
        print('No! You WIN!')
    if user == comp:
      print("Yeah!!! It's a Tie!!")

    print("Better luck next time...")
