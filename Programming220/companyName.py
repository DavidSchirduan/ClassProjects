#This program will allow the user to enter a website,
#and will return only the name of the website, not of the .com or the www.

import string

def main():
    
    website = raw_input("What is your company's website? ")

    domain = string.split(website, ".")
    
    print domain[1]
    
main()

