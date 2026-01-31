/*
Problem 2: University with Faculties and Departments (Composition and Aggregation)
Description: Create a University with multiple Faculty members and Department objects. Model it so that the University and its Departments are in a composition relationship (deleting a university deletes all departments), and the Faculty members are in an aggregation relationship (faculty can exist outside of any specific department).
Tasks:
Define a University class with Department and Faculty classes.
Demonstrate how deleting a University also deletes its Departments.
Show that Faculty members can exist independently of a Department.
Goal: Understand the differences between composition and aggregation in modeling complex hierarchical relationships.
 */
import java.util.ArrayList;

// Faculty can exist independently (Aggregation)
class Faculty {
    private String name; // faculty name

    public Faculty(String name) {
        this.name = name; // initializing faculty name
    }

    public String getName() {
        return name; // returning faculty name
    }
}

// Department cannot exist without University (Composition)
class Department {
    private String deptName; // department name

    public Department(String deptName) {
        this.deptName = deptName; // initializing department name
    }

    public void displayDepartment() {
        System.out.println("  Department: " + deptName); // displaying department
    }
}

// University is the owner class
class University {
    private String universityName; // university name
    private ArrayList<Department> departments; // composed departments
    private ArrayList<Faculty> facultyMembers; // aggregated faculty

    public University(String universityName) {
        this.universityName = universityName; // initializing university name
        this.departments = new ArrayList<>(); // initializing department list
        this.facultyMembers = new ArrayList<>(); // initializing faculty list
    }

    // adding department to university (Composition)
    public void addDepartment(Department department) {
        departments.add(department); // adding department
    }

    // adding faculty to university (Aggregation)
    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty); // adding faculty
    }

    // displaying university details
    public void displayUniversity() {
        System.out.println("University: " + universityName);

        System.out.println("Departments:");
        for (Department d : departments) {
            d.displayDepartment(); // displaying departments
        }

        System.out.println("Faculty Members:");
        for (Faculty f : facultyMembers) {
            System.out.println("  Faculty: " + f.getName()); // displaying faculty
        }
    }

    // deleting university deletes all departments
    public void deleteUniversity() {
        departments.clear(); // deleting departments
        System.out.println("\nUniversity deleted along with all departments.");
    }
}

// Main class
public class UniversityFacultyDepartmentDemo {
    public static void main(String[] args) {

        Faculty f1 = new Faculty("Dr. Sharma"); // creating faculty
        Faculty f2 = new Faculty("Dr. Mehta"); // creating faculty

        University uni = new University("National Technical University"); // creating university

        Department cse = new Department("Computer Science"); // creating department
        Department ece = new Department("Electronics"); // creating department

        uni.addDepartment(cse); // adding department to university
        uni.addDepartment(ece); // adding department to university

        uni.addFaculty(f1); // adding faculty to university
        uni.addFaculty(f2); // adding faculty to university

        uni.displayUniversity(); // displaying university details

        uni.deleteUniversity(); // deleting university

        System.out.println("\nFaculty still exists: " + f1.getName()); // faculty survives deletion
    }
}
