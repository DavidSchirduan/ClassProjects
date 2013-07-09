package Homework1;
import java.io.*;
import java.util.*;


/*Author:   David Schirduan
Date:       8/31/10
Class:     CSCI-230 Java Programming
Assignment: HouseHold/assignment 1
Task:       review java arrays
Input:      creation of an array of simlated families
Output:     an array with which to gather and process data
Certification of Authenticity:   
         I certify that this lab is entirely my own work.  
*/

public class HouseholdStatistics {

	public static void main(String[] args) throws FileNotFoundException {
        Scanner stdin = new Scanner(System.in);	//scanner
        int houseID = 0, members = 0;
        double income = 0.0; 
        double avgincome = 0.0, cash = 0.0; 	//used for finding avg income
      
        ArrayList<Integer> belowline = new ArrayList<Integer> ();	//list of houses below poverty line
        ArrayList<Integer> aboveavg = new ArrayList<Integer> ();	//list of houses above average
        ArrayList<Household> houses = new ArrayList<Household> ();	//list of all house objects.

        System.out.print("File: ");	
        String name = stdin.nextLine();	
        System.out.println();
        
//        File file = new File("/home/mercy/household.txt");	
        
        //I added this bit with the try-catch statement because the Java docs claimed I needed it
        //and I figured that it couldn't hurt.
        
        try{
        Scanner fileIn = new Scanner(name) ;		

        //scans through the text file and makes a list of houses
        while (fileIn.hasNext()) 
        {	
            houseID = fileIn.nextInt();
            income = fileIn.nextDouble();
            avgincome += income;
            members = fileIn.nextInt();
            
            houses.add(new Household(houseID, income, members));
       	}
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        
        //outputs all of the house information 
        System.out.println("HouseID" + "\t\t" + "House Income" + "\t\t" + "House Memebers");
        for (Household house : houses)
        {
        	System.out.println("\n");
        	System.out.println(house.getID());
        	System.out.println("\t\t");
        	System.out.println(house.getIncome());
        	System.out.println("\t\t");
        	System.out.println(house.getHousenum());
        }
        
        //calculates avg income
        avgincome = avgincome / houses.size();
        
        for (Household house: houses)
        {
        	cash = house.getIncome();
        	//adds them to the poverty list if they have a low income.
        	if (cash < (6500.00 + 750 * ((house.getHousenum())-2)))
        	{
        		belowline.add(house.getID());
        	}
        	//adds them to the above average list
        	if (cash > avgincome)
        	{
        		aboveavg.add(house.getID());
        	}
        }
        //prints avg income
        System.out.println("The average income for these households is: $" + avgincome);
        //prints out ID's of those above avg
        System.out.println("The Households with above average income: \n");
        System.out.println(aboveavg.get(0));
        for (int i = 1 ; i <  aboveavg.size() ; i++)
        {
        	System.out.println(", " + aboveavg.get(i));
        }
        //prints out ID's of those below avg
        System.out.println("The Households below the poverty line: \n");
        System.out.println(belowline.get(0));
        for (int i = 1 ; i <  belowline.size() ; i++)
        {
        	System.out.println(", " + belowline.get(i));
        }

}

}
