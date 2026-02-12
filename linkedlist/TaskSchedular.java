/*
Problem Statement:
Create a task scheduler using a circular linked list.
Each node in the list represents a task with Task ID,
Task Name, Priority, and Due Date.

Implement the following functionalities:
1. Add a task at the beginning, end, or at a specific position
   in the circular list.
2. Remove a task by Task ID.
3. View the current task and move to the next task
   in the circular list.
4. Display all tasks in the list starting from the head node.
5. Search for a task by Priority.
*/
package linkedlist;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskCircularLinkedList {
    Task head;
    Task currentTask;

    // Add task at beginning
    void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);

        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    // Add task at end
    void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);

        if (head == null) {
            head = newTask;
            newTask.next = head;
            return;
        }

        Task temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newTask;
        newTask.next = head;
    }

    // Add task at specific position (1-based)
    void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;

        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newTask.next = temp.next;
        temp.next = newTask;
    }

    // Remove task by task ID
    void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        Task current = head;
        Task previous = null;

        do {
            if (current.taskId == taskId) {

                if (current == head) {
                    Task last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    previous.next = current.next;
                }

                System.out.println("Task removed successfully");
                return;
            }

            previous = current;
            current = current.next;

        } while (current != head);

        System.out.println("Task not found");
    }

    // View current task and move to next
    void viewNextTask() {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        if (currentTask == null) {
            currentTask = head;
        }

        printTask(currentTask);
        currentTask = currentTask.next;
    }

    // Display all tasks
    void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        Task temp = head;
        do {
            printTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                printTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with this priority");
        }
    }

    void printTask(Task task) {
        System.out.println(
            "Task ID: " + task.taskId +
            ", Name: " + task.taskName +
            ", Priority: " + task.priority +
            ", Due Date: " + task.dueDate
        );
    }
}

public class TaskSchedular {
    public static void main(String[] args) {
        TaskCircularLinkedList scheduler = new TaskCircularLinkedList();

        scheduler.addAtBeginning(1, "Design Module", 1, "10-02-2026");
        scheduler.addAtEnd(2, "Write Code", 2, "12-02-2026");
        scheduler.addAtPosition(2, 3, "Testing", 1, "15-02-2026");

        System.out.println("All Tasks:");
        scheduler.displayAllTasks();

        System.out.println("\nView Current and Next Task:");
        scheduler.viewNextTask();
        scheduler.viewNextTask();

        System.out.println("\nSearch by Priority:");
        scheduler.searchByPriority(1);

        System.out.println("\nRemove Task:");
        scheduler.removeByTaskId(2);

        System.out.println("\nFinal Task List:");
        scheduler.displayAllTasks();
    }
}
