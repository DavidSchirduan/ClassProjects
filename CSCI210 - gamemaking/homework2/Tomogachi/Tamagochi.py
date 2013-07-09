################################################################################
# Tamagochi.py      version 1.0     Dana Hughes     18-February-2012
#
# Edited by David Schirduan   3/18/12
# changed sleep wait time to .1 seconds to speed up debugging and testing
#
# Create the behavior of a simple Tamagochi.  The behavior is defined in two
# methods, updateTamagochiState and tamagochiAct.

from TamagochiGame import *


############################ METHODS TO DEFINE #################################

def initializeTamagochi():
    """
    Set the initial state of the Tamagochi, and give it some food.
    """

    global tamagochiState      # Do not delete this part
    global nutrition           # or this part

    pass

    nutrition = 100    #Full in beginning    

def updateTamagochiState():
    """
    Based on whether there is food or a toy present, change the state of the
    Tamagochi
    """

    global tamagochiState      # Do not delete this part
    global nutrition           # or this part

    pass

    nutrition = nutrition - 3 #decrease nutrition each turn

    if game.seeFood() > 0 nutrition < 100: #eat above all else
        print "Tomagochi is eating!"
    elif nutrition <= 25:
        print "Tomagochi is hungry!"
    else:
        if game.seeToy():   #play
            print "Tomagochi is playing!"
        else:               #bored is default state
            print "Tomogachi is bored."


def tamagochiAct():
    """
    Based on the state the tamagochi is in, do something (and print it to the
    screen)
    """

    global tamagochiState      # Do not delete this part
    global nutrition           # or this part

    pass

    #always eat the food if present
    if game.seeFood() > 0:
        nutrition = nutrition + game.eat()

    ##these make sure no unnecessary values fill nutrition
    if nutrition > 100:
        nutrition = 100
    elif nutrition < 0:
        nutrition = 0

    #these were used for debug purposes
    #print str(nutrition) + " nutrition"
    #print str(game.amountOfFood) + " pellets left"


if __name__ == "__main__":

    # Set up the pet and game
    initializeTamagochi()               
    game = TamagochiGame(updateTamagochiState, tamagochiAct)
    game.gameLoop()                     # And loop until complete
