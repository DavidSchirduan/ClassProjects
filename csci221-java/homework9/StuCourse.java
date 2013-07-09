/*Author:   David Schirduan
Date:       4/7/10
Class:     CSCI-221-002 Java Programming
Assignment: Student
Task:       learn of class inheritenct by creating extensions of Person and Student classes, and also to test abstract classes
Input:      the creation of class instances
Output:     Outputs a print statement as well as several variables and method tests
Certification of Authenticity:   
         I certify that this lab is entirely my own work.  
*/
public class StuCourse extends Course
{


	public StuCourse (String newDept, int newNumber, int newHours)
	{
		super(newDept, newNumber, newHours);
		
	}
	
	public void setgrade(char newgrade)
	{
		if (newgrade == 'A' || newgrade == 'B' || newgrade == 'C' || newgrade == 'D' || newgrade == 'F')
		Grade = newgrade;
	}

	public char getgrade()
	{
		return Grade;
	}
	
	public String toString()
	{
		String finstring = "";
		
		finstring = finstring + "Department: " + department + " Course ID: " + coursenum + " Credit hours: " + credhours;
		
		return finstring; 
	}


}
