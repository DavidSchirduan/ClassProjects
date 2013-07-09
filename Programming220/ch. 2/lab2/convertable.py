# convert.py
#      A program to convert Celsius temps to Fahrenheit
# by: Susan Computewell (actually Zelle; see p. 28)

def main():
        celsius = 0
        for i in range(11):
            fahrenheit = (9.0 / 5.0) * celsius + 32
            print celsius,"degrees in Celsius is", fahrenheit, "degrees Fahrenheit."
            celsius = celsius + 10
main()
