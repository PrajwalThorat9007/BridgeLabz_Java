/*
Design a Course class with:
Instance Variables: courseName, duration, fee.
Class Variable: instituteName (common for all courses).
Methods:
An instance method displayCourseDetails() to display the course details.
A class method updateInstituteName() to modify the institute name for all courses.
 */
// Class representing a Course
class Course {

    // Instance variables for course details
    String courseName;
    int duration;
    double fee;

    // Static variable shared by all Course objects
    static String instituteName = "ABC Institute";

    // Constructor to initialize course details
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Method to display course and institute details
    void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: " + fee);
    }

    // Static method to update institute name for all courses
    static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }
}
