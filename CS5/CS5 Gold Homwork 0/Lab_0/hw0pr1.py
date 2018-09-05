# CS5 Gold/Black: Lab 0, Problem 1
# Filename: hw0pr1.py
# Name: Andrew Bernas
# Problem description: The four fours challenge!

from math import *

print("Zero is", 4+4-4-4)
print("One is", (4+4)/(4+4))
print("Two is", (4/4)+(4/4))
print("Three is", (4+4+4)/4)
print("Four is", 4*(4-4)+4)
print("Five is", (4*4+4)/4)
print("Six is", 4*.4+4.4)
print("Seven is", 44/4-4)
print("Eight is", 4+4.4-.4)
print("Nine is", 4/4+4+4)
print("Ten is", 44/4.4)
print("Eleven is", 4/.4+4/4)
print("Twelve is", (44+4)/4)
print("Thirteen is", factorial(4)-44/4)
print("Fourteen is", 4*(4-.4)-.4)
print("Fifteen is", 44/4+4)
print("Sixteen is", .4*(44-4))
print("Seventeen is", 4/4+4*4)
print("Eighteen is", 44*.4+.4)
print("Nineteen is", factorial(4)-4-4/4)
print("Twenty is", 4*(4/4+4))

# coding: utf-8
#
# hw0pr2.py
#

import time          # includes a library named time
import random        # includes a library named random


def rps():
  """ this plays a game of rock-paper-scissors 
  (or a variant of that game ...)
  inputs: no inputs    (prompted text doesn't count as input)
  outputs: no outputs  (printing doesn't count as output)
  """
  
  name = input('Hi...what is your name? ')
  print("Hmmm...")
  time.sleep(1)
  
  if name == 'Bob' or name == 'Fred':
    print('I\'m "offline" Try later.')
    
  elif name == 'Andrew':
    print('Do you mean Jeff?')
    time.sleep(1)
    print('No?')
    time.sleep(1)
    print('Oh.')
    print("Welcome ", name)
    my_choice = random.choice(['rock','paper','scissors'])
    print('By the way, I choose ', my_choice)
