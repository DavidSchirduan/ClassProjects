/*Author:   David Schirduan
Date:       2/5/10
Class:     CSCI-221-002 Java Programming
Assignment: Money
Task:       Create a class Money without using doubles
Input:      No user unput. Except what is changed in the code
Output:     Outputs a print statement as well as several variables
Certification of Authenticity:   
         I certify that this lab is entirely my own work.  
*/
public class Money
   {
      public int dollars;	//dollars of the current money object
      public int cents;		//cents of the current money object
      static Money varmoney = new Money();	//variable money to be returned as m3
      public int vardollars;	//dollars of m3
      public int varcents;	//cents of m3
      public int mdollars;	//dollars of money object being imported
      public int mcents;	//cents of money object being imported
      public int userdollars;	//dollars inputed by the user in the constructor
      public int usercents;	//cents inputed by the user in the constructor
      
      //contructor for money with no variables
      public Money()
         {
            dollars = 0;
            cents = 0;
         }
      //contructor for money with variables
      public Money(int userdollars, int usercents)
         {
            dollars = userdollars;
            cents = usercents;
         }
      //overrides the value of cents with a uservalue
      public void setCents(int chgcents)
         {
            cents = chgcents;
         }
      //overrides the value of dollars with a uservalue
      public void setDollars(int chgdollars)
         {
            dollars = chgdollars;
         }
      //return current value of cents
      public int getCents()
         {
            return cents;
         }
      //returns current value of dollars
      public int getDollars()
         {
            return dollars;
         }
      //increases the value of first Money by the second Money
      public void increment(Money m)
         {
            int mdollars = m.getDollars();
            int mcents = m.getCents();
            
            cents = cents + mcents;
            dollars = dollars + mdollars;
            
            while (cents >= 100)
               {
                  cents = cents - 100;
                  dollars = dollars + 1;
               }
         }
      //decreases the value of the first money by the second money
      public void decrement(Money m)
         {
            int mdollars = m.getDollars();
            int mcents = m.getCents();
            
            cents = cents - mcents;
            dollars = dollars - mdollars;
            
            while (cents < 0)
               {
                  cents = cents + 100;
                  dollars = dollars - 1;
               }
         }
      //adds 2 Moneys together and returns the value as a third Money
      public Money add(Money m)
         {
            mdollars = m.getDollars();
            mcents = m.getCents();
            
            varcents = cents + mcents;
            vardollars = dollars + mdollars;
            
            while (varcents >= 100)
               {
                  varcents = varcents - 100;
                  vardollars = vardollars + 1;
               }
            
            
            varmoney.setDollars(vardollars);
            varmoney.setCents(varcents);
            
            return varmoney; 
         }
      //subtracts 1 Money from the other and returns the value as a third Money
      public Money subtract(Money m)
         {
            mdollars = m.getDollars();
            mcents = m.getCents();
            
            varcents = cents - mcents;
            vardollars = dollars - mdollars;           
            
            while (varcents < 0)
               {
                  varcents = varcents + 100;
                  vardollars = vardollars - 1;
               }
            varmoney.setDollars(vardollars);
            varmoney.setCents(varcents);
                        
            return varmoney;
         }
      //tests for equality between 2 Moneys
      public boolean equals(Money m)
         {
            mdollars = m.getDollars();
            mcents = m.getCents();
            
            return (mcents == cents && mdollars == dollars);
         }
      //toString method
      public String toString()
         {
            return ("$" + dollars + "." + cents);
         }
      //print method for Money
      public void print()
         {
            System.out.println("$" + dollars + "." + cents);
         }
   }
