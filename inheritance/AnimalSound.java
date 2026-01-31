/*
Animal Hierarchy
Description: Create a hierarchy where Animal is the superclass, and Dog, Cat, and Bird are subclasses. Each subclass has a unique behavior.
Tasks:
Define a superclass Animal with attributes name and age, and a method makeSound().
Define subclasses Dog, Cat, and Bird, each with a unique implementation of makeSound().
Goal: Learn basic inheritance, method overriding, and polymorphism with simple classes.
*/

//main class
public class AnimalSound{
    
    public static void main(String[] args){
        Animal pet1=new Animal();
        pet1.makeSound();
        
        Animal pet2=new Dog();
        pet2.makeSound();
        
        Animal pet3=new Cat();
        pet3.makeSound();
        
        Animal pet4=new Bird();
        pet4.makeSound();
    }
}
//superclass
class Animal{
    String name;
    int age;
    
    void makeSound(){
        System.out.println("Animals sound");
    }
}

//subclasses
class Dog extends Animal{
    Dog(){
        this.name="Dog";
        this.age=11;
    }
    
    @Override
    void makeSound(){
        System.out.println("Dog Barks");
    }
}

//subclass
class Cat extends Animal{
    Cat(){
        this.name="Cat";
        this.age=1;
    }
    
    @Override
    void makeSound(){
        System.out.println("Cat Meow");
    }
}

//subclass
class Bird extends Animal{
    Bird(){
        this.name="Bird";
        this.age=4;
    }
    
    @Override
    void makeSound(){
        System.out.println("Birds Chirps");
    }
}
