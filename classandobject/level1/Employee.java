/*
Program to Display Employee Details
Problem Statement: Write a program to create an Employee class with attributes name, id, and salary. Add a method to display the details.
 */
import java.util.Scanner;

// Class representing an Employee
class Employee {

    // Private data members to ensure encapsulation
    private String name;
    private int id;
    private int salary;
    
    // Method to set employee details
    public void setData(String name, int id, int salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void getData(){
        System.out.println("Employee name is " + name + " id is " + id + " and salary is " + salary);
    }
    
    public static void main(String[] args){

        // Create Employee object
        Employee emp1 = new Employee();

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);
        
        // Read employee name
        String name = sc.next();

        // Assign fixed values for id and salary
        int id = 345;
        int salary = 1500000;
        
        // Set and display employee data
        emp1.setData(name, id, salary);
        emp1.getData();
    }
}

