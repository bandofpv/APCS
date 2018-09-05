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
