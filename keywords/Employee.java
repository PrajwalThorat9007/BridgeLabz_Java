/*
Design an Employee class with the following features:
Static:
A static variable companyName shared by all employees.
A static method displayTotalEmployees() to show the total number of employees.
This:
Use this to initialize name, id, and designation in the constructor.
Final:
Use a final variable id for the employee ID, which cannot be modified after assignment.
Instanceof:
Check if a given object is an instance of the Employee class before printing the employee details.
 */
class Employee {

    static String companyName = "Tech Solutions Pvt Ltd";
    private static int empCount = 0;

    private final int id;
    private String name;
    private String desig;

    // Constructor to initialize employee details
    Employee(String name, int id, String desig) {
        this.name = name;
        this.id = id;
        this.desig = desig;
        empCount++;
    }

    // Displays total number of employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + empCount);
    }

    // Prints employee details after checking object type
    public static void printDetails(Object obj) {
        if (obj instanceof Employee) {
            Employee e = (Employee) obj;
            System.out.println("Company Name : " + companyName);
            System.out.println("Employee ID  : " + e.id);
            System.out.println("Name         : " + e.name);
            System.out.println("Designation  : " + e.desig);
        } else {
            System.out.println("Object is not an Employee");
        }
    }

    // Entry point of the program
    public static void main(String[] args) {
        Employee e2 = new Employee("Rahul", 202, "DevOps Engineer");

        displayTotalEmployees();

        printDetails(e1);
        System.out.println();
        printDetails(e2);
    }
}
