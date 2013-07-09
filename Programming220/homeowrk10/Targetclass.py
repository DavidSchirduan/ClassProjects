#This program creates the class Target
#This program was completely our own work, and was a collaboration between
#Daniel Spicher, David Schirduan, and Sarah Green


from graphics import *
from math import *
from time import sleep

class Target:
    
    def __init__(self):

        self.quitmove = 0

        self.cenX = 200.0
        self.cenY = 200.0
        self.cenPoint = Point(self.cenX, self.cenY)
        
        self.outermost = Circle(self.cenPoint, 125)
        self.outermost.setOutline("black")
        self.outermost.setFill("White")
        
        self.outer = Circle(self.cenPoint, 100)
        self.outer.setOutline("black")
        self.outer.setFill("black")
        
        self.middle = Circle(self.cenPoint, 75)
        self.middle.setOutline("blue")
        self.middle.setFill("blue")
        
        self.inner = Circle(self.cenPoint, 50)
        self.inner.setOutline("red")
        self.inner.setFill("red")
        
        self.bullseye = Circle(self.cenPoint, 25)
        self.bullseye.setOutline("yellow")
        self.bullseye.setFill("yellow")

    def getCenter(self):
        return self.cenPoint

    def isHit(self, x, y):
        
        testX = abs(x - self.cenX)
        testY = abs(y - self.cenY)

        return testX > 125 and testY > 125

    def Score(self, x, y):
        quad = sqrt((x ** 2) + (y ** 2))
        points = 0

        if quad <= 25:
            points = points + 9
        elif quad <= 50:
            points = points + 7
        elif quad <= 75:
            points = points + 5
        elif quad <= 100:
            points = points + 3
        elif quad <= 125:
            points = points + 1
            
        return points

    def draw(self, win):
        self.outermost.draw(win)
        self.outer.draw(win)
        self.middle.draw(win)
        self.inner.draw(win)
        self.bullseye.draw(win)

    def move(self, win, dx, dy):
        winX = win.getWidth()
        winY = win.getHeight()

        self.cenX = self.cenPoint.getX()
        self.cenY = self.cenPoint.getY()
        
        hitwallX = self.cenX > (winX - 125) and self.cenX < (winX + 125)
        hitwallY = self.cenY > (winY - 125) and self.cenY < (winY + 125)
        
        while self.quitmove == 0:
            self.cenPoint.move(dx, dy)

            self.outermost.move(dx, dy)
            self.outer.move(dx, dy)
            self.middle.move(dx, dy)
            self.inner.move(dx, dy)
            self.bullseye.move(dx, dy)

            if hitwallX:
                dx = dx * -1
                
            elif hitwallY:
                dy = dy * -1

            elif hitwallY and hitwallX:
                dy = dy * -1
                dx = dx * -1

            sleep(.1)
            return dx, dy

        
