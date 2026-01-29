package level1;

import java.util.Scanner;

class SubstringCompare {

    static String createSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String userSub = createSubstring(text, start, end);
        String builtInSub = text.substring(start, end);

        boolean result = compareStrings(userSub, builtInSub);

        System.out.println("User substring: " + userSub);
        System.out.println("Built-in substring: " + builtInSub);
        System.out.println("Comparison result: " + result);
    }
}

