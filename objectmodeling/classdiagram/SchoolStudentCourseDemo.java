/*
Problem 1: School and Students with Courses (Association and Aggregation)
Description: Model a School with multiple Student objects, where each student can enroll in multiple courses, and each course can have multiple students.
Tasks:
Define School, Student, and Course classes.
Model an association between Student and Course to show that students can enroll in multiple courses.
Model an aggregation relationship between School and Student.
Demonstrate how a student can view the courses they are enrolled in and how a course can show its enrolled students.
Goal: Practice association by modeling many-to-many relationships between students and courses.
 */
import java.util.ArrayList;

class School {
    private String schoolName;
    private ArrayList<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("School: " + schoolName);
        for (Student s : students) {
            System.out.println("  Student: " + s.getName());
        }
    }
}


class Student {
    private String name;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);   // bidirectional association
    }

    public void viewCourses() {
        System.out.println("Courses enrolled by " + name + ":");
        for (Course c : courses) {
            System.out.println("  " + c.getCourseName());
        }
    }
}


class Course {
    private String courseName;
    private ArrayList<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void viewStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student s : students) {
            System.out.println("  " + s.getName());
        }
    }
}

// 
public class SchoolStudentCourseDemo {
    public static void main(String[] args) {

        School school = new School("Green Valley School");

        Student prajwal = new Student("Prajwal");
        Student anita = new Student("Anita");

        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        school.addStudent(prajwal);
        school.addStudent(anita);

        prajwal.enrollCourse(math);
        prajwal.enrollCourse(science);

        anita.enrollCourse(science);

        prajwal.viewCourses();
        anita.viewCourses();

        science.viewStudents();
    }
}
