# testMoney.py
# Author: Pharr

from money import Money

def main():
    # Use these to test the constructor and getters
    
    m1 = Money()
    m2 = Money()

    print "Constructors, getters:"
    print "m1 dollars =", m1.getDollars()
    print "m1 cents =", m1.getCents()
    print "m2 dollars =", m2.getDollars()
    print "m2 cents =", m2.getCents()

    # Use these to test the setters
    
    m1.setDollars(1)
    m1.setCents(20)
    m2.setDollars(1)
    m2.setCents(190)

    print
    print "setters:"
    print "m1 dollars =", m1.getDollars()
    print "m1 cents =", m1.getCents()
    print "m2 dollars =", m2.getDollars()
    print "m2 cents =", m2.getCents()

    # Use these to test the __str__
    
    print
    print "__str__:"
    print "m1 =", m1
    print "m2 =", m2

    # Use this to test increment
    
    m2.setCents(50)
    print
    print "Before increment:"
    print "m1 =", m1
    print "m2 =", m2
    m1.increment(m2)
    print "After increment, m1 =", m1

    # Use this to test increment more
    
    m1.setDollars(1)
    m1.setCents(20)
    m2.setCents(90)
    print
    print "Before increment with carry:"
    print "m1 =", m1
    print "m2 =", m2
    m1.increment(m2)
    print "After increment with carry, m1 =", m1

    # Use this to test add
    
    m1.setDollars(1)
    m1.setCents(20)
    m2.setDollars(1)
    m2.setCents(50)
    print
    print "Before add:"
    print "m1 =", m1
    print "m2 =", m2
    m3 = m1.add(m2)
    print "After add, m3 =", m3

    # Use this to test add more
    
    m2.setCents(90)
    print
    print "Before add with carry:"
    print "m1 =", m1
    print "m2 =", m2
    m3 = m1.add(m2)
    print "After add with carry, m3 =", m3

    
main()
