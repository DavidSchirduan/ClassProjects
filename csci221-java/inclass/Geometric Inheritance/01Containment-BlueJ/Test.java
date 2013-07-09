/**
 * class Test
 * Demonstrating the containment or "has-a" relationship
 * 
 * @author Pharr 
 * @version 1/18/07; revised 2/21/10
 */

public class Test 
{
   public static void main( String args[] )
   {
      Point p1 = new Point( );
      Point p2 = new Point( 30, 50 );
      Circle c = new Circle( 2.7, 120, 89 );

      System.out.println ( "Point p1: " + p1 );
      System.out.println ( "\nPoint p2: " + p2 );
      System.out.println ( "\nCircle c: \n" + c );
      
      System.out.println ( "\nPrinting the parts of Circle c manually: " );
      System.out.println ( "x and y coordinates: " + c.getCenter() );
      System.out.println ( "radius: " + c.getRadius() );
      System.out.println ( "Area: " + c.area() );
   }
}

// Class Test

