/*
Create a Student class to manage student data with the following features:
Static:
A static variable universityName shared across all students.
A static method displayTotalStudents() to show the number of students enrolled.
This:
Use this in the constructor to initialize name, rollNumber, and grade.
Final:
Use a final variable rollNumber for each student that cannot be changed.
Instanceof:
Check if a given object is an instance of the Student class before performing operations like displaying or updating grades.
 */
class Student{
    //Static variables
    static String universityName="SRM";
    static int totalStudent=0;

    //Instance variables
    private String name;
    private int rollNumber;
    private int grade;
    

    //Constructor using this keyword
    Student(String name,int rollNumber,int grade){
        this.name=name;
        this.rollNumber=rollNumber;
        this.grade=grade;
        totalStudent++;
    }
    
    static void displayTotalStudent(){
        System.out.println("Total Student: "+totalStudent);
    }
    
    //Static method to show student details
    static void displayDetails(Object obj){
        if(obj instanceof Student){
            Student std1=(Student) obj;
            System.out.println("Student Name: "+std1.name);
            System.out.println("Student Roll Number: "+std1.rollNumber);
            System.out.println("Student Grade: "+std1.grade);
        }else{
            System.out.println("This not object of Student class");
        }
    }
    
    //Static method to update grade
    static void gradeUpdate(Object obj,int x){
        if(obj instanceof Student){
            Student std=(Student) obj;
            std.grade=x;
            System.out.println("Grade Updated");
        }
    }
    
    public static void main(String[] args){
        Student std1=new Student("Manas",345,90);
        gradeUpdate(std1,85);
        displayDetails(std1);
        displayTotalStudent();
        
    }
}