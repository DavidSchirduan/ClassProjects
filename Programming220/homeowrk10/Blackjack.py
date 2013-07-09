#This program lets the user play blackjack against a basic AI
# using the deck and card classes. Text only

from CardSOLUTION import Card
from DeckSOLUTION import Deck

class Blackjack:

    def __init__(self):

        self.playerhand = []
        self.playervalue = 0
        self.comphand = []
        self.compvalue = 0

    def play(self):
        deck1 = Deck()
        deck1.shuffle()
##        deck1 = deck1.shuffle()
        ##Deals two cards at beginning of round
        realcardvalue = 0
        for i in range(2):
            self.playerhand.append(deck1.deal())
            self.comphand.append(deck1.deal())
            
        ##Adds cards in player's hand
        print "The current cards in your hand are:"
        for card in self.playerhand:
            if card.getFaceValue() > 10 and card.getFaceValue() < 14:
                realcardvalue = 10
            else:
                realcardvalue = card.getFaceValue()
            
            print card
            self.playervalue = self.playervalue + realcardvalue

        ##adds cards in comphand
        for card in self.comphand:
            if card.getFaceValue() > 10 and card.getFaceValue() < 14:
                realcardvalue = 10
            else:
                realcardvalue = card.getFaceValue()
            self.compvalue = self.compvalue + realcardvalue
        ##gives player choice to hit or stay
        playercommand = raw_input("hit or hold?: ")

        while playercommand != "hold" and self.playervalue <= 21:
            self.playerhand.append(deck1.deal())
            
        ##recalculates playerhand
            self.playervalue = 0
            print "The current cards in your hand are:"
            for card in self.playerhand:
                if card.getFaceValue() > 10 and card.getFaceValue() < 14:
                    realcardvalue = 10
                elif card.getFaceValue() == 1:
                    realcardvalue = 11
                else:
                    realcardvalue = card.getFaceValue()
                print card
                self.playervalue = self.playervalue + realcardvalue
                
        ## deals with the friggin aces!
            for card in self.playerhand:
                if card.getFaceValue() == 1 and self.playervalue > 21:
                    self.playervalue = self.playervalue - 10
                    
            playercommand = raw_input("hit or hold?: ")
        
        if self.playervalue > 21:
            print "You bust!"

        ##calculates computers hand....hit's until >= 15 or bust
        while self.compvalue < 15:
            self.comphand.append(deck1.deal())
            self.compvalue = 0
            for card in self.comphand:
                if card.getFaceValue() > 10 and card.getFaceValue() < 14:
                    realcardvalue = 10
                elif card.getFaceValue() == 1:
                    realcardvalue = 11
                else:
                    realcardvalue = card.getFaceValue()
                self.compvalue = self.compvalue + realcardvalue
            ## deals with the friggin aces!
            for card in self.comphand:
                if card.getFaceValue() == 1 and self.compvalue > 21:
                    self.compvalue = self.compvalue - 10

        if self.compvalue > 21:
            print "Dealer bust!"

        if self.compvalue >= self.playervalue and self.compvalue <= 21:
            print "You lose"
            print "The dealers hand was:"
            for card in self.comphand:
                print card
        elif self.playervalue >= self.compvalue and self.playervalue <= 21:
            print "You win!"
            print "The dealers hand was:"
            for card in self.comphand:
                print card
