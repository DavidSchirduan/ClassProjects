/*Author:   David Schirduan
Date:       3/23/10
Class:     CSCI-221-002 Java Programming
Assignment: Student
Task:       learn of class inheritenct by creating extensions of Person and Student classes
Input:      the creation of class instances
Output:     Outputs a print statement as well as several variables and method tests
Certification of Authenticity:   
         I certify that this lab is entirely my own work.  
*/
public class Person 
{

	public int ID;
	public String fname = "";
	public String lname = "";
	
	public Person ( int newID, String first, String last )
	{
		ID = newID;
		fname = first;
		lname = last;		
	}
	
	//Setters
	public void setfname(String newname)
	{
		fname = newname;
	}
	
	public void setlname(String newname)
	{
		lname = newname;
	}
	
	public void setID(int newID)
	{
		ID = newID;
	}
	//Getters
	public String getfname()
	{
		return fname;
	}
	
	public String getlname()
	{
		return lname;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String toSTring()
	{
		String finstring ="" ;
		
		finstring = finstring + "Name: " + fname + " " + lname + "ID number: " + ID;
		
		return finstring;
	}
	
}
