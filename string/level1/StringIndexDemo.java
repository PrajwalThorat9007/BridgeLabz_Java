package level1;

import java.util.Scanner;

class StringIndexDemo {

    static void generateException(String text) {
        System.out.println(text.charAt(100));
    }

    static void handleException(String text) {
        try {
            System.out.println(text.charAt(100));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled!");
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

