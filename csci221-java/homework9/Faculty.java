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
import java.util.ArrayList;
public class Faculty extends Person
{
	public String department;
	public ArrayList<FacCourse> courses = new ArrayList<FacCourse> ();
	public Registrar headReg = new Registrar();

	
	public Faculty (int idNumber, String firstName, String lastName,String ndepartment)	
	{
		super(idNumber, firstName, lastName);
		department = ndepartment;
	}
	
	public void addCourse(String dept, int num, int hours, int numStudents)
	{
		department = dept;
		
	}


}
