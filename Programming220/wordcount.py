#This program will count the # of words in a sentence

import string

def main():

    var = 0

    sentence = raw_input("SAY SOMETHING! ")

    num = string.split(sentence, " ")

    for i in range(len(num)):
        var = var + 1
    print var
   
    
main()

