/**
 * class Test
 * Demonstrating the inheritance or "is-a" relationship
 * 
 * @author Pharr 
 * @version 1/18/07; revised 2/21/10
 */

public class Test  {
    public static void main( String args[ ] ) {

        Circle c = new Circle( 30, 40, 2.3 );
        Rectangle r = new Rectangle( 50, 60, 3.5, 4.5 );
        Square s = new Square( 70, 80, 5.5 );

        System.out.println ( "Circle c: \n" + c );
        System.out.println ( "\nRectangle r: \n" + r );
        System.out.println ( "\nSquare s: \n" + s );

        System.out.println ( "\n\nArea of Square s = " + s.area() );

    }
} // Class Test

