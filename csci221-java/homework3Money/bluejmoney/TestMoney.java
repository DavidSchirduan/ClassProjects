/*Author:   David Schirduan
Date:       2/5/10
Class:     CSCI-221-002 Java Programming
Assignment: TestMoney
Task:       Create a driver class for Money
Input:      No user unput. Except what is changed in the code
Output:     Outputs several examples of the Money class
Certification of Authenticity:   
         I certify that this lab is entirely my own work.  
*/


public class TestMoney
   {
      static Money m1 = new Money();
      static Money m2 = new Money();
      static Money m3 = new Money();
      
      public static void main(String[] args)
         {
            //creates m1 Money
            m1.setCents(75);
            m1.setDollars(4);
            
            //creates m2 Money
            m2.setCents(50);
            m2.setDollars(2);
            
            System.out.println("m1 = ");
            m1.print();
            System.out.println("m2 = ");
            m2.print();
            
            //increment m1 by m2
            m1.increment(m2);
            
            //increment m2 by m1
            m2.increment(m1);
            
            //print both m1 and m2
            System.out.println("m1 + m2 then m1 = ");
            m1.print();
            System.out.println("m2 + m1 then m2 = ");
            m2.print();
            
            //m1 + m2 = m3
            m3 = m1.add(m2);
            System.out.println("m1 + m2 then m3 = ");
            m3.print();
            
            //m2 - m1 = m3
            m3 = m2.subtract(m1);
            System.out.println("m2 - m1 then m3 = ");
            m3.print();
            
            
            
           
            
            
         }

   }