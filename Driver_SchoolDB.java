import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;

//Hello this is the link -> https://youtu.be/ub-8WY7SGf8

public class Driver_SchoolDB {
	

	public static void main(String[] args) throws IOException {
		FileInputStream textFile = null;
		Scanner scan = null;
		String output = "";
		
		Course [] course = new Course[20];
		int numCourse = 0;
		Person [] person = new Person[20];
		int numPerson = 0;
		Employee [] employee = new Employee[20];
		int numEmployee = 0;
		Faculty [] faculty = new Faculty[20];
		int numFaculty = 0;
		GeneralStaff [] generalStaff = new GeneralStaff[20];
		int numGeneralStaff = 0;
		Student [] student = new Student[20];
		int numStudent = 0;
		
		//Menu
		System.out.println();
		System.out.println("Choose a letter form the menu: ");
		System.out.println("a: Create 3 new Course objects based on the input.");
		System.out.println("b: Create 3 new Faculty objects based on the input.");
		System.out.println("c: Create 3 new GeneralStaff objects based on the input");
		System.out.println("d: Create 3 new Student objects based on input");
		System.out.println("e: Add 2 new Courses to a Faculty object");
		System.out.println("f: Add 2 new Courses to a Student object");
		System.out.println("g: Add an array of 2 Courses to a Faculty object");
		System.out.println("h: Add an array of 2 Courses to a Student obejct");
		System.out.println("i: Get the Course at index (valid and invalid indexes) from a Faculty object");
		System.out.println("j: Get the Course at index (vaild and invalid indexes) form a Student object");
		System.out.println("k: Allow the user to select a Faculty object and a Course object from menus and query the Faculty object for the Course to determine whether the Faculty object teaches it or not.");
		System.out.println("l: Determine which Faculty object teaches the most and the least courses");
		System.out.println("m: Determine which Course is the minimum of all Course objects in the catalog");
		System.out.println("n:  Determine which Course is the maximum of all Course objects in the catalog");
		System.out.println("o: Determine which Student has the most and least credits");
		
		Scanner scnr = new Scanner(System.in);
		String choice = "";
		
		while(choice.length() != 1) {
			System.out.println("Enter a valid letter form the menu: ");
			choice = scnr.nextLine();
			choice = choice.trim().toLowerCase();
			
			if(choice.equals("a") || choice.equals("b") || choice.equals("c") || choice.equals("d") || 
					choice.equals("e") || choice.equals("f") || choice.equals("g") || choice.equals("h") 
					|| choice.equals("i") || choice.equals("j") || choice.equals("k")
					|| choice.equals("l") || choice.equals("m") || choice.equals("n")
					|| choice.equals("o")) {
				break;
			}
			else {
				choice = "not";
			}	
		}
		if(choice.equals("a")) {
			System.out.println("Create 3 new Course object");
			int num = 0;
			while(num < 3) {
				boolean isGradCourse = false;
				int courseNum = 0;
				String courseDept = "";
				int numCredits = 0;
				String grad = "";
				System.out.println("Enter the Course information for 1 new course by following the instructions below.\n" + "You have already created " + num + "/3 Course object.");
				
				while(grad.length() != 1) {
					System.out.println("Is the course a graduate course? (Enter 'y' or 'n')");
					grad = scnr.next().trim().toLowerCase();
					if(grad.equals("y")) {
						isGradCourse = true;
					}
					else if (grad.equals("n")) {
						isGradCourse = false;
					}
					else {
						System.out.println("Please enter a valid letter.");
						grad = "not";
					}
				}
				System.out.println("What is the course number? Enter here: ");
				courseNum = scnr.nextInt();
				System.out.println("What is the course depertment? Enter here: ");
				courseDept = scnr.next();
				System.out.println("How many credits will this course provide? Enter here: ");
				numCredits = scnr.nextInt();
				
				Course course1 = new Course(isGradCourse, courseNum, courseDept, numCredits);
				if(numCourse < 50) {
					course[numCourse] = course1;
					numCourse++;
					num++;
				}
						
			}
			
		}
		else if(choice.equals("b")) {
			System.out.println("Create 3 new Faculty objects");
			int num = 0;
			while (num < 3) {
				boolean isTenured = false;
				String ten = "";
				String deptName = "";
				String name = "";
				int birthYear = 0;
				System.out.println("Enter the Faculty information for 1 new Faculty member by following the instructions below.\n" + "You have already created " + num + "/3 Faculty objects.");
				
				while (ten.length() != 1) {
					System.out.println("Is the faculty member tenured? (Enter 'y' or 'n')");
					ten = scnr.next();
					ten = ten.trim();
					ten = ten.toLowerCase();
					if(ten.equals("n")) {
						isTenured = false;
					}
					else {
						System.out.println("Please enter a valid letter.");
						ten = "not";
					}
				}
				
				System.out.println("What is the faculty member's name? Enter here: ");
				name = scnr.next();
				System.out.println("What year was the faculty member born? Enter here: ");
				birthYear = scnr.nextInt();
				System.out.println("what department does the faculty member work in? Enter here: ");
				deptName = scnr.next();
				
				Faculty fac = new Faculty(name, birthYear, deptName, isTenured);
				if(numFaculty < 100) {
					faculty[numFaculty] = fac;
							numFaculty++;
							num++;
				}
				
			}
		}
		else if(choice.equals("c")) {
			System.out.println("Create 3 new General Staff objects");
			int num = 0;
			
			while (num < 3) {
				String deptName ="";
				String duty ="";
				String name = "";
				int birthYear = 0;
				System.out.println("Enter the General Staff information for 1 new Staff member by following the instructions below.\n"+ "You have already created " 
				+ num + "/3 Faculty objects.");
				
				System.out.println("What is the general staff member's name? Enter here: ");
				name = scnr.next();
				System.out.println();
				System.out.println("What year was the faculty member born? Enter here: ");
				birthYear = scnr.nextInt();
				System.out.println("What department does the faculty member work in? Enter here: ");
				deptName = scnr.next();
				System.out.println("What is this general staff member's duty? ");
				duty = scnr.next();
				
				GeneralStaff staff = new GeneralStaff(name, birthYear, deptName, duty);
				if(numGeneralStaff < 100) {
					generalStaff[numGeneralStaff] = staff;
					numGeneralStaff++;
					num++;
				}
			}
		}
		else if(choice.equals("d")) {
			System.out.println("Create 3 new Student objects");
			int num = 0;
			int birthYear = 0;
			
			while(num < 3) {
				boolean isGraduate = false;
				String name ="";
				String major = "";
				String grad = "";
				
				System.out.println("Enter the Stduent information for 1 new Student by following the instructions below.\n "
						+ "You have already created " +num+ "/3 Student objects." );
				while(grad.length() != 1) {
					System.out.println("Is the student a graduate student? (Enter 'y' or 'n')");
					grad = scnr.next();
					grad = grad.trim();
					grad = grad.toLowerCase();
					if(grad.equals("y")) {
						isGraduate = true;
					}
					else if (grad.equals("n")) {
						isGraduate = false;
					}
					else {
						System.out.println("Please enter a valid letter.");
						grad = "not";
					}
				}
				System.out.println("What is the student's name? Enter here: ");
				name = scnr.next();
				System.out.println();
				System.out.println("In which year was the student born? Enter here: ");
				birthYear = scnr.nextInt();
				System.out.println("What is the stduent's major? Enter here: ");
				major = scnr.next();
				
				Student student1 = new Student(name, birthYear, major, isGraduate);
				if(numStudent < 100) {
					student[numStudent]=student1;
					numStudent++;
					num++;
				}
			}
		}
		else if(choice.equals("e")) {
			System.out.println("Add 2 courses to one of the Faculty Objects");
			int num =0;
			int facultyNumber = 0;
			System.out.println("First, choose the faculty memeber to whom you want to give 2 course: ");
			for(int i = 0; i < numFaculty; i++) {
				int identifier = i +1;
				System.out.println(identifier + ": " + faculty[i].toString());		
			}
			
			while(facultyNumber == 0) {
				facultyNumber = scnr.nextInt();
				System.out.println();
				if(!(facultyNumber>0 && facultyNumber <= numFaculty)) {
					facultyNumber = 0;
					System.out.println("Enter a valid integer that corresponds to your chosen faculty member: ");
				}
			}
			while (num < 2) {
				boolean isGradCourse = false;
				int courseNum = 0;
				String courseDept = "";
				int numCredits = 0;
				String grad = "";
				
				System.out.println();
				System.out.println("Add 2 courses in faculty member #" + facultyNumber);
				System.out.println("Answe the following questions. You have complated " + num+ "/2 courses.");
				
				while(grad.length() !=1) {
					System.out.println("Is the course a Graduate course? (Enter 'y' or 'n')");
					grad =scnr.next();
					grad = grad.trim();
					grad = grad.toLowerCase();
					if(grad.equals("y")) {
						isGradCourse = true;
					}
					else if (grad.equals("n")) {
						isGradCourse = false;
					}
					else {
						System.out.println("Please enter course vaild letter");
						grad = "not";
					}
				}
				
				System.out.println("What is the course number? Enter here: ");
				courseNum =scnr.nextInt();
				System.out.println("What is the course deparment? Enter here: ");
				courseDept =scnr.next();
				System.out.println("How many credits will this course provides? Enter here: ");
				numCredits =scnr.nextInt();
				
				Course course1 = new Course(isGradCourse, courseNum,courseDept, numCredits);
				faculty[facultyNumber -1].addCoursesTaught(course);
				num++;
			}
			
		}
		
		else if(choice.equals("f")) {
			System.out.println("Add 2 new Courses to a Student object");
			int num =0;
			int studentNumber = 0;
			
			System.out.println("First, choose the student to whom yo want to give 2 courses: ");
			for (int i =0; i<numStudent; i++) {
				int identifier = i +1;
				System.out.println(identifier + ": " + student[i].toString());
			}
			
			while(studentNumber == 0) {
				studentNumber = scnr.nextInt();
				System.out.println();
				if(!(studentNumber >0 && studentNumber <= numFaculty)){
					studentNumber =0;
					System.out.println("Enter a valid input");
				}
			}
			while(num <2) {
				boolean isGradCourse = false;
				int courseNum =0;
				String courseDept = "";
				int numCredits = 0;
				String grad = "";
				System.out.println();
				System.out.println("Add 2 course to student #" + studentNumber);
				System.out.println("Answer the following questions. You have completed " + num+ "/2 courses");
				
				while(grad.length() != 1) {
					System.out.println("Is the course a graduate course? (Enter 'y' or 'n')");
					grad = scnr.next().trim().toLowerCase();
					if(grad.equals("y")) {
						isGradCourse = true;
					}
					else if (grad.equals("n")) {
						isGradCourse = false;
					}
					else {
						System.out.println("Please enter course valid letter.");
						grad = "not";
						
					}
				}
				
				System.out.println("What is the course number? Enter here: ");
				courseNum =scnr.nextInt();
				System.out.println("What is the course depatment? Enter here: ");
				courseDept = scnr.next();
				System.out.println("How many credits will this course provide? Enter here: ");
				numCredits = scnr.nextInt();
				
				Course course1 = new Course(isGradCourse, courseNum, courseDept, numCredits);
				student[studentNumber-1].addCoursesTaken(course);
				num++;
			}
			
			
		}
		else if (choice.equals("g")) {
			Course[]additionalCourses = new Course[2];
			System.out.println("Help us add 2 courses to one of the Faculty Objects!");
			int num = 0;
			int facultyNumber = 0;
			
			System.out.println("First, choose the faculty memeber to whom you want to give 2 courses: ");
			for(int i = 0; i<numFaculty; i++) {
				int idenitfier = i+1;
				System.out.println(idenitfier + ": " + faculty[1].toString());
			}
			while(facultyNumber == 0) {
				facultyNumber = scnr.nextInt();
				System.out.println();
				if(!(facultyNumber>0 && facultyNumber <= numFaculty)) {
					facultyNumber = 0;
					System.out.println("Enter a valid integer that corresponds to your chosen faculty number: ");
				}
			}
			while(num <2) {
				boolean isGradCourse = false;
				int courseNum = 0;
				String courseDept = "";
				int numCredits = 0;
				String grad = "";
				
				System.out.println();
				System.out.println("Add 2 courses to faculty member #" + facultyNumber);
				System.out.println("Answer the following questions. You have completed" + num + "/2 courses");
				
				while(grad.length() != 1) {
					System.out.println("Is the course a graduate course? (Enter 'y' or 'n')");
					grad = scnr.next().trim().toLowerCase();
					if(grad.equals("y")) {
						isGradCourse = true;
					}
					else if(grad.equals("n")) {
						isGradCourse = false;
					}
					else {
						System.out.println("Please enter course valid letter.");
						grad = "not";
					}
				}
				
				System.out.println("What is the course number? Enter here: ");
				courseNum =scnr.nextInt();
				System.out.println("What is the course department? Enter here: ");
				courseDept = scnr.next();
				System.out.println("How many credits will this course provide? Enter here: ");
				numCredits =scnr.nextInt();
				
				Course course1 = new Course(isGradCourse, courseNum, courseDept, numCredits);
				additionalCourses[num] = course1;
				num++;
			}
			student[numStudent -1].addCoursesTaken(additionalCourses);
		}
		else if (choice.equals("i")) {
			System.out.println("First, choose the faculty member: ");
			for(int i = 0; i<numFaculty; i++) {
				int identifier = i+1;
				System.out.println(identifier + ": " + faculty[i].toString());
			}
			
			int facultyNumber = 0;
			while(facultyNumber == 0) {
				facultyNumber = scnr.nextInt();
				System.out.println();
				if(!(facultyNumber>0 && facultyNumber<= numFaculty)) {
					facultyNumber = 0;
					System.out.println("Enter a valid integer that matches to a faculty member: ");
				}
			}
			System.out.println("Enter an index to find the course at that index of faculty member #" + facultyNumber + ".");
			int index = 1;
			int numberFacultyCourses = faculty[facultyNumber -1].getNumCoursesTaught();
			
			if(numberFacultyCourses == 0) {
				System.out.println("Faculty #" + facultyNumber + " has no courses.");
			}
			while (index == -1 && numberFacultyCourses>0) {
				index = scnr.nextInt();
				if(index < numberFacultyCourses && index >-1) {
					System.out.println(faculty[facultyNumber -1].getCourseTaughtAsString(index));
				}
				else {
					System.out.println("Enter a vaild index. There is no course at that index.");
					index = -1;
			}
		}
	}
		else if(choice.equals("j")) {
			System.out.println("First, choose the student member: ");
			for(int i = 0; i<numStudent; i++) {
				int identifier = i+1;
				System.out.println(identifier + ": " + student[i].toString());
			}
			
			int studentNumber = 0;
			while(studentNumber == 0) {
				studentNumber = scnr.nextInt();
				System.out.println();
				if(!(studentNumber>0 && studentNumber<= numFaculty)) {
					studentNumber = 0;
					System.out.println("Enter a valid integer that matches to a student member: ");
				}
			}
			System.out.println("Enter an index to find the course at that index of faculty member #" + studentNumber + ".");
			int index = 1;
			int numberFacultyCourses = faculty[studentNumber -1].getNumCoursesTaught();
			
			if(numberFacultyCourses == 0) {
				System.out.println("Faculty #" + studentNumber + " has no courses.");
			}
			while (index == -1 && numberFacultyCourses>0) {
				index = scnr.nextInt();
				if(index < numberFacultyCourses && index >-1) {
					System.out.println(faculty[studentNumber -1].getCourseTaughtAsString(index));
				}
				else {
					System.out.println("Enter a vaild index. There is no course at that index.");
					index = -1;
			}
		}
	}
		else if(choice.equals("k")) {
			System.out.println("select a faculty member form the list below. ");
			System.out.println("First, choose the faculty member: ");
			for(int i =0; i<numFaculty;i++) {
				int identifier = i+1;
				System.out.println(identifier + ": " +faculty[i].toString());
			}
			int facultyNumber =0;
			while (facultyNumber == 0) {
				facultyNumber = scnr.nextInt();
				System.out.println();
				if(!(facultyNumber>0 && facultyNumber <= numFaculty)) {
					facultyNumber = 0;
					System.out.println("Enter a valid integer that mactches a faculty member: ");
				}
			}
			int chosenFaculty = facultyNumber -1;
			
			System.out.println("select a course object form the list below. ");
			for(int i =0; i<numCourse; i++) {
				int identifier =i + 1;
				System.out.println(identifier +": " + course[i].toString());
			}
			int facultyNumber1 = 0;
			while(facultyNumber1 == 0) {
				facultyNumber1 = scnr.nextInt();
				System.out.println();
				if(!(facultyNumber1 >0 && facultyNumber1 <= numFaculty)) {
					facultyNumber1 = 0;
				}
		}
			//int chosenFaculty = faculty -1;
			
		}

		try {
			textFile = new FileInputStream("SchoolDB_Initial.txt");
			scan = new Scanner(textFile);
			
			while(scan.hasNext()) {
				output = scan.nextLine();
				System.out.println(output);
				String objectName = extractObjectType(output);
				String parametersUnfixed = deleteObjectName(output);
				
				if(objectName.contentEquals("COURSE") ) {
					numCourse = courseMaker(parametersUnfixed, course, numCourse);
				}
				if(objectName.contentEquals("PERSON") ) {
					numPerson = personMaker(parametersUnfixed, person, numPerson);
				}
				if(objectName.contentEquals("EMPLOYEE") ) {
					numEmployee = employeeMaker(parametersUnfixed, employee, numEmployee);
				}
				if(objectName.contentEquals("FACULTY") ) {
					numFaculty = facultyMaker(parametersUnfixed, faculty, numFaculty);
				}
				if(objectName.contentEquals("GENERALSTAFF") ) {
					numGeneralStaff = generalStaffMaker(parametersUnfixed, generalStaff, numGeneralStaff);
				}
				if(objectName.contentEquals("STUDENT") ) {
					numStudent = studentMaker(parametersUnfixed, student, numStudent);
				}
				
				
			}
		}
		catch(IOException excpt){
			System.out.println("Could not find the file");
		}
		finally {
			System.out.println();
			System.out.println("**************************************************************");
			System.out.println("SCHOOL DATABASE INFO:");
			System.out.println();
			System.out.println("************************************************");
			System.out.println("COURSES:");
			
			for(int i = 0; i < numCourse; i++) {
				System.out.println(course[i].toString());
			}
			
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("PERSONS:");
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("EMPLOYEES:");
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("GENERAL STAFF:");
			
			for(int i = 0; i < numGeneralStaff; i++) {
				System.out.println(generalStaff[i].toString());
			}
			
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("FACULTY:");
			
			for(int i = 0; i < numFaculty; i++) {
				System.out.println(faculty[i].toString());
			}
			
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("STUDENTS:");
			
			for(int i = 0; i < numStudent; i++) {
				System.out.println(student[i].toString());
			}
			
			System.out.println("************************************************");
			System.out.println("**************************************************************");
			System.out.println();

		}
		
	}
	
