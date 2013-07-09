# -*- coding: utf-8 -*-
def main():

##loop A
    print "loop A:"
    for i in range(8):
        print i

##loop B
    print "loop B:"
    for i in [1, 3, 9]:
        print i
	
##loop C
    print "loop C:"
    for i in range(-1):
        print i
	
##loop D
    print "loop D:"
    sum = 0
    for i in range(5):
        sum = sum + i
    print sum
    
##loop E
    print "loop E:"
    power = 2
    for i in [2, 4, 6]:
        print i ** power
    
##loop F
    print "loop F:"
    difference = 0
    for i in [1, 8, -2, 15, 0]:
        difference = difference - i
        print difference
    
##loop G
    print "loop G:"
    product = 1
    for i in range(4):
        product = product * i
    print product
    
##loop H
    print "loop H:"
    product = 1
    for i in [1, 3, 5]: 
        product = product * i
        print product
main()
