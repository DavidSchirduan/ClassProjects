## Discussion #3, p. 159-60

from graphics22 import *

def main():
    win = GraphWin()
    shape = Circle(Point(50, 50), 20)
    shape.setOutline("red")
    shape.setFill("red")
    shape.draw(win)
    for i in range(5):
        p = win.getMouse()
        c = shape.getCenter()
        dx = p.getX() - c.getX()
        dy = p.getY() - c.getY()
        shape.move(dx, dy)
    win.close()

main()
