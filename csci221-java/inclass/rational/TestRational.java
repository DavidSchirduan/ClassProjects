// Demonstrate Rational data abstraction    
    
import java.util.*; 
    
public class TestRational { 
    public static void main(String[] args) {    
        Scanner stdin = new Scanner(System.in); 
        int n1, d1, n2, d2;
        Rational r1, r2;
        String more;
    
        System.out.print("Do you want to demo rational arithmetic(Y/N)? "); 
        more = stdin.nextLine();
        while (more.equalsIgnoreCase("Y"))
        {
            // obtain values for rationals r1 and r2 
            System.out.print("Enter numerator of a rational number: ");   
            n1 = stdin.nextInt();    
            System.out.print("Enter denominator of a rational number: ");   
            d1 = stdin.nextInt();    
            r1 = new Rational(n1, d1);    
            System.out.println();   
    
            System.out.print("Enter numerator of a rational number: "); 
            n2 = stdin.nextInt();    
            System.out.print("Enter denominator of a rational number: ");   
            d2 = stdin.nextInt();    
            r2 = new Rational(n2, d2);    
            System.out.println();   
            
            // Are r1 and r2 equal?
            if ( r1.equals(r2) ) {
                System.out.println( r1 + " and " + r2 + " are equal.");
            }
            else {
                System.out.println( r1 + " and " + r2 + " are not equal.");
            }
    
            // operate on r1 and r2   
            Rational sum = r1.add(r2);    
            Rational difference = r1.subtract(r2);    
            Rational product = r1.multiply(r2);   
            Rational quotient = r1.divide(r2);    
        
            // display operation results    
            System.out.println("For r1 = " + r1 + " and r2 = " + r2);    
            System.out.println("    r1 + r2 = " + sum);   
            System.out.println("    r1 - r2 = " + difference);    
            System.out.println("    r1 * r2 = " + product);   
            System.out.println("    r1 / r2 = " + quotient);  
            System.out.println();   

            stdin.nextLine();
            System.out.print("More rational arithmetic(Y/N)? "); 
            more = stdin.nextLine();
        } // end while
    } // end main
} // end class RationaDemo
    