# CardSOLUTION.py
# Author: RoxAnn H. Stalvey
# Modified by Pharr

class Card:

    def __init__(self, value, suit):
        if value >= 1 and value <= 13:
            self.value = int(value)
        else:
            self.value = 1
        if self.validSuit(suit):
            self.suit = suit
        else:
            self.suit = "Spades"

    def getFaceValue(self):
        return self.value

    def getSuit(self):
        return self.suit

    def validSuit(self, suit):
        suits = ["Spades", "Hearts", "Clubs", "Diamonds"]
        return suit in suits

    def __str__(self):
        values = ["Ace",2,3,4,5,6,7,8,9,10,"Jack","Queen","King"]
        return str(values[self.value-1]) + " of " + self.suit
