/*
Program to Simulate Student Report
Problem Statement: Create a Student class with attributes name, rollNumber, and marks. Add two methods:
To calculate the grade based on the marks.
To display the student's details and grade.
Explanation: The Student class organizes all relevant details about a student as attributes. Methods are used to calculate the grade and provide a way to display all information.
 */
// Class representing a Student
class Student {

    // Instance variables to store student details
    int rollNumber;
    int marks;
    String name;
    
    // Constructor to initialize student details
    Student(int rollNumber, int marks, String name){
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.name = name;
    }
    
    // Method to determine grade based on marks
    void Grade(int marks){
        if(marks < 50){
            System.out.println("low");
        }
        else if(marks >= 50 && marks < 75){
            System.out.println("Good");
        }
        else{
            System.out.println("Excellent");
        }
    }
    
    // Method to display student details
    void getData(){
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
    }
    
    public static void main(String[] args){

        // Create Student object
        Student std1 = new Student(345, 97, "Raju");

        // Display student data
        std1.getData();

        // Display grade based on marks
        std1.Grade(97);
    }
}
