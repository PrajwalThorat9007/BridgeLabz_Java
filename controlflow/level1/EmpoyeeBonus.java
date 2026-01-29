/*
Create a program to find the bonus of employees based on their years of service.
Hint => 
Zara decided to give a bonus of 5% to employees whose year of service is more than 5 years.
Take salary and year of service in the year as input.
Print the bonus amount.
*/
import java.util.Scanner;

class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double salary = sc.nextDouble();
        int yearsOfService = sc.nextInt();

        double bonus = 0;

        if (yearsOfService > 5) {
            bonus = salary * 0.05;
        }

        System.out.println("The bonus amount is " + bonus);
    }
}