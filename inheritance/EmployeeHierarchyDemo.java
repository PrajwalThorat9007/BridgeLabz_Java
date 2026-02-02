/*
Description: Create an Employee hierarchy for different employee types such as Manager, Developer, and Intern.
Tasks:
Define a base class Employee with attributes like name, id, and salary, and a method displayDetails().
Define subclasses Manager, Developer, and Intern with unique attributes for each, like teamSize for Manager and programmingLanguage for Developer.
Goal: Practice inheritance by creating subclasses with specific attributes and overriding superclass methods.
 */
// Base class

package inheritance;
class Employee {
    String name; // employee name
    int id; // employee id
    double salary; // employee salary

    Employee(String name, int id, double salary) {
        this.name = name; // initializing name
        this.id = id; // initializing id
        this.salary = salary; // initializing salary
    }

    // method to display employee details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

// Manager subclass
class Manager extends Employee {
    int teamSize; // number of team members

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary); // calling parent constructor
        this.teamSize = teamSize; // initializing team size
    }

    // overriding displayDetails method
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

// Developer subclass
class Developer extends Employee {
    String programmingLanguage; // primary programming language

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary); // calling parent constructor
        this.programmingLanguage = programmingLanguage; // initializing language
    }

    // overriding displayDetails method
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Intern subclass
class Intern extends Employee {
    int internshipDuration; // duration in months

    Intern(String name, int id, double salary, int internshipDuration) {
        super(name, id, salary); // calling parent constructor
        this.internshipDuration = internshipDuration; // initializing duration
    }

    // overriding displayDetails method
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Internship Duration: " + internshipDuration + " months");
    }
}

// Main class
public class EmployeeHierarchyDemo {
    public static void main(String[] args) {

        Employee emp1 = new Manager("Amit", 101, 75000, 8);
        Employee emp2 = new Developer("Neha", 102, 60000, "Java");
        Employee emp3 = new Intern("Ravi", 103, 15000, 6);

        emp1.displayDetails();
        System.out.println();

        emp2.displayDetails();
        System.out.println();

        emp3.displayDetails();
    }
}
