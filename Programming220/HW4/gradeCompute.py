##
## Name: David Schirduan
## gradeCompute.py
##
## Problem: calulates the averages from a text file, and writes them to anoth file
## Certification of Authenticity:  
##   I certify that this lab is entirely my own work.
##
import string
def main():

    readfile = raw_input("What is the name of the file where your grades are stored? ")
    writefile = raw_input("What is the name of the file you would like to save the results in? ")

    infile = open(readfile, "r")
    outfile = open(writefile, "w")

    Var = 0

    classavg = 0

#splits up the file by lines
    lines = infile.read()
    listlines = lines.splitlines()
    
#number of grades
    numgrades = listlines[0]
    numgrades = eval(numgrades)
    numgrades = numgrades + 2
    
#Erases first line for calc purposes
    listlines[0:1] = []

#splits each line into names and numbers
    for line in listlines:
        #number of students, e.g. lines - 1st line
        numkids = len(listlines)
        Splititems = string.split(line, ",")
        first = Splititems[1]
        last = Splititems[0]
        #seperates numbers
        numbers = Splititems[2:numgrades]

        #finds the average of the numbers
        for i in numbers:
            #changes nums to ints
            gradeint = eval(i)
            #adds all nums from one line
            Var = Var + gradeint
            Var = float(Var)
            #finds avg
            Average = Var / (numgrades-2)
            Average = str(Average)
            
        #reset Var to default
        Var = 0
        #sets up individual avg
        names = first + ", " + last
        indavg = "The average for" + names + " is: " + Average + '\n'
        #finds class avg
        numavg = eval(Average)
        classavg = numavg + classavg
        #writes averages
        indavg = str(indavg)
        outfile.write(indavg)
        
    #prints class average
    classavg = classavg / numkids
    numkids = str(numkids)
    final = "Total Students: " + numkids + "\t" + "Class Average: " + "%0.2f" % (classavg)
    outfile.write(final)
    

    infile.close
    outfile.close

    print "Your grades have been calculated."

main()
