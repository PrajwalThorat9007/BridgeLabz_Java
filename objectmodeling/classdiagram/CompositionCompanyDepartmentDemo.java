/*
Problem 3: Company and Departments (Composition)
Description: A Company has several Department objects, and each department contains Employee objects. Model this using composition, where deleting a company should also delete all departments and employees.
Tasks:
Define a Company class that contains multiple Department objects.
Define an Employee class within each Department.
Show the composition relationship by ensuring that when a Company object is deleted, all associated Department and Employee objects are also removed.
Goal: Understand composition by implementing a relationship where Department and Employee objects cannot exist without a Company. */
import java.util.ArrayList;
class Employee {
    private String empName;

    public Employee(String empName) {
        this.empName = empName;
    }

    public void displayEmployee() {
        System.out.println("    Employee: " + empName);
    }
}


class Department {
    private String deptName;
    private ArrayList<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String empName) {
        employees.add(new Employee(empName));
    }

    public void displayDepartment() {
        System.out.println("  Department: " + deptName);
        for (Employee emp : employees) {
            emp.displayEmployee();
        }
    }

    // Called when Company is deleted
    public void clearEmployees() {
        employees.clear();
    }
}


class Company {
    private String companyName;
    private ArrayList<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void displayCompany() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }

    // Composition destruction
    public void deleteCompany() {
        for (Department dept : departments) {
            dept.clearEmployees();
        }
        departments.clear();
        System.out.println("\nCompany deleted along with all departments and employees.");
    }
}
public class CompositionCompanyDepartmentDemo {
    public static void main(String[] args) {

        Company techCompany = new Company("TechNova Pvt Ltd");

        Department devDept = new Department("Development");
        devDept.addEmployee("Alice");
        devDept.addEmployee("Bob");

        Department hrDept = new Department("HR");
        hrDept.addEmployee("Charlie");

        techCompany.addDepartment(devDept);
        techCompany.addDepartment(hrDept);

        techCompany.displayCompany();

        // Deleting company (composition effect)
        techCompany.deleteCompany();
    }
}
