package level1;

import java.util.Scanner;

class LowerCaseCompare {

    static String toLower(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
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

        String userLower = toLower(text);
        String builtInLower = text.toLowerCase();

        boolean result = compare(userLower, builtInLower);

        System.out.println("User Lowercase: " + userLower);
        System.out.println("Built-in Lowercase: " + builtInLower);
        System.out.println("Comparison result: " + result);
    }
}
