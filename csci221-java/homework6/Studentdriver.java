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

public class Studentdriver {

	public static ArrayList students = new ArrayList ();
	
	public static void main(String[] args) {

		Student student1 = new Student(001, "Jim", "Johnson");
		Student student2 = new Student(002, "David", "Daniels", "Art");
		Student student3 = new Student(003, "Simon", "Simpleton");
		GraduateStudent Gstudent1 = new GraduateStudent(004, "Gracie", "Lou", "Communication");
		
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(Gstudent1);
		
		student1.addCourse("Science", 112, 4);
		student1.addCourse("Math", 237, 3);
		student1.addCourse("Halo", 101, 6);
		student1.addCourse("Chem", 423, 2);
		student1.addCourse("Helpme", 111, 1);
		
		student1.changeGrade("Science", 112, 'A');
		student1.changeGrade("Math", 237, 'F');
		student1.changeGrade("Halo", 101, 'D');
		student1.changeGrade("Chem", 423, 'B');
		student1.changeGrade("Helpme", 111, 'C');
		
		Gstudent1.addCourse("Science", 112, 4);
		Gstudent1.addCourse("Math", 237, 3);
		Gstudent1.addCourse("Halo", 101, 6);
		Gstudent1.addCourse("Chem", 423, 2);
		Gstudent1.addCourse("Helpme", 111, 1);
		
		Gstudent1.changeGrade("Science", 112, 'A');
		Gstudent1.changeGrade("Math", 237, 'A');
		Gstudent1.changeGrade("Halo", 101, 'A');
		Gstudent1.changeGrade("Chem", 423, 'A');
		Gstudent1.changeGrade("Helpme", 111, 'A');
		
		

		Gstudent1.setThesistopic("Talking is Good");
		
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
		System.out.println(Gstudent1);
		
		System.out.println("Number of enrolled students: " + students.size());
		
	}

}
