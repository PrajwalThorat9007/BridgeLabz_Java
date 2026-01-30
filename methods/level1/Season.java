/*Write a program SpringSeason that takes two int values month and day from the command line and prints “Its a Spring Season” otherwise prints “Not a Spring Season”. 
Hint => Spring Season is from March 20 to June 20. Write a Method to check for Spring season and return a boolean true or false  */
import java.util.Scanner;

class Season {

    // Method to check whether the given date falls in Spring season
    void Seasoncheck(int date, int month) {
        if (date >= 20 && month == 3 || month == 4 || month == 5 || month == 6 && date <= 20) {
            System.out.println("It is Spring");
        } else {
            System.out.println("It is not Spring");
        }
    }

    public static void main(String[] args) {

        // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);
        
        // Read date and month
        int date = sc.nextInt();
        int month = sc.nextInt();

        // Create object of Season class
        Season obj = new Season();
        
        // Call method to check season
        obj.Seasoncheck(date, month);
    }
}
