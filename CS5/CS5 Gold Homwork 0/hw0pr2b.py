# coding: utf-8
#
# hw0pr2b.py
#

""" 
Title for your adventure:   The Quest.

Notes on how to "win" or "lose" this adventure:
  To win, choose the table.
  To lose, choose the door.

"""

import time

def adventure():
    """ this function runs one session of interactive fiction
    """

    username = input("Hello! what is your name? ")
    print("Hey ", username)
    time.sleep(1)
    print()
    print("Lets go on an adveture!!!")
    time.sleep(1.5)
    print()
    print("It is 2043, and you have the opprotunity to buy a car!!!")
    print()
    time.sleep(1)
    car = input("Do you wish to get a ferrari or a lambo? ")
    print()
    print(car, "???")
    time.sleep(1)
    print()
    if(car == "ferrari"): 
      print("sweet...")
    elif(car == "lambo"):
      print("booooo...")
    else: 
      print("uh... ")
      print()
      time.sleep(2)
      print("ok...")
    print()
    time.sleep(1)
    choice = input("Now you can either race it, paint it, or upgrade it: ")
    print()
    time.sleep(0.5)
    if(choice == "race it"):
      print("good luck!!!")
    elif(choice == "paint it"):
      print("how exciting!!!")
    elif(choice == "upgrade it"):
      print("you should put wings on it!!!")
      time.sleep(0.5)
      print()
      print("lol")
    else:
      print("Sorry... not an option")
      return
    time.sleep(1)
    print()
    newChoice = input("U still with me??? ")
    print()
    time.sleep(1)
    if(newChoice == "yeah"):
      print("Great!!!")
    else:
      print("k bye...")
      return
    time.sleep(1)
    print()
    print("A few years past and your kind of getting old of the car... ")
    time.sleep(1)
    sell = input("Do you still with to sell it? ")
    time.sleep(1)
    print()
    if(sell == "yes"):
      print("RIP car...")
      return
    elif(sell != "yes"):
      print("Yay!!! you still have to stick with the old", car)
    time.sleep(1)
    print()
    ret = input("You are now dying... Do you wish to eat rotten food for the rest of your life and live forever? or naw??? (yes/no) ")
    print()
    time.sleep(1)
    if(ret == "sure"):
      print("OK!!!")
    time.sleep(1)
    print()
    print("You die.")
    return
