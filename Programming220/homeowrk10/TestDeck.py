#Test of Deck

from DeckSOLUTION import Deck
from CardSOLUTION import Card


def main():

    deck1 = Deck()
    deck1.shuffle()
    print deck1

    print "----------------------------"
    
    

    print "-------------------------------"

    hand2 = []
    hand2.append(deck1.deal())
    for card in hand2:
        print card
        print str(card.getFaceValue())
    
main()
