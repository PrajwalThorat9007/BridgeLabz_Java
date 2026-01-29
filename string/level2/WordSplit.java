package level2;

import java.util.Scanner;

class WordSplit {

    static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (RuntimeException e) {}
        return count;
    }

    static String[] splitWords(String text) {
        int len = findLength(text);
        int spaceCount = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') spaceCount++;
        }

        int words = spaceCount + 1;
        int[] spaceIndex = new int[spaceCount];
        int idx = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[idx++] = i;
            }
        }

        String[] result = new String[words];

        int start = 0;
        for (int i = 0; i < spaceCount; i++) {
            int end = spaceIndex[i];
            String word = "";
            for (int j = start; j < end; j++) {
                word += text.charAt(j);
            }
            result[i] = word;
            start = end + 1;
        }

        String lastWord = "";
        for (int j = start; j < len; j++) {
            lastWord += text.charAt(j);
        }
        result[words - 1] = lastWord;

        return result;
    }

    static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String text = sc.nextLine();

        String[] userWords = splitWords(text);
        String[] builtInWords = text.split(" ");

        boolean result = compareArrays(userWords, builtInWords);

        System.out.println("Comparison Result: " + result);
    }
}