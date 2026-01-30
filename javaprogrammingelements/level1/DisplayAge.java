/*
Write a program to find the age of Harry if the birth year is 2000. Assume the Current Year is 2024
I/P => NONE
O/P => Harry's age in 2024 is ___
*/
class DisplayAge {
    public static void main(String[] args) {

        // Birth year of the person
        int birthYear = 2000;

        // Current year
        int currentYear = 2024;

        // Calculate current age
        int currentAge = currentYear - birthYear;

        // Display the age
        System.out.println("Harry's age in 2024 is " + currentAge);
    }
}
