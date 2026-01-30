/*
Create a Person class with a copy constructor that clones another person's attributes.
 */
// Class representing a person
class Person {

    // Private data members to ensure encapsulation
    private String name;
    private int age;

    // Parameterized constructor to initialize person details
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor to create a new object from an existing one
    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Method to display person details
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {

        // Create original Person object
        Person p1 = new Person("Prajwal", 21);

        // Create cloned Person object using copy constructor
        Person p2 = new Person(p1);

        // Display original person details
        System.out.println("Original Person:");
        p1.display();

        // Display cloned person details
        System.out.println("\nCloned Person:");
        p2.display();
    }
}

