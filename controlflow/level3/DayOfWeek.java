/*Write a program DayOfWeek that takes a date as input and prints the day of the week that the date falls on. Your program should take three command-line arguments: m (month), d (day), and y (year). For m use 1 for January, 2 for February, and so forth. For output print 0 for Sunday, 1 for Monday, 2 for Tuesday, and so forth. Use the following formulas, for the Gregorian calendar (where / denotes integer division):
y0 = y − (14 − m) / 12
x = y0 + y0/4 − y0/100 + y0/400
m0 = m + 12 × ((14 − m) / 12) − 2
d0 = (d + x + 31m0 / 12) mod 7 
*/
class DayOfWeek {
    public static void main(String[] args) {

        // Read month, day, and year from command-line arguments
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        // Adjust year based on month (Zeller's congruence)
        int y0 = y - (14 - m) / 12;

        // Calculate intermediate value for day calculation
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;

        // Adjust month value
        int m0 = m + 12 * ((14 - m) / 12) - 2;

        // Calculate day of the week (0 = Sunday, 1 = Monday, etc.)
        int d0 = (d + x + (31 * m0) / 12) % 7;

        // Print the day of the week as a number
        System.out.println(d0);
    }
}

