#draws an archery target

from graphics import *

def main():
    win = GraphWin()
    shape1 = Circle(Point(100,100), 100)
    shape1.setOutline("black")
    shape1.setFill("White")
    shape1.draw(win)
    shape2 = Circle(Point(100,100), 75)
    shape2.setOutline("black")
    shape2.setFill("black")
    shape2.draw(win)
    shape3 = Circle(Point(100,100), 50)
    shape3.setOutline("blue")
    shape3.setFill("blue")
    shape3.draw(win)
    shape4 = Circle(Point(100,100), 25)
    shape4.setOutline("red")
    shape4.setFill("red")
    shape4.draw(win)
    shape5 = Circle(Point(100,100), 5)
    shape5.setOutline("yellow")
    shape5.setFill("yellow")
    shape5.draw(win)

main()
