def main():
    
    choice = input("What value do you want to find the approximation of? ")
    var = choice
    var = var / 2
    
    num = 0
    
    usrin = input("How many times should the sqare root be approximated? ") 
    for i in range (usrin):
        var = (var + (30.0 / var)) / 2.0
        num = num + 1
        print var, "is the", num, "st/nd/rd/th approximation of the sqr root of", choice
main()
5
