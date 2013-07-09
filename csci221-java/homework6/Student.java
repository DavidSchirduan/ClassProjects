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
import java.util.ArrayList;


public class Student extends Person
{
	public String major = "Undeclared";
	public ArrayList<Course> courses = new ArrayList<Course> ();
	public int numstudents = 0;
	public String probation = "";
	
	public Student(int ID, String first, String last)
	{
		super(ID, first, last);
		numstudents += 1;
	}
	
	public Student(int ID, String first, String last, String newmajor)
	{
		super(ID, first, last);
		major = newmajor;
		numstudents += 1;
	}
		
	public void setMajor(String newmajor)
	{
		major = newmajor;
	}
	
	public void addCourse(String dept, int num, int hours)
	{
		Course newcourse = new Course(dept, num, hours);
		courses.add(newcourse);
	}
	
	public int find(String dept, int num)
	{
		int i = 0;
		int position = 0;
		for (Course course : courses)
		{
			if (course.getdepartment() == dept && course.getcoursenum() == num)
			{
				position = i;	
			}	
		i++;
		}
		return position;
	}
	
	public void changeGrade (String dept, int num, char grade)
	{
		int position;
		Course clas;
		position = this.find(dept, num);
		clas = courses.get(position);
		
		clas.setgrade(grade);
	}
	
	public String toString()
	{
		double grade = 0;
		double credpts = 0;
		double tothours = 0;

		if (courses.size() > 0)			
		{
			for (Course classes : courses)
			{
				grade = 0;
				if (classes.getgrade() == 'A')
				{
					grade = 4;
				}
				else if (classes.getgrade() == 'B')
				{
					grade = 3;
				}
				else if (classes.getgrade() == 'C')
				{
					grade = 2;
				}
				else if (classes.getgrade() == 'D')
				{
					grade = 1;
				}
				else if (classes.getgrade() == 'F')
				{
					grade = 0;
				}
				//calculates GPA for all courses

				credpts += (grade * classes.getcredhours());
				tothours += classes.getcredhours();
			}
			
			//if GPA is less than 3.0, prints Probabtion
			if ((credpts / tothours) < 2.0)
			{
				probation = "On Probation";
			}
		}
		
		String finstring = "";
		finstring += ("Name: " + this.getfname() + " " + this.getlname() + "\t ID number: " + this.getID() + "\tMajor: " + major + " " + probation);
		return finstring;
	}
}