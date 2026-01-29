package level1;

import java.util.Scanner;

class UpperCaseCompare {

    static String toUpper(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);
            }
            result += ch;
        }
        return result;
    }

    static boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String userUpper = toUpper(text);
        String builtInUpper = text.toUpperCase();

        boolean result = compare(userUpper, builtInUpper);

        System.out.println("User Uppercase: " + userUpper);
        System.out.println("Built-in Uppercase: " + builtInUpper);
        System.out.println("Comparison result: " + result);
    }
}
