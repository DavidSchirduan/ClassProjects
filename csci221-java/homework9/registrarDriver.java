
public class registrarDriver {

	public static Registrar headreg = new Registrar();
	
	public static void main(String[] args) {
		//create students
		Student student1 = new Student(001, "Jim", "Johnson");
		Student student2 = new Student(002, "David", "Daniels", "Art");
		Student student3 = new Student(003, "Simon", "Simpleton");
		Student student4 = new Student(004, "Jack", "Frost");
		Student student5 = new Student(005, "Alison", "Franze");
		Student student6 = new Student(006, "Steven", "Smith");

		GraduateStudent Gstudent1 = new GraduateStudent(100, "Gracie", "Lou", "Communication");
		//create courses
		StuCourse course1 = new StuCourse("Haxor", 1337, 4);
		StuCourse course2 = new StuCourse("Math", 237, 3);
		StuCourse course3 = new StuCourse("Halo", 101, 6);
		StuCourse course4 = new StuCourse("Chem", 423, 2);
		StuCourse course5 = new StuCourse("Helpme", 111, 1);
		//create faculty
		Faculty professor1 = new Faculty(001, "Jim", "Johnson", "Math");
		Faculty professor2 = new Faculty(001, "Tim", "Smith", "Chem");
		Faculty professor3 = new Faculty(001, "General", "Milz", "Halo");
		Faculty professor4 = new Faculty(001, "Doctor", "Mario", "Helpme");
		Faculty professor5 = new Faculty(001, "Steve", "Stevenson", "Haxor");

		//add students and courses to headreg
		headreg.addStudentreg(student1);
		headreg.addStudentreg(student2);
		headreg.addStudentreg(student3);
		headreg.addStudentreg(student4);
		headreg.addStudentreg(student5);
		headreg.addStudentreg(student6);
		headreg.addStudentreg(Gstudent1);
		headreg.addCoursereg(course1);
		headreg.addCoursereg(course2);
		headreg.addCoursereg(course3);
		headreg.addCoursereg(course4);
		headreg.addCoursereg(course5);
		headreg.addFacultyreg(professor1);
		headreg.addFacultyreg(professor2);
		headreg.addFacultyreg(professor3);
		headreg.addFacultyreg(professor4);
		headreg.addFacultyreg(professor5);
		
		//add courses to students
		//Student 1 is in course 1, 2, 3				//So here is how the output should look
		student1.addCourse(course1);					//Course 1	Course2		Course3 	Course 4	Course5 
		student1.addCourse(course2);					//Stu1		Stu1		Stu1		Stu2		Stu3
		student1.addCourse(course3);					//Stu3		Stu2		Stu2		Stu4		Stu5
		//Student 2 is in course 2, 3, 4				//Stu4		Stu5		Stu3		Stu5		Stu6
		student2.addCourse(course2);					//Stu5					Stu4
		student2.addCourse(course3);					//						Stu5
		student2.addCourse(course4);					//
		//Student 3 is in course 3, 4, 5				//   Maybe I should flip it on it's side, e.g.
		student3.addCourse(course3);					//Course1	Stu1	Stu3	Stu4	Stu5
		student3.addCourse(course4);					//
		student3.addCourse(course5);					//
		//Student 4 is in course 1, 3
		student4.addCourse(course1);
		student4.addCourse(course3);
		//Student 5 is in all courses
		student5.addCourse(course1);
		student5.addCourse(course2);
		student5.addCourse(course3);
		student5.addCourse(course4);
		student5.addCourse(course5);
		//Student 6 is only in course 5
		student6.addCourse(course5);
		
		//set student grades
		headreg.assignGrades("Helpme", 111, "Jim", "Johnson", 'D');
		headreg.assignGrades("Halo", 101, "Jim", "Johnson", 'F');
		headreg.assignGrades("Chem", 423, "Jim", "Johnson", 'C');
		headreg.assignGrades("Math", 237, "Jim", "Johnson", 'F');
		headreg.assignGrades("Halo", 101, "Alison", "Franze", 'B');
		headreg.assignGrades("Helpme", 111, "Alison", "Franze", 'A');
		headreg.assignGrades("Math", 111, "Alison", "Franze", 'B');
		headreg.assignGrades("Haxor", 1337, "Alison", "Franze", 'C');
		headreg.assignGrades("Haxor", 1337, "Jim", "Johnson", 'A');

		
		

		System.out.println(headreg);
		
		
			
	}
}
