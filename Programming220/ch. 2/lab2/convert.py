# convert.py
#      A program to convert Celsius temps to Fahrenheit
# by: Susan Computewell (actually Zelle; see p. 28)

def main():
        for i in range(5):
            celsius = input("What is the Celsius temperature? ")
            fahrenheit = (9.0 / 5.0) * celsius + 32
            print "The temperature is", fahrenheit, "degrees Fahrenheit."
            print "Loop is finished"
main()
