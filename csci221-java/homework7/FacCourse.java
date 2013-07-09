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
public class FacCourse extends Course
{
	public int stuNum;
	
	public FacCourse (String newDept, int newNumber, int newHours, int newNumStu)
	{
		super(newDept, newNumber, newHours);
		stuNum = newNumStu;	
	}
	
	public void setstuNum(int newnum)
	{
		stuNum = newnum;
	}

	public int getstuNum()
	{
		return stuNum;
	}
	
	
}
