#David Schirduan and Sarah Green
#This program will encode a message into a Caeser Cipher

import string
def main():

    message = raw_input("What would you like to decode? ")
    shift = input("How many character positions should the message shift? ")
    fin = ""
    alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"


    for i in range(len(message)):
##this pulls the letter out of the string and makes it a seperate var
        letter = message[i]
##find the corresping position of the letter in the alphabet, returns an int val
        pos = string.find(alphabet, letter)
## increases the value by the shift var 
        ans = pos - shift
##finds corresponding letter in alphabet of new letter
        var = alphabet[ans]
##adds the letters together for the final answer
        fin = fin + var
        
    print fin
main()

