package level1;

import java.util.Scanner;

class NumberFormatDemo {

    static void generateException(String text) {
        int num = Integer.parseInt(text);
    }

    static void handleException(String text) {
        try {
            int num = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled!");
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException handled!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number text: ");
        String text = sc.next();

        // generateException(text);
        handleException(text);
    }
}
