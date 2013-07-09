#This program moves a square to wherever the user clicks
#David Schirduan

from graphics import *

def main():
    win = GraphWin()
    shape = Rectangle(Point(50,50), Point(100, 100))
    shape.setOutline("red")
    shape.setFill("red")
    shape.draw(win)
    for i in range (10):
        p = win.getMouse()
        c = shape.getCenter()
        dx = p.getX() - c.getX()
        dy = p.getY() - c.getY()
        shape.move(dx, dy)
    words = Text(Point(100, 100), "Click here to quit.")
    words.draw(win)
    end = win.getMouse()
    win.close()
main()
