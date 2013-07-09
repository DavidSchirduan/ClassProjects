/**
 * Rational.java implements a class for representing and manipulating
 *  rational numbers.
 * 
 */
public class Rational
{
    private int numerator;
    private int denominator;

    /**
     * Constructor for objects of class Rational
     */
    public Rational()
    {
        numerator = 1;
        denominator = 1;
    }
    
    public Rational(int n, int d)
    {
        set(n, d);
    }

    private int gcd(int i, int j)
    {
        int r = 1;
        while (j != 0)
        {
            r = i % j;
            i = j;
            j = r;
        }
        return i;
    }
    
    // accessor methods
    public int getNumerator()
    {
        return numerator;
    }
    
    public int getDenominator()
    {
        return denominator;
    }
       
    // This method sets the numerator and denominator of a 
    // Rational number simultaneously. If the numerator or
    // the denominator could be set independently, the 
    // rational number might not be reduced.
    public void set(int n, int d)
    {
        numerator = n;
        if (d == 0)
            denominator = 1;
        else
            denominator = d;
        int gcd = gcd(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        if (denominator < 0) {
            numerator = numerator * -1;
            denominator = denominator * -1;
        }
    }
       
    public Rational add (Rational r)
    {
        return new Rational(this.numerator*r.denominator + this.denominator*r.numerator, 
                            this.denominator*r.denominator);
    }
    
    public Rational subtract (Rational r)
    {
        return new Rational(this.numerator*r.denominator - this.denominator*r.numerator, 
                            this.denominator*r.denominator);
    }
    
    public Rational multiply(Rational r)
    {
        return new Rational(this.numerator*r.numerator, this.denominator*r.denominator);
    }
    
    public Rational divide(Rational r)
    {
        return new Rational(this.numerator*r.denominator, this.denominator*r.numerator);   
    }
    
   public boolean equals(Rational r)
    {
        return this.numerator == r.numerator && this.denominator == r.denominator;
    }
    
    public String toString()
    {
        return numerator + "/" + denominator;
    }
}