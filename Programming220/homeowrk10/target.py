## Name: David Schirduan
## target.py
##
## Problem: makes a target and gives points based on which target was clicked  
## I certify that this lab is entirely my own work.
##

from graphics import *
from math import *

def main():
    
    win = GraphWin("Target Practice", 500, 500)
    cenPoint = Point(250, 250)
    shape1 = Circle(cenPoint, 125)
    shape1.setOutline("black")
    shape1.setFill("White")
    shape1.draw(win)
    shape2 = Circle(cenPoint, 100)
    shape2.setOutline("black")
    shape2.setFill("black")
    shape2.draw(win)
    shape3 = Circle(cenPoint, 75)
    shape3.setOutline("blue")
    shape3.setFill("blue")
    shape3.draw(win)
    shape4 = Circle(cenPoint, 50)
    shape4.setOutline("red")
    shape4.setFill("red")
    shape4.draw(win)
    shape5 = Circle(cenPoint, 25)
    shape5.setOutline("yellow")
    shape5.setFill("yellow")
    shape5.draw(win)

    scoreDisplay = Text(Point(410, 200), "Score: 0")
    scoreDisplay.draw(win)
    currentPoints = Text(Point(250, 100), "Click the target")
    currentPoints.draw(win)
    finalMessage = Text(Point(250, 400), "")
    finalMessage.draw(win)
    accuracytext = Text(Point(250, 50), "")
    accuracytext.draw(win)
    countertext = Text(Point(60, 300), "Arrows Left: 10")
    countertext.draw(win)

    counter = 1
    points = 0
    while counter <= 10 and points < 50:
        counter = counter + 1
        strcounter = str(12 - counter)
        countertext.setText("Arrows Left: " + strcounter)
        clickPoint = win.getMouse()
        clickX = clickPoint.getX()
        clickY = clickPoint.getY()
        testX = abs(clickX - 250.0)
        testY = abs(clickY - 250.0)

        quad = sqrt((testX ** 2) + (testY ** 2))

        if quad <= 25:
            currentPoints.setText("Bullseye! You just scored 9 points!")
            points = points + 9
            pointstr = str(points)
            scoreDisplay.setText("Score: " + pointstr)
        elif quad <= 50:
            currentPoints.setText("Good job, you just scored 7 points!")
            points = points + 7
            pointstr = str(points)
            scoreDisplay.setText("Score: " + pointstr)
        elif quad <= 75:
            currentPoints.setText("Nice, You just scored 5 points.")
            points = points + 5
            pointstr = str(points)
            scoreDisplay.setText("Score: " + pointstr)
        elif quad <= 100:
            currentPoints.setText("You just scored 3 points.")
            points = points + 3
            pointstr = str(points)
            scoreDisplay.setText("Score: " + pointstr)
        elif quad <= 125:
            currentPoints.setText("You only scored 1 point :(")
            points = points + 1
            pointstr = str(points)
            scoreDisplay.setText("Score: " + pointstr)
        else:
            currentPoints.setText("Try clicking INSIDE the target!")
            points = points + 0
            pointstr = str(points)
            scoreDisplay.setText("Score: " + pointstr)    
        
    if points >= 50:
        finalMessage.setText("You have beaten the game! Now go outside!")
    else:
        loss = str(50 - points)
        finalMessage.setText("You needed " + loss + " more points to win the game\nseriously, how can you not get 50 points?")

    countertext.setText("Click to close.")
    currentPoints.setText("")
    accuracy = points * 100 / ((counter - 1.0)  * 9.0)
    counter = str(counter - 1)
    accuracytext.setText("Your accuracy with " + counter + " arrows was " + "%0.2f" % (accuracy) + "%")
    win.getMouse()
    win.close()
main()
