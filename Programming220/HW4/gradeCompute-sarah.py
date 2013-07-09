##<Sarah Green>
##<gradeCompute.py>
##
##<This program is going to ask the user for the name of the grade file.
##Then, it processes the grade file to compute both student averages and the
##overall class average.   The program will then ask the user for the name of
##an output file.>
##
##<I vertify that this lab is entirely my own work>

import string

def main():
    print "the purpous of this assignment is to find the average of students grade and have it put into an output file"


    infile = open("grade.txt", "r")
    outfile = open("averages.txt","w")


    for line in infile:

        lines = line

        spltstr = string.split(lines)
        

        fname = spltstr[1]
        lname= spltstr[0]
        name = lname + "," + fname
        


        print name
        


main()
