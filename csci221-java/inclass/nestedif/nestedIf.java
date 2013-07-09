// THIS PROGRAM IS DEFECTIVE!!!
// This is a "bad" example of a nested conditional.
// Listen carefully to the class discussion of this program.

// Enter 1 2
// Then 1 -2
// Why is the message wrong?

// Then enter -1 2
// Then enter -1 -2
// What happened to the message?

import java.util.*; 
    
public class BadNestedIf { 
   // main(): application entry point  
   public static void main(String[] args) {    
      // set input stream 
      Scanner stdin = new Scanner(System.in); 
                
      System.out.print("Enter two integers: ");   
      int n1 = stdin.nextInt();   
      int n2 = stdin.nextInt();   
    
      if (n1 > 0)   
         if (n2 > 0)     
            System.out.println("Both integers are positive.");
      else
         System.out.println("First integer is <= zero.");
   }   
}   
    