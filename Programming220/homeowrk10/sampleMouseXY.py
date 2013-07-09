from graphics import *
from time import sleep

def main():
   win = GraphWin("MouseX/Y", 400, 400)

   upXY = 100
   loXY = 200
   p1 = Point(upXY, upXY)
   p2 = Point(loXY, loXY)
   square = Rectangle(p1,p2)
   square.draw(win)

   text = Text(Point(200,350), "Click the window")
   text.draw(win)
   clickX = 0
   clickY = 0
   
   while clickX == None:
      text.setText("You have not clicked the window.")
      clickX = win.mouseX
      sleep(.1)
##      print clickX

   text.setText("Thanks for clicking. Click in the square to quit.")

   clickX = win.mouseX
   clickY = win.mouseY   
   isClicked = clickX < upXY and clickX > loXY
   isClicked = isClicked and clickY < upXY and clickY > loXY
      
   while not isClicked:
      text.setText("You haven't clicked the square")
      clickX = win.mouseX
      clickY = win.mouseY
      print str(clickX) + ", " + str(clickY)
      isClicked = clickX > upXY and clickX < loXY
      isClicked = isClicked and clickY > upXY and clickY < loXY
      sleep(.1)
      clickX = 0
      clickY = 0

   win.close()

main()


