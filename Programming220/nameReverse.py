#This will switch the order of the users input seperated by a space

import string

def main():
    
    name = raw_input("What is your name?(firstname lastname): ")

    fullname = string.split(name, " ")
    
    print fullname[1] + ", " + fullname[0]
    
main()

