# DeckSOLUTION.py
# Author: RoxAnn H. Stalvey
# Modified by Pharr

from CardSOLUTION import Card
from random import randrange

class Deck:

    def __init__(self):
        self.deck = []
        suits = ["Clubs", "Spades", "Hearts", "Diamonds"]
        for suit in suits:
            for i in range (1, 14):
                c = Card(i, suit)
                self.deck.append(c)
        self.next = 0

    def deal(self):
        if self.next < 52:
            c = self.deck[self.next]
            self.next = self.next + 1
        else:
            c = -1
        return c

    def shuffle(self):
        for rep in range(7):
            for i in range(len(self.deck)):
                ran = randrange(len(self.deck))
                temp = self.deck[i]
                self.deck[i] = self.deck[ran]
                self.deck[ran] = temp
        self.next = 0
                
    def __str__(self):
        out = ""
        for card in self.deck:
            out = out + str(card) + "\n"
        return out

