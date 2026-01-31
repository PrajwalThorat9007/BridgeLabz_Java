/*
 Description: Model a course system where Course is the base class, OnlineCourse is a subclass, and PaidOnlineCourse extends OnlineCourse.
Tasks:
Define a superclass Course with attributes like courseName and duration.
Define OnlineCourse to add attributes such as platform and isRecorded.
Define PaidOnlineCourse to add fee and discount.
Goal: Demonstrate how each level of inheritance builds on the previous, adding complexity to the system.

*/
// Base class
class Course {
    String courseName; // course name
    int duration; // duration in hours

    Course(String courseName, int duration) {
        this.courseName = courseName; // initializing course name
        this.duration = duration; // initializing duration
    }

    void displayDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

// Subclass extending Course
class OnlineCourse extends Course {
    String platform; // learning platform
    boolean isRecorded; // recorded or live

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration); // calling parent constructor
        this.platform = platform; // initializing platform
        this.isRecorded = isRecorded; // initializing recorded status
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + isRecorded);
    }
}

// Subclass extending OnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    double fee; // course fee
    double discount; // discount percentage

    PaidOnlineCourse(String courseName, int duration, String platform,
                     boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded); // calling parent constructor
        this.fee = fee; // initializing fee
        this.discount = discount; // initializing discount
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Fee: ₹" + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: ₹" + (fee - (fee * discount / 100)));
    }
}

// Main class
public class CourseInheritance {
    public static void main(String[] args) {

        Course c1 = new Course("Basics of Programming", 30);
        Course c2 = new OnlineCourse("Java Online", 50, "Coursera", true);
        Course c3 = new PaidOnlineCourse("Advanced Java", 80, "Udemy", true, 6000, 15);

        c1.displayDetails();
        System.out.println();

        c2.displayDetails();
        System.out.println();

        c3.displayDetails();
    }
}
