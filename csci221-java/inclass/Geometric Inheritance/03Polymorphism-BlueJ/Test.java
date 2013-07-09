/**
 * class Test
 * Demonstrating polymorphism
 * 
 * @author Pharr 
 * @version 1/18/07; revised 2/21/10
 */

public class Test  {
    public static void main( String args[ ] ) {
        Shape sh;
        Shape [ ] shapes = new Shape[3];
        Circle c;
        Rectangle r;
        Square s;

        sh = new Circle( 30, 40, 2.3 );
        System.out.println ( "Circle c: \n" + sh );
        //System.out.println ( "\nArea of c = " + sh.area() );
        //System.out.println ( "\nradius of c: " + sh.getRadius() );

        c = new Circle( 30, 40, 2.3 );
        r = new Rectangle( 50, 60, 3.5, 4.5 );
        s = new Square( 70, 80, 5.5 );

        shapes[0] = c;
        shapes[1] = r;
        shapes[2] = s;

        for (int i = 1; i < 3; i++) {
            //System.out.println ( "Shape[" + i + "]: \n" + shapes[i] + "\n" );
            //System.out.println ( "Shape[" + i + "] area: \n" + shapes[i].area() + "\n" );
        }
    }
} // Class Test
