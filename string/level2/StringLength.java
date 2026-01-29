package level2;

import java.util.Scanner;

class StringLength {

    static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (RuntimeException e) {
            // charAt out of bound -> stop
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.next();

        int userLen = findLength(text);
        int builtInLen = text.length();

        System.out.println("User-defined length: " + userLen);
        System.out.println("Built-in length(): " + builtInLen);
    }
}
