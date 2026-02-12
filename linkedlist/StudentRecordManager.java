/*
Problem Statement:
Create a program to manage student records using a singly linked list.
Each node will store information about a student, including their
Roll Number, Name, Age, and Grade.

Operations to implement:
1. Add a new student record at the beginning, end, or at a specific position.
2. Delete a student record by Roll Number.
3. Search for a student record by Roll Number.
4. Display all student records.
5. Update a student's grade based on their Roll Number.

Hint:
Use a singly linked list where each node contains student information
and a pointer to the next node.
The head of the list will represent the first student, and the last
node’s next pointer will be null.
Update the next pointers when inserting or deleting nodes.
*/
package linkedlist;

class Student {
    int rollNo;
    String name;
    int age;
    char grade;
    Student next;

    Student(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    Student head;

    // Add at beginning
    void addAtBeginning(int rollNo, String name, int age, char grade) {
        Student newStudent = new Student(rollNo, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add at end
    void addAtEnd(int rollNo, String name, int age, char grade) {
        Student newStudent = new Student(rollNo, name, age, grade);

        if (head == null) {
            head = newStudent;
            return;
        }

        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // Add at specific position (1-based)
    void addAtPosition(int position, int rollNo, String name, int age, char grade) {
        if (position == 1) {
            addAtBeginning(rollNo, name, age, grade);
            return;
        }

        Student newStudent = new Student(rollNo, name, age, grade);
        Student temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Delete by roll number
    void deleteByRollNo(int rollNo) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student deleted");
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted");
        }
    }

    // Search by roll number
    void searchByRollNo(int rollNo) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                printStudent(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    // Update grade
    void updateGrade(int rollNo, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    // Display all students
    void displayAll() {
        Student temp = head;
        if (temp == null) {
            System.out.println("No records available");
            return;
        }

        while (temp != null) {
            printStudent(temp);
            temp = temp.next;
        }
    }

    void printStudent(Student s) {
        System.out.println(
            "Roll No: " + s.rollNo +
            ", Name: " + s.name +
            ", Age: " + s.age +
            ", Grade: " + s.grade
        );
    }
}

public class StudentRecordManager {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        list.addAtBeginning(1, "Prajwal", 20, 'A');
        list.addAtEnd(2, "Rahul", 21, 'B');
        list.addAtPosition(2, 3, "Sneha", 19, 'A');

        System.out.println("All Students:");
        list.displayAll();

        System.out.println("\nSearch Roll No 2:");
        list.searchByRollNo(2);

        System.out.println("\nUpdate Grade of Roll No 3:");
        list.updateGrade(3, 'A');

        System.out.println("\nDelete Roll No 1:");
        list.deleteByRollNo(1);

        System.out.println("\nFinal Records:");
        list.displayAll();
    }
}
