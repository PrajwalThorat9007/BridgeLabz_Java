/*
Problem 1: University Management System with Students, Professors, and Courses (Association and Communication)
 */
import java.util.ArrayList;

// Student class
class Student {
    private String name; // student name
    private ArrayList<Course> courses; // associated courses

    public Student(String name) {
        this.name = name; // initializing student name
        this.courses = new ArrayList<>(); // initializing course list
    }

    // communication between student and course
    public void enrollCourse(Course course) {
        courses.add(course); // associating course with student
        course.addStudent(this); // bidirectional association
        System.out.println(name + " enrolled in " + course.getCourseName());
    }

    public String getName() {
        return name; // returning student name
    }
}

// Professor class
class Professor {
    private String name; // professor name

    public Professor(String name) {
        this.name = name; // initializing professor name
    }

    public String getName() {
        return name; // returning professor name
    }
}

// Course class
class Course {
    private String courseName; // course name
    private Professor professor; // associated professor
    private ArrayList<Student> students; // aggregated students

    public Course(String courseName) {
        this.courseName = courseName; // initializing course name
        this.students = new ArrayList<>(); // initializing student list
    }

    // assigning professor to course
    public void assignProfessor(Professor professor) {
        this.professor = professor; // associating professor
        System.out.println(professor.getName() + " assigned to " + courseName);
    }

    // aggregation: course has students
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student); // adding student to course
        }
    }

    public String getCourseName() {
        return courseName; // returning course name
    }

    public void displayCourseDetails() {
        System.out.println("\nCourse: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not Assigned"));
        System.out.println("Students Enrolled:");
        for (Student s : students) {
            System.out.println("  " + s.getName());
        }
    }
}

// Main class
public class UniversityManagementSystemDemo {
    public static void main(String[] args) {

        Student s1 = new Student("Prajwal"); // creating student
        Student s2 = new Student("Anita"); // creating student

        Professor p1 = new Professor("Dr. Sharma"); // creating professor

        Course java = new Course("Java Programming"); // creating course

        java.assignProfessor(p1); // assigning professor to course

        s1.enrollCourse(java); // student-course communication
        s2.enrollCourse(java);

        java.displayCourseDetails(); // displaying course details
    }
}
