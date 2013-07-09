#This is the class "Money" and will allow for multiple methods and uses
class Money:

    def __init__(self):
        self.dollars = 0
        self.cents = 0

    def getCents(self):
        return self.centsd

    def getDollars(self):
        return self.dollard

    def setCents(self, cents):
        numdollars = 0
        self.cents = cents + self.cents
        while self.cents >= 100:
            numdollars = numdollars + 1
            self.cents = self.cents - 100
        self.dollars = self.dollars + numdollars

    def setDollars(self, dollars):
        self.dollars = self.dollars + dollars

    def increment(self, money):
        addedcents = money.getCents()
        addeddollars = money.getDollars()
        while addedcents >= 100:
            addeddollars = addeddollars + 1
            addedcents = addedcents - 100
        self.cents = self.cents + addedcents
        self.dollars = self.dollars + addeddollars

    def add(self, money):
        addedcents = money.getCents()
        addeddollars = money.getDollars()
        while addedcents >= 100:
            addeddollars = addeddollars + 1
            addedcents = addedcents - 100
        newcents = self.cents + addedcents
        newdollars = self.dollars + addeddollars
        newmoney = Money()
        newmoney.setDollars(newdollars)
        newmoney.setCents(newcents)
        return newmoney
        

    def __str__(self):
        return "$" + str(self.dollars) + "." + str(self.cents)
