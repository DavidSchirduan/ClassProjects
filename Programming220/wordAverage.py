#This program will tell the average length of a word in the user's sentence.

import string

def main():
    ans = 0.0
    var = 0.0

    sentence = raw_input("SAY SOMETHING! ")

    num = string.split(sentence, " ")

    for i in range(len(num)):
        word = num[i]
##seperates word from sentence
        length = len(word)
##finds length of word
        ans = ans + length
## divides by last variable of i + 1
    fin = ans / float(len(num))

    print fin
   
    
main()

