/*
Create a Person class with a copy constructor that clones another person's attributes.
 */
class Person {

    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {

        Person p1 = new Person("Prajwal", 21);
        Person p2 = new Person(p1);   // cloning p1 using copy constructor

        System.out.println("Original Person:");
        p1.display();

        System.out.println("\nCloned Person:");
        p2.display();
    }
}
