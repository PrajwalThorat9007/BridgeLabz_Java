/*
Create a program to find the bonus of 10 employees based on their years of service as well as the total bonus amount the 10-year-old company Zara has to pay as a bonus, along with the old and new salary.
Hint => 
Zara decides to give a bonus of 5% to employees whose year of service is more than 5 years or 2% if less than 5 years
Create a Method to determine the Salary and years of service and return the same. Use the Math.random() method to determine the 5-digit salary for each employee and also use the random method to determine the years of service. Define 2D Array to save the salary and years of service.
Write a Method to calculate the new salary and bonus based on the logic defined above and return the new 2D Array of the latest salary and bonus amount 
Write a Method to Calculate the sum of the Old Salary, the Sum of the New Salary, and the Total Bonus Amount and display it in a Tabular Format

 */
class ZaraBonusCalculator {

    public static double[][] generateEmployeeData() {
        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {
            data[i][0] = 10000 + (int)(Math.random() * 90000);
            data[i][1] = (int)(Math.random() * 11);
        }
        return data;
    }

    public static double[][] calculateBonusAndNewSalary(double[][] data) {
        double[][] result = new double[10][2];

        for (int i = 0; i < 10; i++) {
            double salary = data[i][0];
            int years = (int) data[i][1];

            double bonus;
            if (years > 5) {
                bonus = salary * 0.05;
            } else {
                bonus = salary * 0.02;
            }

            result[i][0] = bonus;
            result[i][1] = salary + bonus;
        }
        return result;
    }

    public static void displaySummary(double[][] data, double[][] result) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("Emp\tOldSalary\tYears\tBonus\t\tNewSalary");

        for (int i = 0; i < 10; i++) {
            double oldSalary = data[i][0];
            int years = (int) data[i][1];
            double bonus = result[i][0];
            double newSalary = result[i][1];

            totalOldSalary += oldSalary;
            totalBonus += bonus;
            totalNewSalary += newSalary;

            System.out.printf("%d\t%.2f\t%d\t%.2f\t%.2f\n",
                    (i + 1), oldSalary, years, bonus, newSalary);
        }

        System.out.println("-------------------------------------------------------------");
        System.out.printf("TOTAL\t%.2f\t\t\t%.2f\t%.2f\n",
                totalOldSalary, totalBonus, totalNewSalary);
    }

    public static void main(String[] args) {

        double[][] employeeData = generateEmployeeData();
        double[][] bonusData = calculateBonusAndNewSalary(employeeData);
        displaySummary(employeeData, bonusData);
    }
}
