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
        Well, it's "fiction," depending on the pill color chosen...
        arguments: no arguments (prompted text doesn't count as an argument)
        results: no results     (printing doesn't count as a result)
    """
    delay = 0.0          # change to 0.0 for testing or speed runs,
                         # ..larger for dramatic effect!

    username = input("What do they call you, worthy adventurer? ")

    print()
    print("Welcome,", username, " to the Libra Complex, a labyrinth")
    print("of weighty wonders and unreal quantities...of poptarts!")
    print()

    print("Your quest: To find--and partake of--a poptart!")
    print()
    flavor = input("What flavor do you seek? ")
    if flavor == "strawberry":
        print("Wise! You show deep poptart experience.")
    elif flavor == "s'mores":
        print("The taste of the campfire: well chosen, adventurer!")
    else:
        print("Each to their own, then.")
    print()

    print("On to the quest!\n\n")
    print("A corridor stretches before you; its dim lighting betrays, to one side,")
    print("a table supporting nameless forms of inorganic bulk and, to the other,")
    print("a door ajar, leaking laughter--is that laughter?--of lab-goers.")
    time.sleep(delay)
    print()

    choice1 = input("Do you choose the table or the door? [table/door] ")
    print()

    if choice1 == "table":
        print("As you approach the table, its hazy burdens loom ever larger, until...")
        time.sleep(delay)
        print("...they resolve into unending stacks of poptarts, foil shimmering.")
        print("You succeed, sumptuously, in sating the challenge--and your hunger.")
        print("Go well,", username, "!")

    else:  
        print("You push the door into a gathering of sagefowl, athenas, and stags alike,")
        print("all relishing their tasks. Teamwork and merriment abound here, except...")
        time.sleep(delay)
        print("...they have consumed ALL of the poptarts! Drifts of wrappers coat the floor.")
        print("Dizzy, you grasp for a pastry. None is at hand. You exhale and slip")
        print("under the teeming tide of foil as it finishes winding around you.")
        print("Farewell,", username, ".")
