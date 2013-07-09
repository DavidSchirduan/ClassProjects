import java.util.*;
public class Registrar 
{
	public ArrayList<Course> regcourseList = new ArrayList<Course> ();
	public ArrayList<Student> regstuList = new ArrayList<Student> ();
	public ArrayList<Faculty> regfacList = new ArrayList<Faculty> ();
	
	
	public Registrar()
	{
		
	}
	
	public void addCoursereg(Course newcourse)
	{
		regcourseList.add(newcourse);
	}
	
	public void addStudentreg (Student newstu)
	{
		regstuList.add(newstu);
	}
	
	public void addFacultyreg (Faculty newfac)
	{
		regfacList.add(newfac);
	}
	
	public void assignGrades(String coursename, int courseid, String fname, String lname, char grade)
	{
		//searches through students for the correct name
		for (Student student : regstuList)
		{
			if (student.fname == fname && student.lname == lname)
			{
				student.changeGrade(coursename, courseid, grade);
			}
		}
	}
	
	public ArrayList<Student> courseinfo(String coursename, int courseid)
	{
		ArrayList<Student> studentsincourse = new ArrayList<Student> ();
		//searches all students and adds the ones in each course
		for (Student student : regstuList)
		{
			//goes through all the courses of the student
			for (Course course : student.courses)
			{
				if (course.coursenum == courseid && course.department == coursename)
				{
					studentsincourse.add(student);
				}
			}
		}
		
		return studentsincourse;
	}
	
	public Student studentinfo(String fname, String lname)
	{
		Student chosenone = null;
		
		for (Student student : regstuList)
		{
			if (student.fname == fname && student.lname == lname)
			{
				chosenone = student;
			}
		}
		
		return chosenone;
	}
	
	public String facultyinfo(String fname, String lname)
	{
		String info = "";
		int stunum = 0;
		//goes through all profs
		for (Faculty faculty : regfacList)
		{
			//tests for the one we need
			if (faculty.fname == fname && faculty.lname == lname)
			{
				//goes through all of those profs courses
				for (FacCourse faccourse : faculty.courses)
				{
					//goes through all the students in registrar
					for (Student student : regstuList)
					{
						//goes through every students' classes
						for (Course stucourse : student.courses)
						{
							//if a student is taking the class, it increases the count by one
							if (stucourse.department == faccourse.department && stucourse.coursenum == faccourse.coursenum)
							{
								stunum += 1;
							}
						}
					}
						
					info += faccourse.toString() + "Number of students: " + stunum;
					
				}
			}
		}
		return info;
	}
	
	public String toString()
	{
		String courselist = "Courses:\n";
		//prints all courses
		for (Course course : regcourseList)
		{
			courselist += course.department + " " + course.coursenum + "\n\n";
			//goes through every student
			for (Student studs : regstuList)
			{
				//then searches though all of those students' courses
				for (Course c : studs.courses)
				{
					//if the student has the same course as the current course, it prints their name
					if (c.department == course.department && c.coursenum == course.coursenum)
					{
						courselist += studs.fname + " " + studs.lname + " " + "Grade: " + course.Grade + "\n";
					}
				}
			}
			courselist += "\n";
		}
		
	return courselist;	
	}
}
