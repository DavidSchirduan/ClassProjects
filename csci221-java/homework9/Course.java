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
public abstract class Course 
{

	public String department = "";	//name of the department that the class belongs to
	public int credhours;			//credit hours
	public int coursenum;			//ID number of the course
	public char Grade;
	
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
	
	public void setGrade(char newgrade)
	{
		Grade = newgrade;
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
	
	public String toString()
	{
		String finstring = "";
		
		finstring = finstring + "Department: " + department + " Course ID: " + coursenum + " Credit hours: " + credhours;
		
		return finstring; 
	}
	
	
}
