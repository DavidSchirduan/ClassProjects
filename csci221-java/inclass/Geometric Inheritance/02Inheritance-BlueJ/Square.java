/**
 * class Square
 * 
 * @author Pharr 
 * @version 1/18/07; revised 2/21/10
 */

public class Square extends Rectangle {
    // Constructor
    public Square( double x, double y, double side ) {
        super( x, y, side, side );  
    }

    // Set side of Square
    public void setSide( double s ) { 
        setHeight(s);
        setWidth(s);
    }

    // Get side of Square
    public double getSide() { 
        return super.getHeight();
        //return height;
    }

    // convert the Square to a String - Version 1
    //
    public String toString() {
        String s = "Position = " + super.getPosition();
        s = s + "\nHeight = " + super.getHeight();
        s = s + "\nWidth  = " + super.getWidth();
        s = s + "\nArea   = " + super.area();
        return s;
    }
    //

    // convert the Square to a String - Version 2
    /*
    public String toString() {
        return super.toString();
    }
    */

} // Class Square
