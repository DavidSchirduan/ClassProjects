#this program creates a target game with a moving target
#This program creates a target game
#This program was completely our own work, and was a collaboration between
#Daniel Spicher, David Schirduan, and Sarah Green
from graphics import *
from math import *
from Targetclass import Target
from time import sleep

def main():
    win = GraphWin("Target game", 500, 500)

    count = 0
    score = 0

    clickX = win.mouseX
    clickY = win.mouseY
    prevX = 0
    prevY = 0


    target1 = Target()

    target1.draw(win)
    text = Text(Point(200,350), "Click to start the game")
    text.draw(win)

    while clickX == None:
        startpt = win.getMouse()
        clickX = startpt.getX()
        clickY = startpt.getY()
        prevX = clickX
        prevY = clickY
        text.undraw()


    while count <= 5:
        target1.move(win, 1, 1)
        clickX = win.mouseX
        clickY = win.mouseY
        print str(clickX) + ", " + str(clickY)
        sleep(.1)
        
        if clickX != prevX and clickY != prevY:        
            if target1.isHit(clickX, clickY):
                score = score + self.score(clickX, clickY)
                count = count + 1
            else:
                count = count + 1
        prevX = ClickX
        prevY = clickY

    text.setText("Your score was:" + str(score))
    text.draw(win)

    
    
main()

    
