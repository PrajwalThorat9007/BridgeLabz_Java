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
class Employee {

    public int employeeID;
    protected String department;
    private double salary;

    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void updateSalary(double salary) {
        this.salary = salary;
    }
}
class Manager extends Employee {

    String designation;

    Manager(int employeeID, String department, double salary, String designation) {
        super(employeeID, department, salary);
        this.designation = designation;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + getSalary());
        System.out.println("Designation: " + designation);
    }
}
public class EmployeeMain {
    public static void main(String[] args) {

        Manager manager = new Manager(201, "IT", 75000, "Project Manager");
        manager.displayDetails();

        manager.updateSalary(82000);
        System.out.println("Updated Salary: " + manager.getSalary());
    }
}
