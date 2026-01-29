package level1;

import java.util.Scanner;

class IllegalArgDemo {

    static void generateException(String text) {
        text.substring(5, 2);
    }

    static void handleException(String text) {
        try {
            text.substring(5, 2);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled!");
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException handled!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.next();

        // generateException(text);
        handleException(text);
    }
}

