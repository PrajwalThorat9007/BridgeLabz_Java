/*
Rewrite program 8 to do the countdown using the for-loop
*/
import java.util.Scanner;

class RocketLaunch2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int counter = sc.nextInt();

        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
    }
}