## Conversion.py
## David Schirduan
## This code converts cups (input) to ml (output)

def main():
    print "This program converts cups to Ml."
    
    units = raw_input ("what are the resultant units: ")
    cups = input ("How many cups does the recipe require: ")

    ounces =  cups * 8
    milliliters = ounces * 29.57
       
    print "This ie equal to ", milliliters, units
main()
