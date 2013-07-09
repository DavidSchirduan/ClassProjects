/**
 * class Point
 * 
 * @author Pharr 
 * @version 1/18/07; revised 2/21/10
 */

public class Point  {
    private double x, y; // coordinates of the Point

    // No-argument constructor
    public Point()
    {
        setPoint( 0.0, 0.0 );
    }

    // Constructor
    public Point( double a, double b )
    {
        setPoint( a, b );
    }

    // Set x and y coordinates of Point
    public void setPoint( double a, double b )
    {
        x = a;
        y = b;
    }

    // get x coordinate
    public double getX() { 
        return x; 
    }  

    // get y coordinate
    public double getY() { 
        return y; 
    }

    // convert the point into a String representation
    public String toString()
    {
        return "[" + x + ", " + y + "]";
    }
} // Class Point

