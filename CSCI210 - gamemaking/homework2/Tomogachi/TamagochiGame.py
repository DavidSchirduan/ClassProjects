################################################################################
# TamagochiGame.py      version 1.0     Dana Hughes     18-February-2012
#
# Runs a simple Tamagochi type game in the console.  Essentially, this is a
# game loop which runs once a second.  During each loop, user input is
# checked, the state of the Game is updated (based on user input), and the state
# of the Tamagochi is updated, based on the current state of the Game.
#

############################ REQUIRED MODULES ##################################

import time                # Allow proper delay for loops
from Tamagochi import *    # Import Tamagochi behavior

import sys
if sys.version_info >= (3,0):
  raw_input = input        # 3.0 and above uses input, 2.x uses raw_input

class TamagochiGame:

  ############################ GAME VARIABLES ####################################

  def __init__(self, update, act):

    # Create some variables to keep track of whether a toy is present, and how much
    # food is available.

    self.isToyPresent = False       # Start out with no toy in the game (True or False)
    self.amountOfFood = 0           # Start out with no food in the game (0-100)

    # In order for the keyboard input to be communicated to the game loop, a
    # variable keeping track of the last key pressed will be needed.  The user input
    # "loop" will set this variable to the last key pressed, and the game loop will
    # "consume" this input and act appropriately.  A "consumed" input resets the
    # variable to None (empty)

    self.lastKeyPressed = None

    self.update = update
    self.act = act

  ########################### USER INPUT THREAD ##################################

  def getUserInput(self):
    """
    This procedure continually asks the user for input, and updates the
    lastKeyPressed variable based on the input.
    """

    userInput = None

    # For now, use raw_input.  Not the cleanest / nicest way to do things,
    # but allows for use in IDLE, doesn't require pyglet or curses modules.

    userInput = raw_input("[F]ood / [T]oy / [N]othing / [Q]uit >> ")

    if len(userInput) > 0:         # User entered something
        userInput = userInput[0]   # Only interested in the first character
        userInput = userInput.upper()     # Upper case
    else:                          # User hit return (length of input == 0)
        userInput = None

    # Update lastKeyPressed to reflect what the user input

    self.lastKeyPressed = userInput

        
  ############################## MAIN GAME LOOP ##################################

  def gameLoop(self):
    """
    The main loop of the game simply checks the user input, updates the game
    model and update the Tamagochi model.
    """

    waitCount = 0

    while(self.lastKeyPressed != 'Q'):          # Keep going until user presses 'Q'
      
        # Check user input

        if self.lastKeyPressed != None:         # The user pressed a key

            # Which key?

            if self.lastKeyPressed == 'F':       # Add food / set to 100
                self.amountOfFood = 100
                print ("Food pellets added!  Food = 100")
                
            elif self.lastKeyPressed == 'T':     # Add / remove toy
                if self.isToyPresent:            # Is there already a toy?
                    self.isToyPresent = False    # Take it away
                    print ("Toy taken away...")
                else:
                    self.isToyPresent = True     # Otherwise, put the toy in
                    print ("Toy added!")

            else:                           # Not one of these keys?  Ignore.
                pass

            # Regardless of the last key pressed, it must be "consumed", so that
            # food isn't continually added.

            self.lastKeyPressed = None


        # Update Tamagochi STATE (get hungry, bored, etc.)

        #updateTamagochiState()
        self.update()

        # Have Tamagochi perform an action (eat / play)

        #tamagochiAct()
        self.act()

        # Wait 1 a second

        time.sleep(.1)

        # Get user input every 5 seconds

        waitCount = waitCount + 1     # We waited a second
        waitCount = waitCount % 5     # Mod this with 5
        if waitCount == 0:            # If no remainder = 5 seconds!
            self.getUserInput()

        # END OF GAME LOOP


################################ HELPER FUNCTIONS ##############################


  def seeFood(self):
    """
    Returns True if food is present
    """

    return self.amountOfFood > 0


  def seeToy(self):
    """
    Returns True if a toy is present
    """

    return self.isToyPresent


  def eat(self):
    """
    If there is food, consume a pellet, and return how many pellets were eaten
    """

    if self.amountOfFood > 0:                   # There's still food left!
        self.amountOfFood = self.amountOfFood - 5    # Eat a pellet of food
        return 5                           # And let the caller know

    else:
        return 0                           # There's no food to eat!





    
