package level3;

// Question: Write a program to display calendar for a given month and year.

import java.util.Scanner;

class CalendarGenerator {

    static String getMonthName(int m){
        String[] months = {"January","February","March","April","May","June",
                "July","August","September","October","November","December"};
        return months[m-1];
    }

    static boolean isLeapYear(int y){
        if(y%400==0) return true;
        if(y%100==0) return false;
        return y%4==0;
    }

    static int getDaysInMonth(int m,int y){
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(m==2 && isLeapYear(y)) return 29;
        return days[m-1];
    }

    // Gregorian calendar algorithm
    static int firstDay(int d,int m,int y){
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31*m0)/12) % 7;
        return d0;
    }

    static void displayCalendar(int m,int y){
        String monthName = getMonthName(m);
        int days = getDaysInMonth(m,y);
        int first = firstDay(1,m,y); // first day of month

        System.out.println("\n    " + monthName + " " + y);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // indentation
        for(int i=0;i<first;i++){
            System.out.print("    ");
        }

        for(int day=1;day<=days;day++){
            System.out.printf("%3d ", day);
            if((day + first) % 7 == 0){
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int m=sc.nextInt();

        System.out.print("Enter year: ");
        int y=sc.nextInt();

        displayCalendar(m,y);
    }
}


