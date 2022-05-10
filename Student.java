
public class Student extends Person{
	private static int numStudents = 0;
	private int studentID;
	private Course[] coursesTaken = new Course[50];
	private int numCoursesTaken;
	private boolean isGraduate;
	private String major = "undeclared";
	
	public Student() {
		super();
		this.coursesTaken    = new Course[50];		
		numStudents++;
		this.studentID = numStudents;
		this.numCoursesTaken = 0;
		this.isGraduate      = false;
		       
	}
	
	public Student(boolean isGraduate) {
		super();
		this.isGraduate = isGraduate;
		numStudents++;
		this.studentID = numStudents;
	}
	
	public Student(String major, boolean isGraduate) {
		super();
		this.major      = major;
		this.isGraduate = isGraduate;
		numStudents++;
		this.studentID = numStudents;
	}
	
	public Student(String name, int birthYear, String major, boolean isGraduate) {
		super.setName(name);
		super.setBirthYear(birthYear);
		this.major      = major;
		this.isGraduate = isGraduate;
		numStudents++;
		this.studentID = numStudents;
	}
	
	public boolean isGraduate() {
		return this.isGraduate;
	}
	
	public int getNumCoursesTaken() {
		return this.numCoursesTaken;
	}
	
	public static int getNumStudents() {
		return numStudents;
	}
	
	public int getStudentID() {
		return this.studentID;
	}
	
	public String getMajor() {
		return this.major;
	}
	
	public void setIsGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}
	
	public String isGraduate1() {
		if(this.isGraduate == true)
			return "Graduate";
		else
			return "Undergraduate";
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public void addCourseTaken(Course course) {
		if(this.numCoursesTaken < this.coursesTaken.length) {
			this.coursesTaken[this.numCoursesTaken++] = course;	
		}
	}
	
	public void addCoursesTaken(Course [] course) {
		for(int i = 0; i < this.coursesTaken.length && i < course.length; i++) {
			this.coursesTaken[this.numCoursesTaken] = course[i];
		}
	}
	
	public Course getCourseTaken(int index) {
		if(index < 0 || index >= this.numCoursesTaken) {
			return null;
		}
		return this.coursesTaken[index];
	}
	
	public String getCourseTakenAsString(int index) {
		if(index < 0 || index >= this.numCoursesTaken) {
			return "";
		}
		return this.coursesTaken[index].getCourseDept() + "-" + this.coursesTaken[index].getCourseNum();
	}
	
	public String getAllCoursesTakenAsString() {
		String index = "";
		for(int i = 0; i < this.numCoursesTaken; i++) {
			 index += this.getCourseTakenAsString(i);
			 index += ", ";
		}
		index = index.trim();
		if(index.endsWith(",")) 
			 index = index.substring(0, index.length() - 1);		
		return index;
	}
	
	public int getNumCredits() {
		int credits = 0;
		for(int i = 0; i < this.numCoursesTaken; i++) {
			credits = credits + this.coursesTaken[i].getNumCredits();			
		}
		return credits;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj))
			return false;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		
		Student s = (Student)obj;
		if(this.isGraduate != s.isGraduate)
			return false;
		if(this.coursesTaken != s.coursesTaken)
			return false;
		if(!this.major.equals(s.major))
			return false;
		if(this.numCoursesTaken != s.numCoursesTaken)
			return false;
		if(this.studentID != s.studentID)
			return false;
//		if(this.numStudents != s.numStudents)
//			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + String.format(" Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s", this.studentID, 
				this.major, isGraduate1(), this.numCoursesTaken, this.getAllCoursesTakenAsString());
	}
	
	@Override
	public int compareTo(Person p) {
		if(this.getClass() == p.getClass()) {
			
			Student st = (Student)p;
			if(this.getNumCredits() == st.getNumCredits())
				return 0;
			else if(this.getNumCredits() < st.getNumCredits())
				return -1;
			else
				return 1;
		}
		else {
			return super.compareTo(p);
		}
	}

}
