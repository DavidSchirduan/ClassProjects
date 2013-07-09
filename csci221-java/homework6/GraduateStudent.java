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
public class GraduateStudent extends Student
{

	String thesis;
	
	public GraduateStudent(int ID, String first, String last, String major)
	{
		super (ID, first, last, major);
		numstudents += 1;	
	}
	
	public void setThesistopic(String newtopic)
	{
		thesis = newtopic;
	}
	
	public String getThesistopic()
	{
		return thesis;
	}
	
	public String toString()
	{
		double grade = 0;
		double credpts = 0;
		int tothours = 0;
		//doesn't run until classes are added
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
			if ((credpts / tothours) < 3.0)
			{
				probation = "On Probation";
			}
		}
		String finstring = "";
		finstring += ("Name: " + this.getfname() + " " + this.getlname() + "\tID number: " + this.getID() + "\tMajor: " + major + " " + thesis + " " + probation);
		return finstring;
	}
	
	
}
