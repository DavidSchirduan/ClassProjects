/**
 * class Rectangle
 * 
 * @author Pharr 
 * @version 1/18/07; revised 2/21/10
 */

public class Rectangle extends Shape {
    private Point position;  // a Point gives the position of the
                            // upper left-hand corner.
    private double height;
    private double width;

    // Default Constructor
    public Rectangle( ) {
        position = new Point ( );
        setHeight( 1.0 );  
        setWidth( 1.0 );  
    }

    // Constructor
    public Rectangle( double x, double y, double height, double width ) {
        position = new Point ( x, y );
        setHeight( height );  
        setWidth( width );  
    }

    // Set position of Rectangle
    public void setPosition( double x, double y ) 
    { 
        position.setPoint( x, y ); 
    }

    // Set height of Rectangle
    public void setHeight( double h ) { 
        height = ( h > 0.0 ? h : 1.0 ); 
    }

    // Set width of Rectangle
    public void setWidth( double w ) { 
        width = ( w > 0.0 ? w : 1.0 ); 
    }

    // Get position of Rectangle
    public Point getPosition() { 
        return position; 
    }
    
    // Get height of Rectangle
    public double getHeight() { 
        return height; 
    }

    // Get width of Rectangle
    public double getWidth() { 
        return width; 
    }

    // Calculate area of Rectangle
    public double area() { 
        return height * width; 
    }

    // show the Rectangle as a String
    public String toString()
    {
        String s = "Position = " + position;
        s = s + "\nHeight = " + height;
        s = s + "\nWidth  = " + width;
        s = s + "\nArea   = " + area();
        return s;
    }
} // Class Rectangle

