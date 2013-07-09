#this program draws a square from 2 points inputted by the user, and then
#prints info about the rectangle
#David Schirduan

from graphics import *
from math import *



def main():

    
    win = GraphWin("", 500, 500)
    p1 = win.getMouse()
    x1 = p1.getX()
    y1 = p1.getY()
    p2 = win.getMouse()
    x2 = p2.getX()
    y2 = p2.getY()
    rect = Rectangle(p1, p2)
    rect.draw(win)

    length = abs(y1 - y2)
    height = abs(x1-x2)

    area = length * height

    perimeter = 2 * (length + height)

    perimeter = str(perimeter)
    area = str(area)

    info = "The area is: " + area + ", and the perimeter is: " + perimeter
        
    words = Text(Point(250, 430), info)
    words.draw(win)
    wordsfin = Text(Point(250, 450), "Click to close.")
    wordsfin.draw(win)
    end = win.getMouse()    
    win.close()
main()
