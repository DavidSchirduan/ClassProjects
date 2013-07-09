## David Schirudan
## Weights.py
## 06/09/09
## Problem: find the average of 3 weights entered, and output in pounds
## and in Kilograms
## Certification of Authenticity:  
##   I certify that this lab is entirely my own work.

##1.What will the program do?
##2.What will be the inputs and outputs?
##3.Provide a step-by-step list of what your
##program must do, aka an algorithm.  (Remember this is in English!)

##1.    The program takes the average of the 3 weights
##      that are entered (in grams), and will convert
##      the average to pounds and kilgrams

##2.    Inputs will be the 3 weights (in grams)
##      Outputs will be the average of the 3 items
##      in kilograms and pounds.

##3.    1) ask the user to input 3 values
##      2) take the average of the 3 values
##      3) convert the value to kilograms (g / 1000 = kg)
##      4) output value
##      5) also convert the value to pounds (kg * 2.2 = lbs)
##      6) output value. 

def main():

    print "You have been stranded on an island."
    print "You can only bring three things with you."
    print "Please enter their respective weights in grams."

    item1 = input("1st item: ")
    item2 = input("2nd item: ")
    item3 = input("3rd item: ")

    average = (item1 + item2 + item3) / 3.0
    total = item1 + item2 + item3
    kilograms = average / 1000.0
    totalkilograms = total / 1000.0
    pounds = kilograms  * 2.2
    totalpounds = totalkilograms * 2.2
    
    print "The total weight of your items in Kilograms is:", totalkilograms, "kg."
    print "Which is an average of:", kilograms, "kg."
    print "For those of you in the US, that is equal to a total of:", totalpounds, "lbs."
    print "And an average of:", pounds, "lbs."
main()
