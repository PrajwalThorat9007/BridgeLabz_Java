/*
Description: Model a restaurant system where Person is the superclass and Chef and Waiter are subclasses. Both Chef and Waiter should implement a Worker interface that requires a performDuties() method.
Tasks:
Define a superclass Person with attributes like name and id.
Create an interface Worker with a method performDuties().
Define subclasses Chef and Waiter that inherit from Person and implement the Worker interface, each providing a unique implementation of performDuties().
Goal: Practice hybrid inheritance by combining inheritance and interfaces, giving multiple behaviors to the same objects.
*/
// Interface defining worker behavior
interface Worker {
    void performDuties(); // method to be implemented
}

// Superclass
class Person {
    String name; // person name
    int id; // person id

    Person(String name, int id) {
        this.name = name; // initializing name
        this.id = id; // initializing id
    }

    // method to display common details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Chef subclass
class Chef extends Person implements Worker {

    Chef(String name, int id) {
        super(name, id); // calling parent constructor
    }

    // implementing interface method
    @Override
    public void performDuties() {
        System.out.println("Chef is preparing food.");
    }
}

// Waiter subclass
class Waiter extends Person implements Worker {

    Waiter(String name, int id) {
        super(name, id); // calling parent constructor
    }

    // implementing interface method
    @Override
    public void performDuties() {
        System.out.println("Waiter is serving customers.");
    }
}

// Main class
public class Restaurant {
    public static void main(String[] args) {

        Worker w1 = new Chef("Rahul", 101); // creating chef
        Worker w2 = new Waiter("Anita", 102); // creating waiter

        ((Person) w1).displayDetails(); // accessing Person details
        w1.performDuties();
        System.out.println();

        ((Person) w2).displayDetails(); // accessing Person details
        w2.performDuties();
    }
}
