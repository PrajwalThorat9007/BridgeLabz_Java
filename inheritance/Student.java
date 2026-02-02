/*Access Modifiers
Problem 1: University Management System
Create a Student class with:
rollNumber (public).
name (protected).
CGPA (private).
Write methods to:
Access and modify CGPA using public methods.
Create a subclass PostgraduateStudent to demonstrate the use of protected members. */
// Class representing a student
package inheritance;
class Student {

    // Public roll number accessible everywhere
    public int rollNumber;

    // Protected name accessible to subclasses
    protected String name;

    // Private CGPA to ensure data encapsulation
    private double cgpa;

    // Constructor to initialize student details
    Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    // Getter method to access CGPA
    public double getCGPA() {
        return cgpa;
    }

    // Setter method to update CGPA
    public void setCGPA(double cgpa) {
        this.cgpa = cgpa;
    }
}

