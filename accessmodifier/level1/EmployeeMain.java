/*
Problem 4: Employee Records
Develop an Employee class with:
employeeID (public).
department (protected).
salary (private).
Write methods to:
Modify salary using a public method.
Create a subclass Manager to access employeeID and department.
 */
// Base class representing an employee
class Employee {

    // Public employee ID accessible everywhere
    public int employeeID;

    // Protected department accessible to subclasses
    protected String department;

    // Private salary to ensure encapsulation
    private double salary;

    // Constructor to initialize employee details
    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Getter method to access salary
    public double getSalary() {
        return salary;
    }

    // Method to update employee salary
    public void updateSalary(double salary) {
        this.salary = salary;
    }
}

// Derived class representing a manager
class Manager extends Employee {

    // Designation specific to manager
    String designation;

    // Constructor to initialize manager details
    Manager(int employeeID, String department, double salary, String designation) {
        super(employeeID, department, salary);
        this.designation = designation;
    }

    // Method to display manager details
    void displayDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + getSalary());
        System.out.println("Designation: " + designation);
    }
}

// Main class to test employee management
public class EmployeeMain {
    public static void main(String[] args) {

        // Create a Manager object
        Manager manager = new Manager(201, "IT", 75000, "Project Manager");

        // Display initial details
        manager.displayDetails();

        // Update salary and display updated value
        manager.updateSalary(82000);
        System.out.println("Updated Salary: " + manager.getSalary());
    }
}
