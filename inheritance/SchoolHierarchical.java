/*
Description: Create a hierarchy for a school system where Person is the superclass, and Teacher, Student, and Staff are subclasses.
Tasks:
Define a superclass Person with common attributes like name and age.
Define subclasses Teacher, Student, and Staff with specific attributes (e.g., subject for Teacher and grade for Student).
Each subclass should have a method like displayRole() that describes the role.
Goal: Demonstrate hierarchical inheritance by modeling different roles in a school, each with shared and unique characteristics.
 */
// Superclass
class Person {
    String name; // person name
    int age; // person age

    Person(String name, int age) {
        this.name = name; // initializing name
        this.age = age; // initializing age
    }

    // method to display common details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // method to be overridden
    void displayRole() {
        System.out.println("Role: Person");
    }
}

// Teacher subclass
class Teacher extends Person {
    String subject; // subject taught

    Teacher(String name, int age, String subject) {
        super(name, age); // calling parent constructor
        this.subject = subject; // initializing subject
    }

    @Override
    void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

// Student subclass
class Student extends Person {
    String grade; // student grade

    Student(String name, int age, String grade) {
        super(name, age); // calling parent constructor
        this.grade = grade; // initializing grade
    }

    @Override
    void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

// Staff subclass
class Staff extends Person {
    String department; // staff department

    Staff(String name, int age, String department) {
        super(name, age); // calling parent constructor
        this.department = department; // initializing department
    }

    @Override
    void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

// Main class
public class SchoolHierarchical {
    public static void main(String[] args) {

        Person p1 = new Teacher("Mr. Sharma", 40, "Mathematics");
        Person p2 = new Student("Amit", 16, "10th Grade");
        Person p3 = new Staff("Ravi", 35, "Administration");

        p1.displayDetails();
        p1.displayRole();
        System.out.println();

        p2.displayDetails();
        p2.displayRole();
        System.out.println();

        p3.displayDetails();
        p3.displayRole();
    }
}
