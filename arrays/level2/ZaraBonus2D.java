/*
Create a program to find the bonus of 10 employees based on their years of service and the total bonus amount the company Zara has to pay, along with the old and new salary.
Hint => 
Zara decides to give a bonus of 5% to employees whose year of service is more than 5 years or 2% if less than 5 years
Define a double array to save salary and years of service for each of the 10 employees
Also define a double array to save the new salary and the bonus amount as well as variables to save the total bonus, total old salary, and new salary
Define a loop to take input from the user. If salary or year of service is an invalid number then ask the use to enter again. Note in this case you will have to decrement the index counter
Define another loop to calculate the bonus of 10 employees based on their years of service. Save the bonus in the array, compute the new salary, and save in the array. Also, the total bonus and total old and new salary can be calculated in the loop
Print the total bonus payout as well as the total old and new salary of all the employees
*/
import java.util.Scanner;

class ZaraBonus2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int employees = 10;
        double[][] data = new double[employees][4];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        // Input salary and years of service
        for (int i = 0; i < employees; i++) {
            System.out.println("Enter salary for employee " + (i + 1));
            data[i][0] = sc.nextDouble();

            System.out.println("Enter years of service for employee " + (i + 1));
            data[i][1] = sc.nextDouble();

            // Validation
            if (data[i][0] <= 0 || data[i][1] < 0) {
                System.out.println("Invalid input. Please enter again.");
                i--; // re-enter for same employee
            }
        }

        // Calculate bonus and new salary
        for (int i = 0; i < employees; i++) {

            if (data[i][1] > 5) {
                data[i][2] = data[i][0] * 0.05; // 5% bonus
            } else {
                data[i][2] = data[i][0] * 0.02; // 2% bonus
            }

            data[i][3] = data[i][0] + data[i][2]; // new salary

            totalOldSalary += data[i][0];
            totalBonus += data[i][2];
            totalNewSalary += data[i][3];
        }

        // Output
        System.out.println("Total Old Salary = " + totalOldSalary);
        System.out.println("Total Bonus Paid = " + totalBonus);
        System.out.println("Total New Salary = " + totalNewSalary);
    }
}
