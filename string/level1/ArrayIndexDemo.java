package level1;

import java.util.Scanner;

class ArrayIndexDemo {

    static void generateException(String[] arr) {
        System.out.println(arr[10]);
    }

    static void handleException(String[] arr) {
        try {
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled!");
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException handled!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        // generateException(names);
        handleException(names);
    }
}

