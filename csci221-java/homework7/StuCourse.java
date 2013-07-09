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
	public char grade;				//grade of the class, either A,B,C,D,F


	public StuCourse (String newDept, int newNumber, int newHours)
	{
		super(newDept, newNumber, newHours);
		
	}
	
	public void setgrade(char newgrade)
	{
		if (newgrade == 'A' || newgrade == 'B' || newgrade == 'C' || newgrade == 'D' || newgrade == 'F')
		grade = newgrade;
	}

	public char getgrade()
	{
		return grade;
	}
	
	public String toString()
	{
		String finstring = "";
		
		finstring = finstring + "Department: " + department + " Course ID: " + coursenum + " Credit hours: " + credhours;
		
		return finstring; 
	}


}
