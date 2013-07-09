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
public class Course 
{

	public String department = "";	//name of the department that the class belongs to
	public int credhours;			//credit hours
	public char grade;				//grade of the class, either A,B,C,D,F
	public int coursenum;			//ID number of the course
	
	public Course ( String dept, int number, int hours )
	{
		department = dept;
		coursenum = number;
		credhours = hours;
	}
	//Setters
	
	public void setdepartment(String newdep)
	{
		department = newdep;
	}
	
	public void setcredhours(int newhours)
	{
		credhours = newhours;
	}
	
	public void setgrade(char newgrade)
	{
		grade = newgrade;
	}
	
	public void setcoursenum(int newnum)
	{
		coursenum = newnum;
	}
	
	//Getters
	
	public int getcoursenum()
	{
		return coursenum;
	}
	
	public String getdepartment()
	{
		return department;
	}
	
	public int getcredhours()
	{
		return credhours;
	}
	
	public char getgrade()
	{
		return grade;
	}
	
	public String toString()
	{
		String finstring = "";
		
		finstring = finstring + "Department: " + department + " Course ID: " + coursenum + " Credit hours: " + credhours + " Grade: " + grade;
		
		return finstring; 
	}
	
	
}