	public static String extractObjectType(String input) {
		if(input.length() == 0) {
			return "";
		}
		String objectName = "";
		String newString = "";
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == ':') {
				objectName = input.substring(0, i);
				if(i+2 < input.length()) {
					newString = input.substring(i+2, input.length());
				}
				break;
			}
		}
		objectName = objectName.toUpperCase();
		return objectName;
		
	}
	
	public static String deleteObjectName(String input) {
		if(input.length() == 0) {
			return "";
		}
		String objectName = "";
		String newString = "";
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == ':') {
				objectName = input.substring(0, i);
				if(i+2 < input.length()) {
					newString = input.substring(i+2, input.length());
				}
				break;
			}
		}
		objectName = objectName.toUpperCase();
		return newString;
		
	}
	
	
	
	public static int courseMaker(String input, Course [] course, int numCourse) {
		int numParameters = countNumParameters(input);
		String [] parameters = seperateParameters(input, numParameters);
		
			Course addCourse = new Course(Boolean.parseBoolean(parameters[0]), Integer.parseInt(parameters[1]), parameters[2], Integer.parseInt(parameters[3]) );
			course[numCourse] = addCourse;
			numCourse += 1;
			return numCourse;
	}
	
	public static int personMaker(String input, Person [] person, int numPerson) {
		int numParameters = countNumParameters(input);
		String [] parameters = seperateParameters(input, numParameters);
		
		if (numParameters == 0) {
			Person addPerson = new Person();
			person[numPerson] = addPerson;
			numPerson += 1;
			return numPerson;
		}
		if (numParameters == 2) {
			Person addPerson = new Person(parameters[0], Integer.parseInt(parameters[1]));
			person[numPerson] = addPerson;
			numPerson += 1;
			return numPerson;
		}
		return 0;
	}
	
	public static int employeeMaker(String input, Employee [] employee, int numEmployee) {
		int numParameters = countNumParameters(input);
		String [] parameters = seperateParameters(input, numParameters);
		
		if (numParameters == 0) {
			Employee addEmployee = new Employee();
			employee[numEmployee] = addEmployee;
			numEmployee += 1;
			return numEmployee;
		}
		if (numParameters == 1) {
			Employee addEmployee = new Employee(parameters[0]);
			employee[numEmployee] = addEmployee;
			numEmployee += 1;
			return numEmployee;
		}
		if (numParameters == 3) {
			Employee addEmployee = new Employee(parameters[0], Integer.parseInt(parameters[1]), parameters[2]);
			employee[numEmployee] = addEmployee;
			numEmployee += 1;
			return numEmployee;
		}
		return 0;
	}
	
	public static int facultyMaker(String input, Faculty [] faculty, int numFaculty) {
		int numParameters = countNumParameters(input);
		String [] parameters = seperateParameters(input, numParameters);
		
		if (numParameters == 0) {
			Faculty addFaculty = new Faculty();
			faculty[numFaculty] = addFaculty;
			numFaculty += 1;
			return numFaculty;
		}
		if (numParameters == 1) {
			Faculty addFaculty = new Faculty(Boolean.parseBoolean(parameters[0]));
			faculty[numFaculty] = addFaculty;
			numFaculty += 1;
			return numFaculty;
		}
		if (numParameters == 2) {
			Faculty addFaculty = new Faculty(parameters[0], Boolean.parseBoolean(parameters[1]));
			faculty[numFaculty] = addFaculty;
			numFaculty += 1;
			return numFaculty;
		}
		if (numParameters == 4) {
			Faculty addFaculty = new Faculty(parameters[0], Integer.parseInt(parameters[1]), parameters[2], Boolean.parseBoolean(parameters[3]));
			faculty[numFaculty] = addFaculty;
			numFaculty += 1;
			return numFaculty;
		}
		return 0;
	}
	
	public static int generalStaffMaker(String input, GeneralStaff [] generalStaff, int numGeneralStaff) {
		int numParameters = countNumParameters(input);
		String [] parameters = seperateParameters(input, numParameters);
		
		if (numParameters == 0) {
			GeneralStaff addGeneralStaff = new GeneralStaff();
			generalStaff[numGeneralStaff] = addGeneralStaff;
			numGeneralStaff += 1;
			return numGeneralStaff;
		}
		if (numParameters == 1) {
			GeneralStaff addGeneralStaff = new GeneralStaff(parameters[0]);
			generalStaff[numGeneralStaff] = addGeneralStaff;
			numGeneralStaff += 1;
			return numGeneralStaff;
		}
		if (numParameters == 2) {
			GeneralStaff addGeneralStaff = new GeneralStaff(parameters[0], parameters[1]);
			generalStaff[numGeneralStaff] = addGeneralStaff;
			numGeneralStaff += 1;
			return numGeneralStaff;
		}
		if (numParameters == 4) {
			GeneralStaff addGeneralStaff = new GeneralStaff(parameters[0], Integer.parseInt(parameters[1]), parameters[2], parameters[3]);
			generalStaff[numGeneralStaff] = addGeneralStaff;
			numGeneralStaff += 1;
			return numGeneralStaff;
		}
		return 0;
	}
	
	public static int studentMaker(String input, Student [] student, int numStudent) {
		int numParameters = countNumParameters(input);
		String [] parameters = seperateParameters(input, numParameters);
		
		if (numParameters == 0) {
			Student addStudent = new Student();
			student[numStudent] = addStudent;
			numStudent += 1;
			return numStudent;
		}
		if (numParameters == 1) {
			Student addStudent = new Student(Boolean.parseBoolean(parameters[0]));
			student[numStudent] = addStudent;
			numStudent += 1;
			return numStudent;
		}
		if (numParameters == 2) {
			Student addStudent = new Student(parameters[0], Boolean.parseBoolean(parameters[1]));
			student[numStudent] = addStudent;
			numStudent += 1;
			return numStudent;
		}
		if (numParameters == 4) {
			Student addStudent = new Student(parameters[0], Integer.parseInt(parameters[1]), parameters[2], Boolean.parseBoolean(parameters[3]));
			student[numStudent] = addStudent;
			numStudent += 1;
			return numStudent;
		}
		return 0;
	}
	
	
	
	public static int countNumParameters(String text) {
		int numWords = 0;
		for(int i = 0; i < text.length(); i ++) {
			if(text.charAt(i) == ',') {
				numWords += 1;
			}
		}
		if (numWords == 0) {
		}
		else { 
			numWords = numWords + 1; 
			}
		if( (numWords == 0) && (text.length() > 0) ) {
			numWords = 1;
		}
		return numWords;
		
	}
	
	public static String [] seperateParameters(String text, int numParameters) {
		String [] parameters = new String[numParameters];
		int count = 0;
		String fixMe = "";
		int previousIndex = 0;
		
		for(int i = 0; i < text.length(); i++) {
			if(i == (text.length() - 1) ) {
				fixMe = text.substring(previousIndex, text.length() );
				if(fixMe.charAt(0) == ' ') {
					fixMe = fixMe.substring(1, fixMe.length());
				}
				parameters[count] = fixMe;
				count += 1;
				previousIndex = i+1;
			}
			if( (text.charAt(i) == ',') && (text.charAt(i+1) == ' ') ) {
				fixMe = text.substring(previousIndex, i);
				if(fixMe.charAt(0) == ' ') {
					fixMe = fixMe.substring(1, fixMe.length());
				}
				parameters[count] = fixMe;
				count += 1;
				previousIndex = i+1;
			}
			else if(text.charAt(i) == ',') {
				fixMe = text.substring(previousIndex, i);
				if(fixMe.charAt(0) == ' ') {
					fixMe = fixMe.substring(1, fixMe.length());
				}
				parameters[count] = fixMe;
				count += 1;
				previousIndex = i+1;
			}
		
		}
		return parameters;
	}
	
	public static void courseHighestLowest(Course [] course, int numCourse) {
		int highest = 0;
		int highIndex = 0;
		int lowest = 0;
		int lowIndex = 0;
		int currentNum = 0;
		
		for(int i = 0; i < numCourse; i++) {
			if(i == 0) {
				lowest = course[i].getCourseNum();
				highest = course[i].getCourseNum();
			}
			else {
				currentNum = course[i].getCourseNum();
				if( currentNum < lowest) {
					lowest = currentNum;
					lowIndex = i;
				}
				if (currentNum > highest) {
					highest = currentNum;
					highIndex = i;
				}
			}
		}
		
		System.out.println("Lowest Course #: " + course[lowIndex]);
		System.out.println("Highest Course #: " + course[highIndex]);
	}
	
	public static void facultyHighestLowest(Faculty [] faculty, int numFaculty) {
		int lowest = 0;
		int lowIndex = 0;
		int highest = 0;
		int highIndex = 0;
		int currentNum = 0;
		
		for(int i = 0; i < numFaculty; i++) {
			if(i == 0) {
				lowest = faculty[i].getNumCoursesTaught();
				highest = faculty[i].getNumCoursesTaught();
			}
			else {
				currentNum = faculty[i].getNumCoursesTaught();
				if( currentNum < lowest) {
					lowest = currentNum;
					lowIndex = i;
				}
				if (currentNum > highest) {
					highest = currentNum;
					highIndex = i;
				}
			}
		}
		
		System.out.println("Teachest least # of Courses: " + faculty[lowIndex].toString());
		System.out.println("Teachst most #  of Courses: " + faculty[highIndex].toString());
		
		
	}
	
	public static int studentTotalCredit(Student student) {
		int total = 0;
		int numClassTaken = student.getNumCoursesTaken();
		
		for(int i = 0; i < numClassTaken; i++) {
			total = total + student.getCourseTaken(i).getNumCredits();
		}
		return total;
	}
	
	public static void studentHighLow(int [] totals, Student [] student, int totalLength) {
		int lowest = 0;
		int lowIndex = 0;
		int highest = 0;
		int highIndex = 0;
		int currentNum = 0;
		
		for(int i = 0; i < totalLength; i++) {
			if(i == 0) {
				lowest = totals[i];
				highest = totals[i];
			}
			else {
				currentNum = totals[i];
				if( currentNum < lowest) {
					lowest = currentNum;
					lowIndex = i;
				}
				if (currentNum > highest) {
					highest = currentNum;
					highIndex = i;
				}
			}
		}
		
		System.out.println("Student with least credits: " + student[lowIndex].toString());
		System.out.println("Student with most credits: " + student[highIndex].toString());
	}
	
	

}
