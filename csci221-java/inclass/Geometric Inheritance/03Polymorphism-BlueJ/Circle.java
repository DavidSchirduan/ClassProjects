/**
 * class Circle
 * 
 * @author Pharr 
 * @version 1/18/07; revised 2/21/10
 */

public class Circle extends Shape {
    private Point center;        // a Circle contains a Point
    protected double radius;

    // No-argument constructor
    public Circle()
    {
        center = new Point ();
        setRadius( 0 );  
    }

    // Constructor
    public Circle( double x, double y, double r )
    {
        center = new Point ( x, y );
        setRadius( r );  
    }

    // Set center of Circle
    public void setCenter( double x, double y ) 
    { 
        center.setPoint( x, y ); 
    }

    // Set radius of Circle
    public void setRadius( double r ) 
    { 
        radius = ( r >= 0.0 ? r : 0.0 ); 
    }

    // Get center of Circle
    public Point getCenter() { 
        return center; 
    }
    
    // Get radius of Circle
    public double getRadius() { 
        return radius; 
    }

    // Calculate area of Circle
    public double area() { 
        return Math.PI * radius * radius; 
    }

    // show the Circle as a String
    public String toString()
    {
        String s = "Center = " + center;
        s = s + "\nRadius = " + radius;
        s = s + "\nArea   = " + area();
        return s;
    }
} // Class Circle

